package services.ui;

import services.ui.interfaces.Printer;

import java.util.List;

public class ConsolePrinterService implements Printer {
    @Override
    public void printScreen(List<List<Integer>> screen) {
        try {
            for (List<Integer> i : screen) {
                for (int j : i) {
                    if(j==0)
                    System.out.print(" ");
                    else
                        System.out.print(1);
                }
                System.out.println();
            }
            Thread.sleep(400);
        }catch (Exception e){
            System.out.println("some exception occurred during runtime");
            e.printStackTrace();
        }

    }

    @Override
    public void cleanScreen() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("some exception occurred during runtime");
            e.printStackTrace();
        }
    }
}
