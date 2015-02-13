 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class Versus extends Gamemode implements PieceProperties{
    
    public Boolean movePiece(Vector2 from, Vector2 to){
        //Check wheter the move is valid
        if(0 > from.x || from.x > 7 || 0 > from.y || from.y > 7 ||
                0 > to.x || to.x > 7 || 0 > to.y || to.y > 7 )
            return false;
        //Check wheter the move is legal

        if(board[from.x][from.y].checkMove(from, to, board)){
            //Attack
            if(board[to.x][to.y].getColor()==PieceProperties.Color.WHITE)
        	lostWhite.add(board[to.x][to.y]);

            if(board[to.x][to.y].getColor()==PieceProperties.Color.BLACK)
        	lostBlack.add(board[to.x][to.y]);


            //Identify castling
            if(board[from.x][from.y].getType() == Type.KING && 
                    Vector2.length(from) > 2){
                //Move rook
                System.out.println("Moving rook!");
                board[to.x == 6 ? 5:3][to.y] = board[to.x == 6 ? 7:0][to.y];
                board[to.x == 6 ? 7:0][to.y] = new EmptyPiece();
                //Normal move below moves the king
            }
            
            //Normal move
            board[to.x][to.y] = board[from.x][from.y];
            board[from.x][from.y] = new EmptyPiece();

        }else{
            System.out.println("Error: Illegal move!");
        }
        return false;
    }
}
