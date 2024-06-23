class Stroberi extends Tanaman implements Perawatan {
    public Stroberi() {
        super(60, 150, 35);
    }

    @Override
    public void berkembang() {
        if (status().equals("Hidup")) {
            lamaHidup++;
            prosesBerbuah += perkembangan;
            while (prosesBerbuah >= berbuah) {
                buah++;
                prosesBerbuah -= berbuah;
            }
        }
    }

    @Override
    public void treatment() {
        perkembangan += 5;
    }

    @Override
    public String toString() {
        return "Stroberi - " + super.toString();
    }
}
