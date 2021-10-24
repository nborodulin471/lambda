package calculator;

import java.util.function.*;

public class Calculator {
    private static Supplier<Calculator> instance = Calculator::new;
    Predicate<Integer> isPositive = x -> x > 0;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Consumer<Integer> println = System.out::println;


    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
//        int c = calc.devide.apply(a, b);
//        Ошибка возникала т.к отсутствовала проверка деления на ноль.
//        Я реализовал ее ниже с помощью тернарного оператора и лямбда выражения
        int c = calc.devide.apply(a, calc.isPositive.test(b) ? b : 1);
        calc.println.accept(c);

    }
}
