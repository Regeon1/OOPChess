// * This program is free software; you can redistribute it and/or
// * modify it under the terms of the GNU General Public License 2


abstract class Piece implements PieceProperties{
    protected final Color color;
    protected final Type type;
    abstract Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board);
    Piece(Type type, Color color){
        this.type = type;
        this.color = color;
    }
    
    Color getColor(){
        return color;
    }
    
    Type getType(){
        return type;
    }
}