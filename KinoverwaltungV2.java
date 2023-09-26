package Woche3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;

public class KinoverwaltungV2 {
    public static void main(String[] args) {

        //Einlass Abfrage
        System.out.println("Guten Tag, wie viel geld haben Sie dabei? (Es werden mind 20€ benötigt um fortzufahren)");
        Scanner sc = new Scanner(System.in);
        double moneycustomer = sc.nextDouble();

        if (moneycustomer < 20) {
            System.out.println("Sie haben nicht genug Geld, gengans wieda Ham!");
            System.exit(0);
        }

        String[][] FilmDaten = new String[][]{

                {"Film Nr.", "Film Name", "Uhrzeit", "Saal", "Restplätze"},
                {"1.", "Batman", "20:15", "1", "5"},
                {"2.", "Pokemon", "22:00", "3", "2"},
                {"3.", "Cats", "17:00", "2", "0"},
        };
        int welcherfilm;

        String[][] SnackDaten = new String[][]{

                {"Nr.", "Snack", "Preis", "Auf Lager"},
                {"1.", "Popcorn", "1", "5"},
                {"2.", "Chips", "2", "0"},
                {"3.", "Schokolade", "3.50", "2"},
        };
        int welchersnack;


        ArrayList<Integer> choosenMovies = new ArrayList();

        ArrayList<Integer> choosenSnacks = new ArrayList();

        boolean cont2 = true;
        do {                                                                     //<- All schleife
            System.out.println("Was willst du als nächstes tun?");
            System.out.println("1. Tickets kaufen");
            System.out.println("2. Snacks kaufen");
            System.out.println("3. Film ansehen");
            System.out.println("4. Snacks essen");
            System.out.println("5. Beim Gewinnspiel mitmachen");
            System.out.println("6. Kino verlassen");

            System.out.println(choosenMovies);
            System.out.println(choosenSnacks);

            Scanner sc1 = new Scanner(System.in);
            int mainchoice = sc.nextInt();                      // Hauptauswahl was machen

            if (mainchoice == 1) { //Tickets kaufen

//Filmtabelle Ausgabe
                boolean cont = true;
                do {

                    //Auswahl Film
                    do {

                        for (int i = 0; i < FilmDaten.length; i++) {                                        // durchlauf aller zeilen
                            for (int j = 0; j < FilmDaten[0].length; j++) {     // [i] same as [0]                     // durchlauf aller spalten


                                String verfügbar = "verfügbar";
                                String ausgebucht = "ausgebucht";

                                if (i >= 1 && j == FilmDaten[i].length - 1) {                                                                     //i>=1 && j==4
                                    int seatsleft = Integer.parseInt(FilmDaten[i][j]);
                                    if (seatsleft > 0) {
                                        System.out.printf("%-15s", verfügbar);
                                    } else {
                                        System.out.printf("%-15s", ausgebucht);
                                    }
                                } else {
                                    System.out.printf("%-15s", FilmDaten[i][j]);
                                }

                            }

                            if (i == 0) {
                                System.out.println();
                                System.out.print("-----------------------------------------------------------------------");

                            }
                            System.out.println();
                        }
                        System.out.print("-----------------------------------------------------------------------");
                        System.out.println();


                        do {
                            System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                            Scanner sc2 = new Scanner(System.in);
                            welcherfilm = sc.nextInt();


                            if (welcherfilm == 0) {
                                System.out.println("Vielen Danke für Ihren Besuch am Ticketschalter.");
                                //System.exit(0);
                            }
                        } while (welcherfilm < 0 || welcherfilm > FilmDaten.length - 1);   //nachfragen: .length-1 ?-> -1 = index?

                        if (FilmDaten[welcherfilm][4].equals("0")) {
                            System.out.println("Dieser Film ist ausgebucht.");
                        } else if (welcherfilm != 0) {
                            int available = Integer.parseInt(FilmDaten[welcherfilm][4]);
                            int howmany;
                            int price;

// Abfrage Verfügbarkeit
                            do {
                                System.out.println("Es sind noch " + available + " Tickets um je 15€ verfügbar. Wie viele möchten Sie kaufen?");

                                Scanner sc3 = new Scanner(System.in);
                                howmany = sc.nextInt();

                                price = (15 * howmany);
//Ticket-Kauf

                                if (howmany <= available && price <= moneycustomer && howmany > 0) { // -> 0 bedingung
                                    System.out.println("Du kaufst " + howmany + " Tickets um " + price + "€ und hast jetzt noch " + (moneycustomer - price) + "€");   //sprung nach oben

                                    for (int i = 0; i < howmany; i++) {
                                        choosenMovies.add(Integer.valueOf(welcherfilm));
                                    }

                                    moneycustomer = moneycustomer - price;

                                    available = available - howmany;

                                    FilmDaten[welcherfilm][4] = String.valueOf(available);

                                } else if (howmany > available) {
                                    System.out.println("Es sind nicht genug Tickets verfügbar. Verfügbare Tickets: " + available);
                                } else if (price > moneycustomer) {
                                    System.out.println("Sie haben nicht genug Geld dabei.");
                                }
                            } while (howmany > available || price > moneycustomer);
                        } else {
                            cont = false;
                        }
                    } while (!FilmDaten[welcherfilm][4].equals("0") && welcherfilm != 0);  // -> 0 Bedingung


                } while (cont);

            } //mainchoice = 1 (Tickets kaufen)


        else if (mainchoice == 2) { //Snacks kaufen


//Snacktabelle Ausgabe
            boolean cont = true;
            do {

                //Auswahl Snacks
                do {

                    for (int i = 0; i < SnackDaten.length; i++) {                                        // durchlauf aller zeilen
                        for (int j = 0; j < SnackDaten[0].length; j++) {     // [i] same as [0]                     // durchlauf aller spalten


                            String verfügbar = "verfügbar";
                            String ausverkauft = "ausverkauft";

                            if (i >= 1 && j == SnackDaten[i].length - 1) {                                                                     //i>=1 && j==4
                                int snacksleft = Integer.parseInt(SnackDaten[i][j]);
                                if (snacksleft > 0) {
                                    System.out.printf("%-15s", verfügbar);
                                } else {
                                    System.out.printf("%-15s", ausverkauft);
                                }
                            } else {
                                System.out.printf("%-15s", SnackDaten[i][j]);
                            }

                        }

                        if (i == 0) {
                            System.out.println();
                            System.out.print("-----------------------------------------------------------------------");

                        }
                        System.out.println();
                    }
                    System.out.print("-----------------------------------------------------------------------");
                    System.out.println();


                    do {
                        System.out.println("Welchen (verfügbaren) Snack möchtest du kaufen? (0 zum abbrechen)");
                        Scanner sc4 = new Scanner(System.in);
                        welchersnack = sc.nextInt();


                        if (welchersnack == 0) {
                            System.out.println("Vielen Danke für Ihren Besuch an der Snackbar.");
                            //System.exit(0);
                        }
                    } while (welchersnack < 0 || welchersnack > SnackDaten.length - 1);   //nachfragen: .length-1 ?-> -1 = index?

                    if (SnackDaten[welchersnack][3].equals("0")) {
                        System.out.println("Dieser Snack ist ausverkauft.");
                    } else if (welchersnack != 0) {
                        int availablesnacks = Integer.parseInt(SnackDaten[welchersnack][3]);
                        int howmanysnacks;
                        double pricesnacks = Double.parseDouble(SnackDaten[welchersnack][2]);

// Abfrage Verfügbarkeit
                        do {
                            System.out.println("Es sind noch " + availablesnacks + " Stück um je" + pricesnacks + "€ verfügbar. Wie viele möchten Sie kaufen?");

                            Scanner sc5 = new Scanner(System.in);
                            howmanysnacks = sc.nextInt();

                            pricesnacks = (pricesnacks * howmanysnacks);
//Ticket-Kauf

                            if (howmanysnacks <= availablesnacks && pricesnacks <= moneycustomer && howmanysnacks > 0) {
                                System.out.println("Du kaufst " + howmanysnacks + " Snacks um " + pricesnacks + "€ und hast jetzt noch " + (moneycustomer - pricesnacks) + "€");   //sprung nach oben

                                for (int i = 0; i < howmanysnacks; i++) {
                                    choosenSnacks.add(Integer.valueOf(welchersnack));
                                }

                                moneycustomer = moneycustomer - pricesnacks;

                                availablesnacks = availablesnacks - howmanysnacks;

                                SnackDaten[welchersnack][3] = String.valueOf(availablesnacks);

                            } else if (howmanysnacks > availablesnacks) {
                                System.out.println("Es sind nicht genug Snacks verfügbar. Verfügbare Snacks: " + availablesnacks);
                            } else if (pricesnacks > moneycustomer) {
                                System.out.println("Sie haben nicht genug Geld dabei.");
                            }
                        } while (howmanysnacks > availablesnacks || pricesnacks > moneycustomer);
                    } else {
                        cont = false;
                    }
                } while (!SnackDaten[welchersnack][3].equals("0") && welchersnack != 0);


            } while (cont);

        }//mainchoice = 2 (Snacks kaufen)

        else if (mainchoice == 3) { //Film ansehen
            int chooseticket;
            boolean cont3 = true;
        do {

            choosenMovies.sort(Comparator.naturalOrder());
            System.out.println(choosenMovies);

            if (choosenMovies.size() > 0 ) {
                System.out.println("Welchen Film für den du ein Ticket hast möchtest du ansehen? (0 für abbrechen)");

                int tickets = choosenMovies.size();
                System.out.println("Gesamtanzahl Tickets: " + tickets);


                for (int i = 0; i < FilmDaten.length; i++) {

                    if (choosenMovies.contains(i)) {
                        System.out.println(FilmDaten[i][0] + FilmDaten[i][1]);
                    }
                }

                Scanner sc6 = new Scanner(System.in);
                chooseticket = sc.nextInt();
                //String stringchooseticket = String.valueOf(chooseticket);

                if (chooseticket == 0) {
                cont3 = false;
                }

                else if (chooseticket > 0 && chooseticket < FilmDaten.length - 1 && choosenMovies.contains(chooseticket)) {
                    System.out.println("Du siehst dir den Film " + FilmDaten[chooseticket][1] + " an. Viel Spaß!");
                    choosenMovies.remove(Integer.valueOf(chooseticket));
                    tickets--;
                }
                if (tickets == 0){
                    System.out.println("\nDu hast keine Tickets mehr.");
                    cont3 = false;
                }

            }
            else {
                System.out.println("Keine Tickets verfügbar");
                System.out.println();
                cont3 = false;
            }

        } while (cont3);
        }//mainchoice = 3 (Film ansehen) ENDE

            else if (mainchoice == 4) {         //Snack jausnen

                int choosensnack;
                boolean cont4 = true;
                do {

                    choosenSnacks.sort(Comparator.naturalOrder());
                    System.out.println(choosenSnacks);

                    if (choosenSnacks.size() > 0 ) {
                        System.out.println("Welchen Snack möchtest du jausnen? (0 für abbrechen)");

                        int snackies = choosenMovies.size();
                        System.out.println("Gesamtanzahl Snacks: " + snackies);


                        for (int i = 0; i < SnackDaten.length; i++) {

                            if (choosenSnacks.contains(i)) {
                                System.out.println(SnackDaten[i][0] + SnackDaten[i][1]);
                            }
                        }

                        Scanner sc7 = new Scanner(System.in);
                        choosensnack = sc.nextInt();
                        //String stringchooseticket = String.valueOf(chooseticket);

                        if (choosensnack == 0) {
                            cont4 = false;
                        }

                        else if (choosensnack > 0 && choosensnack < SnackDaten.length - 1 && choosenSnacks.contains(choosensnack)) {
                            System.out.println("Du gönnst dir den Snack " + SnackDaten[choosensnack][1] + ". Hau rein!");
                            choosenSnacks.remove(Integer.valueOf(choosensnack));
                            snackies--;
                        }
                        if (snackies == 0){
                            System.out.println("\nDu hast keine Snacks mehr.");
                            cont4 = false;
                        }

                    }
                    else {
                        System.out.println("Keine Snacks verfügbar");
                        System.out.println();
                        cont4 = false;
                    }
                } while (cont4);
            }//mainchoice = 4 (Snack Jausnen) ENDE


            else if (mainchoice == 5) { //Gewinnspiel
                boolean cont5 = true;




            do {
                System.out.println("Guten Tag, wollen Sie an unserem illegalen Glücksspiel teilnehmen?");
                System.out.println("Sie haben " + moneycustomer + "€ verfügbar. (1 für teilnehmen / 0 für abbrechen");

                Scanner sc8 = new Scanner(System.in);
                int teilnahme = sc.nextInt();

                if (teilnahme == 1){ // if int == 1
                    if (moneycustomer < 5) {
                        System.out.println("Sie haben nicht genug Geld für das Gewinnspiel.\n");
                        cont5 = false;
                    }
//----------------------------------------------------------------------------------------------------------------
                    else if (moneycustomer >= 5){

                        moneycustomer = moneycustomer-5;

                        Random r = new Random();
                        int zufallszahl = r.nextInt(200);

                        System.out.println("Ihre Glückszahl ist: " + zufallszahl);

                        int a = 1;
                        int b = 1;
                        int c = 0;

                        for (int z = 0;c < zufallszahl; z++) {

                             c=a+b;
                            System.out.println(a + "+" + b + "=" + c);

                            a = b; b=c;
                        }

                        if (zufallszahl == c || zufallszahl == zufallszahl%10){
                            System.out.println(zufallszahl + " ist eine Fibonacci-Nummer! Sie haben 20€ gewonnen");
                            moneycustomer = moneycustomer +25;
                        }
                        else
                            System.out.println("you looooooooooooooooooooooooose");
                        }
                    }

//-----------------------------------------------------------------------------------------------------------------------
                else {
                    System.out.println("Schade dass Sie nicht an unserem illegalen Glücksspiel teilnehmen wollen. Tschüss.\n");
                    cont5 = false;
                }

                } while (cont5);//7 if teilnahme generell

            }//Gewinnspiel ENDE

            else if (mainchoice == 6) { //Kino Verlassen
                System.out.println("Tschüss");
                cont2 = false;
            }//mainchoice = 6 (Kino verlassen)

        } while (cont2); // cont all
    } //public static void
}  //public class



