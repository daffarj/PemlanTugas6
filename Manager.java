
public class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, boolean jenisKelamin, String NIK, boolean menikah,
                   double gaji, int tahunMasuk, int bulan, int tanggal, int jumlahAnak, String departemen) {
        // super untuk menurunkan atribut dari class induk 
        super(nama, jenisKelamin, NIK, menikah, gaji, tahunMasuk, bulan, tanggal, jumlahAnak);
        this.departemen = departemen;
    }

    // override pendapatan dari class induk
    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.10 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartemen: " + departemen;
    }
}
