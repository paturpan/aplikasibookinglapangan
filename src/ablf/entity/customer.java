/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.entity;
import java.util.Date;
/**
 *
 * @author 
 */
public class customer {
    private String id_anggota, nama_anggota, alamat, no_telp, email;
    private Date tgl_daftar;

    public customer(){
    }
    
    public customer(String id_anggota, String nama_anggota, String alamat, String no_telp, String email, Date tgl_daftar) {
        this.id_anggota = id_anggota;
        this.nama_anggota = nama_anggota;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.email = email;
        this.tgl_daftar = tgl_daftar;
    }

    public String getId_anggota() {
        return id_anggota;
    }
    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }
    
    public String getNama_anggota() {
        return nama_anggota;
    }
    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }
    
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getNo_telp() {
        return no_telp;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getTgl_daftar() {
        return tgl_daftar;
    }
    public void setTgl_daftar(Date tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }
    
}
