/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Pelaaja kuvaa pelaajan kontrolloimaa hahmoa. Luokka on varsin tynkä koska
 * statteja ei vielä ole. Pelaaja muistaa koordinaattinsa Roguelike-luokan
 * tarpeisiin
 *
 * @see Roguelike
 * @see Hahmo
 * @author toukk
 */
public class Pelaaja extends Hahmo {

    private int level;

    public Pelaaja(int x, int y) {
        super(x, y);
        this.getKuva().setFill(Color.AQUA);
        setDmg(1);
        setAcc(100);
        setHp(30);
        setMaxhp(30);
        setNimi("Pelaaja");
        this.level = 1;
    }

    public int getLevel() {
        return this.level;
                
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public void levelUp(){
        this.level = this.level + 1;
    }
    
    public String status(){
        return "HP: " +getHp() +"/"+getMaxhp()+" : DMG: " + this.getDmg() + " : ACC: "+ getAcc();
    }
}
