/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200121;

/**
 *
 * @author ACER
 */
public class Responsi_123200121 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewTransaksi vt = new ViewTransaksi();
        ModelTransaksi mt = new ModelTransaksi();
        ControllerTransaksi ct = new ControllerTransaksi(mt,vt);
    }
    
}
