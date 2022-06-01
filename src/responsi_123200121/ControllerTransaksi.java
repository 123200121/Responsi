/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200121;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.management.Query.value;

/**
 *
 * @author ACER
 */
public class ControllerTransaksi {
    ModelTransaksi modelTrans;
    ViewTransaksi transView;
    public String data;
    
    public ControllerTransaksi(ModelTransaksi modelTrans, ViewTransaksi transView){
        this.modelTrans = modelTrans;
        this.transView = transView;
        
        if (modelTrans.getBanyakData()!=0) {
            String dataTrans[][] = modelTrans.readData();
            transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         transView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String IdTransaksi = transView.getIDTransaksi();
                String NamaBarang = transView.getNamaBarang();
                String NamaKasir = transView.getNamaKasir();
                int Quantity = transView.getQuantity();
                int HargaSatuan = transView.getHargaSatuan();
                double Diskon = transView.getDiskon();
                double HargaTotal = (HargaSatuan*Quantity)*((100-Diskon)/100);
                int HargaTotal2;
                HargaTotal2 = (int)HargaTotal;
                int Diskon2 = (int)Diskon;
                if(IdTransaksi.isEmpty() || NamaBarang.isEmpty() || NamaKasir.isEmpty() || Quantity==0 || HargaSatuan==0 || Diskon == -1){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else if(IdTransaksi.length()>10){
                    JOptionPane.showMessageDialog(null, "Id Transaksi Tidak Boleh Lebih Dari 10");
                }
                else{
                    modelTrans.insertData(IdTransaksi, NamaBarang, NamaKasir, Quantity, HargaSatuan, Diskon2, HargaTotal2);
                }
                
         
                String dataTrans[][] = modelTrans.readData();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            }
        });
         
          transView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String IdTransaksi = transView.getIDTransaksi();
                String NamaBarang = transView.getNamaBarang();
                String NamaKasir = transView.getNamaKasir();
                int Quantity = transView.getQuantity();
                int HargaSatuan = transView.getHargaSatuan();
                double Diskon = transView.getDiskon();
                double HargaTotal = (HargaSatuan*Quantity)*((100-Diskon)/100);
                int HargaTotal2;
                HargaTotal2 = (int)HargaTotal;
                int Diskon2 = (int)Diskon;
                if(IdTransaksi.isEmpty() || NamaBarang.isEmpty() || NamaKasir.isEmpty() || Quantity==0 || HargaSatuan==0 || Diskon == -1){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else if(IdTransaksi.length()>10){
                    JOptionPane.showMessageDialog(null, "Id Transaksi Tidak Boleh Lebih Dari 10");
                }
                else{
                    modelTrans.updateData(IdTransaksi, NamaBarang, NamaKasir, Quantity, HargaSatuan, Diskon2, HargaTotal2);
                }
                

                String dataTrans[][] = modelTrans.readData();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            }
        });
         
          transView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                transView.tfid.setText("");
                transView.tfnamabarang.setText("");
                transView.tfnamakasir.setText("");
                transView.tfquantity.setText("");
                transView.tfhargasatuan.setText("");
                transView.tfdiskon.setText("");
            }
        });
        
    
          transView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = transView.tabel.getSelectedRow();
                data = transView.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = transView.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = transView.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          transView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus Judul " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelTrans.deleteData(data);
                String dataTrans[][] = modelTrans.readData();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });
          
          

    }
}
