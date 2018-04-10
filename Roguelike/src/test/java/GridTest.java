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
import th.roguelike.Grid;
import th.roguelike.Tyyppi;

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
        gridi = new Grid(5,5);
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
    public void lvoikoSeinanLuodaOikein(){
        gridi.lisaaSeina(1, 1);
        assertEquals(Tyyppi.SEINÄ,gridi.haeKoordinaatista(1, 1));
    }
}
