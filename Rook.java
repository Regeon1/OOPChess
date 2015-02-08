 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class Rook extends Piece{
    Rook(Color color){
        //Set piece's color
        super(color);
    }
    
    public Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        if(board[to.x][to.y].getColor() == board[from.x][from.y].getColor())
            return false;
        if(from.x == to.x && from.y != to.y){
            for(int i = from.y + Vector2.sign(new Vector2(to.y, from.y));
                    Math.abs(i-to.y) > 0 ; i += Vector2.sign(new Vector2(to.y, from.y))){
                if(board[to.x][i].getColor() != Color.EMPTY)
                    return false;
            }
            return true;
        }
        if(from.y == to.y && from.x != to.x){
            for(int i = from.x + Vector2.sign(new Vector2(to.x, from.x));
                    Math.abs(i-to.x) > 0 ; i +=  + Vector2.sign(new Vector2(to.x, from.x))){
                if(board[i][to.y].getColor() != Color.EMPTY)
                    return false;
            }
            return true;
        }
        return false;
    }
    
    public String toString(){
        if(color == Color.WHITE) //Capital letters for white pieces
            return "R";
        else
            return "r";
    }
}
