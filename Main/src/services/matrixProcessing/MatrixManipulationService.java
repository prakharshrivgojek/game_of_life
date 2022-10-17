package services.matrixProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixManipulationService {
    int initialSize;
    List<List<Integer>> screenDataCopy;

    public MatrixManipulationService(int size) {
        this.initialSize = size;
        screenDataCopy = getZeroes2dList();
    }


    public List<List<Integer>> getZeroes2dList() {
        List<List<Integer>> temporaryZeroesList = new ArrayList<>();
        for (int i = 0; i < initialSize; i++) {
            Integer[] tempArr = new Integer[initialSize];
            Arrays.fill(tempArr, 0);
            temporaryZeroesList.add(new ArrayList<>(Arrays.asList(tempArr)));
        }
        return new ArrayList<>(temporaryZeroesList);
    }

    public void setScreenDataCopyToInitial() {
        screenDataCopy = getZeroes2dList();
    }

    public List<List<Integer>> getNextState(List<List<Integer>> currentState) {

        for (int i = 0; i < screenDataCopy.size(); i++) {
            for (int j = 0; j < screenDataCopy.get(i).size(); j++) {
                if (currentState.get(i).get(j) == 1) {

                    int left, top, right, down;
                    left = j - 1;
                    right = j + 1;
                    top = i - 1;
                    down = i + 1;
                    if (left >= 0)
                        screenDataCopy.get(i).set(left, screenDataCopy.get(i).get(left) + 1);

                    if (right < initialSize)
                        screenDataCopy.get(i).set(right, screenDataCopy.get(i).get(right) + 1);

                    if (top >= 0)
                        screenDataCopy.get(top).set(j, screenDataCopy.get(top).get(j) + 1);

                    if (down < initialSize)
                        screenDataCopy.get(down).set(j, screenDataCopy.get(down).get(j) + 1);

                    if (top >= 0 && left >= 0)
                        screenDataCopy.get(top).set(left, screenDataCopy.get(top).get(left) + 1);

                    if (top >= 0 && right < initialSize)
                        screenDataCopy.get(top).set(right, screenDataCopy.get(top).get(right) + 1);

                    if (down < initialSize && left >= 0)
                        screenDataCopy.get(down).set(left, screenDataCopy.get(down).get(left) + 1);

                    if (down < initialSize && right < initialSize)
                        screenDataCopy.get(down).set(right, screenDataCopy.get(down).get(right) + 1);
                }
            }
        }

//        for(List<Integer> i:currentState)
//            System.out.println(i);
//        System.out.println("---------------------");
//        for(List<Integer> i:screenDataCopy)
//            System.out.println(i);
        return screenDataCopy;
    }

    public List<List<Integer>> getNextScreenState(List<List<Integer>> currentState) {
        List<List<Integer>> neighbourState = getNextState(currentState);
        setScreenDataCopyToInitial();
        List<List<Integer>> newScreenState = getZeroes2dList();
        for (int i = 0; i < neighbourState.size(); i++) {
            for (int j = 0; j < neighbourState.get(i).size(); j++) {
                int element = neighbourState.get(i).get(j);
                if (element <= 1 || element >= 4)
                    newScreenState.get(i).set(j, 0);
                if (element == 2 && currentState.get(i).get(j) == 1)
                    newScreenState.get(i).set(j, 1);
                if (element == 3)
                    newScreenState.get(i).set(j, 1);
            }
        }
        return newScreenState;
    }

    public boolean getBoundaryExpansionFlag(List<List<Integer>> currentState) {
        for (int i = 0; i < initialSize; i++) {
            if (currentState.get(0).get(i) == 1 ||
                    currentState.get(i).get(0) == 1 ||
                    currentState.get(initialSize - 1).get(i) == 1 ||
                    currentState.get(i).get(initialSize - 1) == 1)
                return true;
        }
        return false;
    }

    public List<List<Integer>> expandBoundaries(List<List<Integer>> currentState) {
        boolean boundaryExpansionFlag = getBoundaryExpansionFlag(currentState);
        if (boundaryExpansionFlag) {
            this.initialSize = this.initialSize + 10;
            screenDataCopy = getZeroes2dList();
            return getExpandedCurrentState(currentState);
        } else
            return currentState;

    }

    public List<List<Integer>> getExpandedCurrentState(List<List<Integer>> currentState) {
        List<List<Integer>> currentStateCopy = getZeroes2dList();
        for (int i = 0; i < currentState.size(); i++) {
            for (int j = 0; j < currentState.get(0).size(); j++) {
                if (currentState.get(i).get(j) == 1)
                    currentStateCopy.get(i + 5).set(j + 5, currentState.get(i).get(j));
            }
        }
        return new ArrayList<>(currentStateCopy);
    }
}
