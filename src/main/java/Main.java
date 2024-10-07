import java.util.Random;
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
                    System.out.print("\u001b[31m(X)\u001b[0m");
                }
                if (spieler1x == spieler2x && spieler1y == spieler2y && (a == spieler1x && b == spieler1y)) {
                    System.out.print("\u001b[31;1m(A)\u001b[0m");
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
            }
            System.out.println("\u001b[31m(X)\u001b[0m");
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
            System.out.println("Wo möchtest du den Roboter hinbewegen? (w - oben ; a - links ; s - unten  ; d - rechts ; b - Verbleib auf Position)");
            System.out.println("Mit q kannst du das Spiel beenden");
            String auswahl = scanner.nextLine();

            if (auswahl.equals("w")) {
                y--;
                if (y == 0) {
                    System.out.println("Der Zug ist außerhalb des Spielfeldes");
                    y++;
                } else {
                    bool5 = true;
                }
            } else if (auswahl.equals("d")) {
                x++;
                if (x == 16) {
                    System.out.println("Der Zug ist außerhalb des Spielfeldes");
                    x--;
                } else {
                    bool5 = true;
                }
            } else if (auswahl.equals("s")) {
                y++;
                if (y == 11) {
                    System.out.println("Der Zug ist außerhalb des Spielfeldes");
                    y--;
                } else {
                    bool5 = true;
                }
            } else if (auswahl.equals("a")) {
                x--;
                if (x == 0) {
                    System.out.println("Der Zug ist außerhalb des Spielfeldes \n");
                    x++;
                } else {
                    bool5 = true;
                }
            } else if (auswahl.equals("b")) {
                bool5 = true;
            } else if (auswahl.equals("q")) {
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
        System.out.println("Wähle einen Namen für den Roboter");

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

    public static String farbe(String name, String farbes1) {
        Scanner scanner = new Scanner(System.in);
        String farbe = "";
        boolean check = false;

        System.out.println("\n" + name + " welche Farbe soll dein Robo haben?");
        System.out.println("\u001b[31;1m1. Rot");
        System.out.println("\u001b[32;1m2. Grün");
        System.out.println("\u001b[33;1m3. Gelb");
        System.out.println("\u001b[34;1m4. Blau");
        System.out.println("\u001b[35;1m5. Magenta\u001b[0m");

        while (!check) {
            int auswahl = scanner.nextInt();
            if (auswahl == 1) {
                farbe = "\u001b[31;1m";
                check = true;
            } else if (auswahl == 2) {
                farbe = "\u001b[32;1m";
                check = true;
            } else if (auswahl == 3) {
                farbe = "\u001b[33;1m";
                check = true;
            } else if (auswahl == 4) {
                farbe = "\u001b[34;1m";
                check = true;
            } else if (auswahl == 5) {
                farbe = "\u001b[35;1m";
                check = true;
            } else {
                System.out.println("Wähle eine Zahl zwischen 1 und 5");
            }
            if (farbe.equals(farbes1) && !farbes1.isEmpty()) {
                System.out.println("\nbitte wähle eine andere Farbe als dein Gegner");
                check = false;
            }
        }
        return farbe;
    }


    public static void main(String[] args) throws InterruptedException {
        int[] xy = new int[2];
        boolean bool = false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String robotArt = "\u001b[31;1m          _____                   _______                   _____                   _______               _____                    _____                    _____                    _____                    _____          \n" +
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


        System.out.println(robotArt + "\u001b[0m");

        String names1 = "";
        String names2 = "";
        String avatarstrings1 = "";
        String avatarstrings2 = "";
        String farbes1 = "";
        String farbes2 = "";

        System.out.println("Herzlich Willkommen bei Robot-Wars");
        System.out.println("Spieler:");

        names1 = namensueberpruefung(names1);

        avatarstrings1 = avatarauswahl(avatarstrings1);

        farbes1 = farbe(names1, farbes1);

        System.out.println("Jetzt für deinen Gegner:");

        names2 = namensueberpruefung(names2);

        avatarstrings2 = avatarauswahl(avatarstrings2);

        farbes2 = farbe(names2, farbes1);

        names1 = farbes1 + names1 + "\u001b[0m";
        avatarstrings1 = farbes1 + avatarstrings1 + "\u001b[0m";
        names2 = farbes2 + names2 + "\u001b[0m";
        avatarstrings2 = farbes2 + avatarstrings2 + "\u001b[0m";

        System.out.println("Dein Roboter heißt: " + names1);
        System.out.println("Dein Roboter sieht so aus : " + avatarstrings1);
        System.out.println("Dein Gegner heißt: " + names2);
        System.out.println("Dein Gegner sieht so aus : " + avatarstrings2);

        boolean bool2 = false;
        boolean bool3 = false;
        int spieler2x = 7;
        int spieler2y = 2;

        System.out.println("\nWähle eine X-Koordinate");
        int spieler1x = scanner.nextInt();

        while (!bool2) {
            if (spieler1x <= 15 && spieler1x >= 0) {
                bool2 = true;
            } else {
                System.out.println("Wähle eine Zahl im Spielfeld (15x10)");
                spieler1x = scanner.nextInt();
            }
        }
        System.out.println("\nwähle eine Y-Koordinate");
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

            spielfeldprint(spieler1x, spieler1y, spieler2x, spieler2y, avatarstrings1, avatarstrings2, names1);

            xy = bewegung(spieler1x, spieler1y, avatarstrings1, names1, bool4);
            spieler1x = xy[0];
            spieler1y = xy[1];

            if (xy[2] == 1) {
                bool4 = false;
            }

            while (spieler1x == spieler2x && spieler1y == spieler2y && bool4) {

                spielfeldprint(spieler1x, spieler1y, spieler2x, spieler2y, avatarstrings1, avatarstrings2, names1);
                TimeUnit.MILLISECONDS.sleep(1000);

                System.out.println("Es kommt zu einem Kampf");
                TimeUnit.MILLISECONDS.sleep(500);

                System.out.println(names1 + " würfelt");
                TimeUnit.MILLISECONDS.sleep(2000);
                int wuerfels1 = random.nextInt(6) + 1;
                System.out.println(names1 + " hat folgendes gewürfelt: " + wuerfels1);
                TimeUnit.MILLISECONDS.sleep(2000);

                System.out.println(names2 + " würfelt");
                TimeUnit.MILLISECONDS.sleep(2000);
                int wuerfels2 = random.nextInt(6) + 1;
                System.out.println(names2 + " hat folgendes gewürfelt: " + wuerfels2);
                TimeUnit.MILLISECONDS.sleep(2000);

                if (wuerfels1 > wuerfels2) {
                    System.out.print("\u001b[32;1m .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .-----------------. .----------------.  .-----------------.\n" +
                            "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                            "| |    ______    | || |  _________   | || | _____  _____ | || |     ____     | || | ____  _____  | || | ____  _____  | || |  _________   | || | ____  _____  | |\n" +
                            "| |  .' ___  |   | || | |_   ___  |  | || ||_   _||_   _|| || |   .'    `.   | || ||_   \\|_   _| | || ||_   \\|_   _| | || | |_   ___  |  | || ||_   \\|_   _| | |\n" +
                            "| | / .'   \\_|   | || |   | |_  \\_|  | || |  | | /\\ | |  | || |  /  .--.  \\  | || |  |   \\ | |   | || |  |   \\ | |   | || |   | |_  \\_|  | || |  |   \\ | |   | |\n" +
                            "| | | |    ____  | || |   |  _|  _   | || |  | |/  \\| |  | || |  | |    | |  | || |  | |\\ \\| |   | || |  | |\\ \\| |   | || |   |  _|  _   | || |  | |\\ \\| |   | |\n" +
                            "| | \\ `.___]  _| | || |  _| |___/ |  | || |  |   /\\   |  | || |  \\  `--'  /  | || | _| |_\\   |_  | || | _| |_\\   |_  | || |  _| |___/ |  | || | _| |_\\   |_  | |\n" +
                            "| |  `._____.'   | || | |_________|  | || |  |__/  \\__|  | || |   `.____.'   | || ||_____|\\____| | || ||_____|\\____| | || | |_________|  | || ||_____|\\____| | |\n" +
                            "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                            "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                            " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'");
                    System.out.println("\n\u001b[0m Herzlichen Glückwunsch " + names1 + " du hast gewonnen!");
                    bool4 = false;
                } else if (wuerfels1 == wuerfels2) {
                    System.out.println("Das ist ein Unentschieden und es wird erneut gewürfelt");
                    TimeUnit.MILLISECONDS.sleep(2000);
                } else {
                    System.out.println("Dein Gegner " + names2 + " hat dich im Kampf bezwungen, viel Glück beim nächsten mal!");
                    bool4 = false;
                }
            }
        }
    }
}
