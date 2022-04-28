package day02;

import java.util.*;

public class Lambda01 {
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2, 6, 11, -5, 7, 3, 21,15));

        ciftKarePrint(sayi); // 16 4 36
        System.out.println("\n   ***   ");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n   ***   ");
        ciftKareKokPrint(sayi);
        System.out.println("\n   ***   ");
        maxElBul(sayi);
        System.out.println("\n   ***   ");
        ciftKareMaxBul(sayi);
        System.out.println("\n   ***   ");
        elTopla(sayi);
        System.out.println("\n   ***   ");
        ciftCarp(sayi);
        System.out.println("\n   ***   ");
        minBul(sayi);
        System.out.println("\n   ***   ");
        bestenBuyukEnKucuk(sayi);
        System.out.println("\n   ***   ");
        ciftKareKucuktenBuyuge(sayi);
        System.out.println("\n   ***   ");
        tekKareKucuktenBuyuge(sayi);
    }

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.stream().filter(day01.Lambda01::ciftBul).map(t-> t*t).forEach(day01.Lambda01::yazdir);
        //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin

    public static void tekKupBirFazlaPrint(List<Integer> sayi ){
        sayi.stream().filter(t-> t%2!=0).map(t->(t*t*t)+1).forEach(day01.Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokPrint(List<Integer> sayi ){
        sayi.stream().filter(day01.Lambda01::ciftBul).map(Math::sqrt).forEach(t-> System.out.print(t+" "));
    }

    // Task : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi){
       Optional<Integer> maxSayi= sayi.stream().reduce(Math::max);
       //Risk gordugu zaman Optional donuyor

        System.out.println(maxSayi);

        System.out.println(sayi.stream().reduce(Math::max));
        /*
         reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
         kullanımı yaygındır pratiktir.
         Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
         bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
         reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
         reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
         İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

         */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareMaxBul(List<Integer> sayi){

        System.out.println(sayi.stream().filter(day01.Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));

    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...

    public static void elTopla(List<Integer> sayi){

       int toplam= sayi.stream().reduce(0,(a,b)->a+b); //Lambda expression
        /*
        a ilk degerini her zaman atanan degerden (identity) alır
        b degerini her zamana  stream()'dan akısdan alır
        a ilk degerinden sonraki her değeri action(işlem)'dan alır


       */

        System.out.println(toplam);

        System.out.println(sayi.stream().reduce(Integer::sum)); // method reff
    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi){
        sayi.stream().filter(day01.Lambda01::ciftBul).reduce(Math::multiplyExact); //Method referans

        sayi.stream().filter(day01.Lambda01::ciftBul).reduce(1,(a,b)->(a*b)); //Lamda expression
    }
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.

    public static void minBul(List<Integer> sayi){

        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayi= sayi.stream().reduce(Integer::min);
        System.out.println(minSayi);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath=sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);
        //3. yontem Lambda Expression
        int minSayiLambda = sayi.stream().reduce(Integer.MAX_VALUE,(x,y) -> x<y ? x : y);
        System.out.println(minSayiLambda);
        //4. yontem Method Reference -->  class
        Optional<Integer> minSayiKagan=sayi.stream().reduce(Lambda01::byKagan);
        System.out.println(minSayiKagan);
    }
        public static int byKagan(int a, int b ){
        return a<b?a:b;
        }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukEnKucuk(List<Integer> sayi){
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda01::byKagan));
    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKucuktenBuyuge(List<Integer> sayi){
        sayi.stream().
                filter(day01.Lambda01::ciftBul).
                map(t-> t*t).
                sorted().// siralama icin
                forEach(day01.Lambda01::yazdir);
    }


    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void tekKareKucuktenBuyuge(List<Integer> sayi){
        sayi.stream().
                filter(t-> t%2==1).
                map(t-> t*t).
                sorted(Comparator.reverseOrder()). // tersten siralama
                forEach(day01.Lambda01::yazdir);
    }


}
