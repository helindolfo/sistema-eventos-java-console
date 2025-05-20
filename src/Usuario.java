import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private String telefone;
    private List<Evento> eventosInscritos;

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.eventosInscritos = new ArrayList<>();
    }

    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public List<Evento> getEventosInscritos() { return eventosInscritos; }

    // Métodos para gerenciar eventos
    public void inscreverEmEvento(Evento evento) {
        eventosInscritos.add(evento);
    }

    public void cancelarInscricao(Evento evento) {
        eventosInscritos.remove(evento);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
