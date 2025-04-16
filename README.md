# PemlanTugas6
## Class
1. [Manusia.java](Manusia.java)
2. [MahasiswaFILKOM.java](MahasiswaFILKOM.java)
3. [Pekerja.java](Pekerja.java)
4. [Manajer.java](Manajer.java)
## Manusia.java
Class `Manusia.java` merupakan class induk yang berisi atribut utama yaitu :
```java
// Atribut utama
    String nama;
    boolean jenisKelamin;
    String NIK;
    boolean menikah;
    double tujangan;
```
Class ini memiliki constructor yang berparameter atribut yang ada 
```java
public Manusia (String nama, String NIK, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.NIK = NIK;
        this.menikah = menikah;
    }
```
lalu ada method getter untuk tunjangan :
``` java
 public double getTunjangan(){
        if (menikah) {
            return jenisKelamin ? 25:30;
        } else
            return 15;
        
    }
```
dan juga pendapatan :
``` java
 public double getPendapatan(){
        return getTunjangan();
    }
```
Lalu ada juga method toString yang digunakan untuk membuat atribut dari class tsb menjadi String agar mudah ditampilkan
``` java
public String toString(){
        return "Nama : " + nama + "\n" + "NIK : " + NIK + "\n" + 
                "Jenis Kelamin : " + (jenisKelamin ? "Laki - laki" : "Perempuan") + "\n" +
                "Pendapatan : " + getPendapatan();
    }
```
## MahasiswaFILKOM.java
Class ini merupakan class induk dari `Manusia.java` class ini mempunyai atribut khusus (nim dan ipk)
``` java
public class MahasiswaFILKOM extends Manusia {
    
    // atribut khusus class Mahasiswa Filkom
    private String nim;
    private double ipk;
```
di class ini ada constructor berparameter sesuai dengan variabel attribut class tersebut dan juga menurunkan atribut dari class induk yaitu `Manusia.java`
```java
public MahasiswaFILKOM(String nama, String NIK, boolean jenisKelamin, boolean menikah, String nim, double ipk){
        // menurunkan atribut dari class Manusia
        super(nama, NIK, jenisKelamin, menikah);
        this.nim = nim;
        this.ipk = ipk;

    }
```
lalu ada method getBeasiswa untuk menentukan apakah mahasiswa tsb mendapatkan beasiswa dengan ketentuan :
Beasiswa untuk ipk 3.0 – 3.5 mendapat $50 dan untuk 3.5 – 4 mendapat $75
```java
 // method untuk menentukan apakah dapat beasiswa?
    public double getBeasiswa(){
        if (ipk >= 3.5 && ipk == 4.0) {
            return 75;
        } else if (ipk >= 3.0 ) {
            return 50;
        } else {
            return 0;
        }
    }
```
lalu ada method getStatus yang menentukan prodi dan angkatan dari mahasiswa tsb menggunakan subString dan charAt dari String nim dengan ketentuan seperti filkom UB
```java
 // Status mahasiswa yang terdiri dari angkatan dan prodi ditentukan 
    // dengan nim menggunakan substring dan charAt
    public String getStatus(){
        String angkatan = "20" + nim.substring(0, 2);
        char charProdi = nim.charAt(6);

        String prodi;
        switch (charProdi) {
            case '2': prodi = "Teknik Informatika"; break;
            case '3': prodi = "Teknik Komputer"; break;
            case '4': prodi = "Sistem informasi"; break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi"; break;         
            default: prodi = "Prodi tidak ditemukan";
                break;
        }
        return prodi + ", " + angkatan;
    }
```
kemudian ada override untuk method getPendapatan dan toString. Pendapatan mahasiswa diambil dari beasiswa yang ia dapatkan 
```java
    // Override class getPendaptan dan toString dari class induk
    @Override
    public double getPendapatan(){
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString(){
        return super.toString() + "\nNIM: " + nim + "\nIPK: " + ipk + "\nStatus : " + getStatus() ;
    }
```
## Pekerja.java
Class ini merupakan turunan dari class `Manusia.java` yang memiliki atribut khusus :
```java
ublic class Pekerja extends Manusia {
    // Atribut khusus clas pekerja
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;
```
lalu ada constructor dengan parameter sesuai dengan yang dibutuhkan dan atribut turunan dari class `Manusia.java`
```java
public Pekerja(String nama, boolean jenisKelamin, String NIK, boolean menikah,
            double gaji, int tahunMasuk, int bulan, int tanggal, int jumlahAnak) {
        // super untuk menurunkan atribut class induk
        super(nama, NIK, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahunMasuk, bulan, tanggal);
        this.jumlahAnak = jumlahAnak;
    }
```
lalu ada method getBonus untuk menentukan bonus yang didapat oleh pekerja ini ditentukan dari durasi lama bekerja
```java
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
```
lalu ada getGaji yaitu method untuk mengambil info gaji pokok pekerja
```java
 public double getGaji() {
        return gaji;
    }
```
lalu ada override dari toString dan getPendapatan untuk menjumlahkan gaji dan bonus yang didapat dan menjadi pendapatan keseluruhan
```java
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
```
## Manajer.java
Class ini turunan dari class pekerja yang dimana class ini khusus untuk manajer dan memiliki atribut khusus class manajer yaitu departement.
Memilik Constructor yang dibutuhkan dengan tambahan departement.
```java
public class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, boolean jenisKelamin, String NIK, boolean menikah,
                   double gaji, int tahunMasuk, int bulan, int tanggal, int jumlahAnak, String departemen) {
        // super untuk menurunkan atribut dari class induk 
        super(nama, jenisKelamin, NIK, menikah, gaji, tahunMasuk, bulan, tanggal, jumlahAnak);
        this.departemen = departemen;
    }
```
lalu ada override di getPendapatan dengan ketentuan total pendapatan ditambah dengan gaji pokok dikali 10% dan juga ada method toString
```java
// override pendapatan dari class induk
    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.10 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartemen: " + departemen;
    }
```
## Main.java
Class ini berisi instansiasi objek sesuai yang ditentukan yaitu :
1. Manusia
a. Laki-laki telah menikah.
b. Perempuan telah menikah.
c. Belum menikah.
2. MahasiswaFilkom (sesuai status Anda)
a. Ipk < 3
b. Ipk 3 – 3.5
c. Ipk 3.5 – 4
3. Pekerja
a. Lama bekerja 2 tahun, anak 2
b. Lama bekerja 9 tahun
c. Lama bekerja 20 tahun, anak 10
4. Manager, lama bekerja 15 tahun dengan gaji $7500
```java
public class Main {
    public static void main(String[] args) {
        
        // Manusia
        // laki-laki menikah
        Manusia anto = new Manusia("Anto", "6705161510040003", true, true);
        System.out.println(anto);
        System.out.println();
        // perempuan menikah
        Manusia anna = new Manusia("Anna", "7704161103050002", false, true);
        System.out.println(anna);
        System.out.println();
        // belum menikah
        Manusia andin = new Manusia("Andin", "8165021104020001", false, false);
        System.out.println(andin);
        System.out.println();

        // Mahasiswa filkom
        // IPK <3.0
        MahasiswaFILKOM anji = new MahasiswaFILKOM("Anji", "9871690405030002", true, false, "235150200111032", 2.9);
        System.out.println(anji);
        System.out.println();
        // IPK 3 - 3.5
        MahasiswaFILKOM budi = new MahasiswaFILKOM("Budi", "2205171212060003", true, false, "245150600111032", 3.3);
        System.out.println(budi);
        System.out.println();
        // IPK  3.5 - 4.0
        MahasiswaFILKOM daffa = new MahasiswaFILKOM("Daffa", "3305161112040002", true, false, "245150700111032", 4.0);
        System.out.println(daffa);
        System.out.println();

        // Pekerja
        // anak 2 2 tahun kerja
        Pekerja agus = new Pekerja("Agus", true, "8802131311940003", true, 1000, 2023, 4, 16, 2);
        System.out.println(agus);
        System.out.println();

        // kerja 9 tahun
        Pekerja ronal = new Pekerja("Ronal", true, "8802131103930001", true, 1000, 2016, 4, 16, 0);
        System.out.println(ronal);
        System.out.println();

        // kerja 20 tahun anak 10
        Pekerja sutejo = new Pekerja("Sutejo", true, "7765241004870001", true, 1000, 2005, 4, 16, 10);
        System.out.println(sutejo);
        System.out.println();

        // Manajer
        // Manajer 15 tahun gaji 7500
        Manager daniel = new Manager("Daniel", true, "3305161102800001", true, 7500, 2010, 1, 2, 0, "HRD");
        System.out.println(daniel);
    }
}
```
