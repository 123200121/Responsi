/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200121;




import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewTransaksi extends JFrame{
    JLabel lid = new JLabel("Id Transaksi");
    JLabel lnamabarang = new JLabel("Nama Barang");
    JLabel lnamakasir = new JLabel("Nama Kasir");
    JLabel lquantity = new JLabel("Quantity");
    JLabel lhargasatuan = new JLabel("Harga Satuan");
    JLabel ldiskon = new JLabel("Diskon");
    
    public JTextField tfid = new JTextField();
    public JTextField tfnamabarang = new JTextField();
    public JTextField tfnamakasir = new JTextField();
    public JTextField tfquantity = new JTextField();
    public JTextField tfhargasatuan = new JTextField();
    public JTextField tfdiskon = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Id Transaksi", "Nama Barang", "Nama Kasir", "Quantity", "Harga Satuan", "Diskon", "Total Harga"};

    public ViewTransaksi() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Catatan Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(745,500);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 570, 400);
        
        add(lid);
        lid.setBounds(600, 20, 90, 20);
        add(tfid);
        tfid.setBounds(600, 40, 120, 20);
        
        add(lnamabarang);
        lnamabarang.setBounds(600, 60, 90, 20);
        add(tfnamabarang);
        tfnamabarang.setBounds(600, 80, 120, 20);
        
        add(lnamakasir);
        lnamakasir.setBounds(600, 100, 90, 20);
        add(tfnamakasir);
        tfnamakasir.setBounds(600, 120, 120, 20);
        
        add(lquantity);
        lquantity.setBounds(600, 140, 90, 20);
        add(tfquantity);
        tfquantity.setBounds(600, 160, 120, 20);
        
        add(lhargasatuan);
        lhargasatuan.setBounds(600, 180, 90, 20);
        add(tfhargasatuan);
        tfhargasatuan.setBounds(600, 200, 120, 20);
        
        add(ldiskon);
        ldiskon.setBounds(600, 220, 90, 20);
        add(tfdiskon);
        tfdiskon.setBounds(600, 240, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(600, 270, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(600, 300, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(600, 330, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(600, 360, 90, 20);
    }
    
    public String getIDTransaksi(){
        return tfid.getText();
    }
    
    public String getNamaBarang(){
        return tfnamabarang.getText();
    }
    
    public String getNamaKasir(){
        return tfnamakasir.getText();
    }
    
    public int getQuantity(){
        if(tfquantity.getText().isEmpty()){
            int qty = 0;
            return qty;
        }
        else{
            return Integer.parseInt(tfquantity.getText());
        }
        
    }
    
    public int getHargaSatuan(){
        if(tfhargasatuan.getText().isEmpty()){
            int hs = 0;
            return hs;
        }
        else{
            return Integer.parseInt(tfhargasatuan.getText());
        }
        
    }
    
    public int getDiskon(){
        if(tfdiskon.getText().isEmpty()){
            int d = -1;
            return d;
        }
        else{
            return Integer.parseInt(tfdiskon.getText());
        }
        
    }
}
