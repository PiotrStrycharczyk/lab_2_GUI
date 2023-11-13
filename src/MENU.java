import java.util.Scanner;
public class MENU {
    public static void wywolanie() {
        while(true) {
            System.out.println("-----MENU-----");
            System.out.println("Podaj program jaki chcesz wywolac");
            System.out.println("Zad 1 [1]");
            System.out.println("Zad 2 [2]");
            System.out.println("Zad 3 [3]");
            System.out.println("Zad 4 [4]");
            System.out.println("Zad 5 [5]");
            System.out.println("Zad 6 [6]");
            Scanner scan = new Scanner(System.in);
            int wybor = scan.nextInt();
            if(wybor == 1){
                new zad_1().zad_1();
            } else if (wybor == 2) {
                new zad_2().zad_2();
            } else if (wybor == 3) {
                new zad_3().zad_3();
            } else if (wybor == 4) {
                new zad_4().zad_4();
            } else if (wybor == 5) {
                new zad_5().zad_5();
            } else if (wybor == 6) {
                new zad_6().zad_6();
            }
            else break;

        }
    }
}
