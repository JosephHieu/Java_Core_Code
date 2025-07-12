package PathListings;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("files/testing.txt");
        printPathInfo(path);

    }

    private static void printPathInfo(Path path) {

        System.out.println("Path: " + path);
        System.out.println("fileName = " + path.getFileName());
        System.out.println("parent = " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute Path: = " + absolutePath);
        System.out.println("Absolute Path Root: = " + absolutePath.getRoot());
        System.out.println("isAbsolute = " + path.isAbsolute());
        System.out.println("-----------------------");

    }
}
