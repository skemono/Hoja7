package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BinaryTree<String, String> dictionary = new BinaryTree<>();

        // Leer el archivo de diccionario y construir el árbol binario
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    String key = parts[0].trim().substring(1); // Elimina el paréntesis abierto
                    String value = parts[1].trim().substring(0, parts[1].length() - 1); // Elimina el paréntesis cerrado
                    Association<String, String> association = new Association<>(key, value);
                    dictionary.insert(association); // Inserta la asociación en el árbol
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Realizar el recorrido en orden del árbol para mostrar las relaciones ordenadas por la palabra en inglés
        System.out.println("Relaciones ordenadas por la palabra en inglés:");
        dictionary.inorderTraversal();

        // Leer el archivo de texto para traducir las palabras
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    // Separa las palabras y traduce cada una
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        String translation = dictionary.lookup(word.toLowerCase()); // Busca la palabra en minúscula
                        if (translation != null) {
                            System.out.print(translation + " ");
                        } else {
                            System.out.print("*" + word + "* ");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
