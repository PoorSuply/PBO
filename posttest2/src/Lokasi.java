import java.util.ArrayList;
import java.util.List;

public class Lokasi {
    private String id;
    private String nama;
    private List<Ternak> ternakDiLokasi;

    public Lokasi(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.ternakDiLokasi = new ArrayList<>();
    }


public Lokasi(String id) {
    this(id, "");
}


    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Ternak> getTernakDiLokasi() {
        return new ArrayList<>(ternakDiLokasi); 
    }

    public void tambahTernak(Ternak ternak) {
        if (ternak != null && !this.ternakDiLokasi.contains(ternak)) {
            this.ternakDiLokasi.add(ternak);
        }
    }

    public boolean hapusTernak(String idTernak) {
        return ternakDiLokasi.removeIf(ternak -> ternak.getId().equals(idTernak));
    }

    public int getJumlahTernak() {
        return this.ternakDiLokasi.size();
    }

    public void displayTernakDanInfo() {
        if (ternakDiLokasi.isEmpty()) {
            System.out.println("  Tidak ada ternak di lokasi ini.");
        } else {
            for (Ternak ternak : ternakDiLokasi) {
                System.out.println("Lokasi: " + id );
                System.out.println("  ID Ternak: " + ternak.getId());
                System.out.println("  Jenis: " + ternak.getJenis());
                System.out.println("  Usia: " + ternak.getUsia() + " bulan");
                System.out.println("  Berat: " + ternak.getBerat() + " kg");
                System.out.println("  Jenis Kelamin: " + ternak.getJenisKelamin());
                System.out.println("  --- Info Kesehatan ---");
                System.out.println("  Status Kesehatan: " + ternak.getInfo().getStatusKesehatan());
                System.out.println("  Jenis Pakan: " + ternak.getInfo().getJenisPakan());
                System.out.println("  Jumlah Pakan: " + ternak.getInfo().getJumlahPakan() + " kg");
                System.out.println("  Jadwal Pemberian Pakan: " + ternak.getInfo().getJadwalPemberianPakan());
                System.out.println("  Sudah Diberi Pakan: " + (ternak.getInfo().isSudahDiberiPakan() ? "Ya" : "Tidak"));
                System.out.println();
            }
        }
    }
}
