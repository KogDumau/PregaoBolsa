package Requisitos;
import java.util.Scanner;
import Requisitos.Ativos.AcaoOrdinaria;
import Requisitos.Ativos.AcaoPreferencial;
import Requisitos.Ativos.FundoInvestimentoImobiliario;
import Requisitos.Ativos.Ativo;
import java.util.ArrayList;
import java.util.List;

public class MinhaCorretora {
    public MinhaCorretora(Carteira carteira) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o saldo inicial da sua carteira:");
        double saldoInicial = scanner.nextDouble();
        Carteira carteira = new Carteira(saldoInicial);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Comprar Ativo");
            System.out.println("2. Mostrar Saldo");
            System.out.println("3. Mostrar Ativos");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Escolha o tipo de ativo:");
                    System.out.println("1. Ação Ordinária");
                    System.out.println("2. Ação Preferencial");
                    System.out.println("3. Fundo de Investimento Imobiliário (FII)");

                    int tipoAtivo = scanner.nextInt();
                    System.out.println("Nome dos ativos:");
                    System.out.println("GOGLi:");
                    System.out.println("APPLI:");
                    System.out.println("Petrotras:");
                    System.out.println("Construtoria:");
                    System.out.println("Digite o nome do Ativo desejado");
                    String nomeAtivo = scanner.next();
                    System.out.println("Digite o Preço por unidade desse Ativo:");
                    System.out.println("170:");
                    System.out.println("200:");
                    System.out.println("50:");
                    System.out.println("15:");
                    Double precoAtivo = scanner.nextDouble();
                
                    System.out.println("Informe a quantidade desejada:");
                    int quantidadeAtivo = scanner.nextInt();

                    Ativo novoAtivo;

                    switch (tipoAtivo) {
                        case 1:
                            novoAtivo = new AcaoOrdinaria(nomeAtivo, precoAtivo);
                            break;
                        case 2:
                            novoAtivo = new AcaoPreferencial(nomeAtivo, precoAtivo);
                            break;
                        case 3:
                            novoAtivo = new FundoInvestimentoImobiliario(nomeAtivo, precoAtivo);
                            break;
                        default:
                            System.out.println("Tipo de ativo inválido.");
                            continue;
                    }

                    
                    carteira.comprarAtivo(novoAtivo, quantidadeAtivo);
                    break;
                case 2:
                    
                    carteira.mostrarSaldo();
                    break;
                case 3:
                    
                    carteira.mostrarAtivos();
                    break;
                case 4:
                    System.out.println("Saindo da corretora.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void interagirComCorretora() {
    }
}     