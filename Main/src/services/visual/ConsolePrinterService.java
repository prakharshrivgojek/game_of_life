package services.visual;

import services.visual.interfaces.Printer;

import java.util.List;

public class ConsolePrinterService implements Printer {

    public static void printScreen(List<List<Integer>> screen) {
        for (List<Integer> i : screen) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void cleanScreen() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
//            Thread.sleep(200);
        } catch (Exception e) {
            System.out.println("some exception occurred during runtime");
            e.printStackTrace();
        }
    }
}
