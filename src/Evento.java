// Evento.java
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable {
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime horario;
    private String descricao;
    private List<Usuario> participantes = new ArrayList<>();

    public Evento(String nome, String endereco, String categoria, LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public void adicionarParticipante(Usuario u) {
        participantes.add(u);
    }

    public void removerParticipante(Usuario u) {
        participantes.remove(u);
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + " | " + categoria + " | " + endereco + " | " + horario + "\n" + descricao;
    }
}
