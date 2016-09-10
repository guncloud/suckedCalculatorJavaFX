package com.guncloud.calculator;

public class Model {
    public float calculate(long numberX, long numberY, String operator){
        switch (operator){
            case "+":
                return numberX + numberY;
            case "-":
                return numberX - numberY;
            case "/":
                return numberX / numberY;
            case "*":
                return numberX * numberY;
        }
        return 0;
    }
}
