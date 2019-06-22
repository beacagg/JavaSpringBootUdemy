package br.com.springboot.restcourse.math;

public class SimpleMathOps {

    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double sub(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double mult(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public Double div(Double firstNumber, Double secondNumber) {
        return firstNumber / secondNumber;
    }

    public Double media(Double firstNumber, Double secondNumber) {
        return (firstNumber + secondNumber)/2;
    }

    public Double square(Double number) {
        return (Double) Math.sqrt(number);

    }


}
