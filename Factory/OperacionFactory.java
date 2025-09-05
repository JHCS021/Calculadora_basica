package factory;

import domain.*;

public class OperacionFactory {
    public Operacion fromOption(int opcion) {
        return switch (opcion) {
            case 1 -> new Suma();
            case 2 -> new Resta();
            case 3 -> new Multiplicacion();
            case 4 -> new Division();
            default -> throw new IllegalArgumentException("Opción inválida.");
        };
    }
}
