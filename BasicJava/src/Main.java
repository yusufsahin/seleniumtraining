import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        int sayi = 10;
        System.out.println(sayi);
        double ondalik= 3.14;
        System.out.println(ondalik);

        char karakter='A';

        System.out.println(karakter);

        String metin= "Merhaba,Nasılsınız?";
        System.out.println(metin);

        System.out.println("Hello world!");

        Scanner scanner=new Scanner(System.in);
        System.out.println("Adinizi giriniz?");

        String ad= scanner.nextLine();
*/

//      System.out.println("Hello World, "+ad);


       /* Scanner scanner=new Scanner(System.in);
        System.out.println("Sayi giriniz?");

       // String ad= scanner.nextLine();
       // int sayi = 5;
        int sayi= scanner.nextInt();
        if (sayi > 0) {
            System.out.println("Sayı pozitiftir.");
        } else {
            System.out.println("Sayı negatif veya sıfırdır.");
        }
*/
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.println("Sayi giriniz?");

        int gun = scanner.nextInt();;

        switch (gun) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            default:
                System.out.println("Geçersiz gün");
                break;
        }
*/
/*
        int i = 1;

        while (i <= 0) {
            System.out.println(i);
            i++; // i=i+1;
        }
        */


/*
        int i = 1;

        do {
            System.out.println(i);
            i++;
        } while (i <0);*/
/*
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
*/
        /*
        int[] dizi = {1, 2, 3, 4, 5};

        for (int eleman : dizi) {
            System.out.println(eleman);
        }
*/
        /*
        List<String> liste = Arrays.asList("elma", "armut", "kiraz");

        for (String meyve : liste) {
            System.out.println(meyve);
        }
*/
/*
        int x = 5;
        int y = 3;
        int sonuc = toplama(x, y);
        System.out.println("Toplam: " + sonuc);
        isimsoyisim("john","doe");
        System.out.println();

        int sayi = 5;
        int sonuc2 = faktoriyel(sayi);
        System.out.println(sayi + " faktoriyel: " + sonuc2);

        Gunler gun= Gunler.CARSAMBA;

        System.out.println(gun);*/

        Student s1= new Student();
        s1.setId(1);
        s1.setAd("Jane");
        s1.setSoyad("Doe");

        System.out.println(s1.getId()+")"+s1.getAd()+" "+s1.getSoyad());

        Student s2= new Student(2,"Frank","Doe");

        System.out.println(s2.getId()+")"+s2.getAd()+" "+s2.getSoyad());

        System.out.println(s2.getAdSoyad());

    }

    public static int toplama(int sayi1, int sayi2) {
        int toplam = sayi1 + sayi2;
        return toplam;
    }

    public static void isimsoyisim(String isim, String soyisim) {
       System.out.println(isim+" " +soyisim);

    }

    public static int faktoriyel(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * faktoriyel(n - 1);
        }
    }

    public enum Gunler {
        PAZARTESI,
        SALI,
        CARSAMBA,
        PERSEMBE,
        CUMA,
        CUMARTESI,
        PAZAR
    }
}