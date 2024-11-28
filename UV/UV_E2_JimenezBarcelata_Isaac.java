public class UV_E2_JimenezBarcelata_Isaac {

    public static void main(String[] args) {
        // Crear un árbol y agregar los datos
        BinaryTree arbol = new BinaryTree();
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);

        // Verificar si el árbol es un BST
        if (isBST(arbol)) {
            System.out.println("El árbol analizado, es BST");
        } else {
            System.out.println("El árbol analizado, No es BST");
        }

        // Modificar un valor para hacer que el árbol no sea BST
        //Nota profe, modifique la clase BinaryTree porque el constructor era privado. Lo pase a publico
        arbol.root.right.left.data = -20;

        // Verificar nuevamente
        if (isBST(arbol)) {
            System.out.println("El árbol analizado, es BST");
        } else {
            System.out.println("El árbol analizado, No es BST");
        }
    }

    // Método para verificar si el árbol es un BST
    public static boolean isBST(BinaryTree arbol) {
        return isBSTUtil(arbol.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Método auxiliar recursivo para verificar si el árbol es un BST
    private static boolean isBSTUtil(BinaryTree.Node node, int min, int max) {
        // Si el nodo es null, se considera válido
        if (node == null) {
            return true;
        }

        // Verificar si el valor del nodo está dentro del rango permitido
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recorrer recursivamente los subárboles izquierdo y derecho
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }
}
