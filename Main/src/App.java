import services.matrixProcessing.MatrixManipulationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> screen = new ArrayList<>();
        int INITIAL_SIZE = 4;
        for (int i = 0; i < INITIAL_SIZE; i++) {
            Integer[] tempArr =new Integer[INITIAL_SIZE];
            Arrays.fill(tempArr,0);
            screen.add(new ArrayList<>(Arrays.asList(tempArr)));
        }
        screen.get(1).set(1, 1);
        screen.get(1).set(2, 1);
        screen.get(2).set(1, 1);
        screen.get(3).set(0, 1);

        MatrixManipulationService matrixManipulationService=new MatrixManipulationService(INITIAL_SIZE);
        matrixManipulationService.getNextState(screen);

//        for (int i = 0; i < 10; i++) {
//
//            System.out.println(screen);
//            Thread.sleep(2000);
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
//            Thread.sleep(1000);
//        }


    }
}
