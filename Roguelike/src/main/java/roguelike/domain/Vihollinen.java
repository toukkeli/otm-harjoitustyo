/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.domain;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Geneerista vihollista kuvaava luokka. Ei sisällä vielä mitään koska hahmoille
 * ei ole vielä implementoitu statteja
 *
 * @author toukk
 */
public class Vihollinen extends Hahmo {

    public Vihollinen(int x, int y) {
        super(x, y);

        this.getKuva().setFill(Color.RED);
    }

    public Vihollinen(String nimi, int x, int y, int hp, int dmg, int acc) {
        super(x, y);
        this.setHp(hp);
        this.setMaxhp(hp);
        this.setDmg(dmg);
        this.setAcc(acc);
        this.setNimi(nimi);
    }

    public void toimi() {

    }

}
