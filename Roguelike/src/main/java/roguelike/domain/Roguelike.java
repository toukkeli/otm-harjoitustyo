/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.shape.Polygon;

/**
 * Luokka toteuttaa luolastoseikkailupelin perustoiminnallisuudet.
 *
 * @author toukk
 */
public class Roguelike {

    private Grid kartta;
    private Pelaaja pelaaja;

    public Roguelike() {
        this.kartta = new Grid(10, 10);
        this.pelaaja = new Pelaaja(4, 4);
        Vihollinen vihollinen = new Vihollinen();
        Vihollinen vihollinen2 = new Vihollinen();
        this.kartta.setHahmo(pelaaja, pelaaja.getX(), pelaaja.getY());
        this.kartta.setHahmo(vihollinen, 6, 6);
        this.kartta.setHahmo(vihollinen2, 1, 1);
    }

    public Roguelike(Grid kartta, int x, int y) {
        this.kartta = kartta;
        this.pelaaja = new Pelaaja(x, y);
        this.kartta.setHahmo(pelaaja, x, y);
    }

    /**
     * Palauttaa pelin ruudukon
     *
     * @return Pelin kartan muodostava Grid-olio
     */
    public Grid getGrid() {
        return this.kartta;
    }

    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    /**
     * Siirtää pelaaja-oliota Gridillä johonkin toiseen ruutuun.
     *
     * @param xMuutos -1 jos liikutaan vasemmalle 1 ruutu, 1 jos oikealle
     * 1-ruutu
     * @param yMuutos -1 jos liikutaan ylös 1-ruutu, 1 jos alas 1-ruutu
     * @return Liikuttiinko onnistuneesti
     */
    public Boolean liikutaPelaajaa(int xMuutos, int yMuutos) {
        int x = getPelaaja().getX();
        int y = getPelaaja().getY();
        Ruutu lahtoruutu = getGrid().getRuutu(x, y);
        Ruutu kohderuutu = getGrid().getRuutu(x + xMuutos, y + yMuutos);
        if (kartta.moveHahmo(lahtoruutu, kohderuutu)) {
            pelaaja.setX(x + xMuutos);
            pelaaja.setY(y + yMuutos);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Etsii Griidlta joka ikisen hahmon joka on tyyppia Vihollinen ja siirtaa
     * sita pelaajaa kohti
     */
    public void liikutaVihollisia() {
        /* Grid uusiKartta;
        uusiKartta = new Grid(this.kartta.getLeveys(), this.kartta.getKorkeus());
        //Alustetaan uusi kartta

        for (int i = 0; i < this.kartta.getLeveys(); i++) {

            for (int j = 0; j < this.kartta.getKorkeus(); j++) {
                uusiKartta.getRuutu(i, j).setRuutu(this.kartta.getRuutu(i, j).getRuutu());
                uusiKartta.getRuutu(i, j).setHahmo(this.kartta.getRuutu(i, j).getHahmo());
            }
        }*/

        //Käydään läpi jokainen hahmo vanhassa kartassa ja siirretään ne uuteen karttaan.
        for (int i = 0; i < this.kartta.getLeveys(); i++) {

            for (int j = 0; j < this.kartta.getKorkeus(); j++) {
                if (this.getGrid().getRuutu(i, j).containsHahmo() && !this.getGrid().getRuutu(i, j).getHahmo().equals(this.getPelaaja())) {
                    int xSuunta = 0;
                    int ySuunta = 0;
                    if (i < this.getPelaaja().getX()) {
                        xSuunta = 1;
                    } else if (i > this.getPelaaja().getX()) {
                        xSuunta = -1;
                    }
                    if (j < this.getPelaaja().getY()) {
                        ySuunta = 1;
                    } else if (j > this.getPelaaja().getY()) {
                        ySuunta = -1;
                    }
                    this.getGrid().moveHahmo(this.getGrid().getRuutu(i, j), this.getGrid().getRuutu(i + xSuunta, j + ySuunta));
                }
            }
        }
    }

    /* public Collection<Polygon> haeRuudut(){
        Collection<Polygon> haettavat = new ArrayList<>();
        haettavat.
        return haettavat;
    }*/

 /*public Boolean liikutaHahmoa(Hahmo hahmo, int xMuutos, int yMuutos){
        int x = getPelaaja().getX();
        int y = getPelaaja().getY();
        Ruutu lahtoruutu = getGrid().getRuutu(x, y);
        Ruutu kohderuutu = getGrid().getRuutu(x +xMuutos, y + yMuutos);
        return kartta.moveHahmo(lahtoruutu, kohderuutu);
    }*/
}
