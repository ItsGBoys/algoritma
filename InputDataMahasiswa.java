import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class InputDataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> namaMahasiswa = new ArrayList<String>();
        ArrayList<String> nimMahasiswa = new ArrayList<String>();
        ArrayList<String> jurusanMahasiswa = new ArrayList<String>();
        ArrayList<Integer> tahunLahirMahasiswa = new ArrayList<Integer>();
        ArrayList<String> jenisKelaminMahasiswa = new ArrayList<String>();

        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.print("Masukkan nama mahasiswa: ");
            String nama = input.nextLine();
            namaMahasiswa.add(nama);

            System.out.print("Masukkan NIM mahasiswa: ");
            String nim = input.nextLine();
            nimMahasiswa.add(nim);

            System.out.print("Masukkan jurusan mahasiswa: ");
            String jurusan = input.nextLine();
            jurusanMahasiswa.add(jurusan);

            System.out.print("Masukkan tahun lahir mahasiswa: ");
            int tahunLahir = input.nextInt();
            input.nextLine(); // membersihkan new line di buffer
            tahunLahirMahasiswa.add(tahunLahir);

            System.out.print("Masukkan jenis kelamin mahasiswa (Laki-laki/perempuan): ");
            String jenisKelamin = input.nextLine();
            jenisKelaminMahasiswa.add(jenisKelamin);
            System.out.println("-------------------------------------------------------------");
            System.out.print("lanjutkan/selesai?  ");
            String keputusan = input.nextLine();
            if (keputusan.equalsIgnoreCase("selesai")) {
                break;
            }        }

        // menghitung jumlah mahasiswa laki-laki dan perempuan
        int jumlahLakiLaki = 0;
        int jumlahPerempuan = 0;
        int jumlah = jenisKelaminMahasiswa.size();
        for (int i = 0; i < jumlah; i++) {
            String jenisKelamin = jenisKelaminMahasiswa.get(i);
            if (jenisKelamin.equalsIgnoreCase("Laki-Laki")) {
                jumlahLakiLaki++;
            } else if (jenisKelamin.equalsIgnoreCase("Perempuan")) {
                jumlahPerempuan++;
            }
        }

        // menampilkan data mahasiswa dalam bentuk tabel
        System.out.println("\n\n================================================================================================================");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("==================================================================================================================");
        System.out.println("No\tNama\t\tNIM\t\tMJurusan\t\t\tUmur\t\tJenis Kelamin");
        System.out.println("=================================================================================================================");
        for (int i = 0; i < jumlah; i++) {
            int tahunLahir = tahunLahirMahasiswa.get(i);
            int umur = hitungUmur(tahunLahir);
            System.out.println((i + 1)+"\t"+ namaMahasiswa.get(i)+"\t\t"+nimMahasiswa.get(i)+"\t\t"+jurusanMahasiswa.get(i)+"\t\t"+ umur+"\t\t"+jenisKelaminMahasiswa.get(i));
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Jumlah mahasiswa laki-laki: " + jumlahLakiLaki);
        System.out.println("Jumlah mahasiswa perempuan: " + jumlahPerempuan);
    }

    // fungsi untuk menghitung umur
    public static int hitungUmur(int tahunLahir) {
        int tahunSekarang = Calendar.getInstance().get(Calendar.YEAR);
        return tahunSekarang - tahunLahir;
        }
        }
