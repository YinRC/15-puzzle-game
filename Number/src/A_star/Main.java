package A_star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static Map beginMap = new Map(new int[][]{{ 5, 1, 2, 4 }, { 9, 6, 3, 8 }, { 13, 15, 10, 11 }, { 14, 0, 7, 12 }});
    public static Map endMap = new Map(new int[][]{{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 }});

    public static void main(String[] args) {
        Open openTable = new Open();
        Close closeTable = new Close();
        //初始状态填入Open表
        openTable.openArr.add(beginMap);
        Map curMap;
        ArrayList<Map> show = new ArrayList<>();

        while (openTable.openArr.size() != 0){
            curMap = openTable.getMin();
            //System.out.println(Arrays.deepToString(curMap.map));
            //System.out.println("depth : "+curMap.depth+"    Eval : "+curMap.f);
            closeTable.closeArr.add(curMap);
            if(curMap.equals(endMap)){
                System.out.println("SUCCESS!");
                show.add(curMap);
                while(curMap.parent != null){
                    curMap = curMap.parent;
                    show.add(curMap);
                }
                show.sort(Comparator.comparingInt(Map::getDepth));
                for(Map i : show){
                    System.out.println(Arrays.deepToString(i.map));
                    System.out.println("\nDepth : " + i.depth + "     Eval : " + i.f + "\n");
                }
                break;
            }
            //上下左右依次扩展
            for(int k = 0; k < 4; k++){
                Map newMap = null;
                if(k == 0){                 //UP
                    if(curMap.i != 0){
                        newMap = curMap.up();
                    }else continue;
                }
                else if(k == 1){
                    if(curMap.i != 3){      //DOWN
                        newMap = curMap.down();
                    }else continue;
                }
                else if(k == 2){            //LEFT
                    if(curMap.j != 0){
                        newMap = curMap.left();
                    }else continue;
                }
                else if(k == 3){                      //RIGHT
                    if(curMap.j != 3){
                        newMap = curMap.right();
                    }else continue;
                }

                if(curMap.parent != null && curMap.parent.equals(newMap))
                    continue;

                if(openTable.hasMap(newMap)){
                    //open表里的map
                    Map oldMap = openTable.getMap(newMap);
                    //满足open表替换条件
                    if(newMap.f < oldMap.f){
                        newMap.child = oldMap.child;
                        for(Map i : newMap.child){
                            i.parent = newMap;
                        }
                        openTable.openArr.remove(openTable.openArr.indexOf(oldMap));
                        openTable.openArr.add(newMap);
                    }
                }
                else if(closeTable.hasMap(newMap)){
                    Map oldMap = closeTable.getMap(newMap);
                    if(newMap.f < oldMap.f){
                        newMap.child = oldMap.child;
                        for(Map i : newMap.child){
                            i.parent = newMap;
                        }
                        closeTable.closeArr.remove(closeTable.closeArr.indexOf(oldMap));
                        openTable.openArr.add(newMap);
                    }
                }
                else {
                    openTable.openArr.add(newMap);
                }
            }
            openTable.openArr.remove(openTable.openArr.indexOf(curMap));
        }
    }

}
