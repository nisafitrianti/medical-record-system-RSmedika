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
public class Dokter extends Auth{
    private int id_dokter;
    private int id_Spesialisasi;
    private int id_poliklinik;
    private String namaDokter;
    private String genderDokter;
    private String tglLahirDokter;
    private String tglMulaiKerja;
    private String noTelpDokter;
    private String alamatDokter;
    private String namaPoliklinik;
    private String namaSpesialisasi;
    

    public Dokter() {
    }

    public Dokter(int id_dokter, int id_Spesialisasi, int id_poliklinik, String namaDokter, String genderDokter, String tglLahirDokter, String noTelpDokter, String alamatDokter, String tglMulaiKerja) {
        this.id_dokter = id_dokter;
        this.id_Spesialisasi = id_Spesialisasi;
        this.id_poliklinik = id_poliklinik;
        this.namaDokter = namaDokter;
        this.genderDokter = genderDokter;
        this.tglLahirDokter = tglLahirDokter;
        this.noTelpDokter = noTelpDokter;
        this.alamatDokter = alamatDokter;
        this.tglMulaiKerja = tglMulaiKerja;
    }

    public Dokter(int id_dokter, String namaDokter, String genderDokter, String tglLahirDokter, String tglMulaiKerja, String noTelpDokter, String alamatDokter, String namaPoliklinik, String namaSpesialisasi) {
        this.id_dokter = id_dokter;
        this.namaDokter = namaDokter;
        this.genderDokter = genderDokter;
        this.tglLahirDokter = tglLahirDokter;
        this.tglMulaiKerja = tglMulaiKerja;
        this.noTelpDokter = noTelpDokter;
        this.alamatDokter = alamatDokter;
        this.namaPoliklinik = namaPoliklinik;
        this.namaSpesialisasi = namaSpesialisasi;
    }
    

    public int getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(int id_dokter) {
        this.id_dokter = id_dokter;
    }

    public int getId_Spesialisasi() {
        return id_Spesialisasi;
    }

    public void setId_Spesialisasi(int id_Spesialisasi) {
        this.id_Spesialisasi = id_Spesialisasi;
    }

    public int getId_poliklinik() {
        return id_poliklinik;
    }

    public void setId_poliklinik(int id_poliklinik) {
        this.id_poliklinik = id_poliklinik;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getGenderDokter() {
        return genderDokter;
    }

    public void setGenderDokter(String genderDokter) {
        this.genderDokter = genderDokter;
    }

    public String getTglLahirDokter() {
        return tglLahirDokter;
    }

    public void setTglLahirDokter(String tglLahirDokter) {
        this.tglLahirDokter = tglLahirDokter;
    }

    public String getNoTelpDokter() {
        return noTelpDokter;
    }

    public void setNoTelpDokter(String noTelpDokter) {
        this.noTelpDokter = noTelpDokter;
    }

    public String getAlamatDokter() {
        return alamatDokter;
    }

    public void setAlamatDokter(String alamatDokter) {
        this.alamatDokter = alamatDokter;
    }

    public String getTglMulaiKerja() {
        return tglMulaiKerja;
    }

    public void setTglMulaiKerja(String tglMulaiKerja) {
        this.tglMulaiKerja = tglMulaiKerja;
    }

    public String getNamaPoliklinik() {
        return namaPoliklinik;
    }

    public void setNamaPoliklinik(String namaPoliklinik) {
        this.namaPoliklinik = namaPoliklinik;
    }

    public String getNamaSpesialisasi() {
        return namaSpesialisasi;
    }

    public void setNamaSpesialisasi(String namaSpesialisasi) {
        this.namaSpesialisasi = namaSpesialisasi;
    }
    
    

   
}
