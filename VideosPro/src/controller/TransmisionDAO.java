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
import model.Transmision;
import model.Usuario;
import model.Contenido;
import utils.ConnectionDB;
import utils.ConnectionDB;
      
/**
 *
 * @author alejandro
 */
public class TransmisionDAO {
    private Connection conn = null;
    public ArrayList<Transmision> getAllTransmisiones(){
        ArrayList<Transmision> Transmisiones = new ArrayList();
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT * FROM Transmision ORDER BY Trans_id ASC;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Transmision tr = new Transmision(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                Transmisiones.add(tr);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return Transmisiones;
    }
    public void insertTransmision(Transmision tr, Usuario user, Contenido cont){
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT into Transmision (trans_fecha, trans_cont_id, trans_alias) values (?,(SELECT cont_id FROM Contenido WHERE nombre_cont=?),?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, tr.getTransFecha());
            pstm.setString(2, cont.getNombreCont());
            pstm.setString(3, user.getAlias());
            
            
            int rowsInserted = pstm.executeUpdate();
            if (rowsInserted>0)
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
       
    }
    public String[] getAllTransID(){
        ArrayList<Transmision> Transmisiones = new ArrayList();
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT * FROM Transmision ORDER BY Trans_id ASC;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Transmision tr = new Transmision(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                Transmisiones.add(tr);
            }
            String[] IDs = new String[Transmisiones.size()];
            for(int i=0; i<Transmisiones.size();i++){
                IDs[i]=String.valueOf(Transmisiones.get(i).getTransId());
            }
            return IDs;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return null;
    }
    public void updateTransmision(String nuevaFecha, Transmision tr, Contenido cont, Usuario user){
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE Transmision SET trans_fecha=?, trans_cont_id=(SELECT cont_id FROM Contenido WHERE nombre_cont=?), trans_alias=? WHERE trans_id=?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nuevaFecha);
            pstm.setString(2, cont.getNombreCont());
            pstm.setString(3, user.getAlias());
            pstm.setInt(4, tr.getTransId());
            
            
            int rowsInserted = pstm.executeUpdate();
            if (rowsInserted>0)
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
    }
    public void deleteTransmision(Transmision tr){
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM Transmision WHERE trans_id=?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, tr.getTransId());          
            
            int rowsInserted = pstm.executeUpdate();
            if (rowsInserted>0)
                JOptionPane.showMessageDialog(null, "El registro fue Eliminado exitosamente !");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
    }
}
