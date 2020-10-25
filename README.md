# 15 puzzle game (A*)

*code in java by IntelliJ IDEA*

#### the main object - Map

> Attributes

> 1. *int\[][]* **map** to store statuses
> 2. *int* **i**, **j** to mark the position of the blank **using  0 to represent**
> 3. *Map* **parent** to record the parent node
> 4.  *ArrayList<Map>* **child** to record the list of child nodes
> 5. *int* **f**, **h**, **depth** to quantify statues

> Methods
>
> 1. ```java
>    public boolean equals(Map m) //compare two Map object
>    ```
>
> 2. ```java
>    //calculate a new map and revalue it to produce child node
>    //try these directions
>    public Map up()
>    public Map down()
>    public Map left()
>    public Map right()
>    ```

#### heuristic function(Tool.java) ：

> 1. by distance 
>
>    ```java
>    public static int getDistance(int x1, int x2, int y1, int y2){
>              return Math.abs(x1-x2)+Math.abs(y1-y2);
>          }
>    
>          public static int getH(Map m){
>              int count = 0;
>              int ix, jx;
>              for(int i = 0; i < 4; i++){
>                  for(int j = 0; j < 4; j++){
>                      if(m.map[i][j] == 0)
>                          continue;
>                      else if(m.map[i][j] % 4 == 0){
>                          ix = m.map[i][j] / 4 - 1;
>                          jx = 3;
>                          count += getDistance(ix, i, jx, j);
>                      }
>                      else {
>                          ix = m.map[i][j] / 4;
>                          jx = m.map[i][j] % 4 - 1;
>                          count += getDistance(ix, i, jx, j);
>                      }
>                  }
>              }
>              return count;
>    }
>    ```
>
>    
>
> 2. by the number of absent
>
>    ```java
>    public static int getH(Map map){
>            int count = 0;
>            for (int i = 0; i < 4; i++) {
>                for (int j = 0; j < 4; j++) {
>                    if(map.map[i][j] != 4 * i + j + 1){
>                        count++;
>                    }
>                }
>            }
>            if (map.map[3][3] == 0)  count--;
>            return count;
>    }
>    ```
>
>    
