/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Polygon;
import roguelike.dao.Database;
import roguelike.dao.VihollinenDao;

/**
 *
 * @author toukk
 *
 * Pelin toiminnallisuutta pääasiallisesti ohjaava luokka
 *
 * Sisältää kaksiulotteisen taulukon, joka sisältää ruutu-olioita.
 *
 * Luokan metodit siirtävät pelaajahahmoa sekä vihollisia ruudusta toiseen
 * koordinaatistossa ja hoitaa muutenkin yleistä pelimekaniikkaa
 *
 */
public class Map {

    private List<List<Ruutu>> koordinaatisto;
    private final Database tietokanta;
    private final Pelaaja pelaaja;
    private final ArrayList<Vihollinen> viholliset;
    private boolean havitty;

    public Map(Database tietokanta) {

        this.koordinaatisto = new ArrayList<>();
        this.pelaaja = new Pelaaja(5, 5);
        this.viholliset = new ArrayList<>();
        this.tietokanta = tietokanta;
        this.havitty = false;

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

    public Pelaaja getPelaaja() {
        return this.pelaaja;
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
     * on seinä
     *
     * Jos kohderuudussa on toinen vihollinen (tai vihollisen näkökulmasta
     * tietenkin pelaaja), suoritetaan hyökkäys
     *
     * @param lahtoruutu Mistä hahmoa siirretään
     * @param kohderuutu Minne hahmo siirretään
     * @return Onnistuiko siirto
     */
    private String moveHahmo(Ruutu lahtoruutu, int x, int y) {
        Ruutu kohderuutu = getRuutu(x, y);
        if (!(lahtoruutu.containsHahmo()) || kohderuutu.getRuutu().equals(Ruututyyppi.SEINÄ)) {
            Hahmo hahmo = lahtoruutu.getHahmo();
            return hahmo.getNimi() + " ei voinut liikkua";
        } else if (kohderuutu.containsHahmo()) {
            Hahmo hahmo = lahtoruutu.getHahmo();
            return hahmo.hyokkaa(kohderuutu.getHahmo());
        } else {
            Hahmo hahmo = lahtoruutu.getHahmo();
            kohderuutu.setHahmo(hahmo);
            lahtoruutu.setHahmo(null);
            hahmo.setX(x);
            hahmo.setY(y);
            return hahmo.getNimi() + " liikkui";
        }
    }

    public List<String> liikutaVihollisia() {
        List<String> kommentit = new ArrayList<>();
        if (viholliset.isEmpty()) {
            return kommentit;
        }

        viholliset.forEach(n -> kommentit.add(liikutaPelaajanSuuntaan(n)));
        return kommentit;
    }

    public Collection<Polygon> haeRuudut(int aloitusX, int aloitusY, int lopetusX, int lopetusY, int ruudunKoko) {
        ArrayList<Polygon> haettavat = new ArrayList<>();
        for (int i = aloitusX; i < lopetusX; i++) {
            for (int j = aloitusY; j < lopetusY; j++) {
                Polygon kuva = this.getRuutu(i, j).getKuva();
                kuva.setTranslateX(i * ruudunKoko);
                kuva.setTranslateY(j * ruudunKoko);
                haettavat.add(kuva);
            }
        }
        return haettavat;
    }

    public List<String> paivita() {
        List<String> kommentit = new ArrayList<>();

        if (ollaankoHavitty()) {
            kommentit.add("Pelaajaraukka kuolla kupsahti vakavaan HP:n puutteeseen!");
        } else {
            poistaKuolleetViholliset();
            kommentit.add(seuraavaTaso());
            kommentit.addAll(liikutaVihollisia());
        }

        return kommentit;
    }

    private String liikutaSuuntaan(Hahmo hahmo, int xMuutos, int yMuutos) {
        int x = hahmo.getX();
        int y = hahmo.getY();
        Ruutu lahtoruutu = getRuutu(x, y);
        return moveHahmo(lahtoruutu, x + xMuutos, y + yMuutos);

    }

    public String liikutaPelaajaa(int xMuutos, int yMuutos) {
        return liikutaSuuntaan(this.getPelaaja(), xMuutos, yMuutos);
    }

    public String liikutaPelaajanSuuntaan(Hahmo kuka) {
        int xMuutos = 0;
        int yMuutos = 0;
        if (kuka.getX() < this.getPelaaja().getX()) {
            xMuutos = 1;
        }
        if (kuka.getX() > this.getPelaaja().getX()) {
            xMuutos = -1;
        }
        if (kuka.getY() < this.getPelaaja().getY()) {
            yMuutos = 1;
        }
        if (kuka.getY() > this.getPelaaja().getY()) {
            yMuutos = -1;
        }
        return liikutaSuuntaan(kuka, xMuutos, yMuutos);
    }

    /**
     * Generoi uuden kerroksen luolastoon ja esiintyy sina
     *
     * @param leveys
     * @param korkeus
     * @return
     */
    private void generateMap(int leveys, int korkeus, int tyhjiaRuutuja, int vihollisia) {
        List<List<Ruutu>> uusiKoordinaatisto = new ArrayList<>(0);
        int i;
        // Luodaan ensin raamit
        for (i = 0; i < leveys; i++) {
            ArrayList<Ruutu> uusiSarake = new ArrayList<>();
            int j;
            for (j = 0; j < korkeus; j++) {

                uusiSarake.add(new Ruutu(Ruututyyppi.SEINÄ));

            }
            uusiKoordinaatisto.add(uusiSarake);
        }
        koordinaatisto = uusiKoordinaatisto;

        // Sen jälkeen luodaan sattumanvaraisia käytäviä ja muuta kivaa
        // Lisätään pelaaja alkuun ja portaat loppuun
        Random satunnainen = new Random();
        int rx = leveys / 2;
        int ry = korkeus / 2;
        this.pelaaja.setX(rx);
        this.pelaaja.setY(ry);
        getRuutu(rx, ry).setHahmo(pelaaja);
        for (int j = 0; j < tyhjiaRuutuja; j++) {

            getRuutu(rx, ry).setRuutu(Ruututyyppi.LATTIA);
            while (getRuutu(rx, ry).getRuutu().equals(Ruututyyppi.LATTIA)) {
                if (satunnainen.nextBoolean()) {
                    rx = rx + satunnainen.nextInt(3) - 1;
                } else {
                    ry = ry + satunnainen.nextInt(3) - 1;
                }
                while (rx < 1 || ry < 1 || ry >= korkeus || rx >= leveys) {
                    rx = leveys / 2;
                    ry = korkeus / 2;
                }
            }

        }

        getRuutu(rx, ry).setRuutu(Ruututyyppi.PORTAAT);

        // Lisätään vielä annettu määrä vihollisia
        for (int j = 0; j < vihollisia; j++) {

            rx = satunnainen.nextInt(leveys);
            ry = satunnainen.nextInt(korkeus);
            if (getRuutu(rx, ry).getRuutu().equals(Ruututyyppi.SEINÄ) || getRuutu(rx, ry).containsHahmo()) {
                j--;
            } else {
                lisaaSatunnainenVihollinen(rx, ry);
            }
        }

    }

    public void uusiTaso(int leveys, int korkeus, int tyhjiaRuutuja, int vihollisia) {
        generateMap(leveys, korkeus, tyhjiaRuutuja, vihollisia);
    }

    private void poistaKuolleetViholliset() {

        for (int i = 0; i < viholliset.size(); i++) {
            Hahmo tama = viholliset.get(i);
            if (tama.getHp() <= 0) {
                getRuutu(tama.getX(), tama.getY()).setHahmo(null);
                viholliset.remove(i);
                i--;
            }
        }
    }

    private void lisaaSatunnainenVihollinen(int x, int y) {
        VihollinenDao dao = new VihollinenDao(tietokanta);

        List<Vihollinen> vaihtoehdot = new ArrayList<>();
        try {
            vaihtoehdot = dao.findAll();
        } catch (SQLException ex) {
            vaihtoehdot.add(new Vihollinen("Bugi", 1, 1, 3, 2, 40));
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);

        }
        Random satunnainen = new Random();
        int r = satunnainen.nextInt(vaihtoehdot.size());
        Vihollinen vihollinen = vaihtoehdot.get(r);
        vihollinen.setX(x);
        vihollinen.setY(y);
        getRuutu(x, y).setHahmo(vihollinen);
        viholliset.add(vihollinen);

    }

    private boolean ollaankoHavitty() {
        return this.pelaaja.getHp() <= 0;

    }

    private String seuraavaTaso() {
        int x = this.getPelaaja().getX();
        int y = this.getPelaaja().getY();

        if (this.getRuutu(x, y).getRuutu().equals(Ruututyyppi.PORTAAT)) {
            this.getPelaaja().levelUp();
            this.viholliset.clear();
            uusiTaso(this.getLeveys(), this.getKorkeus(), 70, this.getPelaaja().getLevel());
            return "Syvemmälle vain! Laskeudutaan uudelle tasolle.";
        }
        return "";
    }

    public String pelaajanStatsit() {
        return this.getPelaaja().status();
    }
}
