package Woche3;

import java.util.ArrayList;
import java.util.Scanner;

public class RPGV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[][] choices = {
                {"-1", "0", "", "Du stehst in einer Bar."},
                {"0", "1", "Geh in die Wildnis", "Du bist in der Wildnis angekommen."},
                {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},
                {"1", "3", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},
                {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},
        };

        ArrayList<Integer> allowedinput = new ArrayList();

        int currentchoice = 0;


        do {

            System.out.println(choices[currentchoice][3]);  // + " <---start"

            // currentchoice = 0;

//            if (currentchoice == 0) {
//                allowedinput.clear();
//                allowedinput.add(1);
//                allowedinput.add(2);
//            } else if (currentchoice == 1) {
//                allowedinput.clear();
//                allowedinput.add(3);
//                allowedinput.add(4);
//            }

            allowedinput.clear();


            //Weiterleitung nachdem option gewählt wurde
            if (choices[currentchoice].length == 5) {
                currentchoice = Integer.parseInt(choices[currentchoice][4]);                       //int abfragen aus array und string holen und umwandeln in int
                System.out.println();
                continue;
            }

            System.out.println("-----------------------"); // -> before for

            //Ausdrucken von optionen
            for (int i = 0; i < choices.length; i++) {
                if (currentchoice == Integer.parseInt(choices[i][0])) {                            //int abfragen aus array und string holen und umwandeln in int
                    System.out.print(choices[i][1] + ".) ");
                    allowedinput.add(Integer.parseInt(choices[i][1]));
                    //System.out.print(".) ");
                    System.out.println(String.format("%2s", (choices[i][2])));
                }
            }

            System.out.println("-----------------------"); // -> after for

            //Eingabe
            System.out.println("Was willst du als nächstes tun?");
            System.out.print("Eingabe:");
            do {

                while (!sc.hasNextInt()) {
                    System.out.println("herst gib a zoi ein do!!!");
                    System.out.print("Eingabe:");
                    sc.nextLine();
                }
                System.out.print("Eingabe:");
                currentchoice = sc.nextInt();

            } while (!allowedinput.contains(currentchoice));  //überprüfung ob in array list

            //System.out.println(allowedinput);
            //allowedinput.clear();                           //Löschen von array list
            //System.out.println(allowedinput);

            // System.out.println(choices[currentchoice][3] + "-----loop end");


        } while (true);

    }
}
