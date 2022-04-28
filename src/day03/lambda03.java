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
        // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
        // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
        // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    }

}