/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import javafx.scene.shape.Polygon;


/**
 * Ruutu-olio sisältää tiedon sekä ruudun tyypistä (lattia tai seinä) sekä
 * ruudussa mahdollisesti olevasta hahmosta
 *
 * @author toukk
 */
public class Ruutu {

    private Ruututyyppi ruutu;
    private Hahmo hahmo;
    // private List<Esine> esineet;  // Tuleva feature?

    public Ruutu(Ruututyyppi ruutu) {
        this.ruutu = ruutu;
        this.hahmo = null;
    }

    public Ruutu(Ruututyyppi ruutu, Hahmo hahmo) {
        this.ruutu = ruutu;
        this.hahmo = hahmo;
    }

    public Ruututyyppi getRuutu() {
        return this.ruutu;
    }

    public Hahmo getHahmo() {
        return this.hahmo;
    }

    public void setRuutu(Ruututyyppi ruutu) {
        this.ruutu = ruutu;
    }

    public void setHahmo(Hahmo hahmo) {
        this.hahmo = hahmo;
    }

    /**
     * Palauttaa tiedon siita onko ruudussa jotain hahmoa vai ei
     *
     * @return Onko ruudussa hahmo
     */
    public boolean containsHahmo() {
        return this.hahmo != null;
    }

    public Polygon getKuva() {
        Polygon kuva;
        if (this.containsHahmo()) {
            kuva = this.getHahmo().getKuva();
        } else {
            kuva = new Polygon (0,0,0,20,20,20,20,0);
            kuva.setFill(this.getRuutu().getVari());
        }
        return kuva;
    }
}
