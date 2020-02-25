package ru.stqa.pft.sandbox;

import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class JavaPractice {


    public static void main(String arg[]){
        inflation(100, 50, 2);
        chetnoe(10);
        Pologit(19.6, 6.5);
        Otrezok(1, 9, 6);
        random();
        rest();
    }

    public static void rest(String arg[]) {
        String query = "http://swapi.co/api/"; // определяем конечную точку

        HttpURLConnection connection = null; // создаем подключение
        try {

            connection = (HttpURLConnection) new URL(query).openConnection(); // создаем новое подключение

            connection.setRequestMethod("GET");         // метод запроса

            connection.setUseCaches(false);             //

            connection.setConnectTimeout(250);

            connection.setReadTimeout(250);

            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");

                }
                System.out.println(sb.toString());
            } else {
                System.out.println("fail400");
            }

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    public static void inflation(int orig, float ir, int n){
        float cost;
        cost = orig * ((ir / 100) + 1);
        for (int i = 1; i < n; i++)
            cost = cost * ((ir / 100) + 1);
        System.out.println(cost);
    }


    //1. Создать программу, проверяющую и сообщающую на экран, является ли целое число записанное в переменную n,
    // чётным либо нечётным.
    public static void chetnoe(int number){

        if (number % 2 == 0) System.out.println("chetnoe");
        else System.out.println("Задача номер 1  " + "ne_chetnoe");
     }


    // 2. Создать программу, выводящую на экран ближайшее к 10 из двух положительных чисел, записанных в переменные m и n.
    // Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.
    public static void Pologit(double n, double m){

        if (n - 10 > m - 10) System.out.println(m);
        else System.out.println("Задача номер 2  " + "ne_chetnoe");

    }
    //3. Создать программу, которая будет проверять попало ли случайно выбранное из отрезка [5;155] целое число в
    // интервал (25;100) и сообщать результат на экран. Примеры работы программы:
    //
    //Число 113 не содержится в интервале (25,100). Число 72 содержится в интервале (25,100). Число 25 не содержится в
    // интервале (25,100) Число 155 не содержится в интервале (25,100)
    //
    public static void Otrezok(int n, int m, int x){

        if (x > n  & x < m) System.out.println("число " + x + " содержится в отрезке (" + n + ", " + m + ")");

        else System.out.println("Задача номер 3   " +  "число " + x + " не содержится в отрезке (" + n + ", " + m + ")");


    }
    //4. Создать программу, выводящую на экран случайно сгенерированное трёхзначное натуральное число и его наибольшую
    // цифру. Примеры работы программы:


    //
    //В числе 208 наибольшая цифра 8. В числе 774 наибольшая цифра 7. В числе 613 наибольшая цифра 6
    //

    public static void random() {
        int rand3 = (int) (Math.random() * 100);
        int rand = rand3;
        int rand1 = 0;
        int rand2 = 0;
        while (rand > 1) {
            System.out.println(rand1 = rand % 10);      // остаток от целого числа
            System.out.println(rand = rand / 10);           // делим и получаем остаток от
            if(rand1 > rand2){
                rand2 = rand1;

            }

        }

        System.out.println("В числе " + rand3 + " наибольшая цифра " + rand1 );

    }







    //5. В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа.
    // Создать программу, которая переставит числа в переменных таким образом, чтобы при выводе на экран
    // последовательность a, b и c оказалась строго возрастающей.
    //

    //Числа в переменных a, b и c: 3, 9, -1
    //
    //Возрастающая последовательность: -1, 3, 9
    //
    //Числа в переменных a, b и c: 2, 4, 3
    //
    //Возрастающая последовательность: 2, 3, 4
    //
    //Числа в переменных a, b и c: 7, 0, -5
    //
    //Возрастающая последовательность: -5, 0, 7
    //
    //6. Создайте программу, выводящую на экран все четырёхзначные числа последовательности
    // 1000 1003 1006 1009 1012 1015 ….
    //
    //7. Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 …
    //
    //8. Создайте программу, выводящую на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….
    //
    //9. Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
    //
    //10. Создайте программу, вычисляющую факториал натурального числа n, которое пользователь введёт с клавиатуры.
    //

    //11. Выведите на экран все положительные делители натурального числа, введённого пользователем с клавиатуры.


    //12.  Реализуйте метод, проверяющий, является ли заданная строка палиндромом.




}


