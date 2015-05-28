/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieranross
 */
public abstract class SQL {
    
    public static Connection connect(String Host, String Database, String Username, String Password){
        
        String host = Host;
        String database = Database;
        String username = Username;
        String password = Password;
        
        Connection connection;
        connection = null;
        
        try {
		connection = DriverManager
		.getConnection("jdbc:mysql://" + host + ":3306/" + database,username, password);
 
	} catch (SQLException e) {
		Utilities.consoleMessage("Connection Failed");
		
	}
        Utilities.consoleMessage("Connection Successful");
        return connection;
          
    }
    
    
    public static void update(Connection connection, String Command){
        
        
        Connection databseConnection = connection;
        PreparedStatement Statement = null;
        
        try {
            Statement = databseConnection.prepareStatement(Command);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void insert(Connection connection, String Command){
        
        
        Connection databseConnection = connection;
        PreparedStatement Statement = null;
        
        try {
            Statement = databseConnection.prepareStatement(Command);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void delete(Connection connection, String Command){
        
        Connection databseConnection = connection;
        PreparedStatement Statement = null;
        
        try {
            Statement = databseConnection.prepareStatement(Command);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void create(Connection connection, String Command){
        
        
        Connection databseConnection = connection;
        PreparedStatement Statement = null;
        
        try {
            Statement = databseConnection.prepareStatement(Command);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void execute(Connection connection, String Command){
        
        
        Connection databseConnection = connection;
        PreparedStatement Statement = null;
        
        try {
            Statement = databseConnection.prepareStatement(Command);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
