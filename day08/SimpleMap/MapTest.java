package SimpleMap;

public class MapTest {

    public static void main (String[] args) {
        PersonMap personMap = new PersonMap();

        System.out.print("Map should put entries...");
        personMap.put(2, "John Doe");
        personMap.put(4, "James Tyler");
        personMap.put(7, "Jane Smith");
        personMap.put(89, "Tom Hardy");
        personMap.put(34, "Charlize Theron");

        System.out.print("Map is " + (personMap.isEmpty() ? "" : "not") + " empty...");

        System.out.println(personMap.isEmpty() ? "failed!" : "passed!");

        System.out.print("Map should retrieve content matching id...");
        String charlize = personMap.get(34);

        if (charlize.equals("Charlize Theron")) {
            System.out.println("passed!");
        } else {
            System.out.println("failed!");
        }

        System.out.print("Map should return null if no entry matching id is found...");
        String nullStr = personMap.get(22);

        if (nullStr != null) {
            System.out.println("failed!");
        } else {
            System.out.println("passed!");
        }

        System.out.print("Map should not override existing entry...");
        personMap.put(4, "Dan Carter");

        if (personMap.get(4).equals("Dan Carter")) {
            System.out.println("failed!");
        } else {
            System.out.println("passed!");
        }

        System.out.print("Map should delete existing entry...");
        personMap.remove(4);

        if (personMap.get(4) != null) {
            System.out.println("failed!");
        } else {
            System.out.println("passed!");
        }

        System.out.print("Map should ignore deletion of non-existing entry...");
        personMap.remove(99);
        System.out.println("passed!");

        System.out.print("Map should add entry with key that was previously deleted...");
        personMap.put(4, "Dan Carter");

        if (personMap.get(4).equals("Dan Carter")) {
            System.out.println("passed!");
        } else {
            System.out.println("failed!");
        }

    }

}
