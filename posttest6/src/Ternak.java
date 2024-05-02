import java.util.concurrent.atomic.AtomicInteger;

public interface TernakProperties {
    // Getter methods
    int getUsia();
    double getBerat();
    String getJenisKelamin();

    // Setter methods
    void setUsia(int usia);
    void setBerat(double berat);
    void setJenisKelamin(String jenisKelamin);
}
public abstract class Ternak implements TernakProperties {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private final String id;
    private final String jenis; 
    private int usia;
    private double berat;
    private String jenisKelamin;
    private InfoTernak info;

    public abstract void tempat();

    public Ternak(String jenis, int usia, double berat, String jenisKelamin, InfoTernak info) {
        this.id = String.format("%05d", ID_COUNTER.incrementAndGet());
        this.jenis = jenis;
        this.usia = usia;
        this.berat = berat;
        this.jenisKelamin = jenisKelamin;
        this.info = info;
    }

    public int getUsia() {
        return usia;
    }

    public double getBerat() {
        return berat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }


    public void setUsia(int usia) {
        this.usia = usia;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public InfoTernak getInfo() {
        return info;
    }

    public final class Unggas extends Ternak {
        public Unggas(int usia, double berat, String jenisKelamin, String statusKesehatan, String jenisPakan, double jumlahPakan, String jadwalPemberianPakan, boolean sudahDiberiPakan) {
            super("Unggas", usia, berat, jenisKelamin, new InfoTernak(statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan));
        }

        public void tempat() {
            System.out.println("  Ruangan: Kandang");
            System.out.println("  SuhuMin Ruangan: 20°C");
            System.out.println("  SuhuMax Ruangan: 45°C");
        }
    }
    
    public static class MamaliaTernak extends Ternak {
        public MamaliaTernak(int usia, double berat, String jenisKelamin, String statusKesehatan, String jenisPakan, double jumlahPakan, String jadwalPemberianPakan, boolean sudahDiberiPakan) {
            super("Mamalia", usia, berat, jenisKelamin, new InfoTernak(statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan));
        }

        public void tempat() {
            System.out.println("  Ruangan: Padang Rumput/Kandang");
            System.out.println("  SuhuMin Ruangan: 21°C");
            System.out.println("  SuhuMax Ruangan: 40°C");
        }
    }

    public void updateInfo(int usia, double berat, String jenisKelamin, String statusKesehatan, String jenisPakan, double jumlahPakan, String jadwalPemberianPakan, boolean sudahDiberiPakan) {
        setUsia(usia);
        setBerat(berat);
        setJenisKelamin(jenisKelamin);
        this.info = new InfoTernak(statusKesehatan, jenisPakan, jumlahPakan, jadwalPemberianPakan, sudahDiberiPakan);
    }
}

