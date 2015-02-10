 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class Queen extends Piece{
    Queen(Color color){
        //Set piece's color
        super(color);
    }
    
    public Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        if(board[to.x][to.y].getColor() == board[from.x][from.y].getColor())
            return false;
        //Check wheter the move is vertical or horizontal
        //Same function is in rooks file: if you find bug, fix both
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
                    Math.abs(i-to.x) > 0 ; i += + Vector2.sign(new Vector2(to.x, from.x))){
                if(board[i][to.y].getColor() != Color.EMPTY)
                    return false;
            }
            return true;
        }
        //Check if move is diagonal
        //Same function is in bishops file: if you find bug, fix both
        if(Vector2.length(new Vector2(from.x, to.x)) == 
                Vector2.length(new Vector2(from.y, to.y))){
            //Check that there isn't any pieces on the path
            for(int i = 1; i < Vector2.length(new Vector2(from.y, to.y)); i++){
                if(board[from.x - i*Vector2.sign(new Vector2(from.x, to.x))]
                        [from.y - i*Vector2.sign(new Vector2(from.y, to.y))]
                        .getColor() != Color.EMPTY)
                    return false;
            }
            return true;
        }
        return false;
    }
    
    public String toString(){
        if(color == Color.WHITE) //Capital letters for white pieces
            return "Q";
        else
            return "q";
    }
}
