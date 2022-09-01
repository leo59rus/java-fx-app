package ru.gb.javafxapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Game {

    public static class BullsAndCowsCount {
        private final int bulls;
        private final int cows;

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }

        public BullsAndCowsCount(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }
    }

    public String getGuessNum() {
       final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < guessNum.length; i++) {
            stringBuilder.append(guessNum[i]);
        }
        return stringBuilder.toString();
        // то же самое return " " + guessNum[0] + guessNum[1]+
        // guessNum[2]+ guessNum[3];
    }

    private final int[] guessNum;//число загаданное машиной


    public Game() {


        guessNum = generateNumber();
        System.out.println(Arrays.toString(guessNum));
    }

    public BullsAndCowsCount calculateBullsAndCows(String playerNum) {//число
        // загаданное пользователем
        int bulls = 0, cows = 0;
        for (int i = 0; i < guessNum.length; i++) {
            if (guessNum[i] == playerNum.charAt(i) - '0') {//bulls
                bulls++;//посчитали скко чисел стоят на своем месте
                // угаданных
            } else if (playerNum.contains(String.valueOf(guessNum[i]))) {
                cows++;//посчитали скко совпадающих чисел имеется
                // но не на своих местах

            }
        }
        return new BullsAndCowsCount(bulls, cows);
    }

    private int[] generateNumber() {
        final List<Integer> numbers =
                new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                                              7, 8, 9));
        //создали asList неизменяемый
        Collections.shuffle(numbers);//перемешали
        return new int[]{numbers.get(0), numbers.get(1),
                numbers.get(2), numbers.get(3)};//выдали 4 первые
    }
}

