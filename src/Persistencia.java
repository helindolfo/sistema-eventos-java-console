import java.io.*;
import java.util.List;

public class Persistencia {
    private static final String ARQUIVO_DADOS = "events.data";

    @SuppressWarnings("unchecked")
    public static SistemaEventos carregarDados() {
        SistemaEventos sistema = new SistemaEventos();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_DADOS))) {
            sistema.setEventos((List<Evento>) ois.readObject());
            sistema.setUsuarios((List<Usuario>) ois.readObject());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Criando novo...");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
        
        return sistema;
    }

    public static void salvarDados(SistemaEventos sistema) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            oos.writeObject(sistema.getEventos());
            oos.writeObject(sistema.getUsuarios());
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}

class SistemaEventos {
    private List<Evento> eventos;
    private List<Usuario> usuarios;
    private Usuario usuarioAtual;

    public SistemaEventos() {
        this.eventos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Métodos de cadastro
    public void cadastrarUsuario(String nome, String email, String telefone) {
        Usuario usuario = new Usuario(nome, email, telefone);
        usuarios.add(usuario);
        usuarioAtual = usuario;
    }

    public void cadastrarEvento(String nome, String endereco, CategoriaEvento categoria, 
                              LocalDateTime horario, String descricao) {
        Evento evento = new Evento(nome, endereco, categoria, horario, descricao);
        eventos.add(evento);
    }

    // Métodos de participação
    public void participarEvento(Usuario usuario, Evento evento) {
        evento.inscreverUsuario(usuario);
    }

    public void cancelarParticipacao(Usuario usuario, Evento evento) {
        evento.cancelarParticipacao(usuario);
    }

    // Métodos de consulta
    public List<Evento> listarEventosOrdenadosPorHorario() {
        return eventos.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Evento> listarEventosOcorrendoAgora() {
        return eventos.stream()
                .filter(Evento::estaOcorrendoAgora)
                .collect(Collectors.toList());
    }

    public List<Evento> listarEventosPassados() {
        return eventos.stream()
                .filter(Evento::jaOcorreu)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // Getters e Setters
    public List<Evento> getEventos() { return eventos; }
    public void setEventos(List<Evento> eventos) { this.eventos = eventos; }
    
    public List<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
    
    public Usuario getUsuarioAtual() { return usuarioAtual; }
    public void setUsuarioAtual(Usuario usuario) { this.usuarioAtual = usuario; }
}
