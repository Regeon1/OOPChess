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
        board[0][0] = new Rook(Color.WHITE);
        board[1][0] = new Knight(Color.WHITE);
        board[2][0] = new Bishop(Color.WHITE);
        board[3][0] = new King(Color.WHITE);
        board[4][0] = new Queen(Color.WHITE);
        board[5][0] = new Bishop(Color.WHITE);
        board[6][0] = new Knight(Color.WHITE);
        board[7][0] = new Rook(Color.WHITE);
        
        board[0][7] = new Rook(Color.BLACK);
        board[1][7] = new Knight(Color.BLACK);
        board[2][7] = new Bishop(Color.BLACK);
        board[3][7] = new Queen(Color.BLACK);
        board[4][7] = new King(Color.BLACK);
        board[5][7] = new Bishop(Color.BLACK);
        board[6][7] = new Knight(Color.BLACK);
        board[7][7] = new Rook(Color.BLACK);

    }
    
    public void draw(){
        //Print top of the board
        System.out.println("   1  2  3  4  5  6  7  8  ");
        System.out.println("___________________________");
        System.out.println("");
        //Print pieces and boards sides
        for(int y = 0; y <= 7; y++){
            System.out.print((char)(65 + y) + "| "); // Letters to the left side
            for(int x = 0; x <= 7; x++){
                System.out.print("["+board[x][y]+"]");
            }
            System.out.println(" |" + (char)(65 + y)); // and right side
        }
        //Print lower part of the board
        System.out.println("___________________________");
        System.out.println("   1  2  3  4  5  6  7  8  ");
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