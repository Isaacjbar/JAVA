public class Libro {
    private String titulo;
    private String autor;
    private LinkedList<Genero> generos;  // Usamos la LinkedList personalizada
    private int anioPublicacion;

    public Libro(String titulo, String autor, LinkedList<Genero> generos, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.generos = generos;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LinkedList<Genero> getGeneros() {
        return generos;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setGeneros(LinkedList<Genero> generos) {
        this.generos = generos;
    }
    
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }    
    @Override
    public String toString() {
        StringBuilder generosStr = new StringBuilder();
        for (int i = 0; i < generos.size(); i++) {
            generosStr.append(generos.get(i).name());
            if (i < generos.size() - 1) {
                generosStr.append(", ");
            }
        }
        return "Título: " + titulo + ", Autor: " + autor + ", Géneros: " + generosStr + ", Año: " + anioPublicacion;
    }
}
