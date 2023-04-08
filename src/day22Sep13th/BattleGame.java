package day22Sep13th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattleGame {

    /**
     * A simple message that is displayed at the beginning of the game to let
     * the player know the dimensions of the battle grid. This string can
     * be used as: System.out.printf(GRID_SIZE_MSG, gridSize);
     */
    private static final String GRID_SIZE_MSG =
            "Welcome to exceptional Battleship game.%n"
                    + "The battle grid size is %d rows and columns.%n"
                    + "Guess the row and column of the ship.%n";

    /**
     * Error message to be displayed if the user enters an illegal row or
     * column value. This string can be used as:
     * System.out.printf(GRID_SIZE_MSG, gridSize);
     */
    private static final String ILLEGAL_LOCATION =
            "The row and column must be in the range 0 to %d%n";

    /**
     * A message to be displayed to the player when the correct row
     * and column were correctly guessed.
     */
    private static final String SUCCESS_MSG =
            "You guessed the correct location of the battleship!";

    /**
     * A simple prompt that is displayed to the user to enable them to play
     * the game.
     */
    private static final String INPUT_PROMPT =
            "Enter input [r<num>, c<num>, grid, quit]: ";

    /**
     * A simple message that is displayed to the user to show that the column
     * value guessed is valid. This string is used with System.out.printf.
     */
    private static final String COL_CORRECT_MSG =
            "The column value of %d is correct%n";

    /**
     * A simple message that is displayed to the user to show that the row
     * value guessed is valid. This string is used with System.out.printf.
     */
    private static final String ROW_CORRECT_MSG =
            "The row value of %d is correct%n";

    /**
     * The size of the grid size that is being used by the battle grid. This
     * value is update in the printGridSize method.
     */
    private static int gridSize = 1;

    /**
     * The row value previously guessed by the user.
     */
    private static int guessRow = 0;

    /**
     * The column value previous guessed by the user.
     */
    private static int guessCol = 0;

    // You may add additional class variables as you see fit.
    private static ArrayList<Integer> positions = new ArrayList<>();
    // You may add additional helper methods as needed.
    public static void printGridSize(BattleGrid bg) {
        int size = 1;
        while (true) {
            try {
                bg.guess(0, size++);
            } catch (BattleGrid.InvalidLocationException |
                    BattleGrid.InvalidRowException |
                    BattleGrid.InvalidColException ignored) {
            } catch (BattleGrid.IllegalLocationException e) {
                gridSize = size - 1;
                break;
            }
        }
    }
    public static void printSize(BattleGrid bg){
        int dim = 0;
        while (true) {
            try {
                dim++;
                bg.guess(0, dim);

            } catch (BattleGrid.InvalidRowException
                    | BattleGrid.InvalidColException
                    | BattleGrid.InvalidLocationException e) {
                // e.printStackTrace();
            }catch (BattleGrid.IllegalLocationException e) {
                gridSize = dim;
                break;
            }
        }

    }
    /**
     * This is the top-level method that is called by the BattleGrid to enable
     * the user to play the game of guessing the correct row & column where
     * a battleship has been randomly hidden.
     *
     * @param bg The battle grid (typically randomly generated) being used
     *           to play the game.
     */
    public static void play(BattleGrid bg) {
        printSize(bg);
        // Implement this method based on the project description
        System.out.printf(GRID_SIZE_MSG, gridSize);
        Scanner sc = new Scanner(System.in);
        while (!correct) {
            System.out.printf(INPUT_PROMPT);
            String line = sc.nextLine();
            if (line.equals("quit")) {
                break;
            } else if (line.equals("grid")) {
                printGrid();
            } else {
                processRowCol(line); // 处理 r5 c5 等数据

                processException(bg); // 处理返回结果
            }
        }
    }
    private static boolean correct = false;
    private static void processException(BattleGrid bg) {
        try {
            bg.guess(guessRow, guessCol);
            System.out.printf(SUCCESS_MSG);
            addGrid(guessRow, guessCol);
            correct = true;
        } catch (BattleGrid.InvalidLocationException e) {
            System.out.printf(e.getMessage() + "\n");
            addGrid(guessRow, guessCol);
        } catch (BattleGrid.InvalidRowException e) {
            System.out.printf(COL_CORRECT_MSG + e.getMessage() + "\n" , guessCol);
            addGrid(guessRow, guessCol);
        } catch (BattleGrid.InvalidColException e) {
            System.out.printf(ROW_CORRECT_MSG + e.getMessage() + "\n", guessRow);
            addGrid(guessRow, guessCol);
        } catch (BattleGrid.IllegalLocationException e) {
            System.out.printf(ILLEGAL_LOCATION, gridSize);
        }
    }

    private static void addGrid(int row, int col) {
        positions.add(row);
        positions.add(col);
    }

    // 处理行数和列数的方法
    private static void processRowCol(String line) {
        // ["c5" "r10"]
        String[] strings = line.split(" ");
        for (String string : strings) {
            if (string.charAt(0) == 'c') {
                guessCol = Integer.parseInt(string.substring(1));
            } else if (string.charAt(0) == 'r') {
                guessRow = Integer.parseInt(string.substring(1));
            }
        }
    }

    // 打印表格
    private static void printGrid() {
        char[][] grid = new char[gridSize][gridSize];
//        for (int i = 0 ; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                grid[i][j] = '.';
//            }
//        }
        for (char[] chars : grid) {
            for (char c : chars) {
                c = '.';
            }
        }
        for (char[] chars : grid) {
            Arrays.fill(chars, '.');
        }
        // [1,1,4,5,2,7,9,10] 0-7  8
        for (int i = 0; i < positions.size() - 1; i += 2) {
            int ii = positions.get(i);
            int jj = positions.get(i + 1);
            grid[ii][jj] = 'X';
        }

        for (char[] gridMap : grid) {
            for (char c : gridMap) {
                System.out.printf(String.valueOf(c));
            }
            System.out.printf("\n");
        }
    }
}
