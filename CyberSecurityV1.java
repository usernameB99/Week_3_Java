package Woche3;

import java.util.Arrays;
import java.util.Random;

public class CyberSecurityV1 {
    public static void main(String[] args) {

        Random r = new Random();
        String possible = "ABCabc012!";
        char[] pChars = possible.toCharArray();

        char[] password = new char[4];

        char[] passwordneu = new char[4];

        boolean con = true;

        int counttotal = 0;
        int howoften = 1000;
        int times = 0;

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
        System.out.println("Total runs: " + times);
        System.out.println("Average guesses for each run: " + (counttotal / times));
    }
}

