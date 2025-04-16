import java.time.LocalDate;

public class Pekerja extends Manusia {
    // Atribut khusus clas pekerja
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String NIK, boolean menikah,
            double gaji, int tahunMasuk, int bulan, int tanggal, int jumlahAnak) {
        // super untuk menurunkan atribut class induk
        super(nama, NIK, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahunMasuk, bulan, tanggal);
        this.jumlahAnak = jumlahAnak;
    }

    // method getBonus untuk menghitung bonus yang didapat oleh pekerja
    public double getBonus() {
        long tahunKerja = LocalDate.now().getYear() - tahunMasuk.getYear();
        if (tahunKerja >= 10)
            return gaji * 0.15;
        else if (tahunKerja >= 5)
            return gaji * 0.10;
        else
            return gaji * 0.05;
    }

    public double getGaji() {
        return gaji;
    }

    // override getPendapatan dan toString dari class induk
    @Override
    public double getPendapatan() {
        return super.getPendapatan() + gaji + getBonus() + (20 * jumlahAnak);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTahun Masuk: " + tahunMasuk.getDayOfMonth() + ", " + tahunMasuk.getMonthValue() + ", "
                + tahunMasuk.getYear() +
                "\nJumlah Anak: " + jumlahAnak +
                "\nGaji: " + gaji +
                "\nPendapatan: $" + getPendapatan();
    }
}
