package com.ejemplo.calc.domain;

public interface Operacion {
    double aplicar(double a, double b);
    String nombre();
}
