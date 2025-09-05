package com.ejemplo.calc.domain;

public class Multiplicacion extends OperacionBase {
    public Multiplicacion() { super("Multiplicación"); }
    @Override public double aplicar(double a, double b) { return a * b; }
}
