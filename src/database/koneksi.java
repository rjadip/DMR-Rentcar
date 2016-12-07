/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Driver;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Vector;

public class koneksi {
    private static Connection konek;
    public static String KPinjam = "";
        
    public koneksi()throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        
        konek=DriverManager.getConnection("jdbc:mysql://localhost:3306/uasjava","root","");
        
    }
    
    public boolean isConnected() {
        return (konek != null);
    }
    
    // MOBIL
    public void insertDataMobil(String Plat_No, String Mrk_Mobil, String Tipe_Mobil, String Wrn_Mobil,
            int Thn_Mobil, String K_Mobil, int H_Sewa, int B_Denda, int S_Mobil) throws SQLException{
        String query = "INSERT INTO datamobil (plat_no, merek_mobil, tipe_mobil, wrn_mobil, thn_mobil, k_mobil," 
                + "h_sewa, b_denda, s_mobil) VALUES (?,?,?,?,?,?,?,?,?)";        
        PreparedStatement stmt = konek.prepareStatement(query);
        
        stmt.setString(1, Plat_No);
        stmt.setString(2, Mrk_Mobil);
        stmt.setString(3, Tipe_Mobil);
        stmt.setString(4, Wrn_Mobil);
        stmt.setInt(5, Thn_Mobil);
        stmt.setString(6, K_Mobil);
        stmt.setInt(7, H_Sewa);
        stmt.setInt(8, B_Denda);
        stmt.setInt(9, S_Mobil);
        stmt.execute();
        
        stmt.close();
    }
    
    public void updateDataMobil(String Plat_No, String Mrk_Mobil, String Tipe_Mobil, String Wrn_Mobil,
            int Thn_Mobil, String K_Mobil, int H_Sewa, int B_Denda, int S_Mobil, String tempPlat) throws SQLException{
        String query = "UPDATE datamobil SET plat_no = ?, merek_mobil = ?, tipe_mobil = ?, wrn_mobil = ?, thn_mobil = ?, k_mobil = ?," 
                + "h_sewa = ?, b_denda = ?, s_mobil = ? WHERE plat_no = ? ";
        PreparedStatement stmt = konek.prepareStatement(query);
        
        stmt.setString(1, Plat_No);
        stmt.setString(2, Mrk_Mobil);
        stmt.setString(3, Tipe_Mobil);
        stmt.setString(4, Wrn_Mobil);
        stmt.setInt(5, Thn_Mobil);
        stmt.setString(6, K_Mobil);
        stmt.setInt(7, H_Sewa);
        stmt.setInt(8, B_Denda);
        stmt.setInt(9, S_Mobil);
        stmt.setString(10, tempPlat);
        stmt.execute();
        
        stmt.close();
    }
    
    public Vector<Vector<Object>> selectDataMobil() throws SQLException{        
        String query = "SELECT plat_no, merek_mobil, tipe_mobil, wrn_mobil, thn_mobil, k_mobil," 
                + "h_sewa, b_denda FROM datamobil WHERE s_mobil = 0 ORDER BY merek_mobil ASC";
        PreparedStatement stmt = konek.prepareStatement(query);
        
        ResultSet rs = stmt.executeQuery();
        
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getInt(5));
            v.add(rs.getString(6));
            v.add(rs.getInt(7));
            v.add(rs.getInt(8));
            data.add(v);
        }
        return data;
    }
    
    
    // CUSTOMER
    public void insertDataCustomer(String nomor_identitas, String jenis_identitas, String nama_depan, String nama_belakang, 
            String tgl_lahir, String alamat,String nomor_handphone,  String email) throws SQLException{
        String query = "INSERT INTO customer (nomor_identitas, jenis_identitas, nama_depan, nama_belakang, tgl_lahir, alamat,"
                + " no_handphone, email) VALUES (?,?,?,?,?,?,?,?)";        
        PreparedStatement stmt = konek.prepareStatement(query);
        
        stmt.setString(1, nomor_identitas);
        stmt.setString(2, jenis_identitas);        
        stmt.setString(3, nama_depan);
        stmt.setString(4, nama_belakang);
        stmt.setString(5, tgl_lahir);
        stmt.setString(6, alamat);
        stmt.setString(7, nomor_handphone);
        stmt.setString(8, email);
        stmt.execute();
        
        stmt.close();
    }
    
    public void updateDataCustomer(String nomor_identitas, String jenis_identitas, String nama_depan, String nama_belakang, 
            String tgl_lahir, String alamat,String nomor_handphone,  String email) throws SQLException{
        String query = "UPDATE customer SET  nomor_identitas = ?, jenis_identitas = ?,nama_depan = ?, nama_belakang = ?, "
                + "tgl_lahir = ?, alamat = ?, nomor_handphone = ?, email = ? WHERE nomor_identitas = ? ";
        PreparedStatement stmt = konek.prepareStatement(query);
 
        stmt.setString(1, nomor_identitas);
        stmt.setString(2, jenis_identitas);        
        stmt.setString(3, nama_depan);
        stmt.setString(4, nama_belakang);
        stmt.setString(5, tgl_lahir);
        stmt.setString(6, alamat);
        stmt.setString(7, nomor_handphone);
        stmt.setString(8, email);
        stmt.setString(9, nomor_identitas);
        stmt.execute();
        
        stmt.close();
    }    

    public Vector<Vector<Object>> selectDataCustomer() throws SQLException{        
        String query = "SELECT nomor_identitas, jenis_identitas, nama_depan, nama_belakang, tgl_lahir, alamat," 
                + "nomor_handphone, email FROM customer ORDER BY nama_depan ASC";
        PreparedStatement stmt = konek.prepareStatement(query);
        
        ResultSet rs = stmt.executeQuery();
        
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getInt(5));
            v.add(rs.getString(6));
            v.add(rs.getInt(7));
            v.add(rs.getInt(8));
            data.add(v);
        }
        return data;
        }
    
    // Peminjaman
    public Vector<Vector<Object>> selectDataMobilPinjam(String tglPinjam, String tglSelesai) throws SQLException{        
        String query = "SELECT M.plat_no, M.merek_mobil, M.tipe_mobil, M.wrn_mobil, M.thn_mobil, M.k_mobil, M.h_sewa, M.b_denda "
                + "FROM datamobil AS M LEFT JOIN tblPeminjaman AS P ON M.plat_no = P.plat_no "
                + "WHERE ((P.tgl_pinjam NOT BETWEEN ? AND ?) AND (P.tgl_kembali NOT BETWEEN ? AND ?)) OR "
                + "((M.s_mobil = 0) AND (M.plat_no NOT IN " +
                                        "(SELECT        plat_no " +
                                            "FROM tblPeminjaman)))"
                + "GROUP BY M.plat_no, M.merek_mobil, M.tipe_mobil, M.wrn_mobil, M.h_sewa, M.b_denda, P.tgl_pinjam, P.tgl_kembali "
                + "HAVING        (COUNT(DISTINCT M.plat_no) >= 0) "
                + "ORDER BY M.merek_mobil ASC";
        PreparedStatement stmt = konek.prepareStatement(query);
        
        stmt.setString(1, tglPinjam);
        stmt.setString(2, tglSelesai);        
        stmt.setString(3, tglPinjam);
        stmt.setString(4, tglSelesai);
        
        ResultSet rs = stmt.executeQuery();
        
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getInt(5));
            v.add(rs.getString(6));
            v.add(rs.getInt(7));
            v.add(rs.getInt(8));
            data.add(v);
        }
        return data;
    }
    
    public void insertDataPinjam(String id, String plat, String kode, String tglpinjam, 
            String tglkembali, int total,int deposit) throws SQLException{
        String query = "INSERT INTO tblPeminjaman (id_pinjam, plat_no, kodeK, tgl_pinjam, tgl_kembali, total, deposit) "
                + "  VALUES (?,?,?,?,?,?,?)";        
        PreparedStatement stmt = konek.prepareStatement(query);
        
        stmt.setString(1, id);
        stmt.setString(2, plat);        
        stmt.setString(3, kode);
        stmt.setString(4, tglpinjam);
        stmt.setString(5, tglkembali);
        stmt.setInt(6, total);
        stmt.setInt(7, deposit);
        stmt.execute();
        
        stmt.close();
    }
    // tblPeminjaman
    public Vector<Object> kodePinjam() throws SQLException{
        
        String query = "SELECT RIGHT(id_pinjam,4) AS P FROM tblPeminjaman ORDER BY P DESC";        
        PreparedStatement stmt = konek.prepareStatement(query);
       
        ResultSet rs = stmt.executeQuery();
        
//        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<Object> v = new Vector<Object>();
        while (rs.next()) {
            
            v.add(rs.getString(1));
            KPinjam = rs.getString(1);
//            data.add(v);
        }
        return v;
    }

    public void insertDataPinjam(String text, String text0, String text1, Integer valueOf, Integer valueOf0, Integer valueOf1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertDataKembali(String text, String text0, String text1, Integer valueOf, Integer valueOf0, Integer valueOf1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<Vector<Object>> selectDataMobilPinjam(String sTglKembali) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
