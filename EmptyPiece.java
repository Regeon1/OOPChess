 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


public class EmptyPiece extends Piece{
    EmptyPiece(){
        super(Color.WHITE);
    }
    
    Boolean checkMove(Vector2 from, Vector2 to, Piece[][] b){
        return false; //Can't move empty piece
    }
    
    public String toString(){
        return " ";
    }
}