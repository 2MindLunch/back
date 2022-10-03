import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private Random randomNumberGenerater = new Random();

    public int generateRandomNumber(){
        return randomNumberGenerater.nextInt(1,7);
    }

    public static void main(String[] args){
        int tryCount = 1000;
        int[] historyArray = new int[tryCount];
        int[] countArray = new int[6];
        AtomicInteger number = new AtomicInteger();
        Test test= new Test();

        for(int i=0; i<tryCount; ++i){
            historyArray[i] = test.generateRandomNumber();
        }

        for(int i: historyArray){
            ++ countArray[i-1];
        }

        System.out.println("기록: " + Arrays.toString(historyArray));
        Arrays.stream(countArray).forEach(x -> {System.out.println("숫자 "+ number.incrementAndGet() +": "+ x + "번");});
        System.out.println("시행횟수: " + Arrays.stream(countArray).sum() + "번");
    }
}
