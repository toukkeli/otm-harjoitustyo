/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import javafx.scene.paint.Color;

/**
 *
 * @author toukk
 *
 *
 * Tyyppi sisältää kaikki mahdollisuudet siitä mitä ruudussa voi olla (seinä,
 * lattia) , lukuunottamatta hahmoja.
 *
 * @see Hahmo
 *
 */
public enum Ruututyyppi {
    SEINÄ(Color.GRAY),
    LATTIA(Color.BROWN),
    PORTAAT(Color.DARKGRAY);
    
    private final Color vari;
    public Color getVari(){
        return this.vari;
    }
    
    Ruututyyppi(Color vari){
        this.vari = vari;
    }
    
    
}
