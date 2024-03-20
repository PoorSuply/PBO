public class Ternak {
    String id;
    String jenis;
    int usia; 
    double berat; 
    String jenisKelamin;
    InfoTernak info;

    public Ternak(String id, String jenis, int usia, double berat, String jenisKelamin, InfoTernak info) {
        this.id = id;
        this.jenis = jenis;
        this.usia = usia;
        this.berat = berat;
        this.jenisKelamin = jenisKelamin;
        this.info = info;
    }
    
    public void display() {
        System.out.println("====================================");
        System.out.println("ID Ternak: " + id);
        System.out.println("Jenis Ternak: " + jenis);
        System.out.println("Usia: " + usia + " bulan");
        System.out.println("Berat: " + berat + " kg");
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        if (info != null) {
            info.display();
        }
    }
}
