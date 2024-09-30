import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void spielfeldprint(int x, int y, String avatarstring, String name) throws InterruptedException {
        int a = 0;
        int b = 0;

        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
        while (b < 12) {
            while (a < 16) {

                if (a == x && b == y) {
                    System.out.print(avatarstring);
                    a++;
                } else if (a == 0 || b == 0 || b == 11) {
                    System.out.print("(X)");
                }
                if (a > 0 && b > 0 && a < 16 && b < 11) {
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

    }

    public static int[] bewegung(int x, int y, String avatarstring, String name, boolean bool4) {
        boolean bool5 = false;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        int[] xy = new int[3];

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
                    System.out.println("Der Zug ist außerhalb des Spielfeldes \n");
                    x++;
                } else {
                    bool5 = true;
                }
            } else if (auswahl == 5) {
                xy[2] = 1;
                bool5 = true;
            } else {
                System.out.println("ungültiger Zug");
            }
        }
        xy[0] = x;
        xy[1] = y;
        return xy;
    }

    public static String namensueberpruefung(String name) {
        boolean bool = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen bei Robot-Wars, wähle einen Namen für deinen Roboter");

        while (!bool) {
            name = scanner.nextLine();

            if (name.contains(" ") || name.contains(".") ||
                    name.contains(",") || name.contains("-") ||
                    name.contains("!") || name.contains("§") ||
                    name.contains("$") || name.contains("%") ||
                    name.contains("&") || name.contains("/") ||
                    name.contains("(") || name.contains(")") ||
                    name.contains("=") || name.contains("?") ||
                    name.contains("´") || name.contains("`") ||
                    name.contains("+") || name.contains("*") ||
                    name.contains("'") || name.contains("#") ||
                    name.contains(";") || name.contains(":") ||
                    name.contains("_") || name.contains("^") ||
                    name.contains(">") || name.contains("<")) {
                System.out.println("Bitte gebe nur gültige Zeichen ein (Buchstaben und Zahlen)");
            } else {
                bool = true;
            }
        }
        return name;
    }

    public static String avatarauswahl(String avatarstring) {
        boolean boolavatar = true;
        Scanner scanner = new Scanner(System.in);

        while (boolavatar) {
            System.out.println("Wähle einen der folgenden Avatare aus");
            System.out.println("1: {0}");
            System.out.println("2: (§)");
            System.out.println("3: )8(");
            System.out.println("4: /$/");
            int avatarauswahl = scanner.nextInt();

            if (avatarauswahl == 1) {
                avatarstring = "{0}";
                boolavatar = false;
            } else if (avatarauswahl == 2) {
                avatarstring = "(§)";
                boolavatar = false;
            } else if (avatarauswahl == 3) {
                avatarstring = ")8(";
                boolavatar = false;
            } else if (avatarauswahl == 4) {
                avatarstring = "/$/";
                boolavatar = false;
            } else {
                System.out.println("Wähle eine Zahl von 1-4");
            }
        }
        return avatarstring;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] xy = new int[2];
        boolean bool = false;
        Scanner scanner = new Scanner(System.in);

        String robotArt = "          _____                   _______                   _____                   _______               _____                    _____                    _____                    _____                    _____          \n" +
                "         /\\    \\                 /::\\    \\                 /\\    \\                 /::\\    \\             /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\         \n" +
                "        /::\\    \\               /::::\\    \\               /::\\    \\               /::::\\    \\           /::\\    \\                /::\\____\\                /::\\    \\                /::\\    \\                /::\\    \\        \n" +
                "       /::::\\    \\             /::::::\\    \\             /::::\\    \\             /::::::\\    \\          \\:::\\    \\              /:::/    /               /::::\\    \\              /::::\\    \\              /::::\\    \\       \n" +
                "      /::::::\\    \\           /::::::::\\    \\           /::::::\\    \\           /::::::::\\    \\          \\:::\\    \\            /:::/   _/___            /::::::\\    \\            /::::::\\    \\            /::::::\\    \\      \n" +
                "     /:::/\\:::\\    \\         /:::/~~\\:::\\    \\         /:::/\\:::\\    \\         /:::/~~\\:::\\    \\          \\:::\\    \\          /:::/   /\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\     \n" +
                "    /:::/__\\:::\\    \\       /:::/    \\:::\\    \\       /:::/__\\:::\\    \\       /:::/    \\:::\\    \\          \\:::\\    \\        /:::/   /::\\____\\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\    \n" +
                "   /::::\\   \\:::\\    \\     /:::/    / \\:::\\    \\     /::::\\   \\:::\\    \\     /:::/    / \\:::\\    \\         /::::\\    \\      /:::/   /:::/    /       /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\   \n" +
                "  /::::::\\   \\:::\\    \\   /:::/____/   \\:::\\____\\   /::::::\\   \\:::\\    \\   /:::/____/   \\:::\\____\\       /::::::\\    \\    /:::/   /:::/   _/___    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    ___\\:::\\   \\:::\\    \\  \n" +
                " /:::/\\:::\\   \\:::\\____\\ |:::|    |     |:::|    | /:::/\\:::\\   \\:::\\ ___\\ |:::|    |     |:::|    |     /:::/\\:::\\    \\  /:::/___/:::/   /\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\____\\  /\\   \\:::\\   \\:::\\    \\ \n" +
                "/:::/  \\:::\\   \\:::|    ||:::|____|     |:::|    |/:::/__\\:::\\   \\:::|    ||:::|____|     |:::|    |    /:::/  \\:::\\____\\|:::|   /:::/   /::\\____\\/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::|    |/::\\   \\:::\\   \\:::\\____\\\n" +
                "\\::/   |::::\\  /:::|____| \\:::\\    \\   /:::/    / \\:::\\   \\:::\\  /:::|____| \\:::\\    \\   /:::/    /    /:::/    \\::/    /|:::|__/:::/   /:::/    /\\::/    \\:::\\  /:::/    /\\::/   |::::\\  /:::|____|\\:::\\   \\:::\\   \\::/    /\n" +
                " \\/____|:::::\\/:::/    /   \\:::\\    \\ /:::/    /   \\:::\\   \\:::\\/:::/    /   \\:::\\    \\ /:::/    /    /:::/    / \\/____/  \\:::\\/:::/   /:::/    /  \\/____/ \\:::\\/:::/    /  \\/____|:::::\\/:::/    /  \\:::\\   \\:::\\   \\/____/ \n" +
                "       |:::::::::/    /     \\:::\\    /:::/    /     \\:::\\   \\::::::/    /     \\:::\\    /:::/    /    /:::/    /            \\::::::/   /:::/    /            \\::::::/    /         |:::::::::/    /    \\:::\\   \\:::\\    \\     \n" +
                "       |::|\\::::/    /       \\:::\\__/:::/    /       \\:::\\   \\::::/    /       \\:::\\__/:::/    /    /:::/    /              \\::::/___/:::/    /              \\::::/    /          |::|\\::::/    /      \\:::\\   \\:::\\____\\    \n" +
                "       |::| \\::/____/         \\::::::::/    /         \\:::\\  /:::/    /         \\::::::::/    /     \\::/    /                \\:::\\__/:::/    /               /:::/    /           |::| \\::/____/        \\:::\\  /:::/    /    \n" +
                "       |::|  ~|                \\::::::/    /           \\:::\\/:::/    /           \\::::::/    /       \\/____/                  \\::::::::/    /               /:::/    /            |::|  ~|               \\:::\\/:::/    /     \n" +
                "       |::|   |                 \\::::/    /             \\::::::/    /             \\::::/    /                                  \\::::::/    /               /:::/    /             |::|   |                \\::::::/    /      \n" +
                "       \\::|   |                  \\::/____/               \\::::/    /               \\::/____/                                    \\::::/    /               /:::/    /              \\::|   |                 \\::::/    /       \n" +
                "        \\:|   |                   ~~                      \\::/____/                 ~~                                           \\::/____/                \\::/    /                \\:|   |                  \\::/    /        \n" +
                "         \\|___|                                            ~~                                                                     ~~                       \\/____/                  \\|___|                   \\/____/         \n" +
                "                                                                                                                                                                                                                      ";


        System.out.println(robotArt);

        String name = "";
        String avatarstring = "";

        name = namensueberpruefung(name);

        avatarstring = avatarauswahl(avatarstring);

        System.out.println("Dein Roboter heißt: " + name);
        System.out.println("Dein Roboter sieht so aus : " + avatarstring);

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

        boolean bool4 = true;

        while (bool4) {

            spielfeldprint(x, y, avatarstring, name);

            xy = bewegung(x, y, avatarstring, name, bool4);
            x = xy[0];
            y = xy[1];

            if (xy[2] == 1) {
                bool4 = false;
            }
        }
    }
}
