package services.matrixProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixManipulationService {
    int initialSize;
    int INCREASE_SIZE=10;

    List<List<Integer>> screenDataCopy;

    public MatrixManipulationService(int size) {
        this.initialSize = size;
        screenDataCopy = getZeroes2dListForInitialSize();
    }

    public List<List<Integer>> getZeroes2dListForInitialSize() {
        List<List<Integer>> temporaryZeroesList = new ArrayList<>();
        for (int i = 0; i < initialSize; i++) {
            Integer[] zeroes = new Integer[initialSize];
            Arrays.fill(zeroes, 0);
            temporaryZeroesList.add(new ArrayList<>(Arrays.asList(zeroes)));
        }
        return new ArrayList<>(temporaryZeroesList);
    }

    public void setScreenDataCopyToInitial() {
        this.screenDataCopy = getZeroes2dListForInitialSize();
    }

    public List<List<Integer>> getNextState(List<List<Integer>> currentState) {

        for (int i = 0; i < screenDataCopy.size(); i++) {
            for (int j = 0; j < screenDataCopy.get(i).size(); j++) {
                if (currentState.get(i).get(j) == 1) {
                    int directions[][]={{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
                    for(int k=0;k<directions.length;k++){
                        int row=i+directions[k][0];
                        int col=j+directions[k][1];
                        if(row>=0&&row<initialSize && col>=0&&col<initialSize)
                            screenDataCopy.get(row).set(col,screenDataCopy.get(row).get(col)+1);
                    }
                }
            }
        }

        return screenDataCopy;
    }

    public List<List<Integer>> getNextScreenState(List<List<Integer>> currentState) {
        List<List<Integer>> nextNeighbourState = getNextState(currentState);
        setScreenDataCopyToInitial();
        List<List<Integer>> newScreenState = getZeroes2dListForInitialSize();
        for (int row = 0; row < nextNeighbourState.size(); row++) {
            for (int col = 0; col < nextNeighbourState.get(row).size(); col++) {
                int element = nextNeighbourState.get(row).get(col);
                if (element <= 1 || element >= 4)
                    newScreenState.get(row).set(col, 0);
                if (element == 2 && currentState.get(row).get(col) == 1)
                    newScreenState.get(row).set(col, 1);
                if (element == 3)
                    newScreenState.get(row).set(col, 1);
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
            this.initialSize = this.initialSize + INCREASE_SIZE;
            screenDataCopy = getZeroes2dListForInitialSize();
            return getExpandedCurrentState(currentState);
        } else
            return currentState;

    }

    public List<List<Integer>> getExpandedCurrentState(List<List<Integer>> currentState) {
        List<List<Integer>> currentStateCopy = getZeroes2dListForInitialSize();
        for (int i = 0; i < currentState.size(); i++) {
            for (int j = 0; j < currentState.get(0).size(); j++) {
                if (currentState.get(i).get(j) == 1)
                    currentStateCopy.get(i + (INCREASE_SIZE/2)).set(j + (INCREASE_SIZE/2), currentState.get(i).get(j));
            }
        }
        return new ArrayList<>(currentStateCopy);
    }
}
