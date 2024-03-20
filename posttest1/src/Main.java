import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Lokasi> daftarLokasi = new ArrayList<>();
    private static int idTernakCounter = 1; 
    private static final int MAX_TERNAK_PER_LOKASI = 20; 

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("====================================");
            System.out.println("Sistem Pengelolaan Ternak");
            System.out.println("1. Tambah Ternak");
            System.out.println("2. Lihat Ternak");
            System.out.println("3. Update Ternak");
            System.out.println("4. Hapus Ternak");
            System.out.println("5. Quit");
            System.out.print("Pilih menu: ");

            String pilihan = reader.readLine();
            switch (pilihan) {
                case "1":
                    tambahTernak();
                    break;
                case "2":
                    lihatTernak();
                    break;
                case "3":
                    updateTernak();
                    break;
                case "4":
                    hapusTernak();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void tambahTernak() throws IOException {
        clear();
        System.out.print("Masukkan ID Lokasi (A1-D10): ");
        String idLokasi = reader.readLine();

        if (!idLokasi.matches("^[A-D][1-9]|10$")) {
            System.out.println("Lokasi tidak valid. Harus dalam rentang A1-D10.");
            return;
        }

        Lokasi lokasi = daftarLokasi.stream()
                .filter(l -> l.getId().equals(idLokasi))
                .findFirst()
                .orElseGet(() -> {
                    Lokasi baru = new Lokasi(idLokasi, "Nama Lokasi Baru");
                    daftarLokasi.add(baru);
                    return baru;
                });

        if (lokasi.getJumlahTernak() >= MAX_TERNAK_PER_LOKASI) {
            System.out.println("Lokasi sudah penuh. Tidak dapat menambah ternak baru.");
            return;
        }

        String id = "ternak" + idTernakCounter++;
        System.out.print("Jenis Ternak: ");
        String jenis = reader.readLine();
        System.out.print("Usia Ternak (bulan): ");
        int usia = Integer.parseInt(reader.readLine());
        System.out.print("Berat Ternak (kg): ");
        double berat = Double.parseDouble(reader.readLine());
        System.out.print("Jenis Kelamin Ternak (Jantan/Betina): ");
        String jenisKelamin = reader.readLine();
        System.out.print("Status Kesehatan: ");
        String statusKesehatan = reader.readLine();
        System.out.print("Jenis Pakan: ");
        String jenisPakan = reader.readLine();
        System.out.print("Jumlah Pakan (kg): ");
        double jumlahPakan = Double.parseDouble(reader.readLine());
        System.out.print("Jadwal Pemberian Pakan: ");
        String jadwalPemberianPakan = reader.readLine();
        System.out.print("Sudah Diberi Pakan (Ya/Tidak): ");
        boolean sudahDiberiPakan = reader.readLine().trim().equalsIgnoreCase("Ya");

        InfoTernak info = new InfoTernak(statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan);
        Ternak ternak = new Ternak(id, jenis, usia, berat, jenisKelamin, info);
        lokasi.tambahTernak(ternak);
        System.out.println("Ternak berhasil ditambahkan dengan ID: " + id);
    }

    private static void lihatTernak() {
        clear();
        if (daftarLokasi.isEmpty()) {
            System.out.println("Belum ada data lokasi dan ternak.");
            return;
        }
        daftarLokasi.forEach(Lokasi::displayTernakDanInfo);
    }
    

    private static void updateTernak() throws IOException {
        clear();
        System.out.print("Masukkan ID Ternak yang ingin diupdate: ");
        String idTernak = reader.readLine();
        boolean found = false;

        for (Lokasi lokasi : daftarLokasi) {
            for (Ternak ternak : lokasi.ternakDiLokasi) {
                if (ternak.id.equals(idTernak)) {
                    System.out.println("Mengupdate Ternak dengan ID: " + idTernak);
                    System.out.print("Jenis Ternak baru: ");
                    ternak.jenis = reader.readLine();
                    System.out.print("Usia Ternak baru (bulan): ");
                    ternak.usia = Integer.parseInt(reader.readLine());
                    System.out.print("Berat Ternak baru (kg): ");
                    ternak.berat = Double.parseDouble(reader.readLine());
                    System.out.print("Jenis Kelamin Ternak baru (Jantan/Betina): ");
                    ternak.jenisKelamin = reader.readLine();
                    // Update InfoTernak
                    System.out.print("Status Kesehatan baru: ");
                    ternak.info.statusKesehatan = reader.readLine();
                    System.out.print("Jenis Pakan baru: ");
                    ternak.info.jenisPakan = reader.readLine();
                    System.out.print("Jumlah Pakan baru (kg): ");
                    ternak.info.jumlahPakan = Double.parseDouble(reader.readLine());
                    System.out.print("Jadwal Pemberian Pakan baru: ");
                    ternak.info.jadwalPemberianPakan = reader.readLine();
                    System.out.print("Sudah Diberi Pakan baru (Ya/Tidak): ");
                    ternak.info.sudahDiberiPakan = reader.readLine().equalsIgnoreCase("Ya");

                    System.out.println("Ternak berhasil diupdate.");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("Ternak dengan ID tersebut tidak ditemukan.");
        }
    }


    private static void hapusTernak() throws IOException {
        clear();
        System.out.print("Masukkan ID Ternak yang ingin dihapus: ");
        String idTernak = reader.readLine();
        boolean found = false;
    
        for (Lokasi lokasi : daftarLokasi) {
            for (Iterator<Ternak> iterator = lokasi.ternakDiLokasi.iterator(); iterator.hasNext(); ) {
                Ternak ternak = iterator.next();
                if (ternak.id.equals(idTernak)) {
                    iterator.remove();
                    System.out.println("Ternak berhasil dihapus.");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
    
        if (!found) {
            System.out.println("Ternak dengan ID tersebut tidak ditemukan.");
        }
    }
    

}
