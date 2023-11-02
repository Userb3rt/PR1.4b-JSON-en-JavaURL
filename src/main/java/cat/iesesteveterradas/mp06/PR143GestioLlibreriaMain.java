package cat.iesesteveterradas.mp06;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PR143GestioLlibreriaMain {

    static String[] titles = { "Id", "Títol", "Autor", "Any" };

    public static void main(String[] args) throws IOException {
        /*
         * primer imprimirem la capçalera dels títols dels atributs per poder llegir-los
         */
        for (int i = 0; i < titles.length; i++) {
            System.out.print(titles[i] + tabular(titles[i]));

        }
        System.out.println("");
        /*
         * 
         * llegir jason
         * 
         */
        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String, Object>> llistaDeLlibres = objectMapper.readValue(
                new File("src/main/java/cat/iesesteveterradas/resources/assets/llibres_input.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class));

        for (Map<String, Object> map : llistaDeLlibres) {
            System.out.print(map.get("id") + tabular(map.get("id") + ""));
            System.out.print(map.get("títol") + tabular(map.get("títol") + ""));
            System.out.print(map.get("autor") + tabular(map.get("autor") + ""));
            System.out.print(map.get("any") + tabular(map.get("any") + ""));
            System.out.println("");
        }
        /*
         * 
         * Modificar jason
         * 
         */
        try {
            // Nom de l'arxiu JSON
            String nomArxiu = "src/main/java/cat/iesesteveterradas/resources/assets/llibres_input.json";
            objectMapper = new ObjectMapper();
            // Llegir l'arxiu JSON en una llista d'objectes
            List<ObjectNode> llistaLlibres = objectMapper.readValue(new File(nomArxiu),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, ObjectNode.class));
            // Iterar sobre la llista d'objectes i buscar el que tingui un id igual a 1
            for (ObjectNode llibre : llistaLlibres) {
                int id = llibre.get("id").asInt();
                if (id == 1) {
                    // Modificar el camp "any" a 1995
                    llibre.put("any", 1995);
                }
            }
            // Desar la llista d'objectes modificada a l'arxiu JSON original
            objectMapper.writeValue(new File(nomArxiu), llistaLlibres);

            System.out.println("Arxiu JSON modificat amb èxit.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 
         * afegir jason
         * 
         */
        try {
            // Nom de l'arxiu JSON
            String nomArxiu = "src/main/java/cat/iesesteveterradas/resources/assets/llibres_input.json";
            objectMapper = new ObjectMapper();
            // Llegir l'arxiu JSON en una llista d'objectes
            List<ObjectNode> llistaLlibres = objectMapper.readValue(new File(nomArxiu),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, ObjectNode.class));
            // Crear un nou llibre com un objecte JSON
            ObjectNode nouLlibre = objectMapper.createObjectNode();
            nouLlibre.put("id", 4);
            nouLlibre.put("títol", "Històries de la ciutat");
            nouLlibre.put("autor", "Miquel Soler");
            nouLlibre.put("any", 2022);
            // Afegir el nou llibre a la llista de llibres
            llistaLlibres.add(nouLlibre);
            // Desar la llista de llibres modificada a l'arxiu JSON original
            objectMapper.writeValue(new File(nomArxiu), llistaLlibres);
            System.out.println("Nou llibre afegit a l'arxiu JSON amb èxit.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 
         * eliminar jason
         * 
         */
        try {
            // Nom de l'arxiu JSON
            String nomArxiu = "src/main/java/cat/iesesteveterradas/resources/assets/llibres_input.json";
            objectMapper = new ObjectMapper();
            // Llegir l'arxiu JSON en una llista d'objectes
            List<ObjectNode> llistaLlibres = objectMapper.readValue(new File(nomArxiu), objectMapper.getTypeFactory().constructCollectionType(List.class, ObjectNode.class));
            // Iterar sobre la llista de llibres i buscar el que tingui un id igual a 2
            java.util.Iterator<ObjectNode> iter = llistaLlibres.iterator();
            while (iter.hasNext()) {
                ObjectNode llibre = iter.next();
                int id = llibre.get("id").asInt();
                if (id == 2) {
                    // Esborrar el llibre amb id igual a 2
                    iter.remove();
                }
            }
            // Desar la llista de llibres modificada a l'arxiu JSON original
            objectMapper.writeValue(new File(nomArxiu), llistaLlibres);
            System.out.println("Llibre amb ID 2 esborrat de l'arxiu JSON amb èxit.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String tabular(String restar) {
        String resultat = "";
        for (int j = 0; j < 30 - restar.length(); j++) {
            resultat += " ";
        }
        return resultat;
    }

}
