// * This program is free software; you can redistribute it and/or
// * modify it under the terms of the GNU General Public License 2

import java.util.Scanner;

public class ChessServer {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game g = new Game();
        
        g.draw();
        while(true){
            String cmd = in.nextLine();
            String[] a = cmd.split(" ");
            if(a[0].equals("move")){
                g.movePiece(convertCMDcoordinates(a[1]), convertCMDcoordinates(a[2]));
            }else if(a[0].equals("exit")){
                return;
            }
            g.draw();
        }
    }
    
    public static Vector2 convertCMDcoordinates(String cmd){
        char letter = cmd.charAt(0);
        if(letter > 73){
            letter = Character.toUpperCase(letter);
        }
        return new Vector2(((int)letter)-65, Integer.parseInt(cmd.substring(1))-1);
    }
 
}
