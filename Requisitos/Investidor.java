package Requisitos;

import Requisitos.Ativos.AcaoOrdinaria;
import Requisitos.Ativos.AcaoPreferencial;
import Requisitos.Ativos.FundoInvestimentoImobiliario;
import Requisitos.Ativos.Ativo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Requisitos.Carteira;

import java.io.*;

public class Investidor {
    private String nome;
    private int id;
    private String cpf;
    private Carteira carteira;

    public Investidor(String nome, int id, String cpf, double saldoInicial) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.carteira = new Carteira(saldoInicial);
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Informe seu ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe seu CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Informe o saldo inicial da sua carteira:");
        double saldoInicial = scanner.nextDouble();

        Investidor investidor = carregarInvestidor();
        if (investidor == null) {
            investidor = new Investidor(nome, id, cpf, saldoInicial);
        }

        if (investidor.getCarteira() == null) {
            investidor.setCarteira(new Carteira(saldoInicial));
        }

        MinhaCorretora corretora = new MinhaCorretora(investidor.getCarteira());

        while (true) {
            System.out.println("\nBem-vindo, " + investidor.getNome() + "!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Interagir com a Corretora");
            System.out.println("2. Mostrar informações da Carteira");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    corretora.interagirComCorretora();
                    break;
                case 2:
                    investidor.getCarteira().mostrarSaldo();
                    investidor.getCarteira().mostrarAtivos();
                    break;
                case 3:
                    salvarInvestidor(investidor);
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static Investidor carregarInvestidor() {
        try (FileInputStream fileIn = new FileInputStream("investidor.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            return (Investidor) objectIn.readObject();

        } catch (FileNotFoundException ex) {
            
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static void salvarInvestidor(Investidor investidor) {
        try (FileOutputStream fileOut = new FileOutputStream("investidor.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(investidor);
            System.out.println("Investidor serializado e salvo em investidor.ser");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}