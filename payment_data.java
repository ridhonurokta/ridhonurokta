/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm149.entity;

/**
 *
 * @author RidhoNurOktaviansyah
 */
import com.app.uts.npm149.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class payment_data {
    private Connection connection;

    public payment_data() {
        connection = ConnectionUtil.getConnection();
    }
    
    public List<Servis> getAll(){
        List<Servis> List = new ArrayList<>();
        String sql = "SELECT * FROM Procurement";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Servis srv;
            while(rs.next()){
                srv = new Servis();
                srv.setId(rs.getString("id"));
                srv.setNama(rs.getString("tanggal"));
                srv.setMerk(rs.getString("nomorPO"));
                srv.setPemilik(rs.getString("supplier"));
                srv.setHarga(rs.getDouble("totaltagihan"));
                List.add(srv);    
            }
            
        } catch (Exception e) {
            System.out.println("Error get All " + e.getMessage());
        }
        return List;
    }
    
    public Servis getByID(String nim){
        String sql = "SELECT * FROM Procurement WHERE id=?";
        Servis srv = null;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nim);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                srv = new Servis();
                srv.setId(rs.getString("id"));
                srv.setNama(rs.getString("tanggal"));
                srv.setMerk(rs.getString("nomorPO"));
                srv.setPemilik(rs.getString("supplier"));
                srv.setHarga(rs.getDouble("totaltagihan"));
            }
        }catch (Exception e){
        }
        return srv;
    }
    
    public boolean insert(Servis srv){
        boolean status = false;
        String sql = "INSERT INTO Procurement VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, srv.getId());
            statement.setString(2, srv.getTanggal());
            statement.setString(3, srv.getNomorPO());
            statement.setString(4, srv.getSupplier());
            statement.setDouble(5, srv.getTotalTagihan());
            int result = statement.executeUpdate();
            status = result > 0;
        }catch (Exception e) {
            
        }
        return status;
    }
    
    public boolean update(Servis srv){
        boolean status = false;
        String sql = "UPDATE Procurement SET tanggal=?,nomorPO=?,Supplier=?,TotalTagihan=? " + "WHERE id=?" ;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, srv.getId());
            statement.setString(2, srv.getTanggal());
            statement.setString(3, srv.getNomorPo());
            statement.setString(4, srv.getSupplier());
            statement.setDouble(5, srv.getTotalTagihan());
            int result = statement.executeUpdate();
            status = result > 0;
        }catch (Exception e) {
            
        }
        return status;
    }
    
    public boolean delete(Servis srv){
        boolean status = false;
        String sql = "DELETE FROM Procurement WHERE id=?" ;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, srv.getId());
            int result =statement.executeUpdate();
            status = result > 0;
        }catch (Exception e) {
            
        }
        return status;
    }
}
