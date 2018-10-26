/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.service.impl;
import ablf.entity.lapangan;
import ablf.error.lapanganException;
import ablf.service.lapanganDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Penghuni Warnet
 */
public class lapanganDaoImpl implements lapanganDao{
    private Connection connection;
    
    private final String insertBuku = "INSERT INTO buku"
            + "(kode_buku, judul_buku, pengarang, penerbit, tgl_entry_perpus, jml_buku, jml_diperpus, jml_dipinjam, statistik)"
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    
    private final String updateBuku = "UPDATE buku SET judul_buku=?, pengarang=?, penerbit=?, jml_buku=?, jml_diperpus=?, jml_dipinjam=? WHERE kode_buku=?";
    
    private final String updatePinjamBuku = "UPDATE buku SET jml_diperpus=jml_diperpus-1, jml_dipinjam=jml_dipinjam+1, statistik=statistik+1 WHERE kode_buku=?";
    
    private final String updatePengembalianBuku = "UPDATE buku SET jml_diperpus=jml_diperpus+1, jml_dipinjam=jml_dipinjam-1 WHERE kode_buku=?";
    
    private final String deleteBuku = "DELETE FROM buku WHERE kode_buku=?";
    
    private final String top10Buku = "SELECT judul_buku, statistik FROM buku ORDER BY statistik DESC limit 10";
    
    private final String top10BukuBaru = "SELECT judul_buku FROM buku ORDER BY tgl_entry_perpus DESC limit 10";
    
    private final String getById = "SELECT * FROM buku WHERE kode_buku=?";
    
    private final String selectAll = "SELECT * FROM buku";
    
    public lapanganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertBuku(lapangan buku) throws lapanganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertBuku);
            statement.setString(1, buku.getKode_lapangan());
            statement.setString(2, buku.getJenis_lapangan());

            statement.setDate(5, new Date(buku.getTgl_entry_booking().getTime()));
            statement.setInt(6, buku.getJml_durasi());
            statement.setInt(9, buku.getStatistik());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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

    @Override
    public void updateBuku(lapangan buku) throws lapanganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateBuku);
            statement.setString(1, buku.getKode_lapangan());
            statement.setString(2, buku.getJenis_lapangan());
            statement.setDate(3, new Date(buku.getTgl_entry_booking().getTime()));
            statement.setInt(4, buku.getJml_durasi());
            statement.setInt(5, buku.getStatistik());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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
    
    @Override
    public void updatePinjamBuku(String kode_buku) throws lapanganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePinjamBuku);
            statement.setString(1, kode_buku);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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

    @Override
    public void updatePengembalian(String kode_buku) throws lapanganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengembalianBuku);
            statement.setString(1, kode_buku);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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
    
    @Override
    public void deleteBuku(String kode_buku) throws lapanganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteBuku);
            statement.setString(1, kode_buku);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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

    @Override
    public lapangan getBuku(String kode_buku) throws lapanganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, kode_buku);
            
            ResultSet result = statement.executeQuery();
            lapangan buku = null;
            if (result.next()) {
                buku = new lapangan();
                buku.setJenis_lapangan(result.getString("jenis_lapangan"));
                buku.setTgl_entry_booking(result.getDate("tgl_entry_booking"));
                buku.setJml_buku(result.getInt("jml_durasi"));
                buku.setStatistik(result.getInt("statistik"));
                } else {
                throw new lapanganException("Data Buku Tidak Ada!!!");
            }
            connection.commit();
            return buku;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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

    
    public List<lapangan> top10Buku() throws lapanganException {
        Statement statement = null;
        List<lapangan> list = new ArrayList<lapangan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(top10Buku);
            
            while(result.next()){
                lapangan buku = new lapangan();
                buku.setJenis_lapangan(result.getString("judul_buku"));
                buku.setStatistik(result.getInt("statistik"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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
    
    @Override
    public List<lapangan> top10BukuBaru() throws lapanganException {
        Statement statement = null;
        List<lapangan> list = new ArrayList<lapangan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(top10BukuBaru);
            
            while(result.next()){
                lapangan buku = new lapangan();
                buku.setJenis_lapangan(result.getString("judul_buku"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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
    
    @Override
    public List<lapangan> selectAllBuku() throws lapanganException {
        Statement statement = null;
        List<lapangan> list = new ArrayList<lapangan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                lapangan buku = new lapangan();
                buku.setJenis_lapangan(result.getString("jenis_lapangan"));
                buku.setTgl_entry_booking(result.getDate("tgl_entry_booking"));
                buku.setJml_buku(result.getInt("jml_durasi"));
                buku.setStatistik(result.getInt("statistik"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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

    public List<lapangan> top10BukuFavorit() throws lapanganException {
        Statement statement = null;
        List<lapangan> list = new ArrayList<lapangan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(top10Buku);
            
            while(result.next()){
                lapangan buku = new lapangan();
                buku.setJenis_lapangan(result.getString("jenis_lapangan"));
                buku.setStatistik(result.getInt("statistik"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new lapanganException(exception.getMessage());
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
        } //To change body of generated methods, choose Tools | Templates.
    }
}
