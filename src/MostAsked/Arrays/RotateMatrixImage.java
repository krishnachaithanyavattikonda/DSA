package MostAsked.Arrays;

import java.util.Arrays;

public class RotateMatrixImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Before Rotation:");
        for(int[] arr:matrix){
            System.out.println(Arrays.toString(arr));
        }
        rotate(matrix);
        System.out.println("After Rotation:");
        for(int[] arr:matrix){
            System.out.println(Arrays.toString(arr));
        }
    }
    static void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
