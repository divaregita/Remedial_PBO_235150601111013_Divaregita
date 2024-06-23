class Persik extends Tanaman implements Perawatan {
    public Persik() {
        super(180, 250, 15);
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
        perkembangan += 2.5;
    }

    @Override
    public String toString() {
        return "Persik - " + super.toString();
    }
}
