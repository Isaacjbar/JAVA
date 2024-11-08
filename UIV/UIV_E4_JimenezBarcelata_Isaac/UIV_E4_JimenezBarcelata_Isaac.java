import java.util.Scanner;
import java.util.Stack;

public class UIV_E4_JimenezBarcelata_Isaac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Documento doc = new Documento("MiDocumento");
        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1) Agregar texto al documento");
            System.out.println("2) Quitar texto del documento");
            System.out.println("3) DesHacer");
            System.out.println("4) ReHacer");
            System.out.println("5) Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (choice) {
                case 1:
                    System.out.println("Ingrese la línea de texto:");
                    String lineToAdd = scanner.nextLine();
                    undoStack.push(lineToAdd);
                    doc.pushLine(lineToAdd);
                    redoStack.clear(); // Vaciar la pila de rehacer
                    System.out.println("Texto agregado al documento.");
                    printDocumentContent(doc);
                    break;

                case 2:
                    if (!doc.isEmpty()) {
                        String lastLine = doc.getCuerpo().get(doc.getCuerpo().size() - 1);
                        undoStack.push("REMOVE:" + lastLine);
                        doc.removeLine();
                        redoStack.clear(); // Vaciar la pila de rehacer
                        System.out.println("Última línea eliminada del documento.");
                    } else {
                        System.out.println("El documento está vacío.");
                    }
                    printDocumentContent(doc);
                    break;

                case 3:
                    if (!undoStack.isEmpty()) {
                        String action = undoStack.pop();
                        if (action.startsWith("REMOVE:")) {
                            String lineToRestore = action.substring(7);
                            doc.pushLine(lineToRestore);
                            redoStack.push("REMOVE:" + lineToRestore);
                        } else {
                            doc.removeLine();
                            redoStack.push(action);
                        }
                        System.out.println("Deshacer realizado.");
                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }
                    printDocumentContent(doc);
                    break;

                case 4:
                    if (!redoStack.isEmpty()) {
                        String action = redoStack.pop();
                        if (action.startsWith("REMOVE:")) {
                            String lineToRemove = action.substring(7);
                            doc.removeLine();
                            undoStack.push("REMOVE:" + lineToRemove);
                        } else {
                            doc.pushLine(action);
                            undoStack.push(action);
                        }
                        System.out.println("Rehacer realizado.");
                    } else {
                        System.out.println("No hay acciones para rehacer.");
                    }
                    printDocumentContent(doc);
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    private static void printDocumentContent(Documento doc) {
        System.out.println("Contenido actual del documento:");
        for (String line : doc.getCuerpo()) {
            System.out.println(line);
        }
        System.out.println("Fin del contenido.\n");
    }
}
