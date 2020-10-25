package A_star;

import java.util.ArrayList;
import java.util.Comparator;

public class Open {
    public ArrayList<Map> openArr = new ArrayList<>();

    public Map getMin(){
        openArr.sort(Comparator.comparingInt(Map::getF));
        return openArr.get(0);
    }

    public boolean hasMap(Map map){
        for(Map i : openArr){
            if(map.equals(i)){
                return true;
            }
        }
        return false;
    }

    public Map getMap(Map map) {
        for(Map i : openArr){
            if(map.equals((i)))
                return i;
        }
        return null;
    }
}
