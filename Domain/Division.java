package com.ejemplo.calc.domain;

public class Division extends OperacionBase {
    public Division() { super("División"); }
    @Override public double aplicar(double a, double b) {
        if (b == 0) throw new ArithmeticException("No se puede dividir entre cero.");
        return a / b;
    }
}
