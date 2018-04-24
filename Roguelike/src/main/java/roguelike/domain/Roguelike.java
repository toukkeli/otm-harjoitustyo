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
public class Roguelike {
    private Grid kartta;
    private Pelaaja pelaaja;
    
    public Roguelike(){
        this.kartta = new Grid(10,10);
        this.pelaaja = new Pelaaja(4,4);
        this.kartta.setHahmo(pelaaja, pelaaja.getX(), pelaaja.getY());
    }
    
    public Roguelike(Grid kartta, int x, int y){
        this.kartta = kartta;
        this.pelaaja = new Pelaaja(x,y);
        this.kartta.setHahmo(pelaaja, x, y);
    }
    
    
    public Grid getGrid(){
        return this.kartta;
    }
    
    public Pelaaja getPelaaja(){
        return this.pelaaja;
    }
    
    
    public Boolean liikutaPelaajaa(int xMuutos, int yMuutos){
        int x = getPelaaja().getX();
        int y = getPelaaja().getY();
        Ruutu lahtoruutu = getGrid().getRuutu(x, y);
        Ruutu kohderuutu = getGrid().getRuutu(x +xMuutos, y + yMuutos);
        if(kartta.moveHahmo(lahtoruutu, kohderuutu)){
            pelaaja.setX(x + xMuutos);
            pelaaja.setY(y + yMuutos);
            return true;
        }else{
            return false;
        }
        
    }
    
    /*public Boolean liikutaHahmoa(Hahmo hahmo, int xMuutos, int yMuutos){
        int x = getPelaaja().getX();
        int y = getPelaaja().getY();
        Ruutu lahtoruutu = getGrid().getRuutu(x, y);
        Ruutu kohderuutu = getGrid().getRuutu(x +xMuutos, y + yMuutos);
        return kartta.moveHahmo(lahtoruutu, kohderuutu);
    }*/
    
}
