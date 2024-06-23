class Tomat extends Tanaman implements Perawatan {
    public Tomat() {
        super(100, 100, 25);
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
        return "Tomat - " + super.toString();
    }
}
