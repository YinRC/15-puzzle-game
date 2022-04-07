# 15 数码问题 (A* 算法)

#### 主要数据结构 - Map

> 抽象数据结构

> 1. *int\[][]* **map** 存储状态
> 2. *int* **i**, **j** 标记空白的位置 **用 0 表示**
> 3. *Map* **parent** 存储父结点
> 4.  *ArrayList<Map>* **child** 存储子结点列表
> 5. *int* **f**, **h**, **depth** 量化状态信息

> 方法
>
> 1. ```java
>    public boolean equals(Map m) // 比较两个Map 对象
>    ```
>
> 2. ```java
>    // 计算并产生新的子结点
>    // 向四个方向依次做尝试
>    public Map up()
>    public Map down()
>    public Map left()
>    public Map right()
>    ```

#### 启发函数(Tool.java) ：

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
