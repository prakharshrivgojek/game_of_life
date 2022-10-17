package services.ui.interfaces;

import java.util.List;

public interface Printer {
    public void printScreen(List<List<Integer>> screen);
    public void cleanScreen();
    }
