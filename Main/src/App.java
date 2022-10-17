import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> screen = new ArrayList<>();
        List<List<Integer>> screenDataCopy = new ArrayList<>();
        int INITIAL_SIZE = 4;
        for (int i = 0; i < INITIAL_SIZE; i++) {
            Integer[] tempArr =new Integer[INITIAL_SIZE];
            Arrays.fill(tempArr,0);
            screen.add(new ArrayList<>(Arrays.asList(tempArr)));
            screenDataCopy.add(Arrays.asList(tempArr));
        }
        screen.get(1).set(1, 1);
        screen.get(1).set(2, 1);
        screen.get(2).set(1, 1);
        screen.get(3).set(0, 1);

//        for (int i = 0; i < 10; i++) {
//
//            System.out.println(screen);
//            Thread.sleep(2000);
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
//            Thread.sleep(1000);
//        }

        for (int i = 0; i < screenDataCopy.size(); i++) {
            for (int j = 0; j < screenDataCopy.get(i).size(); j++) {
                if (screen.get(i).get(j) == 1) {

                    int left, top, right, down;
                    left = j - 1;
                    right = j + 1;
                    top = i-1;
                    down = i+1;
                    if (left >= 0)
                        screenDataCopy.get(i).set(left, screenDataCopy.get(i).get(left) + 1);

                    if (right < INITIAL_SIZE)
                        screenDataCopy.get(i).set(right, screenDataCopy.get(i).get(right) + 1);

                    if (top>= 0)
                        screenDataCopy.get(top).set(j, screenDataCopy.get(top).get(j) + 1);

                    if (down < INITIAL_SIZE)
                        screenDataCopy.get(down).set(j, screenDataCopy.get(down).get(j) + 1);

                    if (top >= 0 && left >=0)
                        screenDataCopy.get(top).set(left, screenDataCopy.get(top).get(left) + 1);

                    if (top >= 0 && right<INITIAL_SIZE)
                        screenDataCopy.get(top).set(right, screenDataCopy.get(top).get(right) + 1);

                    if (down < INITIAL_SIZE && left >=0)
                        screenDataCopy.get(down).set(left, screenDataCopy.get(down).get(left) + 1);

                    if (down < INITIAL_SIZE && right <INITIAL_SIZE)
                        screenDataCopy.get(down).set(right, screenDataCopy.get(down).get(right) + 1);
                }
            }
        }
//        System.out.println(screenDataCopy);
        for(List<Integer> i:screen)
            System.out.println(i);
        System.out.println("---------------------");
        for(List<Integer> i:screenDataCopy)
            System.out.println(i);

    }
}
