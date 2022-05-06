package lambdaPractice;

import java.util.stream.IntStream;

public class Practice01 {

    public static void main(String[] args) {

        System.out.println("TASK 01 struc -->"+ strucProgSum(10));
        System.out.println("TASK 01 func -->"+ funcProgSum(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + cifttopla(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + ilkPozCiftSayi(10));//2+4+6+...+18+20=110
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->"+ ilkPozTekSayi(10));//1+3+5+...17+19=10
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikiIlkXKuvveti(10);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenilenSayiIlkXKuvveti(4,3);
        System.out.println("   ***   ");
        istenilenSayiIlkXKuvveti(3,4);
        System.out.println("   ***   ");
        istenilenSayiIlkXKuvveti(1453,0);
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->" + istenenSayiFactorial(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + istenilenSayiXKuvveti(4,3));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured Programming

    public static int strucProgSum(int x ){

        int toplam=0;

        for (int i = 0; i <= x ; i++) {
            toplam+=i;
        }
        return toplam;
    }

    //Functional Programming

    public static int funcProgSum(int x){

       return IntStream.
               range(1,x+1).//baslangic dahil bitis haric
               sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int cifttopla(int x){

        return IntStream.
                rangeClosed(1,x).//baslanıc ve bitis dahil
                filter(day01.Lambda01::ciftBul).//ciftler bulundu
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkPozCiftSayi(int x){

       return IntStream.
               iterate(2,t-> t+2).//2 den baslayip sonsuza kadar arttırarak akisa alir 2,4,6,8...
               limit(x).//
               sum();
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int ilkPozTekSayi(int x){

        return IntStream.
                iterate(1,t->t+2).
                limit(x).
                sum();
    }


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikiIlkXKuvveti(int x ){
         IntStream.
                iterate(2,t-> t*2).// 2den sorna sonsuza kadar elemanlari 2 ile carpar
                limit(x).// girilen degerlde sinirlar
                forEach(day01.Lambda01::yazdir);
    }


    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenilenSayiIlkXKuvveti(int istenensayi ,int x ){
        IntStream.
                iterate(istenensayi,t-> t*istenensayi).// 2den sorna sonsuza kadar elemanlari 2 ile carpar
                limit(x).// girilen degerlde sinirlar
                forEach(day01.Lambda01::yazdir);
    }


    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenenSayiFactorial(int x){
        return IntStream.
                rangeClosed(1,x).
                //reduce(Math::multiplyExact).
                reduce(1,(t,u)-> t*u);
    }


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.

    public static int istenilenSayiXKuvveti(int istenilensayi , int x){

        return IntStream.
                iterate(istenilensayi, t-> t*istenilensayi).
                limit(x).
                reduce(0,(t,u)->u);
    }

}