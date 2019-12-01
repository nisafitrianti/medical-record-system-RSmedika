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
public class Poliklinik extends Spesialisasi{
    private int kode_poliklinik;
    private String namaPoliklinik;

    public Poliklinik() {
    }

    public Poliklinik(int kode_poliklinik, String namaPoliklinik) {
        this.kode_poliklinik = kode_poliklinik;
        this.namaPoliklinik = namaPoliklinik;
    }

    public Poliklinik(int kode_poliklinik, String namaPoliklinik, int id_spesialisasi, String namaSpesialisasi, int id_penyakit, String namaPenyakit) {
        super(id_spesialisasi, namaSpesialisasi, id_penyakit, namaPenyakit);
        this.kode_poliklinik = kode_poliklinik;
        this.namaPoliklinik = namaPoliklinik;
    }

    public int getKode_poliklinik() {
        return kode_poliklinik;
    }

    public void setKode_poliklinik(int kode_poliklinik) {
        this.kode_poliklinik = kode_poliklinik;
    }

    public String getNamaPoliklinik() {
        return namaPoliklinik;
    }

    public void setNamaPoliklinik(String namaPoliklinik) {
        this.namaPoliklinik = namaPoliklinik;
    }
    
    

    
    
}
