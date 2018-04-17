/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import roguelike.domain.Grid;
import roguelike.domain.Pelaaja;
import roguelike.domain.Ruututyyppi;

/**
 *
 * @author toukk
 */
public class GridTest {

    Grid gridi;

    public GridTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        gridi = new Grid(5, 5);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void palautaOikeaLeveys(){
        Grid gridi2 = new Grid(3,3);
        assertEquals(gridi2.getLeveys(), 3);
    }
    
    @Test
    public void palautaOikeaKorkeus(){
        Grid gridi2 = new Grid(3,3);
        assertEquals(gridi2.getKorkeus(), 3);
    }
    
    @Test
    public void ruudunTyyppiHaetaanOikein(){
        assertTrue(gridi.getRuutu(1, 1).getRuutu() == Ruututyyppi.LATTIA);
    }
    
    @Test
    public void ruudunTyyppiAsetetaanOikein(){
        gridi.setRuututyyppi(Ruututyyppi.SEINÄ, 1, 1);
        assertTrue(gridi.getRuutu(1, 1).getRuutu() == Ruututyyppi.SEINÄ);
    }
    
    @Test
    public void ruudunHahmoAsetetaanOikein(){
        Pelaaja pelaaja = new Pelaaja(1,1);
        gridi.setHahmo(pelaaja, 1, 1);
        assertEquals(pelaaja,gridi.getRuutu(1, 1).getHahmo());
    }
    
    /*@Test
    public void siirtoToimii(){
        Pelaaja pelaaja = new Pelaaja(1,1);
        gridi.setHahmo(pelaaja, 1, 1);
        gridi.getRuutu(1, 2).setRuutu(Ruututyyppi.LATTIA);
        Boolean onnistuiko = gridi.moveHahmo(gridi.getRuutu(1,1), gridi.getRuutu(1,2));
        assertTrue(onnistuiko);
    }
    
    @Test
    public void hahmoaVoiSiirtaaOikein(){
        Pelaaja pelaaja = new Pelaaja(1,1);
        gridi.setHahmo(pelaaja, 1, 1);
        gridi.getRuutu(1, 2).setRuutu(Ruututyyppi.LATTIA);
        gridi.moveHahmo(gridi.getRuutu(1,1), gridi.getRuutu(1,2));
        assertEquals( pelaaja, gridi.getRuutu(1, 2).getHahmo());
    }*/
}
