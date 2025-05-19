# Sistema de Eventos - Console Java

Este é um sistema simples em Java para cadastro e gerenciamento de eventos locais, desenvolvido para fins acadêmicos, com execução em console.

---

## 🎯 Objetivo
Permitir que o usuário cadastre eventos e possa participar, cancelar, visualizar e listar eventos com base no horário. O sistema simula uma rede local de eventos da cidade.

---

## 📦 Funcionalidades

- Cadastro de **usuário** (nome, e-mail, telefone)
- Cadastro de **eventos** (nome, endereço, categoria, data/hora, descrição)
- Listar todos os eventos cadastrados
- Participar de eventos e cancelar participação
- Ver eventos ocorrendo no momento (utiliza `LocalDateTime`)
- Ver eventos passados
- Eventos são ordenados por horário
- **Persistência** dos dados no arquivo `events.data`

---

## 💻 Tecnologias Utilizadas

- Java 8+
- Console (modo texto)
- `ArrayList`, `LocalDateTime`, `Scanner`
- Serialização com `ObjectOutputStream` e `ObjectInputStream`

---

## 📁 Estrutura do Projeto

```
📦 Projeto
 ┣ 📜 Usuario.java
 ┣ 📜 Evento.java
 ┣ 📜 Persistencia.java
 ┣ 📜 Main.java
 ┗ 📄 events.data (gerado automaticamente)
```

---

## ▶️ Como Executar

1. Clone este repositório:
```bash
git clone https://github.com/seuusuario/sistema-eventos-java.git
```
2. Abra o projeto na sua IDE Java (Eclipse, IntelliJ, NetBeans ou Replit)
3. Compile e execute `Main.java`
4. Interaja pelo menu apresentado no console

---

## 📝 Observações

- Os dados são persistidos automaticamente em `events.data`
- O projeto segue o paradigma de **Programação Orientada a Objetos**
- Recomendado estender usando padrão MVC no futuro

---

## 📚 Atividade Acadêmica

Este projeto atende aos critérios da atividade da disciplina **Programação de Soluções Computacionais** no contexto da **Imersão Digital**, com foco no desenvolvimento de habilidades práticas em Java orientado a objetos.

---

## 👨‍💻 Autor

Helindolfo Israel
