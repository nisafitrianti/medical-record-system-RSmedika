/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.Model;

/**
 *
 * @author saftrn
 */
public class Pasien {
    private int id_pasien;
    private String namaPasien;
    private String genderPasien;
    private String tglLahirPasien;
    private String noTelpPasien;
    private String alamatPasien;
    private String pekerjaanPasien;
    private int umur;

    public Pasien() {
    }

    public Pasien(int id_pasien, String namaPasien, String genderPasien, String tglLahirPasien, String noTelpPasien, String alamatPasien, String pekerjaanPasien, int umur) {
        this.id_pasien = id_pasien;
        this.namaPasien = namaPasien;
        this.genderPasien = genderPasien;
        this.tglLahirPasien = tglLahirPasien;
        this.noTelpPasien = noTelpPasien;
        this.alamatPasien = alamatPasien;
        this.pekerjaanPasien = pekerjaanPasien;
        this.umur = umur;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getGenderPasien() {
        return genderPasien;
    }

    public void setGenderPasien(String genderPasien) {
        this.genderPasien = genderPasien;
    }

    public String getTglLahirPasien() {
        return tglLahirPasien;
    }

    public void setTglLahirPasien(String tglLahirPasien) {
        this.tglLahirPasien = tglLahirPasien;
    }

    public String getNoTelpPasien() {
        return noTelpPasien;
    }

    public void setNoTelpPasien(String noTelpPasien) {
        this.noTelpPasien = noTelpPasien;
    }

    public String getAlamatPasien() {
        return alamatPasien;
    }

    public void setAlamatPasien(String alamatPasien) {
        this.alamatPasien = alamatPasien;
    }

    public String getPekerjaanPasien() {
        return pekerjaanPasien;
    }

    public void setPekerjaanPasien(String pekerjaanPasien) {
        this.pekerjaanPasien = pekerjaanPasien;
    }
    
    
    
}
