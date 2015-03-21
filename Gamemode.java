 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


import java.util.ArrayList;

public abstract class Gamemode implements PieceProperties{

    protected Piece[][] board = new Piece[8][8];
    protected ArrayList<Piece> lostWhite = new ArrayList<>();
    protected ArrayList<Piece> lostBlack = new ArrayList<>();
    protected Color turn = Color.WHITE;
    protected Vector2 promotion;
    protected Boolean check = false;
    
    public abstract Boolean movePiece(Vector2 from, Vector2 to)
            throws IllegalMoveException, FalseTurnException, 
            CheckMateException, DrawException;
    
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
        return new Gamestate(board.clone(), lostWhite, lostBlack, turn, promotion, check);
    }
    public void makePromotion(Vector2 to, Piece promoted){
    	board[to.x][to.y] = promoted; 
    	promotion=null;
    }

    public Boolean isThreated(Vector2 coordinates, Color byWho){
        for(int x = 0; x <= 7; x++){
            for(int y = 0; y <= 7; y++){
                if(board[x][y].getColor() == byWho){
                    if(board[x][y].checkMove(new Vector2(x, y), coordinates, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Boolean isCheck(Color byWho){
        for(int x = 0; x <= 7; x++){
            for(int y = 0; y <= 7; y++){
                if(board[x][y].getType() == Type.KING && board[x][y].getColor() == 
                        (byWho == Color.WHITE?Color.BLACK:Color.WHITE)){
                    return isThreated(new Vector2(x, y), byWho);
                }
            }
        }
        return false;
    }
    
    public Boolean isDraw(Color byWho){
        for(int x = 0; x <= 7; x++){
            for(int y = 0; y <= 7; y++){
                if(board[x][y].getType() == Type.KING && board[x][y].getColor() == 
                        (byWho == Color.WHITE?Color.BLACK:Color.WHITE)){
                    Boolean draw = true;
                    for(int a = (x > 0)?-1:0; a <= ((x < 7)?1:0); a++){
                        for(int b = (y > 0)?-1:0; b <= ((y < 7)?1:0); b++){
                            if((!isThreated(new Vector2(x+a, y+b), byWho) &&
                                board[x+a][y+b].getType() == Type.EMPTY)&& 
                                    (a != 0 && b != 0))
                                draw = false;
                        }
                    }
                    return draw;
                }
            }
        }
        return false; 
    }
}
