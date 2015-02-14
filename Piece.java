// * This program is free software; you can redistribute it and/or
// * modify it under the terms of the GNU General Public License 2


abstract class Piece implements PieceProperties{
    protected final Color color;
    protected final Type type;
    Boolean moved; //This is used to chech castling move, only KING and ROOK
                    //have this feature. If other pieces need this, add it.
    
    abstract Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board);
    Piece(Type type, Color color){
        moved = false;
        this.type = type;
        this.color = color;
    }
    
    Color getColor(){
        return color;
    }
    
    Type getType(){
        return type;
    }
    
    Boolean isMoved(){
        return moved;
    }
}