// * This program is free software; you can redistribute it and/or
// * modify it under the terms of the GNU General Public License 2


abstract class Piece implements PieceColor{
    Color color;
    abstract Boolean checkMove(Vector2 from, Vector2 to, Piece[][] board);
    Piece(Color color){
        this.color = color;
    }
}
