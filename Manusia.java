class Manusia{
    // Atribut utama
    String nama;
    boolean jenisKelamin;
    String NIK;
    boolean menikah;
    double tujangan;

    public Manusia (String nama, String NIK, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.NIK = NIK;
        this.menikah = menikah;
    }

    public String getNama(){
        return nama;
    }

    public double getTunjangan(){
        if (menikah) {
            return jenisKelamin ? 25:30;
        } else
            return 15;
        
    }

    public double getPendapatan(){
        return getTunjangan();
    }

    public String toString(){
        return "Nama : " + nama + "\n" + "NIK : " + NIK + "\n" + 
                "Jenis Kelamin : " + (jenisKelamin ? "Laki - laki" : "Perempuan") + "\n" +
                "Pendapatan : " + getPendapatan();
    }
   
}