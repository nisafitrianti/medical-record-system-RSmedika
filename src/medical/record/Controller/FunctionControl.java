/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import medical.record.Model.Dokter;
import medical.record.View.ViewDokter;

/**
 *
 * @author Acer
 */
public class FunctionControl {
    
    DefaultTableModel modelDokter, modelPasien, modelRekamMedis, modelPoliklinik;
    ArrayList<Dokter> listDokter;
    Dokter dokter;
    Connection conn;
    
    public FunctionControl() {
        modelDokter = new DefaultTableModel();
        modelPasien = new DefaultTableModel();
        modelRekamMedis = new DefaultTableModel();
        conn = Conf.databaseConnected();
    }
    
    public DefaultTableModel getModelDokter() {
        return modelDokter;
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
    
    public void setTableRekamMedis(){}
    
    public void setTablePoliklinik(){
        modelPasien.addColumn("Kode Poli");
        modelPasien.addColumn("Nama Poliklinik");
    }
    
    public void readDokter(){
        modelDokter.setRowCount(0);
        for(Dokter value : listDokter){
            modelDokter.addRow(
                    new Object[]{
                        value.getId_dokter(), 
                        value.getNamaDokter(),
                        value.getId_Spesialisasi(),
                        value.getId_poliklinik(),
                        value.getTglMulaiKerja(),
                        value.getNoTelpDokter()
                    }
            );
        }
    }
    
    public void loadDokter(){
        if(conn != null){
            try{
                String query = "SELECT * FROM dokter";
                listDokter = new ArrayList<>();
                PreparedStatement preparedStatement =  conn.prepareStatement(query);
                ResultSet neSet = preparedStatement.executeQuery();
                while(neSet.next()){
                    int idDokter = neSet.getInt("id_dokter");
                    String nama = neSet.getString("nama_dokter");
                    String gender = neSet.getString("gender_dokter");
                    String tglLahir = neSet.getString("tgl_lahir");
                    String tglMulaiKerja = neSet.getString("tgl_mulai_kerja");
                    String noTelp = neSet.getString("no_telepon");
                    String alamat = neSet.getString("alamat");
                    int kdPoli = neSet.getInt("kode_poliklinik");
                    int kdSpesialis = neSet.getInt("kode_spesialisasi");
                    
                    Dokter dokter = new Dokter(
                            idDokter, 
                            kdSpesialis, 
                            kdPoli, 
                            nama, 
                            gender, 
                            tglLahir, 
                            noTelp, 
                            alamat, 
                            tglMulaiKerja
                    );
                    listDokter.add(dokter);
                }
                listDokter.size();
                neSet.close();
                preparedStatement.close();
            }catch(SQLException ex){
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,ex);     
            }
        }else{
            System.out.println("Disconnected");
        }
    }
    
      public void insertDokter(String nip, String nama, String spesialis, String poliklinik, String tglL, String gender,String tgl){
        if(conn != null){
            try{
                String sql = "INSERT INTO dokter(id_dokter, nama_dokter, jns_kelamin, tgl_lahir,tgl_mulai_bekerja, kode_poliklinik, kode_spesialisasi) VALUES"
                        + "(?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nip);
                ps.setString(2, nama);
                ps.setString(3, gender);
                ps.setString(4, tglL);
                ps.setString(5, tgl);
                ps.setString(6, poliklinik);
                ps.setString(7, spesialis);
                
                
            }catch(SQLException e){
                Logger.getLogger(ViewDokter.class.getName()).log(Level.SEVERE,null,e); 
            }
        }
        
    }
}
