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
public class booking {
    private String id_anggota, kode_lapangan;
    private Date tgl_booking, jam_mulai, jam_selesai;
    private int id_booking, biaya;

    public booking() {
    }

    public booking(String id_anggota, String kode_booking, Date tgl_booking, Date jam_mulai, Date jam_selesai, int id_booking, int biaya) {
        this.id_anggota = id_anggota;
        this.kode_lapangan = kode_lapangan;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
        this.tgl_booking = tgl_booking;
        this.id_booking = id_booking;
        this.biaya = biaya;
    }

    public Date getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(Date jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public String getKode_lapangan() {
        return kode_lapangan;
    }

    public void setKode_buku(String kode_lapangan) {
        this.kode_lapangan = kode_lapangan;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public int getId_booking() {
        return id_booking;
    }

    public void setId_booking(int id_booking) {
        this.id_booking = id_booking;
    }

    public Date getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(Date Jam_mulai) {
        this.jam_mulai = Jam_mulai;
    }

    public Date getjam_mulai() {
        return jam_mulai;
    }

    public void setjam_mulai(Date jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    

}
