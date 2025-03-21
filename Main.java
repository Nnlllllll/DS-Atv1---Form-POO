import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>(); // Lista para armazenar várias pessoas
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Menu de Cadastro ===");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Editar Pessoa");
            System.out.println("3. Apresentar Todas as Pessoas");
            System.out.println("4. Excluir Pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1: // Cadastrar Pessoa
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    Pessoa novaPessoa = new Pessoa(nome, idade, email);
                    pessoas.add(novaPessoa);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;

                case 2: // Editar Pessoa
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        listarPessoas(pessoas);
                        System.out.print("Digite o número da pessoa que deseja editar (0 a " + (pessoas.size() - 1) + "): ");
                        int indiceEditar = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        if (indiceEditar >= 0 && indiceEditar < pessoas.size()) {
                            Pessoa pessoa = pessoas.get(indiceEditar);
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Digite a nova idade: ");
                            int novaIdade = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            System.out.print("Digite o novo e-mail: ");
                            String novoEmail = scanner.nextLine();
                            pessoa.setNome(novoNome);
                            pessoa.setIdade(novaIdade);
                            pessoa.setEmail(novoEmail);
                            System.out.println("Dados editados com sucesso!");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;

                case 3: // Apresentar Todas as Pessoas
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        listarPessoas(pessoas);
                    }
                    break;

                case 4: // Excluir Pessoa
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        listarPessoas(pessoas);
                        System.out.print("Digite o número da pessoa que deseja excluir (0 a " + (pessoas.size() - 1) + "): ");
                        int indiceExcluir = scanner.nextInt();
                        if (indiceExcluir >= 0 && indiceExcluir < pessoas.size()) {
                            pessoas.remove(indiceExcluir);
                            System.out.println("Pessoa excluída com sucesso!");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;

                case 5: // Sair
                    sair = true;
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    // Método auxiliar para listar todas as pessoas
    private static void listarPessoas(ArrayList<Pessoa> pessoas) {
        System.out.println("\n=== Pessoas Cadastradas ===");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println("Pessoa " + i + ":");
            pessoas.get(i).apresentar();
            System.out.println("-------------------");
        }
    }
}