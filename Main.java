import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    static Stack<String> anteriores = new Stack<>();
    static Stack<String> proximos = new Stack<>();

    static String atual = null;

    public static void main(String[] args) {

        proximos.push("Pedro");
        proximos.push("Maria");
        proximos.push("João");
        proximos.push("Carlos");
        proximos.push("Ana");

        int opcao = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("     BANCO - CONTROLE DE ATENDIMENTO");
            System.out.println("========================================");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Realizar atendimento");
            System.out.println("3 - Mostrar atendimento atual");
            System.out.println("4 - Mostrar atendimento anterior");
            System.out.println("5 - Mostrar próximo atendimento");
            System.out.println("6 - Mostrar todos os clientes");
            System.out.println("7 - Sair");
            System.out.println("8 - Voltar para atendimento anterior");
            System.out.println("9 - Avançar para próximo atendimento");
            System.out.print("Escolha uma opção: ");

            if (!entrada.hasNextInt()) {
                System.out.println("Digite uma opção numérica válida!");
                entrada.nextLine();
                continue;
            }

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = entrada.nextLine().trim();

                    if (nome.isEmpty()) {
                        System.out.println("O nome não pode ser vazio.");
                    } else {
                        proximos.push(nome);
                        System.out.println("Cliente adicionado!");
                    }
                    break;

                case 2:
                    if (proximos.isEmpty()) {
                        System.out.println("Não há próximos clientes.");
                    } else {
                        if (atual != null) {
                            anteriores.push(atual);
                        }

                        atual = proximos.pop();

                        System.out.println("Atendendo: " + atual);
                    }
                    break;

                case 3:
                    if (atual == null) {
                        System.out.println("Nenhum atendimento atual.");
                    } else {
                        System.out.println("Atendimento atual: " + atual);
                    }
                    break;

                case 4:
                    if (anteriores.isEmpty()) {
                        System.out.println("Nenhum atendimento anterior.");
                    } else {
                        System.out.println(
                            "Atendimento anterior: " + anteriores.peek()
                        );
                    }
                    break;

                case 5:
                    if (proximos.isEmpty()) {
                        System.out.println("Nenhum próximo atendimento.");
                    } else {
                        System.out.println(
                            "Próximo atendimento: " + proximos.peek()
                        );
                    }
                    break;

                case 6:
                    System.out.println("\n--- SITUAÇÃO DOS ATENDIMENTOS ---");
                    System.out.println("Anteriores: " + anteriores);
                    System.out.println("Atual: " + atual);
                    System.out.println("Próximos: " + proximos);
                    System.out.println(
                        "Quantidade de anteriores: " + anteriores.size()
                    );
                    System.out.println(
                        "Quantidade de próximos: " + proximos.size()
                    );
                    break;

                case 7:
                    System.out.println("Sistema encerrado.");
                    break;

                case 8:
                    if (anteriores.isEmpty()) {
                        System.out.println("Não há atendimento anterior.");
                    } else {
                        if (atual != null) {
                            proximos.push(atual);
                        }

                        atual = anteriores.pop();

                        System.out.println(
                            "Voltando para o atendimento de: " + atual
                        );
                    }
                    break;

                case 9:
                    if (proximos.isEmpty()) {
                        System.out.println("Não há próximo atendimento.");
                    } else {
                        if (atual != null) {
                            anteriores.push(atual);
                        }

                        atual = proximos.pop();

                        System.out.println(
                            "Avançando para o atendimento de: " + atual
                        );
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        entrada.close();
    }
}