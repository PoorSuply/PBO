import java.util.ArrayList;
import java.util.List;

public class Lokasi {
    String id;
    String nama;
    List<Ternak> ternakDiLokasi;

    public Lokasi(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.ternakDiLokasi = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getJumlahTernak() {
        return ternakDiLokasi.size();
    }

    public void tambahTernak(Ternak ternak) {
        ternakDiLokasi.add(ternak);
    }

    public void displayTernakDanInfo() {
        if (ternakDiLokasi.isEmpty()) {
            System.out.println("Tidak ada data ternak !!! ");
        } else{ 
        System.out.println("====================================");
        for (Ternak ternak : ternakDiLokasi) {
            ternak.display();
            System.out.println();
        }
    }
}
}
