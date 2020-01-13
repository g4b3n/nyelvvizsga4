import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static int db = 0;
    public static ArrayList<Vizsga> adatok = new ArrayList<>();

    public static void main(String[] args) {

        Beolvas("sikeres.csv", "sikertelen.csv");
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
                int[] x= new int [sikeres.length-1];
                int[] y= new int [sikertelen.length-1];
                for (int i = 0; i <sikeres.length ; i++) {
                    x[i] = Integer.parseInt(sikeres[i]);
                    y[i] = Integer.parseInt(sikertelen[i]);
                }

                adatok.add(new Vizsga(sikeres[0],x,y));

            }


        } catch (IOException error) {
            System.out.println("Hiba az állomány beolvasása során!");
        }

    }
}





