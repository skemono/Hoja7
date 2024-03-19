import org.example.Association;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.example.BinaryTree;
import org.junit.jupiter.api.Test;
public class TestBinaryTree {

    @Test
    public void testInsertAndLookup() {
        BinaryTree<String, String> tree = new BinaryTree<>();

        // Insertar algunas asociaciones
        tree.insert(new Association<>("house", "casa"));
        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("homework", "tarea"));
        tree.insert(new Association<>("woman", "mujer"));
        tree.insert(new Association<>("town", "pueblo"));
        tree.insert(new Association<>("yes", "sí"));

        // Verificar que se puedan buscar las asociaciones correctamente
        assertEquals("casa", tree.lookup("house"));
        assertEquals("perro", tree.lookup("dog"));
        assertEquals("tarea", tree.lookup("homework"));
        assertEquals("mujer", tree.lookup("woman"));
        assertEquals("pueblo", tree.lookup("town"));
        assertEquals("sí", tree.lookup("yes"));

        // Verificar que una palabra que no está en el diccionario devuelve null
        assertNull(tree.lookup("cat"));
    }
}
