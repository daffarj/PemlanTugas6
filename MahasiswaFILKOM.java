public class MahasiswaFILKOM extends Manusia {
    
    // atribut khusus class Mahasiswa Filkom
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nama, String NIK, boolean jenisKelamin, boolean menikah, String nim, double ipk){
        // menurunkan atribut dari class Manusia
        super(nama, NIK, jenisKelamin, menikah);
        this.nim = nim;
        this.ipk = ipk;

    }

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

    // Override class getPendaptan dan toString dari class induk
    @Override
    public double getPendapatan(){
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString(){
        return super.toString() + "\nNIM: " + nim + "\nIPK: " + ipk + "\nStatus : " + getStatus() ;
    }
}
