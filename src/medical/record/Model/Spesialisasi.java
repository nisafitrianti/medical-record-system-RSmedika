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
public class Spesialisasi extends Penyakit{
    private int kode_spesialisasi;
    private String namaSpesialisasi;

    public Spesialisasi() {
    }

    public Spesialisasi(int kode_spesialisasi, String namaSpesialisasi) {
        this.kode_spesialisasi = kode_spesialisasi;
        this.namaSpesialisasi = namaSpesialisasi;
    }

    public Spesialisasi(int kode_spesialisasi, String namaSpesialisasi, int kode_penyakit, String namaPenyakit) {
        super(kode_penyakit, namaPenyakit);
        this.kode_spesialisasi = kode_spesialisasi;
        this.namaSpesialisasi = namaSpesialisasi;
    }

    public int getKode_spesialisasi() {
        return kode_spesialisasi;
    }

    public void setKode_spesialisasi(int kode_spesialisasi) {
        this.kode_spesialisasi = kode_spesialisasi;
    }

    public String getNamaSpesialisasi() {
        return namaSpesialisasi;
    }

    public void setNamaSpesialisasi(String namaSpesialisasi) {
        this.namaSpesialisasi = namaSpesialisasi;
    }  
    
    
   
}
