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
                g.movePiece(new Vector2(Integer.parseInt(a[1]), Integer.parseInt(a[2])),
                        new Vector2(Integer.parseInt(a[3]), Integer.parseInt(a[4])));
            }else if(a[0].equals("exit")){
                return;
            }
            g.draw();
        }
    }
 
}
