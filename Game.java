 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2
import java.util.Scanner;

public class Game implements PieceProperties{

    Gamemode g = new Versus();
    
    public Game() {
        Scanner in = new Scanner(System.in);
        draw();
        while(true){
            String cmd = in.nextLine();
            String[] a = cmd.split(" ");
            if((a[0].equals("move") || a[0].equals("mv")) && a.length == 3){
                try{
                    g.movePiece(convertCMDcoordinates(a[1]), convertCMDcoordinates(a[2]));
                }catch(IllegalMoveException ex){
                    System.out.println("Error: Illegal move!");
                }catch(FalseTurnException ex){
                    System.out.println("Error: False turn!");
                }
            }else if(a[0].equals("exit")){
                return;
            }
            if(g.getGameState().getPromotion() != null){
            	Vector2 to=g.getGameState().getPromotion();
            	System.out.println("What promotion? Set type.");
                System.out.println("Possible choices: rook, knight, bishop, queen");
            	Color promotionColor = (g.getGameState().getTurn() == Color.BLACK) ? 
                        Color.WHITE:Color.BLACK;
                while(true){
                    String type = in.nextLine();
                    if(type.equals("rook")){
                        Piece promotedPiece = new Rook(promotionColor);
                        g.makePromotion(to, promotedPiece);
                        break;
                    }else if(type.equals("knight")){
                        Piece promotedPiece = new Knight(promotionColor);
                        g.makePromotion(to, promotedPiece);
                        break;
                    }else if(type.equals("bishop")){
                        Piece promotedPiece = new Bishop(promotionColor);
                        g.makePromotion(to, promotedPiece);
                        break;
                    }else if(type.equals("queen")){
                        Piece promotedPiece = new Queen(promotionColor);
                        g.makePromotion(to, promotedPiece);
                        break;
                    }else{
                        System.out.println("Unknown piece, please try again.");
                    }
                }
                
            }
            draw();
        }
    }
    
    private static Vector2 convertCMDcoordinates(String cmd){
        char letter = cmd.charAt(0);
        if(letter > 73){
            letter = Character.toUpperCase(letter);
        }
        return new Vector2(((int)letter)-65, Integer.parseInt(cmd.substring(1))-1);
    }
    
    private void draw(){
    	Boolean flip;
        flip = g.getGameState().getTurn() != Color.WHITE;

        //Prepare information
        String [] info = new String[8];
      
        //Fix turn and lists when turn system is ready
        info[0] = "  |Turn: " + (flip ? "Black": "White");
        info[1] = "  |You have captured:";
        info[2] = "  |" + (flip ? g.getGameState().getLostWhite() : g.getGameState().getLostBlack());
        info[3] = "  |";
        info[4] = "  |You have lost:";
        info[5] = "  |" + (flip ? g.getGameState().getLostBlack() : g.getGameState().getLostWhite());
        info[6] = "  |";
        info[7] = "  |Time left:";
        
        //Print top of the board
        String files = "A  B  C  D  E  F  G  H";
        files = flip ? reverseString(files):files;
        System.out.println("    " + files + " ");
        System.out.println("___________________________");
        System.out.println("");
        //Print pieces and boards sides
        for(int y = flip ? 0 : 7;  (flip ? y <= 7 : y >= 0); y += flip ? 1 : -1){
            System.out.print((y+1) + "| "); // Letters to the left side
            for(int x = flip ? 7 : 0;  (flip ? x >= 0 : x <= 7); x += flip ? -1 : 1){
                System.out.print("[" + g.getGameState().getBoard()[x][y] + "]");
            }
            System.out.print(" |" + (y+1)); // and right side
            System.out.println(info[flip ? y:7-y]);
        }
        //Print lower part of the board
        System.out.println("___________________________");
        System.out.println("    " + files + " ");
    }
    
    private String reverseString(String str){
        String tmp = "";
        for(int i = str.length()-1; i >= 0; i--)
            tmp += ""+str.charAt(i);
        return tmp; 
    }
}