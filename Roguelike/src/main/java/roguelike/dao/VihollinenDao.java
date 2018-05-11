/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roguelike.domain.Vihollinen;

/**
 *
 * @author toukk
 */
public class VihollinenDao implements Dao<Vihollinen, String> {

    private Database database;

    public VihollinenDao(Database database) {
        this.database = database;
    }

    @Override
    public Vihollinen findOne(String key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Vihollinen WHERE nimi = ?");
        stmt.setString(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Vihollinen a = new Vihollinen(rs.getString("nimi"),
                0,
                0,
                rs.getInt("hp"),
                rs.getInt("dmg"),
                rs.getInt("acc"));

        stmt.close();
        rs.close();

        conn.close();

        return a;
    }

    @Override
    public List findAll() throws SQLException {
        List<Vihollinen> kaikki = new ArrayList<>();

        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Vihollinen");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vihollinen a = new Vihollinen(rs.getString("nimi"),
                    0,
                    0,
                    rs.getInt("hp"),
                    rs.getInt("dmg"),
                    rs.getInt("acc"));
            kaikki.add(a);
        }

        stmt.close();
        rs.close();

        conn.close();

        return kaikki;
    }

    /*
        Huomio!
    Vaikka tavoitteena olikin välttää toteuttamattomia metodeja, niin katsoin 
    selkeäksi jättää yleiset DAO-metodit paikalleen toteuttamattomina 
    sekaannusten välttämiseksi.
     */
    @Override
    public Vihollinen saveOrUpdate(Vihollinen vihollinen) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
