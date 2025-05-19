// Persistencia.java
import java.io.*;
import java.util.List;

public class Persistencia {
    public static void salvarEventos(List<Evento> eventos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Evento> carregarEventos(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (List<Evento>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
