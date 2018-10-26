/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.service;

import ablf.entity.lapangan;
import ablf.error.lapanganException;
import java.util.List;
/**
 *
 * @author 
 */
public interface lapanganDao {
    public void insertBuku(lapangan buku) throws lapanganException;
    public void updateBuku(lapangan buku) throws lapanganException;
    
    public void updatePinjamBuku(String kode_buku) throws lapanganException;
    
    public void updatePengembalian(String kode_buku) throws lapanganException;

    public void deleteBuku(String kode_buku) throws lapanganException;
    
    public lapangan getBuku(String kode_buku) throws lapanganException;
    
    public List<lapangan> top10BukuFavorit() throws lapanganException;
    
    public List<lapangan> top10BukuBaru() throws lapanganException;
    
    public List<lapangan> selectAllBuku() throws lapanganException;
}
