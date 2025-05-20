import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable, Comparable<Evento> {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String endereco;
    private CategoriaEvento categoria;
    private LocalDateTime horario;
    private String descricao;
    private List<Usuario> participantes;

    public Evento(String nome, String endereco, CategoriaEvento categoria, 
                 LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
        this.participantes = new ArrayList<>();
    }

    // Getters
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public CategoriaEvento getCategoria() { return categoria; }
    public LocalDateTime getHorario() { return horario; }
    public String getDescricao() { return descricao; }
    public List<Usuario> getParticipantes() { return participantes; }

    // Métodos para gerenciar participantes
    public void inscreverUsuario(Usuario usuario) {
        participantes.add(usuario);
        usuario.inscreverEmEvento(this);
    }

    public void cancelarParticipacao(Usuario usuario) {
        participantes.remove(usuario);
        usuario.cancelarInscricao(this);
    }

    // Métodos para verificação de status
    public boolean estaOcorrendoAgora() {
        LocalDateTime agora = LocalDateTime.now();
        return !horario.isAfter(agora) && horario.plusHours(2).isAfter(agora);
    }

    public boolean jaOcorreu() {
        return horario.isBefore(LocalDateTime.now());
    }

    // Implementação para ordenação
    @Override
    public int compareTo(Evento outro) {
        return this.horario.compareTo(outro.horario);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", categoria=" + categoria +
                ", horario=" + horario.format(formatter) +
                ", descricao='" + descricao + '\'' +
                ", participantes=" + participantes.size() +
                '}';
    }
}

enum CategoriaEvento {
    MUSICAL, ESPORTIVO, CULTURAL, EDUCACIONAL, SOCIAL, TECNOLOGICO
}
