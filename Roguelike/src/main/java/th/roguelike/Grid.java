/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.roguelike;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toukk
 * 
 * Grid luo kaksiulotteisen taulukon, jonka sisään laitetaan se objekti mitä ruudussa on.
 * Tyhjää ruutua käitellään tyhjänä tilana.
 * 
 */

public class Grid {
    private List<List<Tyyppi>> koordinaatisto; //Tulevaisuudessa laitetaan lista siältämään jotain muuta
    private int pelaajaX;
    private int pelaajaY;
    
    public Grid(int x, int y){
        
        koordinaatisto = new ArrayList<>();
        
        int i;
        for(i = 0; i < x; i++){
            ArrayList <Tyyppi> uusiY = new ArrayList<>();
            int j;
            for(j = 0; j < y; j++){
                uusiY.add(Tyyppi.TYHJÄ);
            }
            koordinaatisto.add(uusiY);
        }
    }
    
    public int getX (){
        return koordinaatisto.size();
    }
    
     public int getY (){
        return koordinaatisto.get(0).size();
    }
    
    
    public Tyyppi haeKoordinaatista(int x, int y){
        return koordinaatisto.get(x).get(y);
    }
    
    public void lisaaSeina(int x, int y){
        koordinaatisto.get(x).set(y, Tyyppi.SEINÄ);
    }
    
    public void lisaaPelaaja(int x, int y){
        koordinaatisto.get(x).set(y, Tyyppi.PELAAJA);
        pelaajaX = x;
        pelaajaY = y;
    }
    
    public void siirraPelaajaaOikealle(){
        koordinaatisto.get(pelaajaX).set(pelaajaY, Tyyppi.TYHJÄ);
        koordinaatisto.get(pelaajaX + 1).set(pelaajaY, Tyyppi.PELAAJA);
        
        pelaajaX = pelaajaX + 1;
        pelaajaY = pelaajaY;
    }
    
    
}
