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

    public void setStatusKesehatan(String statusKesehatan) {
        this.statusKesehatan = statusKesehatan;
    }

    public String getJenisPakan() {
        return jenisPakan;
    }

    public void setJenisPakan(String jenisPakan) {
        this.jenisPakan = jenisPakan;
    }

    public double getJumlahPakan() {
        return jumlahPakan;
    }

    public void setJumlahPakan(double jumlahPakan) {
        this.jumlahPakan = jumlahPakan;
    }

    public String getJadwalPemberianPakan() {
        return jadwalPemberianPakan;
    }

    public void setJadwalPemberianPakan(String jadwalPemberianPakan) {
        this.jadwalPemberianPakan = jadwalPemberianPakan;
    }

    public boolean isSudahDiberiPakan() {
        return sudahDiberiPakan;
    }

    public void setSudahDiberiPakan(boolean sudahDiberiPakan) {
        this.sudahDiberiPakan = sudahDiberiPakan;
    }
}
