/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.ui;

import java.util.Scanner;
import roguelike.domain.Grid;
import roguelike.domain.Roguelike;
import roguelike.domain.Ruututyyppi;

/**
 *
 * @author toukk
 */
public class Kayttoliittyma {

    private Scanner lukija;
    private Roguelike peli;

    public Kayttoliittyma(Scanner lukija, Roguelike peli) {
        this.lukija = lukija;
        this.peli = peli;
    }

    public void kaynnista() {
        while (true) {

            Boolean endgame = false;
            tulostaPeliruutu();
            System.out.println("Siirretäänkö pelaajaa oikealle(o), ylös(y), vasemmalle (v), alas (a) vai lopetetaanko peli(muu komento)?");
            String kysymys = lukija.nextLine();

            switch (kysymys) {
                case "y":
                    if (peli.liikutaPelaajaa(0, -1)) {
                        System.out.println("Pelaaja liikkui");
                    } else {
                        System.out.println("Ei voitu liikkua");
                    }
                    break;
                case "v":
                    if (peli.liikutaPelaajaa(-1, 0)) {
                        System.out.println("Pelaaja liikkui");
                    } else {
                        System.out.println("Ei voitu liikkua");
                    }
                    break;
                case "a":
                    if (peli.liikutaPelaajaa(0, 1)) {
                        System.out.println("Pelaaja liikkui");
                    } else {
                        System.out.println("Ei voitu liikkua");
                    }
                    break;
                case "o":
                    if (peli.liikutaPelaajaa(1, 0)) {
                        System.out.println("Pelaaja liikkui");
                    } else {
                        System.out.println("Ei voitu liikkua");
                    }
                    break;
                default:
                    System.out.println(" Kiitos pelistä!");
                    endgame = true;
                    break;

            }

            if (endgame) {
                break;
            }

            peli.liikutaVihollisia();
        }

    }

    private void tulostaPeliruutu() {
        int y;
        Grid kartta = this.peli.getGrid();
        for (y = 0; y < kartta.getKorkeus(); y++) {
            int x;
            for (x = 0; x < kartta.getLeveys(); x++) {
                if (kartta.getRuutu(x, y).containsHahmo()) {
                    if (kartta.getRuutu(x, y).getHahmo().equals(this.peli.getPelaaja())) {
                        System.out.print("@");
                    } else {
                        System.out.print("X");
                    }

                } else {
                    Ruututyyppi maasto = kartta.getRuutu(x, y).getRuutu();
                    if (maasto == Ruututyyppi.SEINÄ) {
                        System.out.print("#");
                    } else if (maasto == Ruututyyppi.LATTIA) {
                        System.out.print("_");
                    }
                }

            }
            System.out.println("");
        }
    }

}
