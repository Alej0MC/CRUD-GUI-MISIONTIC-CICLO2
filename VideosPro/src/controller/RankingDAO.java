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
import model.Ranking;
import utils.ConnectionDB;
import utils.ConnectionDB;
        
/**NewClass
 *
 * @author alejandro;
 */
public class RankingDAO {
    private Connection conn = null;
    public Object[][] getAllRankings(){
        ArrayList<Ranking> Rankings = new ArrayList();
        try {
            if(conn==null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT cont_id, nombre_cont, (SELECT count(trans_cont_id) FROM Transmision WHERE trans_cont_id=cont_id) FROM Contenido ORDER BY (SELECT count(trans_cont_id) FROM Transmision WHERE trans_cont_id=cont_id) DESC;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Ranking ran = new Ranking(rs.getInt(1),rs.getString(2),rs.getInt(3));
                Rankings.add(ran);
            }
            Object[][] tbranking = new Object[Rankings.size()][3];
            for(int i = 0; i < Rankings.size(); i++){
                tbranking[i][0] = Rankings.get(i).getContId();
                tbranking[i][1] = Rankings.get(i).getNombreCont();
                tbranking[i][2] = Rankings.get(i).getVis();
            }
            return tbranking;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return null;
    }
}
