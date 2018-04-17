/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

/**
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

    // Tämän voisi nimetä paremmin?
    public Ruututyyppi getRuutu() {
        return this.ruutu;
    }

    public Hahmo getHahmo() {
        return this.hahmo;
    }

    // Tämän voisi nimetä paremmin?
    public void setRuutu(Ruututyyppi ruutu) {
        this.ruutu = ruutu;
    }

    public void setHahmo(Hahmo hahmo) {
        this.hahmo = hahmo;
    }

    public boolean containsHahmo() {
        if (this.hahmo == null) {
            return false;
        } else {
            return true;
        }
    }
}
