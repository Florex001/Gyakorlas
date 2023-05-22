package hu.katolikuskeri.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Kolcsonzes {

    private String nev;
    private Character jazon;
    private int eora;
    private int eperc;
    private int vora;
    private int vperc;

    public Kolcsonzes(String nev, Character jazon, int eora, int eperc, int vora, int vperc) {
        this.nev = nev;
        this.jazon = jazon;
        this.eora = eora;
        this.eperc = eperc;
        this.vora = vora;
        this.vperc = vperc;
    }

    public Kolcsonzes(String[] adat) {
        this(adat[0],
                adat[1].charAt(0),
                Integer.parseInt(adat[2]),
                Integer.parseInt(adat[3]),
                Integer.parseInt(adat[4]),
                Integer.parseInt(adat[5])
        );
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Character getJazon() {
        return jazon;
    }

    public void setJazon(Character jazon) {
        this.jazon = jazon;
    }

    public int getEora() {
        return eora;
    }

    public void setEora(int eora) {
        this.eora = eora;
    }

    public int getEperc() {
        return eperc;
    }

    public void setEperc(int eperc) {
        this.eperc = eperc;
    }

    public int getVora() {
        return vora;
    }

    public void setVora(int vora) {
        this.vora = vora;
    }

    public int getVperc() {
        return vperc;
    }

    public void setVperc(int vperc) {
        this.vperc = vperc;
    }

    @Override
    public String toString() {
        return "Kolcsonzes{" +
                "nev='" + nev + '\'' +
                ", jazon=" + jazon +
                ", eora=" + eora +
                ", eperc=" + eperc +
                ", vora=" + vora +
                ", vperc=" + vperc +
                '}';
    }

    public static ArrayList<Kolcsonzes> beolvas(String fajl){
        ArrayList<Kolcsonzes> kolcsonzes = new ArrayList<>();

        File file = new File(fajl);

        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adat = sor.split(";");
                Kolcsonzes tmp = new Kolcsonzes(adat);
                kolcsonzes.add(tmp);
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return kolcsonzes;
    }
}
