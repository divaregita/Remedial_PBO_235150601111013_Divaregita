abstract class Tanaman {
    protected int masaHidup;
    protected int lamaHidup;
    protected double prosesBerbuah;
    protected double perkembangan;
    protected int buah;
    protected int berbuah;

    public Tanaman(int masaHidup, int berbuah, double perkembangan) {
        this.masaHidup = masaHidup;
        this.berbuah = berbuah;
        this.perkembangan = perkembangan;
        this.lamaHidup = 0;
        this.prosesBerbuah = 0;
        this.buah = 0;
    }

    public abstract void berkembang();

    public String status() {
        return lamaHidup >= masaHidup ? "Mati" : "Hidup";
    }

    @Override
    public String toString() {
        return "Masa Hidup: " + masaHidup + ", Umur: " + lamaHidup + ", Buah: " + buah + ", Status: " + status();
    }
}
