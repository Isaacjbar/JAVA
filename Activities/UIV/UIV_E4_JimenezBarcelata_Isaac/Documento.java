import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Documento {
    private String titulo;
    private ArrayList<String> cuerpo;

    public Documento(String titulo) {
        this.titulo = titulo;
        this.cuerpo = new ArrayList<>();
    }

    public Documento(Documento doc) {
        this.titulo = doc.getTitulo();
        this.cuerpo = new ArrayList<>(doc.getCuerpo());
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getCuerpo() {
        return new ArrayList<>(cuerpo);
    }

    public boolean pushLine(String line) {
        cuerpo.add(line);
        return updateContent();
    }

    public boolean removeLine() {
        if (cuerpo.isEmpty()) {
            return false;
        }
        cuerpo.remove(cuerpo.size() - 1);
        return updateContent();
    }

    public boolean isEmpty() {
        return cuerpo.isEmpty();
    }

    public boolean updateContent() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(titulo + ".txt"))) {
            for (String line : cuerpo) {
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void loadContent() {
        cuerpo.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(titulo + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cuerpo.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
