import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void spielfeldprint(int spieler1x, int spieler1y, int spieler2x, int spieler2y, String avatarstrings1, String avatarstrings2, String name) throws InterruptedException {
        int a = 0;
        int b = 0;

        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
        while (b < 12) {
            while (a < 16) {

                if (a == 0 || b == 0 || b == 11) {
                    System.out.print("(X)");
                }
                if (spieler1x == spieler2x && spieler1y == spieler2y && (a == spieler1x && b == spieler1y)) {
                    System.out.print("(A)");
                    a++;
                } else if ((a == spieler1x && b == spieler1y)) {
                    System.out.print(avatarstrings1);
                    if (spieler2x == spieler1x + 1 && spieler2y == spieler1y) {
                        System.out.print(avatarstrings2);
                        a++;
                    }
                    a++;
                } else if (a == spieler2x && b == spieler2y) {
                    System.out.print(avatarstrings2);
                    if (spieler1x == spieler2x + 1 && spieler1y == spieler2y) {
                        System.out.print(avatarstrings1);
                        a++;
                    }
                    a++;
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
        System.out.println(spieler1x);
        System.out.println("und auf der Y-Koordinate:");
        System.out.println(spieler1y);

    }

    public static int[] bewegung(int x, int y, String avatarstring, String name, boolean bool4) {
        boolean bool5 = false;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        int[] xy = new int[3];

        while (!bool5) {
            System.out.println("Wo möchtest du den Roboter hinbewegen? (1 - oben ; 2 - rechts ; 3 - unten ; 4 - links ; 5 - Verbleib auf Position)");
            System.out.println("Mit 6 kannst du das Spiel beenden");
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
                bool5 = true;
            } else if (auswahl == 6) {
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
        String avatarstrings1 = "";
        String avatarstrings2 = "";

        name = namensueberpruefung(name);

        avatarstrings1 = avatarauswahl(avatarstrings1);

        System.out.println("Jetzt für deinen Gegner:");

        avatarstrings2 = avatarauswahl(avatarstrings2);

        System.out.println("Dein Roboter heißt: " + name);
        System.out.println("Dein Roboter sieht so aus : " + avatarstrings1);

        boolean bool2 = false;
        boolean bool3 = false;
        int spieler2x = 7;
        int spieler2y = 2;

        System.out.println("Wähle eine X-Koordinate");
        int spieler1x = scanner.nextInt();

        while (!bool2) {
            if (spieler1x <= 15 && spieler1x >= 0) {
                bool2 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                spieler1x = scanner.nextInt();
            }
        }
        System.out.println("wähle eine Y-Koordinate");
        int spieler1y = scanner.nextInt();

        while (!bool3) {
            if (spieler1y <= 10 && spieler1y >= 0) {
                bool3 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                spieler1y = scanner.nextInt();
            }
        }

        boolean bool4 = true;

        while (bool4) {

            spielfeldprint(spieler1x, spieler1y, spieler2x, spieler2y, avatarstrings1, avatarstrings2, name);

            xy = bewegung(spieler1x, spieler1y, avatarstrings1, name, bool4);
            spieler1x = xy[0];
            spieler1y = xy[1];

            if (xy[2] == 1) {
                bool4 = false;
            }
        }
    }
}
