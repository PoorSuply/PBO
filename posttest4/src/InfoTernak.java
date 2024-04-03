public class InfoTernak {
    private String statusKesehatan;
    private String jenisPakan;
    private double jumlahPakan;
    private String jadwalPemberianPakan;
    private boolean sudahDiberiPakan;

    public InfoTernak(String statusKesehatan, String jenisPakan, double jumlahPakan, String jadwalPemberianPakan, boolean sudahDiberiPakan) {
        this.statusKesehatan = statusKesehatan;
        this.jenisPakan = jenisPakan;
        this.jumlahPakan = jumlahPakan;
        this.jadwalPemberianPakan = jadwalPemberianPakan;
        this.sudahDiberiPakan = sudahDiberiPakan;
    }

    public String getStatusKesehatan() {
        return statusKesehatan;
    }

    public String getJenisPakan() {
        return jenisPakan;
    }

    public double getJumlahPakan() {
        return jumlahPakan;
    }

    public String getJadwalPemberianPakan() {
        return jadwalPemberianPakan;
    }

    public boolean isSudahDiberiPakan() {
        return sudahDiberiPakan;
    }
}
