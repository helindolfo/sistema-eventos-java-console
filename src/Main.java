// Main.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Evento> eventos = new ArrayList<>();
    static Usuario usuario;

    public static void main(String[] args) {
        eventos = Optional.ofNullable(Persistencia.carregarEventos("events.data")).orElse(new ArrayList<>());

        System.out.println("Cadastro de usuário");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        usuario = new Usuario(nome, email, telefone);

        int opcao;
        do {
            menu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha
            switch (opcao) {
                case 1 -> cadastrarEvento();
                case 2 -> listarEventos();
                case 3 -> participarEvento();
                case 4 -> verEventosInscritos();
                case 5 -> cancelarParticipacao();
                case 6 -> listarEventosOcorrendoAgora();
                case 7 -> listarEventosPassados();
                case 8 -> Persistencia.salvarEventos(eventos, "events.data");
            }
        } while (opcao != 0);
    }

    public static void menu() {
        System.out.println("\n1 - Cadastrar evento");
        System.out.println("2 - Listar eventos");
        System.out.println("3 - Participar de evento");
        System.out.println("4 - Ver eventos inscritos");
        System.out.println("5 - Cancelar participação");
        System.out.println("6 - Ver eventos ocorrendo agora");
        System.out.println("7 - Ver eventos passados");
        System.out.println("8 - Salvar eventos");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static void cadastrarEvento() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Categoria (festa, show, esportivo...): ");
        String categoria = scanner.nextLine();
        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        String horarioStr = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        LocalDateTime horario = LocalDateTime.parse(horarioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        eventos.add(new Evento(nome, endereco, categoria, horario, descricao));
        System.out.println("Evento cadastrado!");
    }

    public static void listarEventos() {
        eventos.sort(Comparator.comparing(Evento::getHorario));
        eventos.forEach(System.out::println);
    }

    public static void participarEvento() {
        listarEventos();
        System.out.print("Digite o nome do evento para participar: ");
        String nome = scanner.nextLine();
        eventos.stream().filter(e -> e.getNome().equalsIgnoreCase(nome)).findFirst().ifPresent(usuario::inscrever);
    }

    public static void verEventosInscritos() {
        usuario.getEventosInscritos().forEach(System.out::println);
    }

    public static void cancelarParticipacao() {
        verEventosInscritos();
        System.out.print("Digite o nome do evento para cancelar: ");
        String nome = scanner.nextLine();
        eventos.stream().filter(e -> e.getNome().equalsIgnoreCase(nome)).findFirst().ifPresent(usuario::cancelarInscricao);
    }

    public static void listarEventosOcorrendoAgora() {
        LocalDateTime agora = LocalDateTime.now();
        eventos.stream().filter(e -> e.getHorario().isBefore(agora.plusHours(1)) && e.getHorario().isAfter(agora.minusHours(1)))
                .forEach(System.out::println);
    }

    public static void listarEventosPassados() {
        LocalDateTime agora = LocalDateTime.now();
        eventos.stream().filter(e -> e.getHorario().isBefore(agora))
                .forEach(System.out::println);
    }
}
