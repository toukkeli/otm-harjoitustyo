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
public class Pelaaja extends Hahmo {

    private int x;
    private int y;

    public Pelaaja(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Tänne tulee pelaajan perusjuttuja kunhan aika on
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

}
