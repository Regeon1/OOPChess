// * This program is free software; you can redistribute it and/or
// * modify it under the terms of the GNU General Public License 2


public class Pawn extends Piece{
    Pawn(Color color){
        //Set piece's color
        super(color);
    }
    //Check wheter the move is legal
    Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        if(color == Color.WHITE){
            //Normal move forward
            if(to.y == from.y + 1 && to.x == from.x)
                return true;
            //2 forward from start position
            if(to.y == from.y + 2 && to.x == from.x && from.y == 1)
                return true;
            //Attack moves
            if(to.y == from.y + 1 && Math.abs(to.x - from.x) == 1 && 
                    board[to.x][to.y].color == Color.BLACK)
                return true;
        }else if(color == Color.BLACK){
            //Normal move forward
            if(to.y == from.y - 1 && to.x == from.x)
                return true;
            //2 forward from start position
            if(to.y == from.y - 2 && to.x == from.x && from.y == 6)
                return true;
            //Attack moves
            if(to.y == from.y - 1 && Math.abs(to.x - from.x) == 1 && 
                    board[to.x][to.y].color == Color.WHITE)
                return true;
        }
        return false;
    }
    
    public String toString(){
        if(color == Color.WHITE) //Capital letters for white pieces
            return "P";
        else
            return "p";
    }
}