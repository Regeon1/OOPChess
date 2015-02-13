 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class Bishop extends Piece{
    Bishop(Color color){
        //Set piece's color
        super(Type.BISHOP, color);
    }
    
    public Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        //Check wheter there is own piece at the target square
        if(board[to.x][to.y].getColor() == board[from.x][from.y].getColor())
            return false;
        //Check that the move is diagonal
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
            return "B";
        else
            return "b";
    }
}
