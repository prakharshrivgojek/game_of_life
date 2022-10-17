package services.matrixProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixManipulationService {
    int initialSize;
    List<List<Integer>> screenDataCopy;
    public MatrixManipulationService(int size){
        this.initialSize=size;
        setInitialNeighbourState();
    }
    public void setInitialNeighbourState()
    {
        screenDataCopy=new ArrayList<>();
        for (int i = 0; i < initialSize; i++) {
            Integer[] tempArr =new Integer[initialSize];
            Arrays.fill(tempArr,0);
            screenDataCopy.add(new ArrayList<>(Arrays.asList(tempArr)));
        }

    }

    public List<List<Integer>> getNextState(List<List<Integer>> currentState){

        for (int i = 0; i < screenDataCopy.size(); i++) {
            for (int j = 0; j < screenDataCopy.get(i).size(); j++) {
                if (currentState.get(i).get(j) == 1) {

                    int left, top, right, down;
                    left = j - 1;
                    right = j + 1;
                    top = i-1;
                    down = i+1;
                    if (left >= 0)
                        screenDataCopy.get(i).set(left, screenDataCopy.get(i).get(left) + 1);

                    if (right < initialSize)
                        screenDataCopy.get(i).set(right, screenDataCopy.get(i).get(right) + 1);

                    if (top>= 0)
                        screenDataCopy.get(top).set(j, screenDataCopy.get(top).get(j) + 1);

                    if (down < initialSize)
                        screenDataCopy.get(down).set(j, screenDataCopy.get(down).get(j) + 1);

                    if (top >= 0 && left >=0)
                        screenDataCopy.get(top).set(left, screenDataCopy.get(top).get(left) + 1);

                    if (top >= 0 && right<initialSize)
                        screenDataCopy.get(top).set(right, screenDataCopy.get(top).get(right) + 1);

                    if (down < initialSize && left >=0)
                        screenDataCopy.get(down).set(left, screenDataCopy.get(down).get(left) + 1);

                    if (down < initialSize && right <initialSize)
                        screenDataCopy.get(down).set(right, screenDataCopy.get(down).get(right) + 1);
                }
            }
        }

        for(List<Integer> i:currentState)
            System.out.println(i);
        System.out.println("---------------------");
        for(List<Integer> i:screenDataCopy)
            System.out.println(i);
        return screenDataCopy;
    }

    public void updateCell(int row, int column){

    }

    public void setNewState(List<List<Integer>> currentState, List<List<Integer>> newState){

    }
}
