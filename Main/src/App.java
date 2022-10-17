import services.matrixProcessing.MatrixManipulationService;
import services.ui.ConsolePrinterService;
import services.ui.interfaces.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<List<Integer>> screen = new ArrayList<>();
        int INITIAL_SIZE = 5;
        for (int i = 0; i < INITIAL_SIZE; i++) {
            Integer[] zeroes = new Integer[INITIAL_SIZE];
            Arrays.fill(zeroes, 0);
            screen.add(new ArrayList<>(Arrays.asList(zeroes)));
        }
        screen.get(1).set(0, 1);
        screen.get(2).set(0, 1);
        screen.get(3).set(0, 1);
//        screen.get(4).set(3, 1);
//        screen.get(1).set(4, 1);

        MatrixManipulationService matrixManipulationService = new MatrixManipulationService(INITIAL_SIZE);
        Printer printer=new ConsolePrinterService();
        printer.printScreen(screen);
        printer.cleanScreen();
        for (int i = 0; i < 100; i++) {
            System.out.println("iteration:"+ (i+1));
            screen = matrixManipulationService.expandBoundaries(screen);
            screen = matrixManipulationService.getNextScreenState(screen);
            printer.printScreen(screen);
            printer.cleanScreen();

        }
    }
}
