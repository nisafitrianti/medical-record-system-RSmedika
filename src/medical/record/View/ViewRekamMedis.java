/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import medical.record.Controller.Auth;
import medical.record.Controller.Conf;
import medical.record.Controller.Service;
import medical.record.Model.Karyawan;
import medical.record.Model.Spesialisasi;

/**
 *
 * @author Acer
 */
public final class ViewRekamMedis extends javax.swing.JFrame {

    /**
     * Creates new form ViewRekamMedis
     */
    Connection conn;
    Service function;
    Auth auth = new Auth();
    Conf conf = new Conf();
    PreparedStatement sst;
    int id;
    String nama;
    
    public ViewRekamMedis() {
        initComponents();
        this.setLocationRelativeTo(null);
        function = new Service(conn);
        conn = Conf.databaseConnected();
        auth = new Auth();
        function = new Service(conn);

    }

    public ViewRekamMedis(String session, int username) {
        initComponents();
        this.setLocationRelativeTo(null);
        id = username;
        nama = session;  
        function = new Service(conn);
        conn = Conf.databaseConnected();
        auth = new Auth();
        loadPasienCB();
        loadDokterCB();
        loadSpesialisCB();
        loadPenyakitCB();
        loadPoliklinikCB();
    }
    
    public void loadPasienCB(){
        try {
            String query = "SELECT * FROM pasien";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet neSet = ps.executeQuery();
            while(neSet.next()){
                Object[] obj = new Object[2];
                obj[0] = neSet.getString(1);
                obj[1] = neSet.getString(2);
                cbIdPasien.addItem((String) obj[0] +" - "+ (String) obj[1]);
            }
            
            neSet.close(); 
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDokterCB(){
        try {
            String query = "SELECT * FROM dokter";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet neSet = ps.executeQuery();
            while(neSet.next()){
                Object[] obj = new Object[2];
                obj[0] = neSet.getString(1);
                obj[1] = neSet.getString(2);
                cbIdDokter.addItem((String) obj[0] +" - "+ (String) obj[1]);
            }
            
            neSet.close(); 
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void loadSpesialisCB(){
        try {
            String query = "SELECT * FROM spesialisasi";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet neSet = ps.executeQuery();
            while(neSet.next()){
                Object[] obj = new Object[2];
                obj[0] = neSet.getString(1);
                obj[1] = neSet.getString(2);
                cbKdSpesialis1.addItem((String) obj[0] +" - "+ (String) obj[1]);
            }
            
            neSet.close(); 
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
     
     public void loadPenyakitCB(){
        try {
            String query = "SELECT * FROM penyakit";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet neSet = ps.executeQuery();
            
            while(neSet.next()){
                Object[] obj = new Object[2];
                obj[0] = neSet.getString(1);
                obj[1] = neSet.getString(2);
                cbKdPenyakit.addItem((String) obj[0] +" - "+ (String) obj[1]);
            }
            neSet.close(); 
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
     
     public void loadPoliklinikCB(){
        try {
            String query = "SELECT * FROM poliklinik";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet neSet = ps.executeQuery();
            while(neSet.next()){
                Object[] obj = new Object[2];
                obj[0] = neSet.getString(1);
                obj[1] = neSet.getString(2);
                cbKdPoliklinik.addItem((String) obj[0] +" - "+ (String) obj[1]);
            }
            
            neSet.close(); 
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbKdPoliklinik = new javax.swing.JComboBox<>();
        tfRuangRawat = new javax.swing.JTextField();
        tfPemeriksa = new javax.swing.JTextField();
        tfTindakan = new javax.swing.JTextField();
        tfPengobatan = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbRekamMedis1 = new javax.swing.JComboBox<>();
        cbIdDokter = new javax.swing.JComboBox<>();
        cbKdPenyakit = new javax.swing.JComboBox<>();
        dcTglKeluar = new com.toedter.calendar.JDateChooser();
        dcTglMasuk = new com.toedter.calendar.JDateChooser();
        cbKdSpesialis1 = new javax.swing.JComboBox<>();
        cbIdPasien = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1440, 1024));
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setMinimumSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(42, 147, 151));
        jPanel2.setToolTipText("SistemRekam Medis");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/record/assets/rekam-medik-asset/arrow-back.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rekam Medis");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 20, 547, 112);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/record/assets/rekam-medik-asset/Group 27.png"))); // NOI18N
        jLabel3.setToolTipText("SistemRekam Medis");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1010, 20, 370, 110);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Jenis Rekam Medis : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 200, 187, 24);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID Dokter Pemerikasa : ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(290, 300, 162, 19);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Kode Spesialisasi : ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(320, 340, 136, 19);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ruang Perawatan : ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(320, 470, 134, 19);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Kode Poliklinik : ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(340, 430, 116, 19);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Pemeriksaan : ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(350, 620, 102, 19);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tanggal Masuk : ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(340, 510, 117, 19);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Tanggal Keluar : ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(340, 560, 117, 19);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Pengobatan : ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(360, 790, 96, 19);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tindakan : ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(380, 700, 75, 19);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("ID pasien : ");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(380, 260, 77, 19);

        cbKdPoliklinik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKdPoliklinikActionPerformed(evt);
            }
        });
        jPanel1.add(cbKdPoliklinik);
        cbKdPoliklinik.setBounds(470, 430, 190, 26);
        jPanel1.add(tfRuangRawat);
        tfRuangRawat.setBounds(470, 470, 277, 24);

        tfPemeriksa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPemeriksaActionPerformed(evt);
            }
        });
        jPanel1.add(tfPemeriksa);
        tfPemeriksa.setBounds(470, 600, 670, 62);
        jPanel1.add(tfTindakan);
        tfTindakan.setBounds(470, 680, 670, 63);
        jPanel1.add(tfPengobatan);
        tfPengobatan.setBounds(470, 760, 670, 78);

        btnTambah.setBackground(new java.awt.Color(16, 120, 123));
        btnTambah.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah Rekam Medis");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah);
        btnTambah.setBounds(860, 860, 276, 46);

        btnReset.setBackground(new java.awt.Color(16, 120, 123));
        btnReset.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);
        btnReset.setBounds(620, 860, 218, 46);

        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/record/assets/rekam-medik-asset/Group 41.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 840, 127, 186);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/record/assets/rekam-medik-asset/Group 42.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1020, 820, 420, 210);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Kode Penyakit : ");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(340, 380, 120, 19);

        cbRekamMedis1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rawat Jalan", "Rawat Inap", "Gawat Darurat" }));
        jPanel1.add(cbRekamMedis1);
        cbRekamMedis1.setBounds(470, 200, 190, 26);

        cbIdDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdDokterActionPerformed(evt);
            }
        });
        jPanel1.add(cbIdDokter);
        cbIdDokter.setBounds(470, 300, 190, 26);

        cbKdPenyakit.setSelectedIndex(cbKdPenyakit.getSelectedIndex());
        cbKdPenyakit.setSelectedItem(cbKdPenyakit);
        cbKdPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKdPenyakitActionPerformed(evt);
            }
        });
        jPanel1.add(cbKdPenyakit);
        cbKdPenyakit.setBounds(470, 380, 190, 26);
        jPanel1.add(dcTglKeluar);
        dcTglKeluar.setBounds(470, 560, 200, 29);
        jPanel1.add(dcTglMasuk);
        dcTglMasuk.setBounds(470, 510, 200, 29);

        cbKdSpesialis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKdSpesialis1ActionPerformed(evt);
            }
        });
        jPanel1.add(cbKdSpesialis1);
        cbKdSpesialis1.setBounds(470, 340, 190, 26);

        cbIdPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdPasienActionPerformed(evt);
            }
        });
        jPanel1.add(cbIdPasien);
        cbIdPasien.setBounds(470, 260, 190, 26);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbIdPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdPasienActionPerformed

    private void cbKdSpesialis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKdSpesialis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKdSpesialis1ActionPerformed

    private void cbKdPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKdPenyakitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKdPenyakitActionPerformed

    private void cbIdDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdDokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdDokterActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        cbKdPoliklinik.setSelectedIndex(0);
        cbKdPoliklinik.setSelectedIndex(0);
        cbIdDokter.setSelectedIndex(0);
        cbIdPasien.setSelectedIndex(0);
        cbIdDokter.setSelectedItem(0);
        tfPemeriksa.setText("");
        tfRuangRawat.setText("");
        dcTglMasuk.setDate(new Date());
        dcTglKeluar.setDate(new Date());
        tfTindakan.setText("");
        tfPengobatan.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String rekamMedis = cbRekamMedis1.getSelectedItem().toString();
            int idPasien = Integer.parseInt(cbIdDokter.getSelectedItem().toString().substring(0,4));
            int idDokter = Integer.parseInt(cbIdDokter.getSelectedItem().toString().substring(0,4));
            int kdSpesialisasi = Integer.parseInt(cbIdDokter.getSelectedItem().toString().substring(0,4));
            int kdPenyakit = Integer.parseInt(cbKdPenyakit.getSelectedItem().toString().substring(0,4));
            int kdPoli = Integer.parseInt(cbKdPoliklinik.getSelectedItem().toString().substring(0,4));
            String pemeriksa = tfPemeriksa.getText();
            String ruangRawat = tfRuangRawat.getText();
            String tglMasuk = dateformat.format(dcTglMasuk.getDate());
            String tglKeluar = dateformat.format(dcTglMasuk.getDate());
            String tindakan = tfTindakan.getText();
            String pengobatan = tfPengobatan.getText();

            if(rekamMedis.equals("") || idPasien==0 || idDokter==0 || kdPoli==0 || kdSpesialisasi==0
                || kdPenyakit==0 || pemeriksa.equals("") || ruangRawat.equals("") || tglMasuk.equals("")
                || tglKeluar.equals("") || tindakan.equals("") || pengobatan.equals("")){
                JOptionPane.showMessageDialog(this, "pastikan untuk melengkapi semua field sebelum submit data");
            }

            function.addRekamMedik(
                conn,
                idPasien,
                idDokter,
                kdSpesialisasi,
                kdPoli,
                kdPenyakit,
                rekamMedis,
                ruangRawat,
                tglMasuk,
                tglKeluar,
                pemeriksa,
                tindakan,
                pengobatan
            );

            JOptionPane.showMessageDialog(this, "berhasil di tambahkan");
        }catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(this, "inputan pada ID harus berupa angka" );
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void tfPemeriksaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPemeriksaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPemeriksaActionPerformed

    private void cbKdPoliklinikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKdPoliklinikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKdPoliklinikActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        ViewDashboard menu = new ViewDashboard(nama, id);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRekamMedis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbIdDokter;
    private javax.swing.JComboBox<String> cbIdPasien;
    private javax.swing.JComboBox<String> cbKdPenyakit;
    private javax.swing.JComboBox<String> cbKdPoliklinik;
    private javax.swing.JComboBox<String> cbKdSpesialis1;
    private javax.swing.JComboBox<String> cbRekamMedis1;
    private com.toedter.calendar.JDateChooser dcTglKeluar;
    private com.toedter.calendar.JDateChooser dcTglMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfPemeriksa;
    private javax.swing.JTextField tfPengobatan;
    private javax.swing.JTextField tfRuangRawat;
    private javax.swing.JTextField tfTindakan;
    // End of variables declaration//GEN-END:variables
}
