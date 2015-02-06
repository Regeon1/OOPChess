 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


public class Vector2 {
    //Komponentit
    int x, y;
    
    public Vector2(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public void add(Vector2 v){
        this.x += v.x;
        this.y += v.y;
    }
    
    public void substract(Vector2 v){
        this.x -= v.x;
        this.y -= v.y;
    }
}
