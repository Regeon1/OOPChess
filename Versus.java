 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2

public class Versus extends Gamemode implements PieceProperties{
    
    public Boolean movePiece(Vector2 from, Vector2 to) 
            throws IllegalMoveException, FalseTurnException {

    	//Check wheter the move is valid
        if(0 > from.x || from.x > 7 || 0 > from.y || from.y > 7 ||
                0 > to.x || to.x > 7 || 0 > to.y || to.y > 7 )
            return false;
        
        if(turn != board[from.x][from.y].getColor()){
        	throw(new FalseTurnException());
        }
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
                board[to.x == 6 ? 5:3][to.y] = board[to.x == 6 ? 7:0][to.y];
                board[to.x == 6 ? 7:0][to.y] = new EmptyPiece();
                //Normal move below moves the king
            }
            //Promotion
            if(board[from.x][from.y].getColor() == Color.WHITE && to.x == 1){
            	promotion = new Vector2(to.x, to.y);
            }
            if(board[from.x][from.y].getColor() == Color.BLACK && to.x == 8){
            	promotion = new Vector2(to.x, to.y);
            }

            //Normal move
            board[to.x][to.y] = board[from.x][from.y];
            board[from.x][from.y] = new EmptyPiece();

            //Changing turns
            if(turn == PieceProperties.Color.WHITE){
                turn = PieceProperties.Color.BLACK;
            }else{
            	turn = PieceProperties.Color.WHITE;
            }

        }else{
        	throw(new IllegalMoveException());
        }
        return false;
    }
}
