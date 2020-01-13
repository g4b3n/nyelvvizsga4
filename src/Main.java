import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int db = 0;
    public static ArrayList<Vizsga> adatok = new ArrayList<>();
    public int ev = 0;
    public static int[] vizsgaszam;
    public static String[] nyelvneve;

    public static void main(String[] args) {
        Beolvas("sikeres.csv", "sikertelen.csv");
        Nepszeru();
        System.out.println("3. feladat");
        System.out.println("Vizsgálandó év: " + evbe());
        legnagyobbSikertelen();
    }

    private static void legnagyobbSikertelen() {
        String az = "";
        int index;
        switch (ev) {
            case 2009:
                index = 0;
                break;
            case 2010:
                index = 1;
                break;
            case 2011:
                index = 2;
                break;
            case 2012:
                index = 3;
                break;
            case 2013:
                index = 4;
                break;
            case 2014:
                index = 5;
                break;
            case 2015:
                index = 6;
                break;
            case 2016:
                index = 7;
                break;
            case 2017:
                index = 8;
                break;
            case 2018:
                index = 9;
                break;
        }


    }

    private static int evbe() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Adjon meg egy évet: ");
            ev = sc.nextInt();
        } while (ev < 2008 || ev > 2019);
        return ev;
    }

    private static void Nepszeru() {
        vizsgaszam = new int[adatok.size()]; // Itt tároljuk összesítve a sikeres és sikertelen vizsgák számát, nyelvenként
        nyelvek = new String[adatok.size()];

        for (int i = 0; i < vizsgaszam.length; i++) { //Listában lévő adatokon megy végig - nyelveken megy végig
            int osszeg = 0;
            int sikeres[] = adatok.get(i).getSikeres();
            int sikertelen[] = adatok.get(i).getSikertelen();
            for (int j = 0; j < adatok.get(i).getSikeres().length; j++) { //éveken megy végig
                osszeg += adatok.get(i).getSikeres()[j];
            }
            vizsgaszam[i] = osszeg;
        }
        for (int i = 0; i < adatok.size(); i++) {
            nyelvek[i] = adatok.get(i).getNyelv();
        }
        for (int i = 0; i < adatok.size(); i++) {
            for (int j = 0; j < adatok.size(); j++) {
                if (vizsgaszam[i] > vizsgaszam[j]) {
                    int seged = vizsgaszam[i];
                    vizsgaszam[i] = vizsgaszam[j];
                    vizsgaszam[j] = seged;
                    String nev = nyelvek[i];
                    nyelvek[i] = nyelvek[j];
                    nyelvek[j] = nev;
                }
            }
        }
        for (int i = 0; i > adatok.size() - 3; i--) {
            System.out.println("\t" + nyelvek[i]);
        }
    }

    private static void Beolvas(String file1, String file2) {
        try {
            BufferedReader be1 = new BufferedReader(new FileReader(file1));
            BufferedReader be2 = new BufferedReader(new FileReader(file2));
            String sor1 = be1.readLine();
            String sor2 = be2.readLine();
            while ((sor1 = be1.readLine()) != null) {
                sor2 = be2.readLine();
                String[] sikeres = sor1.split(";");
                String[] sikertelen = sor2.split(";");
                int[] x = new int[sikeres.length - 1];
                int[] y = new int[sikertelen.length - 1];
                for (int i = 1; i < sikeres.length; i++) {
                    x[i - 1] = Integer.parseInt(sikeres[i]);
                    y[i - 1] = Integer.parseInt(sikertelen[i]);
                }
                adatok.add(new Vizsga(sikeres[0], x, y));
                //System.out.println(adatok.get(db)); //beolvasás ellenőrzése!
                db++;
            }
        } catch (IOException error) {
            System.out.println("Hiba az állomány beolvasása során!");
        }

    }
}





