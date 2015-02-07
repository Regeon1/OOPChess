 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


public class Game implements PieceColor{

    Piece[][] board = new Piece[8][8];
    
    public Game(){
        for(int x = 0; x <= 7; x++){
            for(int y = 0; y <= 7; y++){
                board[x][y] = new EmptyPiece();
            }
        }
        board[1][0] = new Pawn(Color.WHITE);
        board[0][3] = new Pawn(Color.BLACK);
    }
    
    public void draw(){
        for(int y = 0; y <= 7; y++){
            for(int x = 0; x <= 7; x++){
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
    
    public Boolean movePiece(Vector2 from, Vector2 to){
        //Check wheter the move is valid
        if(board[from.x][from.y].checkMove(from, to, board)){
            //Attack?
            //Move
            board[to.x][to.y] = board[from.x][from.y];
            board[from.x][from.y] = new EmptyPiece();
        }
        return false;
    }
}