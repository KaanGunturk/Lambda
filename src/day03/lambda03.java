package day03;

import java.util.*;

public class lambda03 {
    public static void main(String[] args) {
        List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokreç", "arabAşı", "güveç"));

        alfBuyukTekrarsiz(menü);
        System.out.println("\n   ***   ");
        karakterSayisiTersSirali(menü);
        System.out.println("\n   ***   ");
        karakterSayisiKucuktenSirala(menü);
        System.out.println("\n   ***   ");
        sonHarfTersSirala(menü);
        System.out.println("\n   ***   ");
        harfSayisiKontrol(menü);
        System.out.println("\n   ***   ");
        xIleBıtenKontrol(menü);
    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBuyukTekrarsiz(List<String> yemek) {

        yemek.stream().
                //map(t-> t.toUpperCase()). lambda exp.
                        map(String::toUpperCase). // Method reff.
                sorted().//siraladi
                distinct().// Benzsersiz(tekrarsiz) hale getirdi
                forEach(t -> System.out.print(t + " "));
        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterSayisiTersSirali(List<String> menu) {

        menu.
                stream().
                //map(t-> t.length()).
                        map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                //forEach(t-> System.out.print(t + " "));
                        forEach(day01.Lambda01::yazdir);
    }


    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void karakterSayisiKucuktenSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t -> System.out.print(t + " "));

    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfTersSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString(). //son harf
                        charAt(t.toString().length() - 1)).     //son harf
                        reversed()).
                forEach(t -> System.out.print(t + " "));

    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void charKaresiCiftElemenlariSirala(List<String> menu) {

        menu.
                stream().
                map(t -> t.length() * t.length()).
                filter(day01.Lambda01::ciftBul).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(day01.Lambda01::yazdir);
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisiKontrol(List<String> menu) {

        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);

        if (kontrol) {
            System.out.println("List elemanlari 7 ve daha az harften olusur");
        } else System.out.println("List elemanlari 7 harfte buyuk ");

        System.out.println("Clean codde");
        //Clean code
        System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harften olusur" : "List elemanlari 7 harfte buyukk");
    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanKontrol(List<String> menu) {
        System.out.println(menu.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek yoktur" : "w ile baslayan yemek vardir");
    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBıtenKontrol(List<String> menu) {
        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile baslayan yemek vardir" : "x ile baslayan yemek yoktur");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiBuyukEleman(List<String> menu) {
        menu.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                //findFirst();
                        limit(1);
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ılkElemanHaricPrint(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).//Son harfe gore siralama
                skip(1).
                forEach(t -> System.out.print(t + " "));
        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.


    }
}