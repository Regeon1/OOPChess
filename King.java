 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class King extends Piece{
    
    King(Color color){
        //Set piece's color
        super(color);
    }
    
    public Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board){
        // Add something here ?
        return false;
    }
    
    public String toString(){
        if(color == Color.WHITE) //Capital letters for white pieces
            return "K";
        else
            return "k";
    }
}
