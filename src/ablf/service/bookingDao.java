/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.service;
import ablf.entity.lapangan;
import ablf.entity.booking;
import ablf.error.bookingException;
import java.util.List;
public interface bookingDao {
public void insertPeminjaman(booking booking) throws
bookingException;
public void updatePeminjaman(booking booking) throws
bookingException;
public void updatePengembalian(booking booking) throws
bookingException;
public void deletePeminjaman(int id_booking) throws bookingException;
public List<booking> getPeminjaman(String id_member) throws
bookingException;
}