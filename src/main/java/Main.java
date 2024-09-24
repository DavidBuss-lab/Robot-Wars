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

        while (!bool) {
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

            if (!bool) {
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

        while (!bool2) {
            if (x <= 15 && x >= 0) {
                bool2 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                x = scanner.nextInt();
            }
        }
        System.out.println("wähle eine Y-Koordinate");
        int y = scanner.nextInt();

        while (!bool3) {
            if (y <= 10 && y >= 0) {
                bool3 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                y = scanner.nextInt();
            }
        }

        int a = 0;
        int b = 0;
        boolean bool4 = true;

        while (bool4) {
            while (b < 12) {
                while (a < 16) {

                    if (a == x && b == y) {
                        System.out.print("{O}");
                        a++;
                        }
                    else if (a == 0 || b == 0 || b == 11) {
                        System.out.print("(X)");
                    } if (a > 0 && b > 0 && a < 16 && b < 11) {
                        System.out.print("[ ]");
                    }
                    a = a + 1;
                    TimeUnit.MILLISECONDS.sleep(20);
                }
                System.out.println("(X)");
                b = b + 1;
                a = 0;
            }

            System.out.println("Der Roboter " + name + " befindet sich auf der X-Koordinate:");
            System.out.println(x);
            System.out.println("und auf der Y-Koordinate:");
            System.out.println(y);

            boolean bool5 = false;
            b = 0;

            while (!bool5) {
                System.out.println("Wo möchtest du den Roboter hinbewegen? (1 - oben ; 2 - rechts ; 3 - unten ; 4 - links");
                System.out.println("Mit 5 kannst du das Spiel beenden");
                int auswahl = scanner.nextInt();

                if (auswahl == 1) {
                    y--;
                    if (y == 0) {
                        System.out.println("Der Zug ist außerhalb des Spielfeldes");
                        y++;
                    } else {
                        bool5 = true;
                    }
                } else if (auswahl == 2) {
                    x++;
                    if (x == 16) {
                        System.out.println("Der Zug ist außerhalb des Spielfeldes");
                        x--;
                    } else {
                        bool5 = true;
                    }
                } else if (auswahl == 3) {
                    y++;
                    if (y == 11) {
                        System.out.println("Der Zug ist außerhalb des Spielfeldes");
                        y--;
                    } else {
                        bool5 = true;
                    }
                } else if (auswahl == 4) {
                    x--;
                    if (x == 0) {
                        System.out.println("Der Zug ist außerhalb des Spielfeldes");
                        x++;
                    } else {
                        bool5 = true;
                    }
                } else if (auswahl == 5) {
                    bool4 = false;
                    bool5 = true;
                } else {
                    System.out.println("ungültiger Zug");
                }
            }

        }
    }
}
