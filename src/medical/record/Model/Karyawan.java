/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.Model;

import medical.record.Controller.Auth;

/**
 *
 * @author saftrn
 */
public class Karyawan extends Auth{
    private int id_karyawan;
    private String namaKaryawan;
    private String genderKAryawan;
    private String tglLahir;
    private String tglMulaiKerja;
    private String statusKaryawan;    
    private String password;

    public Karyawan() {
    }

    public Karyawan(int id_karyawan, String namaKaryawan, String genderKAryawan, String tglLahir, String tglMulaiKerja) {
        this.id_karyawan = id_karyawan;
        this.namaKaryawan = namaKaryawan;
        this.genderKAryawan = genderKAryawan;
        this.tglLahir = tglLahir;
        this.tglMulaiKerja = tglMulaiKerja;
    }
 
    public Karyawan(int id_karyawan, String password) {
        this.id_karyawan = id_karyawan;
        this.password = password;
    }

    public int getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(int id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getGenderKAryawan() {
        return genderKAryawan;
    }

    public void setGenderKAryawan(String genderKAryawan) {
        this.genderKAryawan = genderKAryawan;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getTglMulaiKerja() {
        return tglMulaiKerja;
    }

    public void setTglMulaiKerja(String tglMulaiKerja) {
        this.tglMulaiKerja = tglMulaiKerja;
    }

    public String getStatusKaryawan() {
        return statusKaryawan;
    }

    public void setStatusKaryawan(String statusKaryawan) {
        this.statusKaryawan = statusKaryawan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    
}
