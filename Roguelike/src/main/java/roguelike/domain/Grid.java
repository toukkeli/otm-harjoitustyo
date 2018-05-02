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
                if (i == 0 || j == 0 || i == leveys - 1 || j == korkeus - 1) {
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

    /**
     * Asettaa ruutuun annetuissa koordinaateissa annetun hahmon
     *
     * @param hahmo Mikä hahmo laitetaan
     * @param x ensimmäinen koordinaatti
     * @param y toinen koordinaatti
     */
    public void setHahmo(Hahmo hahmo, int x, int y) {
        Ruutu ruutu = getRuutu(x, y);
        ruutu.setHahmo(hahmo);
    }

    /**
     * Asettaa ruutuun annetuissa koordinaateissa alutun maastotyypin
     *
     * @see Ruututyyppi
     * @param tyyppi Mikä maastotyyppi laitetaan
     * @param x ensimmäinen koordinaatti
     * @param y toinen koordinaatti
     *
     */
    public void setRuututyyppi(Ruututyyppi tyyppi, int x, int y) {
        Ruutu ruutu = getRuutu(x, y);
        ruutu.setRuutu(tyyppi);
    }

    /**
     * Siirtää hahmon annetusta ruudusta annettuun kohderuutuun. Palauttaa
     * falsen, jos lähtöruudussa ei ole siirrttävää hahmoa tai jos kohderuusussa
     * on seinä tai toinen hahmo
     *
     * @param lahtoruutu Mistä hahmoa siirretään
     * @param kohderuutu Minne hahmo siirretään
     * @return Onnistuiko siirto
     */
    public boolean moveHahmo(Ruutu lahtoruutu, Ruutu kohderuutu) {
        if (!(lahtoruutu.containsHahmo()) || kohderuutu.getRuutu().equals(Ruututyyppi.SEINÄ) || kohderuutu.containsHahmo()) {
            return false;
        } else {
            Hahmo hahmo = lahtoruutu.getHahmo();
            kohderuutu.setHahmo(hahmo);
            lahtoruutu.setHahmo(null);
            return true;
        }
    }

    /**
     * Palauttaa polygonin suhteessa ruudun sisaltoon
     */
    /* public Polygon haeRuudunSisaltoKuvana(int x, int y){
        Polygon haettu = 
        return haettu;
    }
    
    
    public Collection<Polygon> haeKaikkienRuutunjenSisallotKuvina(){
        
    }*/
    // Palauttaa ruudun suhteessa aloitusruutuun. Esim. -1, 0 palauttaisu ruudun vasemmalta
    /*public Ruutu getRuutuSuhteessa(Ruutu lahtoruutu, int x, int y){
        return new Ruutu();
    }*/
}
