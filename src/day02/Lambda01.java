package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, -35, 20, 63, 21,-8, 38, 15));
    }

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.stream().filter(day01.Lambda01::ciftBul).map(t-> t*t).forEach(day01.Lambda01::yazdir);
    }
}
