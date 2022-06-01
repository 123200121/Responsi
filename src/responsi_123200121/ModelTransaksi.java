/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200121;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class ModelTransaksi {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/trans_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ModelTransaksi() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][7]; 
            
            String query = "SELECT * FROM transactions"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_trans"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama_barang");                
                data[jmlData][2] = resultSet.getString("nama_kasir");
                data[jmlData][3] = String.valueOf(resultSet.getInt("qty"));
                data[jmlData][4] = String.valueOf(resultSet.getInt("price_per_qty"));
                data[jmlData][5] = String.valueOf(resultSet.getInt("discount"));
                data[jmlData][6] = String.valueOf(resultSet.getInt("price_total"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String IdTransaksi, String NamaBarang, String NamaKasir, int Quantity, int HargaSatuan, int Diskon, int TotalHarga){
        int jmlData=0;
        
        try {
           String query = "SELECT * FROM transactions WHERE id_trans='" + IdTransaksi+"'"; 
           System.out.println(IdTransaksi + " " + NamaBarang + " " + NamaKasir + " " + Quantity + " " + HargaSatuan + " " + Diskon + " " + TotalHarga);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO transactions(id_trans,nama_barang,nama_kasir,qty,price_per_qty, discount, price_total) VALUES('"+IdTransaksi+"','"+NamaBarang+"','"+NamaKasir+"','"+Quantity+"','"+HargaSatuan+"','"+Diskon+"','"+TotalHarga+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String IdTransaksi, String NamaBarang, String NamaKasir, int Quantity, int HargaSatuan, int Diskon, int TotalHarga){
        int jmlData=0;
         try {
           String query = "SELECT * FROM transactions WHERE id_trans='" + IdTransaksi+"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE transactions SET nama_barang='" + NamaBarang + "', nama_kasir='" + NamaKasir + "', qty='"+ Quantity+"', price_per_qty='"+ HargaSatuan+"', discount='"+ Diskon+", 'total_price='"+ TotalHarga+"' WHERE id_trans='" + IdTransaksi+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteData (String IdTransaksi) {
        try{
            String query = "DELETE FROM transactions WHERE id_trans = '"+IdTransaksi+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
