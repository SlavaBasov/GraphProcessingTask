package com.company;

public class App {

    public static void main(String[] args) {
        int[][] array = {{1,3,3},
                         {2,1,4},
                         {0,6,4}};


        ArrayHandler arrayHendler = new ArrayHandler(array);

        arrayHendler.start(array);
    }
}
