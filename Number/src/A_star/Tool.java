package A_star;

public class Tool {
//    public static int getH(Map map){
//        int count = 0;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if(map.map[i][j] != 4 * i + j + 1){
//                    count++;
//                }
//            }
//        }
//        if (map.map[3][3] == 0)  count--;
//        return count;
//    }
      public static int getDistance(int x1, int x2, int y1, int y2){
          return Math.abs(x1-x2)+Math.abs(y1-y2);
      }

      public static int getH(Map m){
          int count = 0;
          int ix, jx;
          for(int i = 0; i < 4; i++){
              for(int j = 0; j < 4; j++){
                  if(m.map[i][j] == 0)
                      continue;
                  else if(m.map[i][j] % 4 == 0){
                      ix = m.map[i][j] / 4 - 1;
                      jx = 3;
                      count += getDistance(ix, i, jx, j);
                  }
                  else {
                      ix = m.map[i][j] / 4;
                      jx = m.map[i][j] % 4 - 1;
                      count += getDistance(ix, i, jx, j);
                  }
              }
          }
          return count;
      }
      
      public static int InverseNum(Map m){
          int count = 0;
          int[] arr = new int[16];
          for(int i = 0; i < 4; i++){
              for(int j = 0; j < 4; j++){
                  arr[i*4+j] = m.map[i][j];
              }
          }
          for(int k = 0; k < 16; k++){
              if(arr[k] == 0)
                  continue;
              for(int t = k + 1; t < 16; t++){
                  if(arr[t] == 0)
                      continue;
                  if(arr[t] < arr[k])
                      count++;
              }
          }
          return count;
      }
}
