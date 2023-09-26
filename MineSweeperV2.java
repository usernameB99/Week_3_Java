package Woche3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MineSweeperV2 {
    public static void main(String[] args) {

        Random r = new Random(0);    //TODO      (//FIXME)  // seed o = wiederholt selbe random abfolge

        int[][] map = new int[10][10];
        char[][] display = new char[10][10];
        String letters = "ABCDEFGHIJ";
        int[] numbers = {-3, -2, -1, -0};
        int countmines = 0;
        // int links = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        int fieldstotal;
        int count = 0;
        double percentage;
        String input;
        int revealedmines = 0;

        ArrayList<String> inputstring = new ArrayList();


        // zeitgleiche initialisierung von arrays map[][] und display[][]

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = numbers[r.nextInt(numbers.length)];
                display[i][j] = ' ';
                if (map[i][j] == 0) {
                    countmines = countmines + 1;
                }
            }
        }
        fieldstotal = 100 - countmines;

        //---------------------------------------------------------------------------------------------------
        //                                 Ausgabe display
        do {


            System.out.print("    A   B   C   D   E   F   G   H   I   J\n");
            for (int i = 0; i < display.length; i++) {
                System.out.print(i + " ");                                          // links durch i ersetzen xD holy shit oida xD - links wird sonst bei jeder runde erhöht
                for (int j = 0; j < display[i].length; j++) {
                    System.out.printf("[%2c]", display[i][j]);
                }
                System.out.println();
                // links = links +1;                                                                    // links++  -> links nix gut da erhöht wird nach jeder runde
            }

            percentage = (double) count * 100 / fieldstotal;                        // auf double casten

            //---------------------------------------------------------------------------------------------------
            //                                  Eingabe und Abfrage

            System.out.println("Du hast " + count + '/' + fieldstotal + " " + "(" + (String.format("%.1f", percentage)) + "%" + ")" + " des nicht vermienten Gebietes gecheckt.");
            System.out.println("Es bleiben noch " + countmines + " Mienen versteckt.");
            //System.out.println(percentage + "%");

            do {
                do {
                    System.out.println("\nWo willst du nach Mienen suchen?");
                    System.out.print("Eingabe: ");
                    input = sc.nextLine().toUpperCase();                                      // <---- Eingabe von String
                } while (!input.matches("[A-J][0-9]") && input.length() != 2);
                // System.out.println(inputstring);
            } while (inputstring.contains(input));
            inputstring.add(input);
            System.out.println(inputstring);

            //A4
            char[] coordinates = input.toCharArray(); //{A,4} coordinates[0] coordinates[1]

            int column = letters.indexOf(coordinates[0]);                      //column
            int row = Character.getNumericValue(coordinates[1]);            //row

            //System.out.println("test" + map[row][column]);                                                                    // test
            //System.out.println("test" + map[Character.getNumericValue(coordinates[1])][letters.indexOf(coordinates[0])]);     // test


            System.out.println("test column & row: " + column + " " + row);   //Print von nummern

            System.out.println("Inhalt Feld: " + map[letters.indexOf(coordinates[0])][Character.getNumericValue(coordinates[1])]);  //Print was an pos. in array steht (-1,-2,-3,0)

            //---------------------------------------------------------------------------------------------------
            //------------------------------------ Bedingungen: -------------------------------------------------

            //                                 wenn Miene getroffen:

            if (map[Character.getNumericValue(coordinates[1])][letters.indexOf(coordinates[0])] == 0) {

                display[Character.getNumericValue(coordinates[1])][letters.indexOf(coordinates[0])] = '*';
                countmines--;                                                                                           //countmines = countmines - 1

                System.out.print("    A   B   C   D   E   F   G   H   I   J\n");
                for (int i = 0; i < display.length; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < display[i].length; j++) {
                        System.out.printf("[%2c]", display[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("Du hast " + count + '/' + fieldstotal + " des nicht vermienten Gebietes gecheckt.");
                System.out.println("Es bleiben noch " + countmines + " Mienen versteckt.");
                System.out.println("Katuuusch!!! Das war eine Miene... du hast leider verloren.");
                cont = false;

                //------------------------------------------------------------------------------------------------
                //                              wenn -1,-2,-3 Feld aufgedeckt:
            } else {
                System.out.println("-------------------- hier test");

                int dist = -map[row][column] - 1;
                System.out.println("test distance: " + dist);

                for (int k = (row - dist); k <= (row + dist); k++) {
                    for (int j = (column - dist); j <= (column + dist); j++) {

                        if (k >= 0 && k < map.length && j >= 0 && j < map.length) {   // begrenzung

                            //System.out.println("Inhalt Feld: " + map[k][j]);

                            if (map[k][j] == 0) {
                                if (display[k][j] != '*') {
                                    display[k][j] = '*';
                                    countmines--;
                                    revealedmines++;
                                } else {
                                    display[k][j] = '*';
                                }

                            } else {
                                if (display[k][j] != '-') {
                                    display[k][j] = '-';
                                    count++;
                                } else {
                                    display[k][j] = '-';
                                }
                            }
                        }
                    }
                }
            }

            //---------------------------------------------------------------------------------------------------------
            //                                      Gewinn Ausgabe:

            if (countmines == 0 || count == fieldstotal) {

                System.out.print("    A   B   C   D   E   F   G   H   I   J\n");
                for (int i = 0; i < display.length; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < display[i].length; j++) {
                        System.out.printf("[%2c]", display[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("Ding Ding Ding - Du hast gewonnen!!!");
                System.out.println("Du hast " + count + '/' + fieldstotal + " des nicht vermienten Gebietes aufgedeckt.");
                System.out.println("Du hast " + revealedmines + " Mienen aufgedeckt.");

                for (int i = 0; i < 50; i++) {
                    System.out.println("Du hast gewonnen!!!");
                    cont = false;
                }

            }

        } while (cont);

    }
}
