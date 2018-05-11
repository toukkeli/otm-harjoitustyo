/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Luolastosta löytyvää oliota kuvaava yläluokka. Ei sisällä vielä mitään koska
 * hahmoille ei ole vielä implementoitu statteja
 *
 * @author toukk
 */
public abstract class Hahmo {

    private Polygon kuva;
    private int x;
    private int y;
    private int maxhp;
    private int hp;
    private int dmg;
    private int acc;
    private String nimi;

    public Hahmo(int x, int y) {

        this.kuva = new Polygon(10, 0, 20, 10, 10, 20, 0, 10);
        this.y = y;
        this.x = x;

        this.maxhp = 1;
        this.hp = 1;
        this.acc = 100;
        this.dmg = 1;
    }

    Polygon getKuva() {
        return this.kuva;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setMaxhp(int hp) {
        this.maxhp = hp;
    }

    public int getMaxhp() {
        return this.maxhp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDmg() {
        return this.dmg;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getAcc() {
        return this.acc;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    /**
     * Suorittaa hyokkayksen toiseen hahmoon ja vahentaa silta dmg-statin verran
     * HP>:ta Paaluttaa true jos osuttiin, muuten false
     *
     * @param kohde
     * @return
     */
    public String hyokkaa(Hahmo kohde) {
        Random satunnainen = new Random();
        if(satunnainen.nextInt(100) < this.getAcc()){
            kohde.otaVahinkoa(this.dmg);
            return this.getNimi() + "osui olioon " + kohde.getNimi() + " ja teki " + this.getDmg() + " vahinkoa";
        } else {
            return this.getNimi() + "löi huti";
        }
    }

    public void otaVahinkoa(int dmg) {
        this.hp = this.hp - dmg;

    }
}
