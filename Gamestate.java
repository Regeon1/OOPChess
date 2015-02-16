 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

import java.util.ArrayList;

public class Gamestate implements PieceProperties{
 
    public Piece[][] board = new Piece[8][8];
    public ArrayList<Piece> lostWhite = new ArrayList<Piece>();
    public ArrayList<Piece> lostBlack = new ArrayList<Piece>();
    public Color turn;

    
    public Gamestate(Piece[][] board, ArrayList<Piece> lostWhite, 
            ArrayList<Piece> lostBlack, Color turn){
        this.board = board;
        this.lostWhite = lostWhite;
        this.lostBlack = lostBlack;
        this.turn = turn;
    }
}
