 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

import java.util.ArrayList;

public class Gamestate implements PieceProperties{
 
    private final Piece[][] board;
    private final ArrayList<Piece> lostWhite;
    private final ArrayList<Piece> lostBlack;
    private final Color turn;
    private final Vector2 promotion;
    
    public Gamestate(Piece[][] board, ArrayList<Piece> lostWhite, 
            ArrayList<Piece> lostBlack, Color turn, Vector2 promotion){
        this.board = board;
        this.lostWhite = lostWhite;
        this.lostBlack = lostBlack;
        this.turn = turn;
        this.promotion = promotion;
    }
    
    public Piece[][] getBoard(){
        return board;
    }
    
    public ArrayList<Piece> getLostWhite(){
        return lostWhite;
    }
    
    public ArrayList<Piece> getLostBlack(){
        return lostBlack;
    }
    
    public Color getTurn(){
        return turn;
    }
    public Vector2 getPromotion(){
    	return promotion;
    }
    
}
