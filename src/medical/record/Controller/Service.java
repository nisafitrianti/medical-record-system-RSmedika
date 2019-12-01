/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.Controller;

import com.sun.corba.se.impl.oa.poa.Policies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import medical.record.Model.Dokter;
import medical.record.Model.Karyawan;
import medical.record.Model.Pasien;
import medical.record.Model.Penyakit;
import medical.record.Model.Poliklinik;
import medical.record.Model.Spesialisasi;
import medical.record.View.ViewDokter;
import medical.record.View.ViewRekamMedis;

/**
 *
 * @author Acer
 */
public class Service {

    Connection conn;    
    DefaultTableModel modelDokter, modelPasien, modelRekamMedis, modelPoliklinik, modelKaryawan;
    PreparedStatement preparedStatement;
    ResultSet neSet;
    
    Dokter dokter;
    ArrayList<Dokter> listDokter;
    
    Pasien pasien;
    ArrayList<Pasien> listPasien;
    
    Karyawan karyawan;
    ArrayList<Karyawan> listKaryawan;
    
    Penyakit penyakit;
    ArrayList<Penyakit> listPenyakit;
    
    Poliklinik poliklinik;
    ArrayList<Poliklinik> listPoliklinik;
    
    Spesialisasi spesialis;
    ArrayList<Spesialisasi> listSpesialisasi;
    

    public Service(Connection conn) {
        this.conn = conn;
        modelDokter = new DefaultTableModel();
        modelPasien = new DefaultTableModel();
        modelPoliklinik = new DefaultTableModel();
        modelRekamMedis = new DefaultTableModel();
        modelKaryawan = new DefaultTableModel();
    }
    
    public Service() {
        modelDokter = new DefaultTableModel();
        modelPasien = new DefaultTableModel();
        modelPoliklinik = new DefaultTableModel();
        modelRekamMedis = new DefaultTableModel();
        modelKaryawan = new DefaultTableModel();
        conn = Conf.databaseConnected();
    }
    
    public DefaultTableModel getModelDokter() {
        return modelDokter;
    }
    
    public DefaultTableModel getModelPasien() {
        return modelPasien;
    }
    
    public DefaultTableModel getModelPoliklinik() {
        return modelPoliklinik;
    }
    
    public DefaultTableModel getModelRM() {
        return modelRekamMedis;
    }
    
    public DefaultTableModel getModelKaryawan(){
        return modelKaryawan;
    }
    
    public ArrayList<Pasien> sien(){
        return listPasien;
    }
    
    public ArrayList<Dokter> ter(){
        return listDokter;
    }
    
    public void setTableDokter(){
        modelDokter.addColumn("NIP");
        modelDokter.addColumn("Nama");
        modelDokter.addColumn("Spesialis");
        modelDokter.addColumn("Poliklinik");
        modelDokter.addColumn("Tanggal Mulai Kerja");
        modelDokter.addColumn("No Telepon");
    }
    
    public void setTablePasien(){
        modelPasien.addColumn("ID");
        modelPasien.addColumn("Nama");
        modelPasien.addColumn("Tanggal Lahir");
        modelPasien.addColumn("Telepon");
        modelPasien.addColumn("Pekerjaan");
        modelPasien.addColumn("Alamat");
    }
    
    public void setTablePoliklinik(){
        modelPoliklinik.addColumn("Kode Poliklinik");
        modelPoliklinik.addColumn("Nama Poliklinik");
        modelPoliklinik.addColumn("Spesialis");
        modelPoliklinik.addColumn("Penyakit");
    }
    
    public void readDokter(){
        modelDokter.setRowCount(0);
        for(Dokter value : listDokter){
            modelDokter.addRow(
                    new Object[]{
                        value.getId_dokter(), 
                        value.getNamaDokter(),
                        value.getNamaSpesialisasi(),
                        value.getNamaPoliklinik(),
                        value.getTglMulaiKerja(),
                        value.getNoTelpDokter()
                    }
            );
        }
    }
    
    public void readPasien(){
        modelPasien.setRowCount(0);
        for (Pasien va: listPasien) {
            modelPasien.addRow(
                  new Object[]{
                      va.getId_pasien(),
                      va.getNamaPasien(),
                      va.getTglLahirPasien(),
                      va.getNoTelpPasien(),
                      va.getPekerjaanPasien(),
                      va.getAlamatPasien()     
                  }
            );
        }
    }
    
    public void readKaryawan(){
        modelKaryawan.setRowCount(0);
        for (Karyawan uwu : listKaryawan) {
            modelKaryawan.addRow(
                    new Object[]{
                        uwu.getId_karyawan(),
                        uwu.getNamaKaryawan(),
                        uwu.getGenderKAryawan(),
                        uwu.getTglLahir(),
                        uwu.getTglMulaiKerja(),
                        uwu.getStatus(),
                    }
            );
        }
    }
    
    public void readPoliklinik(){
        modelPoliklinik.setRowCount(0);
        for (Poliklinik po : listPoliklinik) {
            modelPoliklinik.addRow(
                    new Object[]{
                        po.getKode_penyakit(),
                        po.getNamaPoliklinik(),
                        po.getNamaSpesialisasi(),
                        po.getNamaPenyakit()
                    }
            );
        }
        System.out.println(modelPoliklinik);
    }
    
    public void readRekamMedis(){}
    
    public void loadDokter(){
        if(conn != null){
            try{
                String query = "SELECT * FROM dokter "
                        + "JOIN poliklinik ON dokter.kode_poliklinik = poliklinik.kode_poliklinik "
                        + "JOIN spesialisasi ON poliklinik.kode_spesialisasi = spesialisasi.kode_spesialisasi "
                        + "ORDER BY dokter.id_dokter";
                listDokter = new ArrayList<>();
                preparedStatement =  conn.prepareStatement(query);
                neSet = preparedStatement.executeQuery();
                while(neSet.next()){
                    int idDokter = neSet.getInt("id_dokter");
                    String nama = neSet.getString("nama_dokter");
                    String gender = neSet.getString("gender_dokter");
                    String tglLahir = neSet.getString("tgl_lahir");
                    String tglMulaiKerja = neSet.getString("tgl_mulai_kerja");
                    String noTelp = neSet.getString("no_telepon");
                    String alamat = neSet.getString("alamat");
                    String kdPoli = neSet.getString("nama_poliklinik");
                    String kdSpesialis = neSet.getString("nama_spesialisasi");
                    
                    dokter = new Dokter(
                            idDokter, 
                            nama, 
                            gender, 
                            tglLahir,
                            tglMulaiKerja,
                            noTelp, 
                            alamat, 
                            kdPoli,                            
                            kdSpesialis
                    );
                    listDokter.add(dokter);
                }
                neSet.close();
                preparedStatement.close();
            }catch(SQLException ex){
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,ex);     
            }
        }else{
            System.out.println("Disconnected");
        }
    }
    
    public void loadPasien(){
        if(conn != null){
            try {
                String query = "SELECT * FROM pasien";
                listPasien = new ArrayList<>();
                preparedStatement =  conn.prepareStatement(query);
                neSet = preparedStatement.executeQuery();
                while(neSet.next()){
                    int idPasien = neSet.getInt("id_pasien");
                    String namaPasien = neSet.getString("nama_pasien");
                    String tglLahir = neSet.getString("tgl_lahir");
                    int umur = neSet.getInt("umur");
                    String noTelp = neSet.getString("telepon");
                    String gender = neSet.getString("jns_kelamin");
                    String pekerjaan = neSet.getString("pekerjaan");
                    String alamat = neSet.getString("alamat");
                    
                    pasien = new Pasien(
                            idPasien, 
                            namaPasien, 
                            gender, 
                            tglLahir, 
                            noTelp, 
                            alamat, 
                            pekerjaan, 
                            umur);
                    listPasien.add(pasien);
                }
                neSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,e);     
            }
        }else{
            System.out.println("Disconnected");
        }
    }
    
    public void loadPoliklinik(){
        if(conn != null){
            try {
                String query = "SELECT * FROM poliklinik "
                        + "JOIN spesialisasi ON poliklinik.kode_spesialisasi = spesialisasi.kode_spesialisasi "
                        + "JOIN penyakit ON spesialisasi.kode_penyakit = penyakit.kode_penyakit "
                        + "ORDER BY poliklinik.kode_poliklinik";
                listPoliklinik = new ArrayList<>();
                preparedStatement =  conn.prepareStatement(query);
                neSet = preparedStatement.executeQuery();

                while(neSet.next()){
                    int kdPenyakit = neSet.getInt("kode_penyakit");
                    int kdSpesialisasi = neSet.getInt("kode_spesialisasi");
                    int KdPoli = neSet.getInt("kode_poliklinik");
                    String namaPenyakit = neSet.getString("nama_penyakit");
                    String namaSpesialisasi = neSet.getString("nama_spesialisasi");
                    String namaPoli = neSet.getString("nama_poliklinik");
                    
                    poliklinik = new Poliklinik(
                            KdPoli,
                            namaPoli,
                            kdSpesialisasi,
                            namaSpesialisasi,
                            kdPenyakit,
                            namaPenyakit);
                    
                    listPoliklinik.add(poliklinik);
                }
                neSet.close();
                preparedStatement.close();
            } catch (Exception e) {
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,e);     
            }
        }else{
            System.out.println("Disconnected");
        }
    }
    
    public void loadKaryawan(){
        if(conn != null){
            try{
                String query = "SELECT * FROM karyawan";
                listKaryawan = new ArrayList<>();
                preparedStatement =  conn.prepareStatement(query);
                neSet = preparedStatement.executeQuery();
                
                while(neSet.next()){
                    int NIP = neSet.getInt("id_karyawan");
                    String nama = neSet.getString("nama_karyawan");
                    String gender = neSet.getString("jns_kelamin");
                    String lahir = neSet.getString("tgl_lahir");
                    String mulaiKerja = neSet.getString("tgl_mulai_bekerja");
                    int status = neSet.getInt("status");
                    
                    karyawan = new Karyawan(
                            NIP, 
                            nama, 
                            gender, 
                            lahir, 
                            mulaiKerja,
                            status);
                    
                    listKaryawan.add(karyawan);
                }
                neSet.close();
                preparedStatement.close();
            }catch (Exception e) {
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,e);     
            }        
        }else{
            System.out.println("Disconnected");
        }
    }
    
    public void loadRekamMedis(){
    
    }
    
    public void CariDokter(int keyword){
        modelDokter.setRowCount(0);
        loadDokter();
        for (Dokter value : listDokter) {
            if(value.getId_dokter() == keyword){
                readDokter();
            }
        }
    }
    
    public void cariPasien(int keyword){
        modelPasien.setRowCount(0);
        loadPasien();
        for (Pasien val : listPasien) {
            if(val.getId_pasien() == keyword){
                readPasien();
            }
        }
    }
    
    public void cariPoliklinik(){
        
    }
    
      public void addDokter(
              String nama,
              String gender,
              String tglLahir,
              String MulaiKerja,
              String telepon,
              String alamat,
              String pass,
              int kdPoli,
              int kdSpesialisasi
              ){
        if(conn != null){
            String query = "INSERT INTO dokter(nama_dokter,"
                    + "gender_dokter, tgl_lahir, tgl_mulai_kerja,"
                    + "no_telp, alamat, kode_poliklinik, kode_spesialisasi, "
                    + "password_dokter) VALUE(?,?,?,?,?,?,?,?,?)";
            
            try{
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, nama);
                preparedStatement.setString(2, gender);
                preparedStatement.setString(3, tglLahir);
                preparedStatement.setString(4, MulaiKerja);
                preparedStatement.setString(5, telepon);
                preparedStatement.setString(6, alamat);
                preparedStatement.setInt(7, kdPoli);
                preparedStatement.setInt(8, kdSpesialisasi);
                preparedStatement.setString(9, pass);
                
                System.out.println(preparedStatement);
                  preparedStatement.executeUpdate();
                  System.out.println("berhasil oiy");
            }catch(SQLException e){
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,e); 
            }
        }
        
    }
      
      public void addRekamMedik(
              // masih ngeBUG
              Connection conn,
              int idPasien,  
              int idDokter, 
              int kdSpesialisasi, 
              int kdPoliklinik, 
              int kdPenyakit, 
              String jenisRM, 
              String ruangPerawatan, 
              String tglMasuk,
              String tglKeluar,
              String Pemeriksaan,
              String Tindakan,
              String Pengobatan){
          if(conn != null){
              try{
              String query = "INSERT INTO medical_record(jenis_rekam_medis,id_pasien, id_dokter, \n" +
"                           kode_spesialisasi, kode_poliklinik, kode_penyakit, \n" +
"                           ruang_perawatan, tgl_masuk, tgl_keluar, pemeriksaan, \n" +
"                           tindakan, pengobatan) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
             preparedStatement = conn.prepareStatement(query);
             
             preparedStatement.setString(1, jenisRM);
             preparedStatement.setInt(2, idPasien);
             preparedStatement.setInt(3, idDokter);
             preparedStatement.setInt(4, kdSpesialisasi);
             preparedStatement.setInt(5, kdPoliklinik);
             preparedStatement.setInt(6, kdPenyakit);
             preparedStatement.setString(7, ruangPerawatan);
             preparedStatement.setString(8, tglMasuk);
             preparedStatement.setString(9, tglKeluar);
             preparedStatement.setString(10, Pemeriksaan);
             preparedStatement.setString(11, Tindakan);
             preparedStatement.setString(12, Pengobatan);
                  System.out.println(preparedStatement);
                  preparedStatement.executeUpdate();
                  System.out.println("berhasil oiy");
            }catch(SQLException e){
                Logger.getLogger(ViewRekamMedis.class.getName()).log(Level.SEVERE,null,e);
            }
              
          }else{
              System.out.println("Database not connected");
          }
      
      }
      
      public void addKaryawan(
              String nama,
              String gender,
              String tglLahir,
              String mulaiKerja,
              String pass,
              int status
      ){
          if(conn != null){
              try {
                  String query = "INSERT INTO karyawan(nama_karyawan, jns_kelamin, tgl_lahir, tgl_mulai_bekerja,"
                          + "status, password_karyawan) VALUES(?,?,?,?,?,?)";
                  preparedStatement = conn.prepareStatement(query);
                  
                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, gender);
                    preparedStatement.setString(3, tglLahir);
                    preparedStatement.setString(4, mulaiKerja);
                    preparedStatement.setInt(5, status);
                    preparedStatement.setString(6, pass);
                  System.out.println(preparedStatement);
                  preparedStatement.executeUpdate();
                  
                  
              } catch (Exception e) {
                Logger.getLogger(ViewRekamMedis.class.getName()).log(Level.SEVERE,null,e);                  
              }
          }else{
              System.out.println("Database not connected");
          }
      }
      
      public void addPasien(
              String nama,
              String gender,
              String tglLahir,
              String telp,
              String pekerjaan,
              String alamat,
              int umur
      ){
         if(conn != null){
              try {
                  String query = "INSERT INTO pasien(nama_pasien, tgl_lahir, umur, telepon,"
                          + "jns_kelamin, pekerjaan, alamat) VALUES(?,?,?,?,?,?,?)";
                  preparedStatement = conn.prepareStatement(query);
                  
                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, tglLahir);
                    preparedStatement.setInt(3, umur);
                    preparedStatement.setString(4, telp);
                    preparedStatement.setString(5, gender);
                    preparedStatement.setString(6, pekerjaan);
                    preparedStatement.setString(7, alamat);
                  System.out.println(preparedStatement);
                  preparedStatement.executeUpdate();
                  
                  
              } catch (Exception e) {
                Logger.getLogger(ViewRekamMedis.class.getName()).log(Level.SEVERE,null,e);                  
              }
          }else{
              System.out.println("Database not connected");
          } 
      }
      
}
