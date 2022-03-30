import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TugasBesar {
    // Tugas Besar Kelompok 6
    /*
     * 1. Azzahra Athifah Dzaki 2111521009
     * 2. Darma Zidane Gusnambi 2111521023
     * 3. Yohanda 2111522009
     * 4. Nadini Annisa Byant 2111522021
     * 5. Muhammad Ikhlas 2111523007
     * 6. Rizqi Faridsyah Najib Adivita 2111523023
     */

    public static void main(String[] args) {
        // deklarasi stack tiket (bisnis dan ekonomi)
        Stack<Integer> bisnis = new Stack<Integer>();
        Stack<Integer> ekonomi = new Stack<Integer>();

        // isi stack
        for (int i = 1; i <= 10; i++) {
            bisnis.push(i);
        }
        for (int j = 1; j <= 10; j++) {
            ekonomi.push(j);
        }

        // deklarasi queue no_antrian
        Queue<Integer> no_antrian = new LinkedList<>();

        // deklarasi array antrian -> untuk memasukan data no antrian yang sudah
        // diproses
        int antrian[] = new int[100];

        // deklarasi array kelas
        String kelas[] = new String[2];

        // deklarasi riwayat
        String riwayat_bisnis[] = new String[10];
        String riwayat_ekonomi[] = new String[10];

        // bikin binary tree baru
        binaryTree kereta = new binaryTree();

        // deklarasi variabel global lainnya
        String nama, kota_keberangkatan = "Bandung", kota_kedatangan = "Yogyakarta", nama_kereta = "KeretaAir01",
                jawaban_2;
        boolean jawaban_3, jawaban_5, jawaban_8;
        int nomor = 1, umur, uang_bayar, kembalian, harga_bisnis = 50000, m = 0, harga_ekonomi = 20000, n = 0, l = 0,
                angka1;

        try (Scanner inputan = new Scanner(System.in)) {
            // login
            System.out.println("-----------------------------");
            System.out.println("Silahkan login program kereta");
            System.out.println("Username : ");
            String input_username = inputan.nextLine();
            System.out.println("Password : ");
            String input_password = inputan.nextLine();
            // pengecekan username dan password
            if (input_username.equalsIgnoreCase("Kereta Yogyakarta") && input_password.equalsIgnoreCase("123456")) {
                System.out.println("-----------------------------");
                System.out.print("\033[H\033[2J"); // clear layar
                System.out.println("-----------------------------");
                System.out.println("Selamat Datang di Loket Kereta");
                System.out.println("-----------------------------");
                // menu program
                do {
                    System.out.println("-----------------------------");
                    System.out.println("Menu Program Loket Tiket Kereta : ");
                    System.out.println("1. Pemesanan Tiket");
                    System.out.println("2. Pencarian Data Pesanan Tiket (berdasarkan umur)");
                    System.out.println("3. Tampilkan Tiket yang Tersedia");
                    System.out.println("4. Riwayat Pesanan Tiket");
                    System.out.println("5. Loket Tiket Tutup");
                    System.out.println("-----------------------------");
                    System.out.println("Silahkan isikan pilihan anda : ");
                    Integer angka = inputan.nextInt();
                    // pilihan inputan menu
                    switch (angka) {
                        case 1:
                            if (bisnis.size() != 0 && ekonomi.size() != 0) {
                                System.out.println("Tiket yang Tersedia");
                                System.out.println("------------------------------");
                                // stack
                                System.out.println("Tiket Kereta Bisnis : ");
                                System.out.println(bisnis);
                                System.out.println("Tiket Kereta Ekonomi : ");
                                System.out.println(ekonomi);
                                System.out.println("------------------------------");
                                // pengambilan no antrian (queue)
                                do {
                                    System.out.println("Silahkan ambil No.antrian (OK): ");
                                    jawaban_2 = inputan.next();
                                    if (jawaban_2.equalsIgnoreCase("ok")) {
                                        var data_antrian = nomor++;
                                        // queue
                                        if (no_antrian.size() == 10) {
                                            var penuh = "Maaf antrian sedang penuh";
                                            System.out.println(penuh);
                                        } else {
                                            // enqueue no antrian
                                            no_antrian.add(data_antrian);
                                            System.out.println("\n");
                                            System.out.println("Berhasil, no antrian anda adalah " + data_antrian);
                                            System.out.println("\n");
                                            System.out.println("Silahkan tunggu no anda dipanggil");
                                            System.out.println("----------------------------------");
                                        }
                                    }
                                    System.out.println("Apakah ingin mengambil no antrian kembali (true/false) : ");
                                    jawaban_3 = inputan.nextBoolean();
                                } while (jawaban_3);
                                do {
                                    // dequeue no antrian (panggil pelanggan) dan enqueue (hapus no antrian yang
                                    // telah dipanggil)
                                    if (no_antrian.isEmpty() == false) {
                                        System.out.println("-------------------------------");
                                        Integer ambil = no_antrian.poll();
                                        // masukan data no antrian yang udah di proses ke riwayat no antrian
                                        antrian[l] = ambil;
                                        l++;
                                        System.out.println("Silahkan no antrian " + ambil);
                                        System.out.println("-------------------------------");
                                        System.out.println("silahkan pilih kelas tiket yang akan dibeli : ");
                                        System.out.println("1. Bisnis (50.000)");
                                        System.out.println("2. Ekonomi (20.000)");
                                        System.out.println("-------------------------------");
                                        System.out.println("pilihan : ");
                                        int jawaban_4 = inputan.nextInt();
                                        // milih tiket (binary tree dan stack) dan pengambilan no tiket
                                        switch (jawaban_4) {
                                            case 1:
                                                // array
                                                kelas[0] = "bisnis";
                                                System.out.println("-------------------------------");
                                                System.out.println("silahkan isi data berikut : ");
                                                System.out.println("1. nama : ");
                                                nama = inputan.next();
                                                System.out.println("2. umur : ");
                                                umur = inputan.nextInt();
                                                // add binary tree
                                                kereta.addNode(new Node(umur));
                                                System.out
                                                        .println("silahkan lakukan pembayaran " + harga_bisnis + " : ");
                                                System.out.println("-------------------------------");
                                                uang_bayar = inputan.nextInt();
                                                if (uang_bayar > harga_bisnis) {
                                                    kembalian = uang_bayar - harga_bisnis;
                                                    System.out.println(
                                                            "Terimakasih, kembalian anda adalah : " + kembalian);
                                                } else if (uang_bayar < harga_bisnis) {
                                                    System.out.println("Uang anda tidak cukup");
                                                    System.out.println("lakukan pembayaran lagi");
                                                    System.out
                                                            .println("silahkan lakukan pembayaran " + harga_bisnis
                                                                    + " : ");
                                                    uang_bayar = inputan.nextInt();
                                                } else if (uang_bayar == harga_bisnis) {
                                                    System.out.println("Terimakasih telah melakukan pembayaran");
                                                }
                                                // tampil tiket (ada stack)
                                                System.out.println(
                                                        "---------------------------------------------------------");
                                                System.out.println("Kereta Api \n");
                                                // pop pada data tiket bisnis
                                                System.out.println("NO TIKET : " + bisnis.pop() + "\n");
                                                System.out.println("\n");
                                                System.out.println("Nama : \t\t\t\t Tipe Penumpang : \n");
                                                System.out.println(nama + "\t\t\t\t " + kelas[0] + "\n");
                                                // pengisian data array ke riwayat tiket bisnis
                                                riwayat_bisnis[m] = nama;
                                                m++;
                                                System.out.println("-----------");
                                                System.out.println("Kereta : \n");
                                                System.out.println(nama_kereta + "\n");
                                                System.out.println("-----------");
                                                System.out.println("keberangkatan : \t\t Kedatangan : \n");
                                                System.out
                                                        .println(kota_keberangkatan + "\t\t\t\t " + kota_kedatangan
                                                                + "\n");
                                                System.out.println(
                                                        "---------------------------------------------------------");
                                                break;
                                            case 2:
                                                // array
                                                kelas[1] = "ekonomi";
                                                System.out.println("-------------------------------");
                                                System.out.println("silahkan isi data berikut : ");
                                                System.out.println("1. nama : ");
                                                nama = inputan.next();
                                                System.out.println("2. umur : ");
                                                umur = inputan.nextInt();
                                                // add binary tree
                                                kereta.addNode(new Node(umur));
                                                System.out.println(
                                                        "silahkan lakukan pembayaran " + harga_ekonomi + " : ");
                                                System.out.println("-------------------------------");
                                                uang_bayar = inputan.nextInt();
                                                if (uang_bayar > harga_ekonomi) {
                                                    kembalian = uang_bayar - harga_ekonomi;
                                                    System.out.println(
                                                            "Terimakasih, kembalian anda adalah : " + kembalian);
                                                } else if (uang_bayar < harga_ekonomi) {
                                                    System.out.println("Uang anda tidak cukup");
                                                    System.out.println("lakukan pembayaran lagi");
                                                    System.out.println(
                                                            "silahkan lakukan pembayaran " + harga_ekonomi + " : ");
                                                    uang_bayar = inputan.nextInt();
                                                } else if (uang_bayar == harga_ekonomi) {
                                                    System.out.println("Terimakasih telah melakukan pembayaran");
                                                }
                                                // tampil tiket (ada stack)
                                                System.out.println("-------------------------------");
                                                System.out.println("Kereta Api \n");
                                                // pop pada data tiket ekonomi
                                                System.out.println("NO TIKET : " + ekonomi.pop() + "\n");
                                                System.out.println("\n");
                                                System.out.println("Nama : \t\t\t\t Tipe Penumpang : \n");
                                                System.out.println(nama + "\t\t\t\t " + kelas[1] + "\n");
                                                // pengisian array ke riwayat tiket ekonomi
                                                riwayat_ekonomi[n] = nama;
                                                n++;
                                                System.out.println("-----------");
                                                System.out.println("Kereta : \n");
                                                System.out.println(nama_kereta + "\n");
                                                System.out.println("-----------");
                                                System.out.println("keberangkatan : \t\t Kedatangan : \n");
                                                System.out
                                                        .println(kota_keberangkatan + "\t\t\t\t " + kota_kedatangan
                                                                + "\n");
                                                System.out.println("-------------------------------");
                                                break;
                                            default:
                                                System.out.println("inputan salah");
                                                System.out.println("-------------------------------");
                                                break;

                                        }
                                    } else if (no_antrian.isEmpty() == true) {
                                        System.out.println("Pelanggan sudah dipanggil semua.");
                                    }
                                    System.out.println("Apakah ingin memanggil pelanggan berikutnya (true/false) : ");
                                    jawaban_5 = inputan.nextBoolean();
                                } while (jawaban_5);
                                break;
                            } else {
                                System.out
                                        .println("maaf anda tidak bisa melakukan pembelian tiket, tiket sudah habis!");
                                System.out
                                        .println("------------------------------------------------------------------");
                            }

                        case 2:
                            System.out.println("Pencarian data pada binary tree");
                            System.out.println("-------------------------------");
                            System.out.println("Data yang akan anda cari : ");
                            angka1 = inputan.nextInt();
                            // cari nilai dengan method searchvalue di class binaryTree
                            System.out.println("Hasil pencarian : " + binaryTree.searchValue(kereta.root, angka1));
                            System.out.println("-------------------------------");
                            break;

                        case 3:
                            // menampilkan data stack
                            if (bisnis == null && ekonomi == null) {
                                System.out.println("tiket sudah habis");
                            } else if (bisnis == null) {
                                System.out.println("tiket bisnis telah habis");
                                System.out.println("tiket ekonomi : " + ekonomi);
                            } else if (ekonomi == null) {
                                System.out.println("tiket ekonomi telah habis");
                                System.out.println("tiket bisnis : " + bisnis);
                            } else {
                                System.out.println("tiket bisnis : " + bisnis);
                                System.out.println("tiket ekonomi : " + ekonomi);
                            }
                            break;

                        case 4:
                            // menampilkan data array riwayat tiket
                            System.out.println("---------------------------");
                            System.out.println("Riwayat Bisnis");
                            System.out.println("--------------");
                            for (String b : riwayat_bisnis) {
                                System.out.println(b);
                            }
                            System.out.println("---------------------------");
                            System.out.println("Riwayat Ekonomi");
                            System.out.println("--------------");
                            for (String e : riwayat_ekonomi) {
                                System.out.println(e);
                            }
                            break;

                        case 5:
                            // keluar
                            System.exit(0);
                            break;
                        default:
                            System.out.println("inputan salah!");
                            break;
                    }
                    System.out.println("Apakah anda ingin menampilkan menu program kembali (true/false) : ");
                    jawaban_8 = inputan.nextBoolean();
                } while (jawaban_8);
            } else {
                System.out.println("inputan anda salah!!");
                System.exit(0);
            }
        }

    }
}
