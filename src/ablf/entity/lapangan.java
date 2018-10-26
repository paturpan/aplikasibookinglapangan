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
public class lapangan {
    private String kode_lapangan, jenis_lapangan;
    private int jml_durasi, statistik;
    private Date tgl_entry_booking;
   
    public lapangan() {
    }

    public lapangan(String kode_lapangan, String jenis_lapangan,
                int jml_durasi,
                int statistik, Date tgl_entry_booking) {
        this.kode_lapangan = kode_lapangan;
        this.jenis_lapangan = jenis_lapangan;
        this.jml_durasi = jml_durasi;
        this.statistik = statistik;        
        this.tgl_entry_booking = tgl_entry_booking;
    }

    public String getKode_lapangan() {
        return kode_lapangan;
    }
    public void setKode_lapangan(String kode_lapangan) {
        this.kode_lapangan = kode_lapangan;
    }
    
    public String getJenis_lapangan() {
        return jenis_lapangan;
    }
    public void setJenis_lapangan(String jenis_lapangan) {
        this.jenis_lapangan = jenis_lapangan;
    }
   
    public Date getTgl_entry_booking() {
        return tgl_entry_booking;
    }
    public void setTgl_entry_booking(Date tgl_entry_booking) {
        this.tgl_entry_booking = tgl_entry_booking;
    }
        
    public int getJml_durasi() {
        return jml_durasi;
    }
    public void setJml_buku(int jml_durasi) {
        this.jml_durasi = jml_durasi;
    }
    
    public int getStatistik() {
        return statistik;
    }
    public void setStatistik(int statistik) {
        this.statistik = statistik;
    }

}
