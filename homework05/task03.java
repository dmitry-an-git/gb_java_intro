

import java.util.LinkedList;
import java.util.Random;

// расставить 8 ферзей

// we generate a board full of queens
// we select 1 random queen
// she kills all other queens that are horisontal, vertical and diagonal
// we select another random queen from the remaining ones
// we kill more queens and so on, until we cant select any more queens
// depending on the random selections the final number of surviving queens can be lower than 8
// so we iterate until we get 8

public class task03 {
    public static void main(String[] args) {
        
        LinkedList<Integer[]> queens = new LinkedList<>();
        int counter = 0;

        while (queens.size()<8) {
            LinkedList<Integer[]> board = createBoard();
            queens.clear();

            while (board.size()>0) {
                Integer[] nextQuin = selectRandomQueen(board);
                queens.add(nextQuin);
                removeKills(board, nextQuin);
            }
            counter++;
        }  

        System.out.printf("%d iterations\n", counter);
        printBoard(queens);

    }

    public static LinkedList<Integer[]> createBoard() {
        LinkedList<Integer[]> board = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Integer[] coordinates = new Integer[]{i,j};
                board.add(coordinates);
            }
        }
        return board;
    }

    public static Integer[] selectRandomQueen(LinkedList<Integer[]> board){
        
        Random r = new Random();
        Integer[] coord = board.get(r.nextInt(0,board.size()));
        return coord;
    }
 
    public static void removeKills(LinkedList<Integer[]> board, Integer[] coord){
        
        Integer x0 = coord[0];
        Integer y0 = coord[1];
        Integer cell[];

        // remove horizontal:
        for (int i = 0; i < board.size(); i++) {
            cell = board.get(i);
            if (x0 == cell[0]) {
                board.remove(i);
                i--;
            }
        }

        // remove vertical:
        for (int i = 0; i < board.size(); i++) {
            cell = board.get(i);
            if (y0 == cell[1]) {
                board.remove(i);
                i--;  
            }
        }
            
        // remove positive diagonal
        for (int i = 0; i < board.size(); i++) {
            cell = board.get(i);
            if (cell[1]==cell[0]+(y0-x0)) {
                board.remove(i);
                i--;
            }
        }

        // remove negative diagonal
        for (int i = 0; i < board.size(); i++) {
            cell = board.get(i);
            if (cell[1]==(y0+x0) - cell[0]) {
                board.remove(i);
                i--;
            }
        }
    }
    

    public static void printBoard(LinkedList<Integer[]> queens){
        
        char[][] map = new char[8][8];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = '-';
            }
        }

        for (Integer[] coord : queens) {
            Integer x = coord[0];
            Integer y = coord[1];
            map[x][y] = 'X';
        }

        for (char[] row : map) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();

        }  
        System.out.println();
    }
}


// (0,0) - 0,Y, X,0, X=Y
// (2,1) - 2,Y, X,1, Y=X-3, Y=1-X


//    0 1 2 3 4 5 6 7
// ------------------
// 0  F 0 0 0 0 0 0 0
// 1  0 0 F 0 0 0 0 0
// 2  0 0 0 0 0 0 0 0
// 3  0 0 0 0 0 0 0 0
// 4  0 0 0 0 0 0 0 0
// 5  0 0 0 0 0 0 0 0
// 6  0 0 0 0 0 0 0 0
// 7  0 0 0 0 0 0 0 0

// REMOVE horizontal and vertical (all with x=x0 and y = y0)
// REMOVE diagonal - lines 
// 5;2 6;3 3;0 -> y-2 = x - 5; y = x+(2-5); y = x+(y0-x0)
// 5;2 7,0 -> y = 7-x = (y0+x0) - x

// ------------------ 
// 7  0 - 0 0 0 0 0 - 
// 6  0 - 0 0 0 0 - 0
// 5  0 - 0 0 0 - 0 0
// 4  0 - 0 0 - 0 0 0
// 3  0 - 0 - 0 0 0 0
// 2  0 - - 0 0 Y 0 0
// 1  - X - - Y - - -
// 0  - - 0 Y 0 0 0 0

//    0 1 2 3 4 5 6 7