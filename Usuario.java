// Usuario.java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private String nome;
    private String email;
    private String telefone;
    private List<Evento> eventosInscritos = new ArrayList<>();

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void inscrever(Evento evento) {
        if (!eventosInscritos.contains(evento)) {
            eventosInscritos.add(evento);
            evento.adicionarParticipante(this);
        }
    }

    public void cancelarInscricao(Evento evento) {
        eventosInscritos.remove(evento);
        evento.removerParticipante(this);
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public String getNome() {
        return nome;
    }
}
