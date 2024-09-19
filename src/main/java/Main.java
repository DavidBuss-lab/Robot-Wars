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

        boolean bool2 = false;
        boolean bool3 = false;

        System.out.println("Wähle eine X-Koordinate");
        int x = scanner.nextInt();

        while (bool2 == false) {
            if (x <= 15 && x >= 0) {
                bool2 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                x = scanner.nextInt();
            }
        }
        System.out.println("wähle eine Y-Koordinate");
        int y = scanner.nextInt();

        while (bool3 == false) {
            if (y <= 10 && y >= 0) {
                bool3 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                y = scanner.nextInt();
            }
        }

        int a = 0;
        int b = 0;

        while (b < 12) {
            while (a < 16) {

                if (a == x && b == y) {
                    System.out.print("{O}");
                    a = a + 1;
                }
                if (a == 0 || b == 0 || b == 11) {
                    System.out.print("(X)");
                } else {
                    System.out.print("[ ]");
                }
                a = a + 1;
                TimeUnit.MILLISECONDS.sleep(50);
            }
            System.out.println("(X)");
            b = b + 1;
            a = 0;
        }

        System.out.println("Der Roboter " + name + " befindet sich auf der X-Koordinate:");
        System.out.println(x);
        System.out.println("und auf der Y-Koordinate:");
        System.out.println(y);
    }
}
