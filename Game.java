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
                g.movePiece(convertCMDcoordinates(a[1]), convertCMDcoordinates(a[2]));
            }else if(a[0].equals("exit")){
                return;
            }
            draw();
        }
    }
    
    public static Vector2 convertCMDcoordinates(String cmd){
        char letter = cmd.charAt(0);
        if(letter > 73){
            letter = Character.toUpperCase(letter);
        }
        return new Vector2(((int)letter)-65, Integer.parseInt(cmd.substring(1))-1);
    }
    
    public void draw(){
    	Boolean flip;
    	if(g.getGameState().turn == Color.WHITE)
    		flip = false;
    	else
    		flip=true;

        //Prepare information
        String [] info = new String[8];
        
        //Fix turn and lists when turn system is ready
        info[0] = "  |Turn: " + (flip ? "Black": "White");
        info[1] = "  |You have captured:";
        info[2] = "  |" + (flip ? g.getGameState().lostBlack : g.getGameState().lostWhite);
        info[3] = "  |";
        info[4] = "  |You have lost:";
        info[5] = "  |" + (flip ? g.getGameState().lostWhite : g.getGameState().lostBlack);
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
                System.out.print("["+g.getGameState().board[x][y]+"]");
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