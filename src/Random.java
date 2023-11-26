/**
public class Random {

    static void usingMathClass(int n) {
        //Vòng lặp in ra 5 số ngẫu nhiên
        for (int i=0; i<5; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * n + 1;
            int randomInt = (int) randomDouble;
            System.out.println("Random number is : " + randomInt);
        }
    }
}*/