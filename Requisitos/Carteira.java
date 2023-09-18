package Requisitos;

import Requisitos.Ativos.AcaoOrdinaria;
import Requisitos.Ativos.AcaoPreferencial;
import Requisitos.Ativos.FundoInvestimentoImobiliario;
import Requisitos.Ativos.Ativo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carteira {
    private double saldo;
    private List<Ativo> ativos;

    public Carteira(double saldoInicial) {
        this.saldo = saldoInicial;
        this.ativos = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
    }

    public void comprarAtivo(Ativo ativo, int quantidade) {
        double custoTotal = ativo.getPreco() * quantidade;
        if (saldo >= custoTotal) {
            ativo.setQuantidade(ativo.getQuantidade() + quantidade);
            saldo -= custoTotal;
            System.out.println("Compra realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para comprar o ativo.");
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo da carteira: " + saldo);
    }

    public void mostrarAtivos() {
        for (Ativo ativo : ativos) {
            System.out.println(ativo);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o saldo inicial da carteira:");
        double saldoInicial = scanner.nextDouble();

        Carteira carteira = new Carteira(saldoInicial);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Comprar Ativo");
            System.out.println("2. Mostrar Saldo");
            System.out.println("3. Mostrar Ativos");
            System.out.println("4. Sair");
            System.out.println("5. Depositar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    

                    break;
                case 2:
                    carteira.mostrarSaldo();
                    break;
                case 3:
                    carteira.mostrarAtivos();
                    break;
                case 4:
                    System.out.println("Saindo da carteira.");
                    scanner.close();
                    return;
                case 5:
                    System.out.println("Informe o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    carteira.depositar(valorDeposito);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}