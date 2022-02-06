package com.company;

public class App {

    public static void main(String[] args) {
        int[][] array1 = {{1,3,3},
                         {2,1,4},
                         {0,6,4}};

        int[][] array2 = {{1,3,3,4},
                          {2,1,4,3},
                          {1,0,2,3},
                          {0,6,4,5}};

        int[][] array3 = {{3,5,6,4,2},
                          {5,1,2,5,3},
                          {2,8,9,1,2},
                          {8,1,2,5,3},
                          {1,2,1,2,0}};


        ArrayHandler arrayHendler = new ArrayHandler(array3);

        arrayHendler.start(array3);
    }
}
