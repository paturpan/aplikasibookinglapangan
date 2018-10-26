/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.controller;

import ablf.model.AnggotaModel;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import ablf.error.AdminException;
import ablf.error.customerException;
/**
 *
 * @author Penghuni Warnet
 */
public class customerController extends javax.swing.JFrame {

    private Object gettxtId_anggota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object gettxtNama_anggota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object gettxtAlamat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object gettxtNo_telp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object gettxtEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object gettblAnggota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public class customerController {
    private AnggotaModel model;

    public void setModel(AnggotaModel model) {
        this.model = model;
    }

    public void resetAnggota(customerController view) {
        model.resetAnggota();
    }
    
    public void insertAnggota(customerController view) {

        String id_anggota = view.gettxtId_anggota().getText();
        String nama_anggota = view.gettxtNama_anggota().getText();
        String alamat = view.gettxtAlamat().getText();
        String no_telp = view.gettxtNo_telp().getText();
        String email = view.gettxtEmail().getText();
        Date tgl_daftar = new Date();
        
        
        if (id_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Anggota Belum Terisi!!!");
        } else if (id_anggota.length() > 6) {
            JOptionPane.showMessageDialog(view, "ID Anggota tidak boleh lebih dari 6 karakter");
        } else if (nama_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Anggota Belum Terisi!!!");
        } else if (nama_anggota.length() > 35) {
            JOptionPane.showMessageDialog(view, "Nama Anggota tidak boleh lebih dari 35 karakter");
        } else if (alamat.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat Anggota Belum Terisi!!!");
        } else if (alamat.length() > 75) {
            JOptionPane.showMessageDialog(view, "Alamat Anggota tidak boleh lebih dari 75 karakter");
        } else if (no_telp.length() > 18) {
            JOptionPane.showMessageDialog(view, "Nomor no_telp tidak boleh lebih dari 18 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid!!!");
        } else if (email.length() > 25) {
            JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 25 karakter");
        } else {
            model.setId_anggota(id_anggota);
            model.setTgl_daftar(tgl_daftar);
            model.setNama_anggota(nama_anggota);
            model.setAlamat(alamat);
            model.setEmail(email);
            model.setNo_telp(no_telp);

            try {
                model.insertAnggota();
                JOptionPane.showMessageDialog(view, "Data Anggota Berhasil Tersimpan");
                model.resetAnggota();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi Kesalahan Program !!!",
                            throwable.getMessage()});
            }
        }
    }
 
    public void updateAnggota(customerController view) {

        if (view.gettblAnggota().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Diubah");
        } else {
            String id_anggota = view.gettxtId_anggota().getText();
            String nama_anggota = view.gettxtNama_anggota().getText();
            String alamat = view.gettxtAlamat().getText();
            String no_telp = view.gettxtNo_telp().getText();
            String email = view.gettxtEmail().getText();

            if (id_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Anggota Belum Terisi!!!");
        } else if (id_anggota.length() > 6) {
            JOptionPane.showMessageDialog(view, "ID Anggota tidak boleh lebih dari 6 karakter");
        } else if (nama_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Anggota Belum Terisi!!!");
        } else if (nama_anggota.length() > 35) {
            JOptionPane.showMessageDialog(view, "Nama Anggota tidak boleh lebih dari 35 karakter");
        } else if (alamat.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat Anggota Belum Terisi!!!");
        } else if (alamat.length() > 75) {
            JOptionPane.showMessageDialog(view, "Alamat Anggota tidak boleh lebih dari 75 karakter");
        } else if (no_telp.length() > 18) {
            JOptionPane.showMessageDialog(view, "Nomor no_telp tidak boleh lebih dari 18 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid!!!");
        } else if (email.length() > 25) {
            JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 25 karakter");
            } else {
                model.setId_anggota(id_anggota);
                model.setNama_anggota(nama_anggota);
                model.setAlamat(alamat);
                model.setEmail(email);
                model.setNo_telp(no_telp);

                try {
                    model.updateAnggota();
                    JOptionPane.showMessageDialog(view, "Data Anggota Berhasil Terupdate");
                    model.resetAnggota();
                } catch (SQLException | customerException | HeadlessException throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program !!!",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void deleteAnggota(customerController view) {

        if (view.gettblAnggota().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Anggota ini?") == JOptionPane.OK_OPTION) {
                String id_anggota = view.gettxtId_anggota().getText();
                model.setId_anggota(id_anggota);
                try {
                    model.deleteAnggota();
                    JOptionPane.showMessageDialog(view, "Data Anggota Berhasil Terhapus!!!");
                    model.resetAnggota();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program !!!",
                                throwable.getMessage()});
                }
            }
        }
    }
    
}
