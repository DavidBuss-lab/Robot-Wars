import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String robotArt = "  +--------+\n" +
                "  |  [::]  |\n" +
                "  |  [::]  |\n" +
                "  |  [::]  |\n" +
                "  +--------+\n" +
                "  |  [__]  |\n" +
                "  |        |\n" +
                "  |  ROBOT |\n" +
                "  |  WARS  |\n" +
                "  +--------+\n" +
                "     |  |\n" +
                "    /    \\\n" +
                "   |      |\n" +
                "   |______|\n";
        System.out.println(robotArt);

        System.out.println("Willkommen bei Robot-Wars, wähle einen Namen für deinen Roboter");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        boolean bool = false;

        while (bool == false) {
            if (name.contains(" ")) {
            } else if (name.contains(".")) {
            } else if (name.contains(",")) {
            } else if (name.contains("-")) {
            } else if (name.contains("!")) {
            } else if (name.contains("§")) {
            } else if (name.contains("$")) {
            } else if (name.contains("%")) {
            } else if (name.contains("&")) {
            } else if (name.contains("/")) {
            } else if (name.contains("(")) {
            } else if (name.contains(")")) {
            } else if (name.contains("=")) {
            } else if (name.contains("?")) {
            } else if (name.contains("´")) {
            } else if (name.contains("`")) {
            } else if (name.contains("+")) {
            } else if (name.contains("*")) {
            } else if (name.contains("'")) {
            } else if (name.contains("#")) {
            } else if (name.contains(";")) {
            } else if (name.contains(":")) {
            } else if (name.contains("_")) {
            } else if (name.contains("^")) {
            } else if (name.contains(">")) {
            } else if (name.contains("<")) {
            } else {
                bool = true;
            }
            if (bool == false) {
                System.out.println("Dieser Name enthält verbotene Zeichen (bitte nur Zahlen und Buchstaben)");
                System.out.println("Gebe einen anderen Namen ein");
                name = scanner.nextLine();
            }
        }
        System.out.println("Dein Roboter heißt: " + name);

        int x = 0;
        int y = 0;

        while (y < 10) {
            while (x < 14) {
                System.out.print("[ ]");
                x = x + 1;
                TimeUnit.MILLISECONDS.sleep(50);
            }
            System.out.println("[ ]");
            y = y + 1;
            x= 0;
        }
    }
}
