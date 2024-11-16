public class Department {
    private String name;
    private Stack<String> documents;

    public Department(String name) {
        this.name = name;
        this.documents = new Stack<>();
    }

    public String getName() {
        return name;
    }

    public void addDocument(String document) {
        documents.push(document);
    }

    public boolean isEmpty() {
        return documents.isEmpty();
    }

    public String printDocument() {
        return documents.pop();
    }
}
