package com.company;

public class Sudoku_solver {
    public static void main(String[] args) {
        int[][] grid={ {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} }       ;
        if(solve(grid)){
            display(grid);
        }
    }
    static boolean solve(int[][] board){
        int row=-1;
        int col=-1;
        boolean emptyleft=true;
        for(int r=0;r< board.length;r++){
            for(int c=0;c< board.length;c++){
                if(board[r][c]==0){
                    row=r;
                    col=c;
                    emptyleft=false;
                    break;
                }
            }
            if(emptyleft==false){
                break;
            }
        }
        if(emptyleft==true){
            return true;
        }
        for(int num=1;num<10;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solve(board)){
                    return true;
                }else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    static void display(int[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] board,int row,int col,int num){
//        Check the row
        for(int i=0;i< board.length;i++){
            if(board[row][i]==num){
                return false;
            }
        }

//        Check the column
        for(int i=0;i< board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }

        int sqrt=(int)(Math.sqrt(board.length));
        int rowStart=row-row%sqrt;
        int colStart=col - col % sqrt;
        for(int r=rowStart;r<rowStart+sqrt;r++){
            for(int c=colStart;c<colStart+sqrt;c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
