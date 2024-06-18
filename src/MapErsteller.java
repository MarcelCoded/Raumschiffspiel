import java.util.Random;

public class MapErsteller {
    public static void main(String[] args) {
        Random random = new Random();
        double wahrscheinlichkeit = 0.01; // 1% Wahrscheinlichkeit
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 0 || i == 99 || j == 0 || j == 99) {
                    System.out.print("1 ");
                } else {
                    if (random.nextDouble() < wahrscheinlichkeit) {
                        int randomZahl = new Random().nextInt(2, 10);
                        System.out.print(randomZahl + " ");

                    } else {
                        System.out.print("0 ");
                    }
                }
            }
            System.out.println();
        }
    }
}
