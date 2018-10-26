/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.service.impl;
import ablf.entity.customer;
import ablf.error.customerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ablf.service.CustomerDao;
/**
 *
 * @author Penghuni Warnet
 */
public class customerDaoImpl implements CustomerDao {
    private final Connection connection;
    
    private final String insertAnggota = "INSERT INTO anggota"
            + "(id_anggota, nama_anggota, alamat, no_telp, email, tgl_daftar)"
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updateAnggota = "UPDATE anggota SET nama_anggota=?, alamat=?, no_telp=?, email=? WHERE id_anggota=?";
    
    private final String deleteAnggota = "DELETE FROM anggota WHERE id_anggota=?";
    
    private final String getById = "SELECT * FROM anggota WHERE id_anggota=?";
    
    private final String selectAll = "SELECT * FROM anggota";
    
    private final String selectCount = "SELECT COUNT(*) FROM anggota WHERE id_anggota = ?";

    public customerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insertAnggota(customer anggota) throws customerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertAnggota);
            statement.setString(1, anggota.getId_anggota());
            statement.setString(2, anggota.getNama_anggota());
            statement.setString(3, anggota.getAlamat());
            statement.setString(4, anggota.getNo_telp());
            statement.setString(5, anggota.getEmail());
            statement.setDate(6, new Date(anggota.getTgl_daftar().getTime()));
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new customerException(exception.getMessage());
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

    public void updateAnggota(customer anggota) throws customerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateAnggota);
            statement.setString(1, anggota.getNama_anggota());
            statement.setString(2, anggota.getAlamat());
            statement.setString(3, anggota.getNo_telp());
            statement.setString(4, anggota.getEmail());
            statement.setString(5, anggota.getId_anggota());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new customerException(exception.getMessage());
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

    public void deleteAnggota(String id_anggota) throws customerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteAnggota);
            statement.setString(1, id_anggota);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new customerException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public customer getAnggota(String id_anggota) throws customerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id_anggota);
            
            ResultSet result = statement.executeQuery();
            customer anggota = null;
            if (result.next()) {
                anggota = new customer();
                anggota.setNama_anggota(result.getString("nama_anggota"));
                anggota.setAlamat(result.getString("alamat"));
                anggota.setNo_telp(result.getString("no_telp"));
                anggota.setEmail(result.getString("email"));
            } else {
                throw new customerException("Data Anggota Tidak Ada!!!");
            }
            connection.commit();
            return anggota;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new customerException(exception.getMessage());
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
    
    public List<customer> selectAllAnggota() throws customerException {
        Statement statement = null;
        List<customer> list = new ArrayList<customer>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                customer anggota = new customer();
                anggota.setId_anggota(result.getString("id_anggota"));
                anggota.setNama_anggota(result.getString("nama_anggota"));
                anggota.setAlamat(result.getString("alamat"));
                anggota.setNo_telp(result.getString("no_telp"));
                anggota.setEmail(result.getString("email"));
                anggota.setTgl_daftar(result.getDate("tgl_daftar"));
                
                list.add(anggota);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new customerException(exception.getMessage());
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

    public int selectCount(customer anggota) throws customerException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectCount);
            statement.setString(1, anggota.getId_anggota());
            resultSet = statement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                rowCount = resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new customerException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
            } 
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        return rowCount;
    }
}