 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


import java.util.ArrayList;

public abstract class Gamemode implements PieceProperties{

    protected Piece[][] board = new Piece[8][8];
    protected ArrayList<Piece> lostWhite = new ArrayList<>();
    protected ArrayList<Piece> lostBlack = new ArrayList<>();
    
    protected Color turn = Color.WHITE;
    
    public abstract Boolean movePiece(Vector2 from, Vector2 to)
            throws IllegalMoveException, FalseTurnException;
    
    public Gamemode(){
        //Initialize the board
        for(int x = 0; x <= 7; x++){
            for(int y = 2; y <= 5; y++){
                board[x][y] = new EmptyPiece();
            }
        }
        //Initialize pawns
        for(int x = 0; x <= 7; x++){
            board[x][1] = new Pawn(PieceProperties.Color.WHITE);
            board[x][6] = new Pawn(PieceProperties.Color.BLACK);
        }
        //Initialize other pieces
        PieceProperties.Color color = PieceProperties.Color.WHITE;
        for(int i = 0; i <= 7; i+=7){
            board[0][i] = new Rook(color);
            board[1][i] = new Knight(color);
            board[2][i] = new Bishop(color);
            board[3][i] = new Queen(color);
            board[4][i] = new King(color);
            board[5][i] = new Bishop(color);
            board[6][i] = new Knight(color);
            board[7][i] = new Rook(color);
            color = PieceProperties.Color.BLACK;
        }
    }
    
    public Gamestate getGameState(){
        //Possible bug: Arraylists may be modified later, be careful...
        return new Gamestate(board.clone(), lostWhite, lostBlack, turn);
    } 
}
