// Isso permite que os dados do usuário sejam salvos em arquivo
import java.io.Serializable;
// Essas são ferramentas para trabalhar com listas de itens
import java.util.ArrayList;
import java.util.List;

// Aqui estamos criando a "ficha" do usuário
public class Usuario implements Serializable {
    
    // Número que ajuda o computador a entender como ler os dados salvos
    private static final long serialVersionUID = 1L;
    
    // Espaços para guardar as informações do usuário:
    private String nome;         // Guarda o nome
    private String email;        // Guarda o email
    private String telefone;     // Guarda o telefone
    
    // Uma lista para guardar todos os eventos que o usuário vai participar
    private List<Evento> eventosInscritos;

    // Quando criamos um novo usuário, preenchemos esses dados:
    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;               // Coloca o nome fornecido
        this.email = email;             // Coloca o email fornecido
        this.telefone = telefone;       // Coloca o telefone fornecido
        this.eventosInscritos = new ArrayList<>();  // Cria uma lista vazia de eventos
    }

    // Esses métodos servem para PEGAR as informações guardadas:
    
    // Pega o nome do usuário
    public String getNome() { return nome; }
    
    // Pega o email do usuário
    public String getEmail() { return email; }
    
    // Pega o telefone do usuário
    public String getTelefone() { return telefone; }
    
    // Pega a lista de eventos que o usuário está participando
    public List<Evento> getEventosInscritos() { return eventosInscritos; }

    // Métodos para gerenciar os eventos do usuário:
    
    // Adiciona um novo evento na lista do usuário
    public void inscreverEmEvento(Evento evento) {
        eventosInscritos.add(evento);  // Coloca o evento na lista
    }

    // Remove um evento da lista do usuário
    public void cancelarInscricao(Evento evento) {
        eventosInscritos.remove(evento);  // Tira o evento da lista
    }

    // Mostra os dados do usuário de forma organizada quando precisamos imprimir
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +      // Mostra o nome
                ", email='" + email + '\'' +  // Mostra o email
                ", telefone='" + telefone + '\'' + // Mostra o telefone
                '}';
    }
}
