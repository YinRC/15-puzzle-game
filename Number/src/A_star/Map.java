package A_star;

import java.util.ArrayList;

public class Map {
    public int[][] map = new int[4][4];
    public int i, j;
    public int f;
    public int depth;
    public int h;
    public Map parent = null;
    public ArrayList<Map> child = new ArrayList<>();

    public Map(int[][] map){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                this.map[i][j] = map[i][j];
                if(this.map[i][j] == 0){
                    this.i = i;
                    this.j = j;
                }
            }
        }
    }

    public int getF(){
        return f;
    }

    public int getDepth(){
        return depth;
    }

    public Map(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.map[i][j] == 0){
                    this.i = i;
                    this.j = j;
                }
            }
        }
    }

    public boolean equals(Map m){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.map[i][j] != m.map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public Map up() {
        Map newMap = new Map(this.map);

        newMap.parent = this;
        //Up
        newMap.map[i][j] = this.map[i - 1][j];
        newMap.i--;
        newMap.map[newMap.i][newMap.j] = 0;
        this.child.add(newMap);

        newMap.depth = this.depth + 1;
        newMap.h = Tool.getH(newMap);
        newMap.f = newMap.depth + newMap.h;
        return newMap;
    }

    public Map down() {
        Map newMap = new Map(this.map);

        newMap.parent = this;
        //Down
        newMap.map[i][j] = this.map[i + 1][j];
        newMap.i++;
        newMap.map[newMap.i][newMap.j] = 0;
        this.child.add(newMap);

        newMap.depth = this.depth + 1;
        newMap.h = Tool.getH(newMap);
        newMap.f = newMap.depth + newMap.h;
        return newMap;
    }

    public Map left() {
        Map newMap = new Map(this.map);

        newMap.parent = this;
        //Left
        newMap.map[i][j] = this.map[i][j - 1];
        newMap.j--;
        newMap.map[newMap.i][newMap.j] = 0;
        this.child.add(newMap);

        newMap.depth = this.depth + 1;
        newMap.h = Tool.getH(newMap);
        newMap.f = newMap.depth + newMap.h;
        return newMap;
    }

    public Map right() {
        Map newMap = new Map(this.map);

        newMap.parent = this;
        //Right
        newMap.map[i][j] = this.map[i][j + 1];
        newMap.j++;
        newMap.map[newMap.i][newMap.j] = 0;
        this.child.add(newMap);

        newMap.depth = this.depth + 1;
        newMap.h = Tool.getH(newMap);
        newMap.f = newMap.depth + newMap.h;
        return newMap;
    }
}
