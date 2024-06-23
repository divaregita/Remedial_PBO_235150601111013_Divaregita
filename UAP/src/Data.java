import java.util.ArrayList;
import java.util.Scanner;

class Data {
    private static ArrayList<Tanaman> tanamans = new ArrayList<>();
    private static ArrayList<Integer> lokasi = new ArrayList<>();

    public static void mulai() {
        Scanner scanner = new Scanner(System.in);

        // Input masa tanam
        System.out.print("Masukkan masa tanam (dalam bulan): ");
        int bulan = scanner.nextInt();
        int hari = bulan * 30;

        // Menanam 3 tanaman di awal
        for (int i = 0; i < 3; i++) {
            menanam();
        }

        // Proses perkembangan tanaman
        for (int i = 0; i < hari; i++) {
            for (int j = 0; j < tanamans.size(); j++) {
                Tanaman t = tanamans.get(j);
                if (t.status().equals("Hidup")) {
                    t.berkembang();
                } else {
                    lokasi.add(j);
                }
            }

            // Perawatan setiap 90 hari
            if ((i + 1) % 90 == 0) {
                for (int k = 0; k < tanamans.size(); k++) {
                    if (!lokasi.contains(k)) {
                        ((Perawatan) tanamans.get(k)).treatment();
                    }
                }
            }

            // Menanam ulang tanaman mati
            for (int loc : lokasi) {
                menanam();
            }
            lokasi.clear();
        }
    }

    public static void menanam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih tanaman yang ingin ditanam:");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");

        int pilihan = scanner.nextInt();
        Tanaman tanaman = null;

        switch (pilihan) {
            case 1:
                tanaman = new Tomat();
                break;
            case 2:
                tanaman = new Stroberi();
                break;
            case 3:
                tanaman = new Persik();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        tanamans.add(tanaman);
        System.out.println("Berhasil menanam " + tanaman.getClass().getSimpleName());
    }

    public static void info() {
        for (int i = 0; i < tanamans.size(); i++) {
            System.out.println("Tanaman ke-" + (i + 1) + ": " + tanamans.get(i));
        }
    }
}
