/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import javax.accessibility.AccessibleRole;
import model.Contenido;
import utils.ConnectionDB;
import utils.ConnectionDB;
        
/**
 *
 * @author alejandro
 */
public class ContenidoDAO {
    private Connection conn = null;
    public ArrayList<Contenido> getAllContenidos(){
        ArrayList<Contenido> contenidos = new ArrayList();
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT * FROM Contenido;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Contenido cont = new Contenido(rs.getInt(1),rs.getString(2));
                contenidos.add(cont);
            }
            return contenidos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return null;
    }
}
