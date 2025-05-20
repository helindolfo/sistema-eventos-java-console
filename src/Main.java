import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static SistemaEventos sistema = Persistencia.carregarDados();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Eventos");
        menuPrincipal();
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar evento");
            System.out.println("3 - Listar todos os eventos");
            System.out.println("4 - Participar de evento");
            System.out.println("5 - Ver eventos inscritos");
            System.out.println("6 - Cancelar participação");
            System.out.println("7 - Ver eventos passados");
            System.out.println("8 - Ver eventos em andamento");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarUsuario();
                    case 2 -> cadastrarEvento();
                    case 3 -> listarEventos();
                    case 4 -> participarEvento();
                    case 5 -> verEventosInscritos();
                    case 6 -> cancelarParticipacao();
                    case 7 -> verEventosPassados();
                    case 8 -> verEventosEmAndamento();
                    case 9 -> {
                        Persistencia.salvarDados(sistema);
                        System.out.println("Saindo do sistema...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    // Métodos de operação (implementações similares às anteriores)
    private static void cadastrarUsuario() { /* ... */ }
    private static void cadastrarEvento() { /* ... */ }
    private static void listarEventos() { /* ... */ }
    private static void participarEvento() { /* ... */ }
    private static void verEventosInscritos() { /* ... */ }
    private static void cancelarParticipacao() { /* ... */ }
    private static void verEventosPassados() { /* ... */ }
    private static void verEventosEmAndamento() { /* ... */ }
}
