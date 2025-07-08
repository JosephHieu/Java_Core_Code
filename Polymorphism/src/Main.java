import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Movie mo = Movie.getMovie("Cdventure", "Star");
//        mo.watchMovie();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
                    "S for Science Fiction, or Q to quit): ");
            String type = sc.nextLine();
            if ("Qq".contains(type)) {
                break;
            }

            System.out.println("Enter Movie Title: ");
            String title = sc.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }

    }
}