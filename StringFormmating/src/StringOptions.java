public class StringOptions {

    public static void main(String[] args) {

        String helloWorld = "Hello" + "World";
        helloWorld += " and Goobye";

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + "World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(17));

        StringBuilder emtyStart32 = new StringBuilder(32);
        emtyStart32.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emtyStart32);


    }

    public static void printInformation(String string) {
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInformation(StringBuilder builder) {

        System.out.println("StringBuilder = " + builder);
        System.out.println("length = " + builder.length());
    }
}
