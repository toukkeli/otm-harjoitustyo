package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 10.0",kortti.toString());
    }
    
    @Test
    public void kortilleVoiLisataRahaaOikein() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0",kortti.toString());
    }
    
    @Test
    public void rahanOttaminenToimiiJosSeRiittaa() {
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0",kortti.toString());
    }
    
    @Test
    public void rahanOttaminenEiToimiJosSeEiRiita() {
        kortti.otaRahaa(1500);
        assertEquals("saldo: 10.0",kortti.toString());
    }
}
