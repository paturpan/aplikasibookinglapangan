/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.service;
import ablf.entity.customer;
import ablf.error.customerException;
import java.util.List;
public interface CustomerDao {
public void insertAnggota(customer anggota) throws customerException;
public void updateAnggota(customer anggota) throws customerException;
public void deleteAnggota(String id_anggota) throws customerException;
public customer getAnggota(String id_anggota) throws customerException;
public int selectCount(customer anggota) throws customerException;
public List<customer> selectAllAnggota() throws customerException;
}