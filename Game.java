 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


public class Game implements PieceColor{

    Piece[][] board = new Piece[8][8];
    
    public Game(){
        //Initialize the board
        for(int x = 0; x <= 7; x++){
            for(int y = 2; y <= 5; y++){
                board[x][y] = new EmptyPiece();
            }
        }
        //Initialize pawns
        for(int x = 0; x <= 7; x++){
            board[x][1] = new Pawn(Color.WHITE);
            board[x][6] = new Pawn(Color.BLACK);
        }
        //Initialize other pieces
        Color color = Color.WHITE;
        for(int i = 0; i <= 7; i+=7){
            board[0][i] = new Rook(color);
            board[1][i] = new Knight(color);
            board[2][i] = new Bishop(color);
            board[3][i] = new Queen(color);
            board[4][i] = new King(color);
            board[5][i] = new Bishop(color);
            board[6][i] = new Knight(color);
            board[7][i] = new Rook(color);
            color = Color.BLACK;
        }

    }
    
    public void draw(){
        //Print top of the board
        System.out.println("    A  B  C  D  E  F  G  H ");
        System.out.println("___________________________");
        System.out.println("");
        //Print pieces and boards sides
        for(int y = 0; y <= 7; y++){
            System.out.print((y+1) + "| "); // Letters to the left side
            for(int x = 0; x <= 7; x++){
                System.out.print("["+board[x][y]+"]");
            }
            System.out.println(" |" + (y+1)); // and right side
        }
        //Print lower part of the board
        System.out.println("___________________________");
        System.out.println("    A  B  C  D  E  F  G  H ");
    }
    
    public Boolean movePiece(Vector2 from, Vector2 to){
        //Check wheter the move is valid
        if(board[from.x][from.y].checkMove(from, to, board)){
            //Attack?
            //Move
            board[to.x][to.y] = board[from.x][from.y];
            board[from.x][from.y] = new EmptyPiece();
        }else{
            System.out.println("Error: Illegal move!");
        }
        return false;
    }
}