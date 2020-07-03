package sparsearray;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SparseArrayDemo01 {
    public static void main(String[] args) throws IOException {
        //创建一个11*11的原始数组（棋盘）
        //0：没有棋子  1：黑子  2：白子
        int[][] chseeArr1 = new int[11][11];

        chseeArr1[1][2] = 1;
        chseeArr1[2][3] = 2;
        chseeArr1[2][4] = 2;
        //遍历原始数组
        for (int[] row : chseeArr1) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        //先遍历原始数组得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < chseeArr1.length; i++) {
            for (int j = 0; j < chseeArr1[i].length; j++) {
                if (chseeArr1[i][j]!=0){
                    sum++;
                }
            }
        }
//        System.out.println(sum);
        //创建稀疏数组
        int[][] sperseArr = new int[sum + 1][3];
        //第一行
        sperseArr[0][0]= 11;
        sperseArr[0][1]= 11;
        sperseArr[0][2]= sum;
        //给稀疏数组赋值   原始数组-->稀疏数组
        int m = 1;//记录第几个非零数据
        for (int i = 0; i < chseeArr1.length; i++) {
            for (int j = 0; j < chseeArr1[i].length; j++) {
                if (chseeArr1[i][j]!=0){
                    sperseArr[m][0] = i;
                    sperseArr[m][1] = j;
                    sperseArr[m][2] = chseeArr1[i][j];
                    m++;
                }
            }
        }
        //遍历稀疏数组
        for (int[] row : sperseArr) {
            for (int i : row) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }


        //稀疏数组-->原始数组
        int[][] chseeArr2 = new int[sperseArr[0][0]][sperseArr[0][1]];
        for (int i = 1; i < sperseArr.length; i++) {
            chseeArr2[sperseArr[i][0]][sperseArr[i][1]] = sperseArr[i][2];
        }

        //遍历转换后的原始数组
        for (int[] row : chseeArr2) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        //写出到文件
//        new ObjectOutputStream(new FileOutputStream("/aaa")).writeObject(sperseArr);
        
    }
}
