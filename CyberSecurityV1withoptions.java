package Woche3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CyberSecurityV1withoptions {
    public static void main(String[] args) {

        Random r = new Random();
        String possible = "ABCabc012!";
        char[] pChars = possible.toCharArray();

        char[] password = new char[4];

        char[] passwordneu = new char[4];

        boolean con;
        boolean con2 = true;
        boolean again = true;
        int counttotal;
        int times;

        System.out.println("\nHello Sir. Do you want to ckrack the generated password by linear or random program type?\n");

        do {

            System.out.println("... press 1 for linear program.");
            System.out.println("... press 2 for random.");
            System.out.println("... press 0 for exit program.");

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();

            if (choose == 0) {
                System.out.println("bye bye...");
                System.exit(0);
            }

            System.out.println("How often should the program be repeated to determine an average value?");
            int howoften = sc.nextInt();


            if (choose == 1) {
                counttotal = 0;
                times = 0;
                do {
                    con = true;

                    do {
                        int count = 0;

                        for (int x = 0; x < password.length; x++) {
                            password[x] = pChars[r.nextInt(pChars.length)];
                        }
                        String genpw = new String(password);
                        System.out.println("Generated Password: " + genpw + "");
                        System.out.println("working...");

                        for (int i = 0; i < pChars.length && con; i++) {
                            for (int j = 0; j < pChars.length && con; j++) {
                                for (int k = 0; k < pChars.length && con; k++) {
                                    for (int l = 0; l < pChars.length && con; l++) {
                                        passwordneu[0] = pChars[i];
                                        passwordneu[1] = pChars[j];
                                        passwordneu[2] = pChars[k];
                                        passwordneu[3] = pChars[l];

                                        String temppw = new String(passwordneu);

                                        if (temppw.equals(genpw)) {
                                            System.out.println("bli bla blu bla bla");
                                            System.out.println("Found it: " + temppw + " = " + genpw);
                                            System.out.println("It took " + count + " guesses.\n");
                                            con = false;
                                            howoften = howoften - 1;
                                            times = times + 1;

                                        } else {
                                            count = count + 1;
                                            counttotal = counttotal + 1;

                                        }
                                    }
                                }
                            }
                        }
                    } while (con);

                } while (howoften > 0);
                System.out.println("Total runs in linear program: " + times);
                System.out.println("Average guesses for each run: " + (counttotal / times));

            } else if (choose == 2) {
                counttotal = 0;
                times = 0;
                do {
                    con = true;
                    con2 = true;

                    do {
                        int count = 0;

                        for (int x = 0; x < password.length; x++) {
                            password[x] = pChars[r.nextInt(pChars.length)];
                        }
                        String genpw = new String(password);

                        System.out.println("Generated Password: " + genpw + "");
                        System.out.println("working...");

                        do {
                            for (int i = 0; i < passwordneu.length && con && con2; i++) {
                                passwordneu[i] = pChars[r.nextInt(pChars.length)];

                                String temppw = new String(passwordneu);

                                if (temppw.equals(genpw)) {
                                    System.out.println("bli bla blu bla bla");
                                    System.out.println("Found it: " + temppw + " = " + genpw);
                                    System.out.println("It took " + count + " guesses.\n");
                                    con = false;
                                    con2 = false;
                                    howoften = howoften - 1;
                                    times = times + 1;
                                } else {
                                    count = count + 1;
                                    counttotal = counttotal + 1;
                                }
                            }
                        } while (con2);
                    } while (con);
                } while (howoften > 0);
                System.out.println("Total runs in random program: " + times);
                System.out.println("Average guesses for each run: " + (counttotal / times));
            }
            System.out.println("\ndo you want to make another turn?");
            System.out.println("... press 1 for continue.");
            System.out.println("... press 0 for exit program.");
            int tryagain = sc.nextInt();

            if (tryagain == 1) {
                again = true;
            } else {
                again = false;
            }
        } while (again);

        System.out.println("\nbye bye...");
    }
}

