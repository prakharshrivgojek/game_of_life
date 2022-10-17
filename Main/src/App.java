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
        System.out.println(screen);
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
                    top = i;
                    down = i;
                    System.out.println(i+","+j);
                    if (left >= 0)
                        screenDataCopy.get(i).set(left, screenDataCopy.get(i).get(left) + 1);
                    System.out.println(screen+"\t\t"+screenDataCopy);
                    System.out.println();
                    if (right < INITIAL_SIZE)
                        screenDataCopy.get(i).set(right, screenDataCopy.get(i).get(right) + 1);
                    System.out.println(screen+"\t\t"+screenDataCopy);
                    System.out.println();
                    if (i-1 >= 0)
                        screenDataCopy.get(i-1).set(top, screenDataCopy.get(i-1).get(top) + 1);
                    System.out.println(screen+"\t\t"+screenDataCopy);
                    System.out.println();
                    if (i+1 < INITIAL_SIZE)
                        screenDataCopy.get(i+1).set(down, screenDataCopy.get(i+1).get(down) + 1);
                    System.out.println(screen+"\t\t"+screenDataCopy);
                    System.out.println("---------------------------------------------------");


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
