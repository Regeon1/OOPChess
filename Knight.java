 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class Knight extends Piece{
    Knight(Color color){
        //Set piece's color
        super(Type.KNIGHT, color);
    }
    
    public Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        // 2 vertical and 1 horizontal
        if(Vector2.length(new Vector2(from.x, to.x)) == 2 && 
                Vector2.length(new Vector2(from.y, to.y)) == 1 &&
                board[to.x][to.y].getColor() != board[from.x][from.y].getColor()){
            return true;
        }
        // 2 horizontal and 1 vertical
        else if(Vector2.length(new Vector2(from.x, to.x)) == 1 && 
                Vector2.length(new Vector2(from.y, to.y)) == 2 &&
                board[to.x][to.y].getColor() != board[from.x][from.y].getColor()){
            return true;
        }
        return false;
    }
    
    public String toString(){
        if(color == Color.WHITE) //Capital letters for white pieces
            return "C";
        else
            return "c";
    }
}
