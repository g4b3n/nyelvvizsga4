import java.util.Arrays;

public class Vizsga {

    public String getNyelv() {
        return nyelv;
    }

    public Vizsga() {
    }

    public Vizsga(String nyelv, int[] sikeres, int[] sikertelen) {
        this.nyelv = nyelv;
        this.sikeres = sikeres;
        this.sikertelen = sikertelen;
    }

    public void setNyelv(String nyelv) {
        this.nyelv = nyelv;
    }

    public int[] getSikeres() {
        return sikeres;
    }

    public void setSikeres(int[] sikeres) {
        this.sikeres = sikeres;
    }

    public int[] getSikertelen() {
        return sikertelen;
    }

    public void setSikertelen(int[] sikertelen) {
        this.sikertelen = sikertelen;
    }

    private String nyelv;
    private int[] sikeres;
    private int[] sikertelen;

    @Override
    public String toString() {
        return "Vizsga{" +
                "nyelv='" + nyelv + '\'' +
                ", sikeres=" + Arrays.toString(sikeres) +
                ", sikertelen=" + Arrays.toString(sikertelen) +
                '}';
    }
}
