/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.service.impl;
import ablf.entity.booking;
import ablf.error.bookingException;
import ablf.service.bookingDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Penghuni Warnet
 */
public class bookingDaoImpl implements bookingDao{
   private Connection connection;
    
    private final String insertPeminjaman = "INSERT INTO peminjaman"
            + "(id_anggota, kode_buku, tgl_pinjam, tgl_batas_kembali, denda)"
            + "VALUES (?,?,?,?,?)";
    
    private final String updatePeminjaman = "UPDATE peminjaman SET id_anggota=?, kode_buku=?, tgl_kembali=?, denda=? WHERE id_pinjam=?";
    
    private final String updatePengembalian = "UPDATE peminjaman SET tgl_kembali=?, denda=? WHERE id_pinjam=?";
    
    private final String deletePeminjaman = "DELETE FROM peminjaman WHERE id_pinjam=?";
    
    private final String getById_anggota = "SELECT * FROM peminjaman WHERE id_anggota=? AND tgl_kembali IS NULL";
    
    private final String chartPeminjaman = "SELECT date(tgl_pinjam) AS tgl_pinjam, COUNT(id_pinjam) AS transaksi, SUM(denda) AS denda FROM peminjaman GROUP BY date(tgl_pinjam) LIMIT 30";
    
    private final String selectAll = "SELECT * FROM peminjaman";
    
    public bookingDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    public void insertPeminjaman(booking peminjaman) throws bookingException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPeminjaman);
            statement.setString(1, peminjaman.getId_anggota());
            statement.setString(2, peminjaman.getKode_lapangan());
            statement.setDate(3, new Date(peminjaman.getJam_mulai().getTime()));
            statement.setDate(4, new Date(peminjaman.getJam_selesai().getTime()));
            statement.setInt(5, peminjaman.getBiaya());
            
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new bookingException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public void updatePeminjaman(booking peminjaman) throws bookingException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePeminjaman);
            statement.setString(1, peminjaman.getId_anggota());
            statement.setString(2, peminjaman.getKode_lapangan());
            statement.setDate(3, new Date(peminjaman.getJam_mulai().getTime()));
            statement.setInt(4, peminjaman.getBiaya());
            statement.setInt(5, peminjaman.getId_booking());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new bookingException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public void updatePengembalian(booking peminjaman) throws bookingException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengembalian);
            statement.setDate(1, new Date(peminjaman.getJam_mulai().getTime()));
            statement.setInt(2, peminjaman.getBiaya());
            statement.setInt(3, peminjaman.getId_booking());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new bookingException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    public void deletePeminjaman(int id_pinjam) throws bookingException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePeminjaman);
            statement.setInt(1, id_pinjam);
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new bookingException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public List<booking> getPeminjaman(String id_anggota) throws bookingException {
        PreparedStatement statement = null;
        List<booking> list = new ArrayList<booking>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById_anggota);
            statement.setString(1, id_anggota);
            
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                booking peminjaman = new booking();
                peminjaman.setId_booking(result.getInt("id_booking"));
                peminjaman.setId_anggota(result.getString("id_anggota"));
                peminjaman.setKode_buku(result.getString("kode_buku"));
                peminjaman.setJam_mulai(result.getDate("jam_mulai"));
               
                peminjaman.setJam_selesai(result.getDate("jam_selesai"));
                peminjaman.setBiaya(result.getInt("biaya"));
                list.add(peminjaman);
            }
            connection.commit();
            return list;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new bookingException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public List<booking> selectAllPeminjaman() throws bookingException {
        Statement statement = null;
        List<booking> list = new ArrayList<booking>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                booking peminjaman = new booking();
                peminjaman.setId_booking(result.getInt("id_booking"));
                peminjaman.setId_anggota(result.getString("id_anggota"));
                peminjaman.setKode_buku(result.getString("kode_buku"));
                peminjaman.setJam_mulai(result.getDate("tgl_pinjam"));
                
                peminjaman.setJam_selesai(result.getDate("jam_selesai"));
                peminjaman.setBiaya(result.getInt("biaya"));
                list.add(peminjaman);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new bookingException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

       
}
