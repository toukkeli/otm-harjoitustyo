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
import roguelike.domain.Pelaaja;
import roguelike.domain.Ruutu;
import roguelike.domain.Ruututyyppi;

/**
 *
 * @author toukk
 */
public class RuutuTest {

    Pelaaja pelaaja;
    Ruutu ruutu;
    
    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja(1,1);
        ruutu = new Ruutu(Ruututyyppi.LATTIA, pelaaja);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getHahmoToimii() {
        assertEquals(pelaaja, ruutu.getHahmo());
    }
    
    @Test
    public void getRuutytyyppiToimii() {
        assertEquals(Ruututyyppi.LATTIA, ruutu.getRuutu());
    }
}
