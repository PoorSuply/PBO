public class InfoTernak {
    String statusKesehatan;
    String jenisPakan;
    double jumlahPakan; 
    String jadwalPemberianPakan;
    boolean sudahDiberiPakan;

    public InfoTernak(String statusKesehatan, String jenisPakan, double jumlahPakan, String jadwalPemberianPakan, boolean sudahDiberiPakan) {
        this.statusKesehatan = statusKesehatan;
        this.jenisPakan = jenisPakan;
        this.jumlahPakan = jumlahPakan;
        this.jadwalPemberianPakan = jadwalPemberianPakan;
        this.sudahDiberiPakan = sudahDiberiPakan;
    }

    public void display() {
        System.out.println("Status Kesehatan: " + statusKesehatan);
        System.out.println("Jenis Pakan: " + jenisPakan);
        System.out.println("Jumlah Pakan: " + jumlahPakan + " kg");
        System.out.println("Jadwal Pemberian Pakan: " + jadwalPemberianPakan);
        System.out.println("Sudah Diberi Pakan: " + (sudahDiberiPakan ? "Ya" : "Tidak"));
    }
}
