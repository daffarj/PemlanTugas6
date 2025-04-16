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
