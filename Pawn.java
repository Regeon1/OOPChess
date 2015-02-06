// * This program is free software; you can redistribute it and/or
// * modify it under the terms of the GNU General Public License 2


public class Pawn extends Piece{
    Pawn(Color color){
        super(color);
    }
    
    Boolean checkMove(Vector2 to, Piece[][] board){
        //TODO: logic
        return true;
    }
    
    public String toString(){
        return "P";
    }
}