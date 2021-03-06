 //* This program is free software; you can redistribute it and/or
//* modify it under the terms of the GNU General Public License 2


public class Vector2 {
    int x, y;
    
    public Vector2(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public Vector2(){
        this.x = 0;
        this.y = 0;
    }
    
    public void add(Vector2 v){
        this.x += v.x;
        this.y += v.y;
    }
    
    public void substract(Vector2 v){
        this.x -= v.x;
        this.y -= v.y;
    }
    
    public static int length(Vector2 v){
        return Math.abs(v.x - v.y);
    }
    
    public static int sign(Vector2 v){
        return (v.x-v.y)/length(v);
    }
}
