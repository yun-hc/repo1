package recursion;
//迷宫
public class RecursionDemo02 {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < map.length; i++) {
            if (i == 0 || i == map.length - 1){
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = 1;
                }
            }
            for (int j = 0; j < map[i].length; j++) {
                if (j == 0 || j == map[i].length - 1){
                    map[i][j] = 1;
                }
            }
        }
        map[3][1] = 1;
        map[3][2] = 1; //挡板
        map[3][3] = 1;
        map[2][3] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("====");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    /**
     * map地图
     * ij 起始位置
     * 结束位置   map【6】【5】
     *
     * 0表示还没走
     * 2表示走过的路径
     * 3表示走不通
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i -1,j)){   //顺序：下右上左
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
