package hu.katolikuskeri.taxifuvarok.gui.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Fuvar {

    private int taxi_id;
    private LocalDateTime indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetes_modja;

    public Fuvar(int taxi_id, LocalDateTime indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizetes_modja) {
        this.taxi_id = taxi_id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetes_modja = fizetes_modja;
    }

    public Fuvar(String[] adatok) {
        this(
                Integer.parseInt(adatok[0]),
                LocalDateTime.parse(adatok[1]),
                Integer.parseInt(adatok[2]),
                Double.parseDouble(adatok[3]),
                Double.parseDouble(adatok[4]),
                Double.parseDouble(adatok[5]),
                adatok[6]
        );
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public LocalDateTime getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public void setFizetes_modja(String fizetes_modja) {
        this.fizetes_modja = fizetes_modja;
    }

    @Override
    public String toString() {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formázott = indulas.format(FORMATTER);
        return String.format("%s (Taxi #%d)", formázott, taxi_id);
    }

    public static ArrayList<Fuvar> beolvas(String fájl){

        ArrayList<Fuvar> fuvars = new ArrayList<Fuvar>();

        File file = new File(fájl);

        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Fuvar tmp = new Fuvar(adatok);
                fuvars.add(tmp);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fuvars;
    }

}
