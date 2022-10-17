import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> screen = new ArrayList<>();
        int INITIAL_SIZE = 4;
        for (int i = 0; i < INITIAL_SIZE; i++) {
            screen.add(Collections.nCopies(INITIAL_SIZE, 0));
        }
        for (int i = 0; i < 10; i++) {

            System.out.println(screen);
            Thread.sleep(2000);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Thread.sleep(1000);
        }
    }
}
