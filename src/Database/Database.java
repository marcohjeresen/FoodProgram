/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marco
 */
public class Database {

    private String database;
    private String host;
    private String port;
    private String brugernavn;
    private String kode;
    private Connection conn;
    private Statement stmt;

    public Database() throws ClassNotFoundException, SQLException {
        this.database = "foodplan";
        this.host = "localhost";
        this.port = "3306";
        this.brugernavn = "root";
        this.kode = "root";
        Class.forName("com.mysql.jdbc.Driver");
        connect();
    }

    public void connect() throws SQLException {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        conn = DriverManager.getConnection(url, brugernavn, kode);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public ResultSet query(String sql) throws SQLException {
        stmt = conn.createStatement();
        
        return stmt.executeQuery(sql);
    }

    public int ændre(String sql) throws SQLException {
        stmt = conn.createStatement();
        stmt.execute(sql);
        return 0;
    }

   

}
