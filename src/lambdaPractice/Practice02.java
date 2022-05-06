package lambdaPractice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice02 {

    public static void main(String[] args) throws IOException {

        //TASK 01 --> kagan.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** kagan.txt dosyasini okuyunuz -->  ");

        Path kagan= Path.of("src/lambdaPractice/kagan.txt");
        Stream<String> akis=Files.lines(kagan);
        Files.lines(kagan).forEach(System.out::println);

        //2. Yol
        akis.forEach(System.out::println);

        //TASK 02 --> kagan.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** kagan.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/lambdaPractice/kagan.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> kagan.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** kagan.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");

        //1. Yol limit()
        Files.lines(kagan).
                map(String::toUpperCase).
                limit(1).
                forEach(System.out::println);

        //2.Yol findFirs()
        System.out.println(Files.lines(kagan).
                map(String::toLowerCase).
                findFirst());


        //TASK 04 --> kagan.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** kagan.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.lines(kagan).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());


        //TASK 05 --> kagan.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** kagan.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

        /*
        Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
        fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
        Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

        Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
        Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
        flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
        ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
 */
       //1. yol distinc()
        System.out.println(Files.lines(kagan).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                distinct().//Tekrarsiz yapti
                collect(Collectors.toList()));

        //2.Yol toSet()
        System.out.println(Files.lines(kagan).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                collect(Collectors.toSet()));


        //TASK 06 --> kagan.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** kagan.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");

        Files.lines(kagan).
                map(t-> t.split(" ")).//arraya atandi
                flatMap(Arrays::stream).//2D arrayler tek eleman olarak akisa alindi
                sorted().//Harf sirasi yapildi
                forEach(System.out::println);


        //TASK 07 --> kagan.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** kagan.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(kagan).
                map(t -> t.toLowerCase().split("")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());


        //TASK 08 --> kagan.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** kagan.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");

        System.out.println(Files.lines(kagan).//txt dosyasina erisildi
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).//hersatirdaki kelime akisa alindi
                count());


        //TASK 09 --> kagan.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** kagan.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");

        Files.lines(kagan).//txt dosyasina erisildi
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                collect(Collectors.toList()).forEach(System.out::println);

        //TASK 10 --> kagan.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** kagan.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(kagan).//txt dosyasina   erisildi
                map(t -> t.replaceAll("\\W", "").// W ifadesi a-z A-Z 0-9 disindakileri kapsar
                replaceAll("\\d", "").
                split("")).//harf akisi saglandi
                flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 11 --> kagan.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** kagan.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(kagan).
                map(t -> t.replaceAll("[.!,:)\\-]", "").

                        split(" ")).//kelime akısı saglanır
                        flatMap(Arrays::stream).
                distinct().
                count());
        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        Files.lines(kagan).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                flatMap(Arrays::stream).
                distinct().forEach(System.out::println);

    }
}