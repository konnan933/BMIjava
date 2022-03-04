package bmi_index;
import java.util.Scanner;
public class Bmi_index {

    public static void main(String[] args) {
        kiir("BMI index kiszámolása");
        int tomeg = beker("Testtömeg (kg) [40; 150]", 40, 150);
        int mag = beker("Testmagasság (cm) [100; 200]", 100, 200);
        double bmiIndex = bmi(tomeg, mag);
        ertekeles(tomeg, mag, bmiIndex);
    }

    private static void kiir(String szoveg) {
        System.out.println(szoveg);
    }

    private static int beker(String szoveg, int tol, int ig) {
        Scanner scan = new Scanner(System.in);
        boolean jo = false;
        String beAdat;
        int szam = 0;

        do {
            System.out.println(szoveg);
            beAdat = scan.nextLine();
            try {
                szam = Integer.parseInt(beAdat);
                if (tol <= szam && szam <= ig) {
                    jo = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NEM megfelelő adatot adott meg!");
            }
        } while (!jo);

        return szam;
    }

    private static double bmi(int tomeg, int mag) {
        return tomeg / (Math.pow((mag / 100.0), 2));
    }

    private static void ertekeles(int tomeg, int mag, double bmiIndex) {
        String testalkat;
        String[] testalkatok = {"sovány", "normál", "túlsúlyos", "kórosan túlsúlyos"};
        double[] hatarok = {18.4, 24.9, 29.9};
        int i = 0;
        int hossz = hatarok.length;
        while (i < hossz && !(bmiIndex <= hatarok[i])) {
            i++;
        }
        testalkat = testalkatok[i];
        System.out.printf("Ön %d cm magas és %d kg tömegü, "
                + "az ön BMI indexe %.1f , "
                + "Tehát ön %s testalkatú\n", mag, tomeg, bmiIndex, testalkat);

    }
}

}
