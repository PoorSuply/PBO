import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Lokasi> daftarLokasi = new ArrayList<>();


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

    private static int getIntInput(String prompt, boolean positiveOnly) throws IOException {
        int input = 0;
        do {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(reader.readLine());
                if (positiveOnly && input <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harus berupa angka.");
            }
        } while (true);
        return input;
    }
    
    private static double getDoubleInput(String prompt, boolean positiveOnly) throws IOException {
        double input = 0;
        do {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(reader.readLine());
                if (positiveOnly && input <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harus berupa angka.");
            }
        } while (true);
        return input;
    }

    private static String getGenderInput(String prompt) throws IOException {
        String input;
        do {
            System.out.print(prompt);
            input = reader.readLine();
            if (input.equalsIgnoreCase("Jantan") || input.equalsIgnoreCase("Betina")) {
                return input;
            } else {
                System.out.println("Input tidak valid. Harus 'Jantan' atau 'Betina'.");
            }
        } while (true);
    }
    
    private static boolean getFeedingStatusInput(String prompt) throws IOException {
        String input;
        do {
            System.out.print(prompt);
            input = reader.readLine();
            if (input.equalsIgnoreCase("Ya")) {
                return true;
            } else if (input.equalsIgnoreCase("Tidak")) {
                return false;
            } else {
                System.out.println("Input tidak valid. Harus 'Ya' atau 'Tidak'.");
            }
        } while (true);
    }
    

    private static void tambahTernak() throws IOException {
        clear();
        System.out.print("Masukkan ID Lokasi (A1-D10): ");
        String idLokasi = reader.readLine();

        if (!idLokasi.matches("^[A-D][1-9]|10$")) {
            System.out.println("Lokasi tidak valid. Harus dalam rentang A1-D10.");
            return;
        }
        System.out.println("Masukkan detail Ternak:");
        System.out.print("Jenis (Unggas/Mamalia): ");
        String jenis = reader.readLine();
        if (!jenis.equalsIgnoreCase("Unggas") && !jenis.equalsIgnoreCase("Mamalia")) {
            System.out.println("Jenis tidak valid. Harus 'Unggas' atau 'Mamalia'.");
            return;
        }
        int usia = getIntInput("Usia (bulan): ", true);
        double berat = getDoubleInput("Berat (kg): ", true);
        String jenisKelamin = getGenderInput("Jenis Kelamin (Jantan/Betina): ");
        System.out.print("Status Kesehatan: ");
        String statusKesehatan = reader.readLine();
        System.out.print("Jenis Pakan: ");
        String jenisPakan = reader.readLine();
        double jumlahPakan = getDoubleInput("Jumlah Pakan (kg): ", true);
        System.out.print("Jadwal Pemberian Pakan: ");
        String jadwalPemberianPakan = reader.readLine();
        boolean sudahDiberiPakan = getFeedingStatusInput("Sudah Diberi Pakan (Ya/Tidak): ");
        
        Ternak ternak;
        if (jenis.equalsIgnoreCase("Unggas")) {
            ternak = new Ternak.Unggas(usia, berat, jenisKelamin, statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan);
        } else {
            ternak = new Ternak.MamaliaTernak(usia, berat, jenisKelamin, statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan);
        }

        Lokasi lokasi = daftarLokasi.stream().filter(l -> l.getId().equals(idLokasi)).findFirst().orElse(null);
        if (lokasi == null) {
            lokasi = new Lokasi(idLokasi);
            daftarLokasi.add(lokasi);
        }
        lokasi.tambahTernak(ternak);

        System.out.println("Ternak berhasil ditambahkan dengan ID: " + ternak.getId());
    }

    private static void lihatTernak() {
        clear();
        if (daftarLokasi.isEmpty()) {
            System.out.println("Belum ada ternak yang ditambahkan.");
            return;
        }
        for (Lokasi lokasi : daftarLokasi) {
            lokasi.displayTernakDanInfo();
        }
    }
    
    private static void updateTernak() throws IOException {
    clear();
    System.out.println("Update Ternak");
    System.out.print("Masukkan ID Ternak: ");
    String idTernak = reader.readLine();
    boolean found = false;

    for (Lokasi lokasi : daftarLokasi) {
        for (Ternak ternak : lokasi.getTernakDiLokasi()) {
            if (ternak.getId().equals(idTernak)) {
                int usia = getIntInput("Usia baru (bulan): ", true);
                double berat = getDoubleInput("Berat baru (kg): ", true);
                String jenisKelamin = getGenderInput("Jenis Kelamin baru (Jantan/Betina): ");
                String statusKesehatan = getInput("Status Kesehatan baru: ");
                String jenisPakan = getInput("Jenis Pakan baru: ");
                double jumlahPakan = getDoubleInput("Jumlah Pakan baru (kg): ", true);
                String jadwalPemberianPakan = getInput("Jadwal Pemberian Pakan baru: ");
                boolean sudahDiberiPakan = getFeedingStatusInput("Sudah Diberi Pakan baru (Ya/Tidak): ");

                ternak.updateInfo(usia, berat, jenisKelamin, statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan);
                System.out.println("Ternak berhasil diupdate.");
                found = true;
                break; 
            }
        }
        if (found) {
            break; 
        }
    }

    if (!found) {
        System.out.println("Ternak dengan ID tersebut tidak ditemukan.");
    }
    }
    private static String getInput(String prompt) throws IOException {
        System.out.print(prompt);
        return reader.readLine();
    }

    private static void hapusTernak() throws IOException {
        clear();
        System.out.print("Masukkan ID Ternak yang ingin dihapus: ");
        String idTernak = reader.readLine();
        for (Lokasi lokasi : daftarLokasi) {
            if (lokasi.hapusTernak(idTernak)) {
                System.out.println("Ternak berhasil dihapus.");
                return;
            }
        }
        System.out.println("Ternak dengan ID tersebut tidak ditemukan.");
    }
    
    private static void clear() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }
} 

