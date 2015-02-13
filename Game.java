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
        //Print top of the board
        System.out.println("    A  B  C  D  E  F  G  H ");
        System.out.println("___________________________");
        System.out.println("");
        //Print pieces and boards sides
        for(int y = 0; y <= 7; y++){
            System.out.print((y+1) + "| "); // Letters to the left side
            for(int x = 0; x <= 7; x++){
                System.out.print("["+g.getGameState().board[x][y]+"]");
            }
            System.out.println(" |" + (y+1)); // and right side
        }
        //Print lower part of the board
        System.out.println("___________________________");
        System.out.println("    A  B  C  D  E  F  G  H ");
    }
}