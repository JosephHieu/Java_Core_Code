package ArrayReferences;

public class Main {

    public static void main(String... args) {

        String[] splitStrings = "Hello World again".split(" ");
    }

    private static void printText(String... textList) {
        for(String t : textList) {
            System.out.println(t);
        }
    }
}
