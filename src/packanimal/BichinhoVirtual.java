package packanimal;
import java.util.Scanner;

public class BichinhoVirtual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crie seu novo animal");

        String nome;
        do {
            System.out.print("Insira o nome: ");
            nome = scanner.nextLine();
            if (nome.isEmpty()) {
                System.out.println("Nome não pode ser vazio. Tente novamente.");
            }
        } while (nome.isEmpty());

        String classe;
        do {
            System.out.print("Insira a classe: ");
            classe = scanner.nextLine();
            if (classe.isEmpty()) {
                System.out.println("Classe não pode ser vazia. Tente novamente.");
            }
        } while (classe.isEmpty());

        String familia;
        do {
            System.out.print("Insira a família: ");
            familia = scanner.nextLine();
            if (familia.isEmpty()) {
                System.out.println("Família não pode ser vazia. Tente novamente.");
            }
        } while (familia.isEmpty());

        Animal bichinho = new Animal(nome, classe, familia);
        bichinho.exibirStatus();

        while (bichinho.estaVivo()) {
            System.out.println("\nO que o " + nome + " vai fazer agora?");
            System.out.println("1 - Comer\n2 - Correr\n3 - Dormir\n4 - Morrer\n5 - Sair do Programa");
            
            int opcao = -1;
            boolean opcaoValida = false;
            while (!opcaoValida) {
                System.out.print("Escolha uma opção: ");
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    opcaoValida = opcao >= 1 && opcao <= 5;
                    if (!opcaoValida) {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                } else {
                    System.out.println("Por favor, insira um número válido.");
                    scanner.next(); // Limpar a entrada inválida
                }
            }

            switch (opcao) {
                case 1 -> bichinho.comer();
                case 2 -> bichinho.correr();
                case 3 -> bichinho.dormir();
                case 4 -> bichinho.morrer();
                case 5 -> {
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                }
            }

            if (bichinho.estaVivo()) {
                bichinho.exibirStatus();
            }
        }

        System.out.println("GAME OVER!");
        scanner.close();
    }
}
