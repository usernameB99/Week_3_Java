package Woche3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MinesweeperV1 {
    public static void main(String[] args) {

        Random r = new Random();

        int[][] map = new int[10][10];
        char[][] display = new char[10][10];
        //char [] letters = {'A','B','C','D','E','F','G','H','I','J'};
        String letters = "ABCDEFGHIJ";
        int[] numbers = {-3, -2, -1, -0};
        int countzero = 0;
        // int links = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        int fieldstotal;
        int count = 0;
        double percentage;


        // zeitgleiche initialisierung von arrays map[][] und display[][]

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = numbers[r.nextInt(numbers.length)];
                display[i][j] = ' ';
                if (map[i][j] == 0) {
                    countzero = countzero + 1;
                }
            }
        }
        fieldstotal = 100 - countzero;

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
            System.out.println("Es bleiben noch " + countzero + " Mienen versteckt.");
            //System.out.println(percentage + "%");


            System.out.println("\nWo willst du nach Mienen suchen?");
            String input = sc.nextLine();

            //A4
            char[] coordinates = input.toCharArray(); //{A,4} coordinates[0] coordinates[1]

            // int test = letters.indexOf(coordinates[0]);
            // int test2 = Character.getNumericValue(coordinates[1]);

            System.out.println(map[letters.indexOf(coordinates[0])][Character.getNumericValue(coordinates[1])]);

            //---------------------------------------------------------------------------------------------------
            //                                 Bedingungen

            if (map[Character.getNumericValue(coordinates[1])][letters.indexOf(coordinates[0])] == 0) {

                display[Character.getNumericValue(coordinates[1])][letters.indexOf(coordinates[0])] = '*';
                countzero--;                                                                                           //countzero = countzero - 1

                System.out.print("    A   B   C   D   E   F   G   H   I   J\n");
                for (int i = 0; i < display.length; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < display[i].length; j++) {
                        System.out.printf("[%2c]", display[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("Du hast " + count + '/' + fieldstotal + " des nicht vermienten Gebietes gecheckt.");
                System.out.println("Es bleiben noch " + countzero + " Mienen versteckt.");
                System.out.println("Katuuusch!!! Das war eine Miene... du hast leider verloren.");
                cont = false;


            } else {
                count++;
                display[Character.getNumericValue(coordinates[1])][letters.indexOf(coordinates[0])] = '-';

            }

        } while (cont);


    }
}
