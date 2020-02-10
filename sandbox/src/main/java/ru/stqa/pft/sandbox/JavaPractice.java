package ru.stqa.pft.sandbox;

public class JavaPractice {
    public static void main(String arg[]){
        inflation(100, 50, 2);
        chetnoe(10);
    }


    public static void inflation(int orig, float ir, int n){
        float cost;
        cost = orig * ((ir / 100) + 1);
        for (int i = 1; i < n; i++)
            cost = cost * ((ir / 100) + 1);
        System.out.println(cost);
    }
    public static void chetnoe(int number)
    {
        if (number % 2 == 0) System.out.println("chetnoe");
        else System.out.println("ne_chetnoe");
     }


}


