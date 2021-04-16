package okulYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {

    private List<Kisi> ogrenciListesi = new ArrayList<>();
    private List<Kisi> ogretmenListesi = new ArrayList<>();
    private String kisiTuru;

    public void anaMenu() {

        Scanner scan = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println(" OGRENCI VE OGRETMEN YONETIMI PANELI");
        System.out.println("=====================================");
        System.out.println("1- OGRENCI ISLEMLERI");
        System.out.println("2- OGRETMEN ISLEMLERI");
        System.out.println("Q- CIKIS");

        String secim = scan.nextLine().toUpperCase();

        if (secim.equals("Q")) {

            cikis();

        } else if (secim.equals("1")) {

            kisiTuru = "OGRENCI";
            islemMenusu();

        } else if (secim.equals("2")) {

            kisiTuru = "OGRETMEN";
            islemMenusu();

        } else {
            System.out.println("Hatali giris yaptiniz!");
            anaMenu();
        }

    }

    private void islemMenusu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("========== ISLEMLER ==========");
        System.out.println("1- EKLEME");
        System.out.println("2- ARAMA");
        System.out.println("3- LISTELEME");
        System.out.println("4- SILME");
        System.out.println("5- ANA MENU");
        System.out.println("Q- CIKIS\n");
        System.out.println("SECIMINIZ");

        String tercih = scan.nextLine().toUpperCase();

        switch (tercih) {
            case "1": ekle();
                break;
            /*
            case "2": ara();
                break;
            case "3": listele();
                break;
            case "4": sil();
                break;
                */
            case "5": anaMenu();
                break;
            case "Q": cikis();
                break;
            default:
                System.out.println("Hatali secim yaptiniz!");
                islemMenusu();
            break;
        }

    }

    public void cikis() {

        System.out.println("Programi kullandiginiz icin tesekkurler...");
    }

    private void ekle() {

        Scanner scan = new Scanner(System.in);
        System.out.println("---------- " + kisiTuru + " EKLEME SAYFASI ----------");
        System.out.println("Ad ve Soyad Giriniz:");
        String adSoyad = scan.nextLine();
        System.out.println("Kimlik Numarasi Giriniz:");
        String kimlikNo = scan.nextLine();
        System.out.println("Yas Giriniz:");
        int yas = scan.nextInt();

        if (kisiTuru.equals("OGRENCI")) {

            System.out.println("Ogrenci Numarasi Giriniz:");
            String numara = scan.next();
            System.out.println("Sinif Giriniz:");
            String sinif = scan.nextLine();

            Ogrenci ogrenci = new Ogrenci(adSoyad, kimlikNo, yas, numara, sinif);

            ogrenciListesi.add(ogrenci);

        } else if (kisiTuru.equals("OGRETMEN")) {

            System.out.println("Bolum Giriniz:");
            String bolum = scan.next();
            System.out.println("Sicil Numarasi Giriniz:");
            String sicilNo = scan.nextLine();

            Ogretmen ogretmen = new Ogretmen(adSoyad, kimlikNo, yas, bolum, sicilNo);

            ogretmenListesi.add(ogretmen);

        }

        islemMenusu();

    }

}
