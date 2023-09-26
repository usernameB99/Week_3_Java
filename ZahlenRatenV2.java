package Woche3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV2 {
    public static void main(String[] args) {


        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int randomnumber = 0;
        int tries = 9;
        boolean all = true;
        boolean contlvl1 = true;

        int menuechoice;
        String menuechoicestr = "";
        char menuechoicecha;

        boolean contlvl2 = true;
        int distance;

        int provednumber;

        String inputti;

        ArrayList<String> tippslist;

        do {   // all
            do {
                do {
                    System.out.println("Welches Level möchten Sie spielen?");
                    System.out.println("...für Level 1 drücken Sie die Taste 1.");
                    System.out.println("...für Level 2 drücken Sie die Taste 2.");
                    System.out.println("...für Level 3 drücken Sie die Taste 3.");
                    System.out.println("...für Level 4 drücken Sie die Taste 4.");
                    System.out.println("...für abbrechen drücken Sie die Taste 0.");


                    sc = new Scanner(System.in);
                    System.out.print("Eingabe: ");
                    menuechoicestr = sc.nextLine();
                    menuechoicecha = menuechoicestr.charAt(0);

                    menuechoice = Integer.valueOf(menuechoicecha);
                    System.out.println();

                } while (menuechoicestr.length() != 1);


                //System.out.println(menuechoice);

            } while (menuechoice < 48 || menuechoice > 52);


            if (menuechoice == 49) {   // Level 1 Start
                System.out.println("..Level 1 wird gestartet");
                randomnumber = r.nextInt(100);
                System.out.println("Test " + randomnumber); //test von random nummer

                //System.out.println("Erraten Sie die Zahl zwischen 1 und 99");

                tries = 9;
                contlvl1 = true;


                do { //old loop

                    boolean isnumber;
                    do {
                        isnumber = true;
                        do {
                            System.out.println("Erraten Sie die Zahl zwischen 1 und 99");

                            sc = new Scanner(System.in);
                            System.out.print("Eingabe: ");
                            inputti = sc.nextLine();

                        } while (inputti.length() != 1 && inputti.length() != 2);  // es kommen strings mit 1 oder 2 zeichen durch

                        char[] chararray = inputti.toCharArray();       // char array von string eingabe


                        provednumber = 0;
                        //System.out.println("provednumber = " + provednumber);


                        for (int i = 0; i < chararray.length && isnumber; i++) {

                            if (Character.getNumericValue(chararray[i]) < 0 || Character.getNumericValue(chararray[i]) > 9) {
                                isnumber = false;
                            } else {

                                if (i > 0) {
                                    provednumber = provednumber * 10;
                                }
                                provednumber = provednumber + (Character.getNumericValue(chararray[i]));
                            }
                        }

                        if (isnumber) {

                            System.out.println("Spieler Eingabe: " + provednumber);

                        } else {
                            System.out.println("...gib eine zahl ein...");
                            isnumber = false;
                        }
                    } while (!isnumber);


                    if (provednumber < randomnumber && tries > 1) {
                        tries--;
                        System.out.println("Ihre Zahl ist kleiner als die Zufallszahl");
                        if (tries == 1) {
                            System.out.println(tries + " Versuch übrig");
                        } else {
                            System.out.println(tries + " Versuche übrig");
                        }
                    } else if (provednumber > randomnumber && tries > 1) {
                        tries--;
                        System.out.println("Ihre Zahl ist größer als die Zufallszahl");
                        System.out.println(tries + " Versuche übrig");
                    } else if (provednumber == randomnumber) {
                        System.out.println("Ding Ding Ding - Sie haben die Zahl erraten :)\n");
                        contlvl1 = false;
                    } else {
                        System.out.println("Keine Versuche mehr übrig");
                        contlvl1 = false;
                    }
                } while (contlvl1);

            } // Level 1 End
            //------------------------------------------------------------------------
            //                            Level 2

            else if (menuechoice == 50) {   // Level 2 Start
                System.out.println("..Level 2 wird gestartet");

                tries = 9;
                distance = 0;
                contlvl2 = true;
                tippslist = new ArrayList();         // leeren der liste bzw wird bei jedem durchgang neu initialisiert

                randomnumber = r.nextInt(100);
                System.out.println("Test randomnumber = " + randomnumber);
                do {
                    boolean isnumber;
                    do {
                        isnumber = true;
                        do {


                            System.out.println("Erraten Sie die Zahl zwischen 1 und 99");

                            sc = new Scanner(System.in);
                            System.out.print("Eingabe: ");
                            inputti = sc.nextLine();

                        } while (inputti.length() != 1 && inputti.length() != 2);  // es kommen strings mit 1 oder 2 zeichen durch

                        char[] chararray = inputti.toCharArray();       // char array von string eingabe


                        provednumber = 0;
                        // System.out.println("provednumber = " + provednumber);


                        for (int i = 0; i < chararray.length && isnumber; i++) {

                            if (Character.getNumericValue(chararray[i]) < 0 || Character.getNumericValue(chararray[i]) > 9) {
                                isnumber = false;
                            } else {

                                if (i > 0) {
                                    provednumber = provednumber * 10;
                                }
                                provednumber = provednumber + (Character.getNumericValue(chararray[i]));
                            }
                        }

                        if (isnumber) {
                            //distance = (randomnumber - provednumber) * -1;
                            //tippslist.add(Integer.toString(provednumber));

                            if (provednumber < randomnumber) {
                                distance = (randomnumber - provednumber);
                                tippslist.add(Integer.toString(provednumber));
                            } else if (provednumber > randomnumber) {
                                distance = (randomnumber - provednumber) * -1;
                                tippslist.add(Integer.toString(provednumber));
                            }

                        } else {
                            System.out.println("...gib eine zahl ein...");
                            isnumber = false;
                        }
                    } while (!isnumber);     //--------
                    //  System.out.println("distance = " + distance);
                    //  System.out.println("provednumber" + provednumber);
                    //  System.out.println(isnumber);

                    if (isnumber) {

                        if ((distance <= 3 && distance > 0) && tries > 1) {                                      // distance = 0 -> solved here with (distance > 0)
                            tries--;
                            System.out.println("„fast da“: zwischen 1 und 3 daneben.");
                            System.out.println(tries + " Versuche übrig");
                            System.out.println("Bereits eingegebene Tips " + tippslist);
                        } else if ((distance <= 10 && distance >= 4) && tries > 1) {
                            tries--;
                            System.out.println("„relativ nahe“: zwischen 4 und 10 daneben");
                            System.out.println(tries + " Versuche übrig");
                            System.out.println("Bereits eingegebene Tips " + tippslist);
                        } else if ((distance <= 20 && distance >= 11) && tries > 1) {
                            tries--;
                            System.out.println("„Nicht ganz so weit weg“: zwischen 11 und 20 daneben");
                            System.out.println(tries + " Versuche übrig");
                            System.out.println("Bereits eingegebene Tips " + tippslist);
                        } else if (distance > 20 && tries > 1) {
                            tries--;
                            System.out.println("„Weit weg“: > über 20 daneben");
                            System.out.println(tries + " Versuche übrig");
                            System.out.println("Bereits eingegebene Tips " + tippslist);
                        } else if (provednumber == randomnumber) {
                            System.out.println("Ding Ding Ding - Sie haben die Zahl erraten :)");
                            contlvl2 = false;

                        } else if (distance > 0) {                                                                                                // distance jumps in else -> elde if distance > 0
                            System.out.println("Keine Versuche mehr übrig");
                            contlvl2 = false;
                        }
                    }
                } while (contlvl2);

            } // Level 2 End

            //-------------------------------------------------------------------------
            else if (menuechoice == 51) {   // Level 3 Start
                System.out.println("...Level 3 wird gestartet...");

                provednumber = 0;
                boolean contlvl3 = true;
                tippslist = new ArrayList();
                int max = 99;
                int min = 1;


                System.out.println("Erraten Sie die Zahl zwischen 1 und 99");
                randomnumber = r.nextInt(min, max);
                System.out.println("Test randomnumber = " + randomnumber);

                boolean whosfirst = r.nextBoolean(); // zufall anfang ki oder spieler 1
                boolean whosactive = whosfirst;           //

                if (whosfirst) {
                    System.out.println("Spieler 1 fängt an.");
                } else {
                    System.out.println("Computer fängt an.");

                }

                do {
                    // beginn der schleife
                    System.out.println("Erraten Sie die Zahl zwischen 1 und 99");
                    System.out.println("Bereits eingegebene Tips " + tippslist);

                    // KI eingabe:
                    if (!whosactive) {

                        if (tippslist.size() == 0) {      //wenn array list leer ist dnn hau iagndwas raus

                            provednumber = r.nextInt(100);
                            //System.out.println("Eingabe von KI: " + provednumber);
                            tippslist.add(Integer.toString(provednumber));
                        } else {           // wenn in da array list scho wos drin steht
                            do {
                                provednumber = r.nextInt(min, max);

                            } while (tippslist.contains(provednumber));

                            tippslist.add(Integer.toString(provednumber));
                            //System.out.println("min-max gen nr = " + provednumber);
                            System.out.println("Eingabe von KI: " + provednumber);
                        }
                    }

                    // Spieler 1 eingabe:
                    else {
                        boolean isnumber;  // überprüfung spieler eingabe = korrekt - start
                        do {
                            isnumber = true;
                            do {
                                // System.out.println("Erraten Sie die Zahl zwischen 1 und 99");

                                sc = new Scanner(System.in);
                                System.out.print("Eingabe: ");
                                inputti = sc.nextLine();

                            } while (inputti.length() != 1 && inputti.length() != 2);  // es kommen strings mit 1 oder 2 zeichen durch

                            char[] chararray = inputti.toCharArray();       // char array von string eingabe


                            provednumber = 0;
                            System.out.println("[provednumber 0] = " + provednumber);


                            for (int i = 0; i < chararray.length && isnumber; i++) {

                                if (Character.getNumericValue(chararray[i]) < 0 || Character.getNumericValue(chararray[i]) > 9) {
                                    isnumber = false;
                                } else {

                                    if (i > 0) {
                                        provednumber = provednumber * 10;
                                    }
                                    provednumber = provednumber + (Character.getNumericValue(chararray[i]));
                                }
                            }

                            if (isnumber) {

                                System.out.println("Spieler 1 Eingabe: " + provednumber);

                            } else {
                                System.out.println("...gib eine zahl ein...");
                                isnumber = false;
                            }
                        } while (!isnumber); // überprüfung spieler eingabe = korrekt - ende

                        //    System.out.println("provednumber von Spieler 1: " + provednumber);
                        tippslist.add(Integer.toString(provednumber));
                    }

                    // hier festlegung der min max werte für begrenzung random für KI

                    if (provednumber > randomnumber) {

                        if (provednumber < max) {
                            max = provednumber;
                        }
                    } else if (provednumber < randomnumber) {

                        if (provednumber > min) {
                            min = provednumber;
                        }
                    }


                    // auswertung der eingabe:
                    if (provednumber < randomnumber && tries > 1) {
                        System.out.println("Ihre Zahl ist kleiner als die Zufallszahl");
                    } else if (provednumber > randomnumber && tries > 1) {
                        System.out.println("Ihre Zahl ist größer als die Zufallszahl");
                    } else if (provednumber == randomnumber) {
                        if (whosactive) {
                            System.out.println("Ding Ding Ding - Spieler 1 die Zahl erraten :)\n");
                            contlvl3 = false;
                        } else {
                            System.out.println("Ding Ding Ding - die KI hat die Zahl erraten :)\n");
                            contlvl3 = false;
                        }
                    } else {
                        System.out.println("Keine Versuche mehr übrig");
                        contlvl3 = false;
                    }
                    if (contlvl3) {                           // wird nur ausgeführt solange spiel aktiv ist
                        if (whosactive != whosfirst) {
                            tries--;
                            System.out.println(tries + " Runden übrig");
                        }

                        //spielerwechsel
                        if (whosactive) {
                            whosactive = false;
                            System.out.println("Zug von Spieler 1 beendet...jetzt ist die KI am zug");
                        } else {
                            whosactive = true;
                            System.out.println("Zug von KI beendet...jetzt ist Spieler 1 am zug");
                        }
                    }

                } while (contlvl3);


            } // Level 3 End
//---------------------------------------------------------------------------------------------------------------------
//                                                  Level 4

            else if (menuechoice == 52) {
                System.out.println("...Level 4 wird gestartet...\n");

                ArrayList<Integer> availablenumbers = new ArrayList();
                ArrayList<Integer> usednumbers = new ArrayList();
                boolean contLvl4 = true;
                distance = 0;
                tries = 0;
                boolean finish = true;


                for (int i = 0; i < 100; i++) {                                             //befüllen von array list
                    availablenumbers.add(i);
                }
                for (int i = 0; i < 100; i++) {                                            //ausgabe von visualisierung von array list runden start
                    System.out.print(availablenumbers.contains(i) ? '#' : '_');
                }
                System.out.println();
                System.out.println(availablenumbers);                                       // ausdrucken von array list
                System.out.println();

                System.out.println("Erraten Sie die Zahl zwischen 1 und 99");
                randomnumber = r.nextInt(100);
                System.out.println("> Kontrollausgabe: int randomnumber = " + randomnumber);

                boolean whosfirst = r.nextBoolean();                                // zufall anfang ki oder spieler 1
                boolean whosactive = whosfirst;

                if (whosfirst) {
                    System.out.println("Spieler 1 fängt an.");
                } else {
                    System.out.println("Computer fängt an.");

                }

                do { //contLvl4 Schleife

                    if (!whosactive) {                                              // Ki Eingabe

                        do {
                            provednumber = r.nextInt(100);                   // random zahl von arrayList holen
                        } while (!availablenumbers.contains(provednumber));         // zahl ob in array list vorhanden

                        usednumbers.add(provednumber);
                        System.out.println("Eingabe von KI: " + provednumber);

                    }                                                                 // Ki Eingabe Ende

                    else {                                                            // Spieler Eingabe

                        System.out.println("Erraten Sie die Zahl zwischen 1 und 99");
                        do {
                            sc = new Scanner(System.in);
                            System.out.print("Eingabe: ");
                            provednumber = sc.nextInt();
                        } while (!availablenumbers.contains(provednumber));

                        System.out.println("Spieler 1 Eingabe: " + provednumber);
                        usednumbers.add(provednumber);
                    }                                                                   // Spieler Eingabe Ende


                    if (provednumber < randomnumber) {                                  // berechnung der distanz für feedback
                        distance = (randomnumber - provednumber);

                    } else if (provednumber > randomnumber) {
                        distance = (randomnumber - provednumber) * -1;
                    }

                    System.out.println("> Kontrollausgabe: int randomnumber = " + randomnumber);
                    System.out.println("> Kontrollausgabe: int provednumber = " + provednumber);
                    System.out.println("> Kontrollausgabe: int distance = " + distance);
                    System.out.println("> Verfügbare Tips" + availablenumbers);

                    // platzhalter für visualisierung

                    if (provednumber == randomnumber) {
                        finish = false;
                        if (whosactive) {
                            System.out.println("Ding Ding Ding - Spieler 1 die Zahl erraten :)\n");
                            System.out.println("Die Zufallszahl war " + randomnumber);
                            System.out.println("Gesamtanzahl gespielter Runden: " + tries + "\n");
                            contLvl4 = false;
                        } else {
                            System.out.println("Ding Ding Ding - die KI hat die Zahl erraten :)\n");
                            System.out.println("Die Zufallszahl war " + randomnumber);
                            System.out.println("Gesamtanzahl gespielter Runden: " + tries + "\n");
                            contLvl4 = false;
                        }

                    } else if (distance > 20) {
                        tries++;
                        System.out.println("„Weit weg“: > über 20 daneben");
                        System.out.println("Bereits eingegebene Tips " + usednumbers);
                        System.out.println("Anzahl der bereits gespielten Runden: " + tries);


                        for (int i = provednumber - 20; i <= provednumber + 20; i++) {    // kreis to remove
                            availablenumbers.remove(Integer.valueOf(i));
                        }
                    } else if (distance <= 20 && distance >= 11) {
                        tries++;
                        System.out.println("„Nicht ganz so weit weg“: zwischen 11 und 20 daneben");
                        System.out.println("Bereits eingegebene Tips " + usednumbers);
                        System.out.println("Anzahl der bereits gespielten Runden: " + tries);

                        for (int i = provednumber - 10; i <= provednumber + 1; i++) {   // innerer kreis to remove
                            availablenumbers.remove(Integer.valueOf(i));
                        }

                        for (int i = provednumber + 21; i < 100; i++) {
                            availablenumbers.remove(Integer.valueOf(i));         // äußerer kreis (+/seite) to remove
                        }

                        for (int i = 0; i < provednumber - 20; i++) {           // äußerer kreis (-/seite) to remove
                            availablenumbers.remove(Integer.valueOf(i));
                        }
                        System.out.println(availablenumbers);
                    } else if (distance <= 10 && distance >= 4) {
                        tries++;
                        System.out.println("„relativ nahe“: zwischen 4 und 10 daneben");
                        System.out.println("Bereits eingegebene Tips " + usednumbers);
                        System.out.println("Anzahl der bereits gespielten Runden: " + tries);


                        for (int i = provednumber - 3; i <= provednumber + 3; i++) {   // innerer kreis to remove
                            availablenumbers.remove(Integer.valueOf(i));
                        }

                        for (int i = provednumber + 11; i < 100; i++) {
                            availablenumbers.remove(Integer.valueOf(i));         // äußerer kreis (+/seite) to remove
                        }

                        for (int i = 0; i <= provednumber - 11; i++) {           // äußerer kreis (-/seite) to remove
                            availablenumbers.remove(Integer.valueOf(i));
                        }
                        System.out.println(availablenumbers);
                    } else if (distance <= 3 && distance > 0) {
                        tries++;
                        System.out.println("„fast da“: zwischen 1 und 3 daneben.");
                        System.out.println("Bereits eingegebene Tips " + usednumbers);
                        System.out.println("Anzahl der bereits gespielten Runden: " + tries);

                        availablenumbers.remove(Integer.valueOf(provednumber));  // die zahl selbst removen da innerer kreis nur 1 zahl


                        for (int i = provednumber + 4; i < 100; i++) {
                            availablenumbers.remove(Integer.valueOf(i));         // äußerer kreis (+/seite) to remove
                        }

                        for (int i = 0; i < provednumber - 3; i++) {           // äußerer kreis (-/seite) to remove
                            availablenumbers.remove(Integer.valueOf(i));
                        }
                        System.out.println(availablenumbers);
                    }

                    System.out.println(availablenumbers);                                       // ausgabe array list rundenende

                    for (int i = 0; i < 100; i++) {                                            //ausgabe von visualisierung von array list runden ende
                        System.out.print(availablenumbers.contains(i) ? '#' : '_');
                    }
                    System.out.println();
                    //System.out.println("Bereits eingegebene Tips" + usednumbers);

                    if (finish) {
                        if (whosactive) {                                                                //spielerwechsel
                            whosactive = false;
                            System.out.println("Zug von Spieler 1 beendet...jetzt ist die KI am zug\n");
                        } else {
                            whosactive = true;
                            System.out.println("Zug von KI beendet...jetzt ist Spieler 1 am zug\n");
                        }
                    }

                } while (contLvl4);
            } // Level 4 End

//--------------------------------------------------------------------------------------------------------------------

            else if (menuechoice == 48) {
                System.out.println("Tschüss...");
                all = false;
            }

        } while (all); // all
    }
}
