 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class King extends Piece{
    
    
    
    King(Color color){
        //Set piece's color
        super(Type.KING, color);
    }
    
    public Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        //Check normal moves
        if(Vector2.length(new Vector2(from.x, to.x)) <= 1 && 
                Vector2.length(new Vector2(from.y, to.y)) <= 1 &&
                board[to.x][to.y].getColor() != board[from.x][from.y].getColor()){
            moved = true;
            return true;
        }
        
        //Check castling, toward H
        //Check wheter from/to are correct
        if(from.x == 4 && from.y == (color == Color.WHITE ? 0:7) &&
                to.x == 6 && to.y == (color == Color.WHITE ? 0:7) &&
                //Check that neither these pieces aren't moved
                !this.isMoved() && !board[to.x][to.y].isMoved() &&
                //Check that the other piece is rook
                board[7][to.y].getType() == Type.ROOK &&
                //Check that squares between king and rook are empty
                board[5][to.y].getType() == Type.EMPTY &&
                board[6][to.y].getType() == Type.EMPTY){
            
            moved = true;
            return true;
        }
        
        //Check castling, toward the A
        //Check wheter from/to are correct
        if(from.x == 4 && from.y == (color == Color.WHITE ? 0:7) &&
                to.x == 2 && to.y == (color == Color.WHITE ? 0:7) &&
                //Check that neither these pieces aren't moved
                !this.isMoved() && !board[to.x][to.y].isMoved() &&
                //Check that the other piece is rook
                board[0][to.y].getType() == Type.ROOK &&
                //Check that squares between king and rook are empty
                board[3][to.y].getType() == Type.EMPTY &&
                board[2][to.y].getType() == Type.EMPTY &&
                board[1][to.y].getType() == Type.EMPTY){
            
            moved = true;
            return true;
        }
        return false;
    }
    
    public String toString(){
        if(color == Color.WHITE) //Capital letters for white pieces
            return "K";
        else
            return "k";
    }
}
