/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.model;
import ablf.koneksi.customerkoneksi;
import ablf.entity.customer;
import ablf.error.customerException;
import ablf.model.event.customerListener;
import java.sql.SQLException;
import java.util.Date;
import ablf.service.CustomerDao;
/**
 *
 * @author Penghuni Warnet
 */
public class AnggotaModel {
    private String id_anggota, nama_anggota, alamat, no_telp, email;
    private Date tgl_daftar;
    
    private customerListener listener;

    public customerListener getListener() {
        return listener;
    }
    public void setListener(customerListener listener) {
        this.listener = listener;
    }
            
    public String getId_anggota() {
        return id_anggota;
    }
    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
        fireOnChange();
    }

    public String getNama_anggota() {
        return nama_anggota;
    }
    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
        fireOnChange();
    }
    
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    public String getNo_telp() {
        return no_telp;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
        fireOnChange();
    }
    
    public Date getTgl_daftar() {
        return tgl_daftar;
    }
    public void setTgl_daftar(Date tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(customer anggota) {
        if (listener != null) {
            listener.onInsert(anggota);
        }
    }
    
    protected void fireOnUpdate(customer anggota) {
        if (listener != null) {
            listener.onUpdate(anggota);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetAnggota() {
        setId_anggota("");
        setNama_anggota("");
        setAlamat("");
        setNo_telp("");
        setEmail("");
        setTgl_daftar(new Date());
    }
    
    public void insertAnggota() throws SQLException, customerException {
        CustomerDao dao = customerkoneksi.getAnggotaDao();
        
        customer anggota = new customer();
        anggota.setId_anggota(id_anggota);
        anggota.setNama_anggota(nama_anggota);
        anggota.setAlamat(alamat);
        anggota.setNo_telp(no_telp);
        anggota.setEmail(email);
        anggota.setTgl_daftar(tgl_daftar);
        
        dao.insertAnggota(anggota);
        
        fireOnInsert(anggota);
    }
    
    public void updateAnggota() throws SQLException, customerException {
        CustomerDao dao = customerkoneksi.getAnggotaDao();
        customer anggota = new customer();
        anggota.setId_anggota(id_anggota);
        anggota.setNama_anggota(nama_anggota);
        anggota.setAlamat(alamat);
        anggota.setNo_telp(no_telp);
        anggota.setEmail(email);
        anggota.setTgl_daftar(tgl_daftar);
        dao.updateAnggota(anggota);
        
        fireOnUpdate(anggota);
    }
    
    public void deleteAnggota() throws SQLException, customerException {
        CustomerDao dao = customerkoneksi.getAnggotaDao();
        
        dao.deleteAnggota(id_anggota);
        
        fireOnDelete();
    }
}
