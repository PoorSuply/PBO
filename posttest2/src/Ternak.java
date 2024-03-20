public class Ternak {
    private String id;
    private String jenis;
    private int usia; 
    private double berat; 
    private String jenisKelamin;
    private InfoTernak info;

    public Ternak(String id, String jenis, int usia, double berat, String jenisKelamin, InfoTernak info) {
        this.id = id;
        this.jenis = jenis;
        this.usia = usia;
        this.berat = berat;
        this.jenisKelamin = jenisKelamin;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public InfoTernak getInfo() {
        return info;
    }

    public void setInfo(InfoTernak info) {
        this.info = info;
    }
}
