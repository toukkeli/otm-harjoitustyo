/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toukk
 *
 * Grid luo kaksiulotteisen taulukon, jonka sisään laitetaan se objekti mitä
 * ruudussa on. Tyhjää ruutua käitellään tyhjänä tilana.
 *
 */
public class Grid {

    private final List<List<Ruutu>> koordinaatisto;

    public Grid(int leveys, int korkeus) {

        koordinaatisto = new ArrayList<>();

        int i;
        for (i = 0; i < leveys; i++) {
            ArrayList<Ruutu> uusiSarake = new ArrayList<>();
            int j;
            for (j = 0; j < korkeus; j++) {
                if (i == 0 || j == 0 || i == leveys - 1|| j == korkeus - 1) {
                    uusiSarake.add(new Ruutu(Ruututyyppi.SEINÄ));
                } else {
                    uusiSarake.add(new Ruutu(Ruututyyppi.LATTIA));
                }

            }
            koordinaatisto.add(uusiSarake);
        }
    }

    public int getLeveys() {
        return koordinaatisto.size();
    }

    public int getKorkeus() {
        return koordinaatisto.get(0).size();
    }

    // Hahmoja ja ruudun maaaston tyypin saa olion Ruutu metodeilla
    public Ruutu getRuutu(int x, int y) {
        return koordinaatisto.get(x).get(y);
    }

    public void setHahmo(Hahmo hahmo, int x, int y) {
        Ruutu ruutu = getRuutu(x, y);
        ruutu.setHahmo(hahmo);
    }

    public void setRuututyyppi(Ruututyyppi tyyppi, int x, int y) {
        Ruutu ruutu = getRuutu(x, y);
        ruutu.setRuutu(tyyppi);
    }

    // Palauttaa true jos siirto onnistui, false jos ei
    public boolean moveHahmo(Ruutu lahtoruutu, Ruutu kohderuutu) {
        if (lahtoruutu.containsHahmo() || kohderuutu.getRuutu().equals(Ruututyyppi.SEINÄ) || kohderuutu.containsHahmo()) {
            return false;
        } else {
            Hahmo hahmo = lahtoruutu.getHahmo();
            kohderuutu.setHahmo(hahmo);
            lahtoruutu.setHahmo(null);
            return true;
        }
    }

    // Palauttaa ruudun suhteessa aloitusruutuun. Esim. -1, 0 palauttaisu ruudun vasemmalta
    /*public Ruutu getRuutuSuhteessa(Ruutu lahtoruutu, int x, int y){
        return new Ruutu();
    }*/
}
