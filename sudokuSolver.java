class sudokuSolver{

    static int[][] puzzle = {
        {3,0,0,0,2,0,0,7,0},
        {9,0,0,5,0,0,0,1,4},
        {0,1,6,3,7,0,0,0,8},
        {2,0,0,8,0,0,0,0,1},
        {5,0,0,0,4,1,8,0,0},
        {0,8,9,0,0,0,0,5,0},
        {0,0,5,0,1,0,2,8,0},
        {0,4,0,0,0,6,0,9,3},
        {7,3,1,0,8,2,0,0,0}
    };

    public static void main(String[] args) {
        System.out.println("WELCOME TO SUDOKU SOLVER !!!");   
        System.out.println("ORIGINAL PUZZLE:-");
        printPuzzle(puzzle);
        if(solvePuzzle(puzzle,0,0)){
            System.out.println("The Puzzle is Solved...");
            printPuzzle(puzzle);
        }
        else{
            System.out.println("The puzzle is not solved...");
        }
    }

    static boolean solvePuzzle(int[][] puzzle, int row, int col){

        if(col==9){
            if(row==8){
                return true;
            }
            row++;
            col = 0;
        }

        if(puzzle[row][col]>0){
            return solvePuzzle(puzzle, row, col+1);
        }

        for(int i=1; i<=9; i++){
            if(validMove(puzzle, row, col, i)){
                puzzle[row][col] = i;
                if(solvePuzzle(puzzle, row, col+1)){
                    return true;
                }
                puzzle[row][col] = 0;
            }
        }
        return false;
    }

    static boolean validMove(int[][] puzzle, int row, int col, int val){
        //checking row
        for(int j=0; j<9; j++){
            if(puzzle[row][j] == val){
                return false;
            }
        }

        //checking column
        for(int i=0; i<9; i++){
            if(puzzle[i][col]==val){
                return false;
            }
        }

        //checking for a 3X3 box
        int r = row - row%3;
        int c = col - col%3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
               if(puzzle[i+r][j+c]==val){
                return false;
                }
            }
        }

        return true;
    }
    
    static void printPuzzle(int[][] puzzle) {
        System.out.println("+-------+-------+-------+");
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("|-------+-------+-------|");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    System.out.print("| ");
                }
                if (puzzle[row][col] != 0) {
                    System.out.print(puzzle[row][col] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
}