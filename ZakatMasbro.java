import java.util.ArrayList;
import java.util.Scanner;

public class ZakatMasbro {
    public static void main(String[] args) {
        ArrayList<Warga> listWarga = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu");
            System.out.println("1. Masukan data warga");
            System.out.println("2. Tampilkan tabel");
            System.out.println("3. Keluar program");
            System.out.print("Masukkan pilihan: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = input.next();
                    System.out.print("Masukkan NIK: ");
                    String nik = input.next();
                    System.out.println("Pilih jenis zakat:");
                    System.out.println("1. Beras 2,5 Kg");
                    System.out.println("2. Uang 35.000");
                    int pilihanZakat = input.nextInt();
                    System.out.print("Masukkan nilai shodaqoh: ");
                    double shodaqoh = input.nextDouble();
                    Warga warga = new Warga(nama, nik, pilihanZakat, shodaqoh);
                    listWarga.add(warga);
                    break;
                case 2:
                    System.out.println("=============================================================================");
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", "Nama", "NIK", "Jenis Zakat", "Shodaqoh");
                    System.out.println("=============================================================================");
                    for (Warga w : listWarga) {
                        String jenisZakat = (w.getPilihanZakat() == 1) ? "Beras 2,5 Kg" : "Uang 35.000";
                        System.out.printf("| %-20s | %-20s | %-20s | Rp %-16.0f |\n", w.getNama(), w.getNik(), jenisZakat, w.getShodaqoh());
                    }
                    System.out.println("=============================================================================");
                    int countBeras = 0, countUang = 0;
                    double sumBeras = 0, sumUang = 0, sumShodaqoh = 0;
                    for (Warga w : listWarga) {
                        if (w.getPilihanZakat() == 1) {
                            countBeras++;
                            sumBeras += 2.5;
                        } else {
                            countUang++;
                            sumUang += 35000;
                        }
                        sumShodaqoh += w.getShodaqoh();
                    }
                    System.out.printf("%d warga membayar zakat dengan beras (%.1f Kg)\n", countBeras, sumBeras);
                    System.out.printf("%d warga membayar zakat dengan uang (Rp %.0f)\n", countUang, sumUang);
                    System.out.printf("Jumlah zakat berupa beras yang terkumpul: %.1f Kg\n", sumBeras);
                    System.out.printf("Jumlah zakat berupa uang yang terkumpul: Rp %.0f\n", sumUang);
                    System.out.printf("Jumlah sedekah yang terkumpul: Rp %.0f\n", sumShodaqoh);
                    break;
                case 3:
                    System.out.println("Terima kasih sudah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                }
            } while (choice != 3);
        }
    }

class Warga {
private String nama;
private String nik;
private int pilihanZakat;
private double shodaqoh;    
public Warga(String nama, String nik, int pilihanZakat, double shodaqoh) {
    this.nama = nama;
    this.nik = nik;
    this.pilihanZakat = pilihanZakat;
    this.shodaqoh = shodaqoh;
}

public String getNama() {
    return nama;
}

public String getNik() {
    return nik;
}

public int getPilihanZakat() {
    return pilihanZakat;
}

public double getShodaqoh() {
    return shodaqoh;
}
}