package A_star;

import java.util.ArrayList;

public class Close {
    ArrayList<Map> closeArr = new ArrayList<>();

    public boolean hasMap(Map map){
        for(Map i : closeArr){
            if(!map.equals(i)){
                return false;
            }
        }
        return true;
    }

    public Map getMap(Map map) {
        for(Map i : closeArr){
            if(map.equals((i)))
                return i;
        }
        return null;
    }
}
