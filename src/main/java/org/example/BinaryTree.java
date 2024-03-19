package org.example;

public class BinaryTree<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public BinaryTree() {
        this.root = null;
    }

    // Método para insertar un nodo en el árbol
    public void insert(Association<K, V> data) {
        root = insertRec(root, data);
    }

    // Método auxiliar para la inserción recursiva
    private TreeNode<K, V> insertRec(TreeNode<K, V> root, Association<K, V> data) {
        if (root == null) {
            return new TreeNode<>(data);
        }

        K rootKey = root.getData().getKey();
        K newDataKey = data.getKey();

        if (newDataKey.compareTo(rootKey) < 0) {
            root.setLeftChild(insertRec(root.getLeftChild(), data));
        } else if (newDataKey.compareTo(rootKey) > 0) {
            root.setRightChild(insertRec(root.getRightChild(), data));
        }

        return root;
    }

    // Método para realizar el recorrido en orden (in-order traversal) del árbol
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    // Método auxiliar para realizar el recorrido en orden de manera recursiva
    private void inorderTraversal(TreeNode<K, V> root) {
        if (root != null) {
            inorderTraversal(root.getLeftChild());
            System.out.println(root.getData());
            inorderTraversal(root.getRightChild());
        }
    }

    // Método para buscar una palabra en el árbol y obtener su traducción
    public V lookup(K key) {
        return lookupRec(root, key);
    }

    // Método auxiliar para la búsqueda recursiva
    private V lookupRec(TreeNode<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        K rootKey = root.getData().getKey();

        if (key.compareTo(rootKey) < 0) {
            return lookupRec(root.getLeftChild(), key);
        } else if (key.compareTo(rootKey) > 0) {
            return lookupRec(root.getRightChild(), key);
        } else {
            return root.getData().getValue();
        }
    }
}
