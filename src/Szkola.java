import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Szkola{

        static class Uczen {

            String imie;
            String nazwisko;
            private int[] oceny;
            int[] test()
            {
                Scanner skaner = new Scanner(System.in);

                System.out.println("Podaj ile ocen chcesz wpisać "); // Pobranie długości tablicy od użytkownika
                String liczbaOcen = skaner.nextLine(); // Przekształcamy (parsujemy) podaną wartość, która jest łańcuchem snaków (String) na liczbę typu int

                int dlTabeli = Integer.parseInt(liczbaOcen); // Tworzymy tabelę o zadanej długości

                oceny = new int[dlTabeli]; // Wędrujemy to tablicy wpisując do komórek kolejne liczby podawane przez użytkownika i - to numer bierzącej komórki

                for (int i=0; i<=oceny.length-1; i++){
                    System.out.println("Podaj "+(i+1)+" ocenę z "+dlTabeli);
                    String ocena = skaner.nextLine(); // wpisanie wartości do komórki i w tabeli "liczby"
                    oceny[i]=Integer.parseInt(ocena);
                }
                return oceny;
            }

            void print(int[] oceny) {
                for (int i = 0; i <= oceny.length-1; i++) {
                    System.out.println(i + " --- " + oceny[i]);
                }
            }

            int[] returnOceny(){
                    return oceny;
                }


            float srednia(){
                float wynik = 0;
                for (int i = 0; i <= (oceny.length - 1); i++) {
                    wynik+=oceny[i];
            }
            return wynik/oceny.length;
            }

            int najlepsza(){
                int najwieksza = oceny[0];
                for (int i = 0; i <= oceny.length - 1; i++){
                    if(oceny[i] > najwieksza)
                        najwieksza = oceny[i];
                }
                return najwieksza;
            }

            int najgorsza(){
                int najmniejsza = oceny[0];
                for (int i = 0; i <= oceny.length - 1; i++){
                    if(oceny[i] < najmniejsza)
                        najmniejsza = oceny[i];
                }
                return najmniejsza;
            }

        }


    public static void main(String[] args) throws IOException{

        Uczen u1 =  new Uczen();
        u1.imie = "Marcin";
        u1.nazwisko = "Krysiński";
        System.out.println(u1.imie);
        System.out.println(u1.nazwisko);

        Uczen oceny_u1 = new Uczen();
        oceny_u1.test();
        oceny_u1.print(oceny_u1.returnOceny());
        System.out.println("Srednia ocen " + u1.imie +" "+u1.nazwisko + " to: "+ oceny_u1.srednia());
        System.out.println("Najlepsza ocena " + u1.imie +" "+u1.nazwisko + " to: "+ oceny_u1.najlepsza());
        System.out.println("Najgorsza ocena " + u1.imie +" "+u1.nazwisko + " to: "+ oceny_u1.najgorsza());

        Uczen u2 =  new Uczen();
        u2.imie = "Kasia";
        u2.nazwisko = "Kowalska";
        System.out.println(u2.imie);
        System.out.println(u2.nazwisko);

        Uczen oceny_u2 = new Uczen();
        oceny_u2.test();
        oceny_u2.print(oceny_u2.returnOceny());
        System.out.println("Srednia ocen " + u2.imie +" "+u2.nazwisko + " to: "+ oceny_u2.srednia());
        System.out.println("Najlepsza ocena " + u2.imie +" "+u2.nazwisko + " to: "+ oceny_u2.najlepsza());
        System.out.println("Najgorsza ocena " + u2.imie +" "+u2.nazwisko + " to: "+ oceny_u2.najgorsza());

        PrintWriter out = new PrintWriter("uczniowie.txt");
        out.println(oceny_u1);
        out.close();
        Scanner in = new Scanner(Paths.get("uczniowie.txt"));
        //File file = new File("uczniowie.txt");
        //Scanner in = new Scanner(file);

        String oceny = in.nextLine();
        System.out.println(oceny);
    }
}


