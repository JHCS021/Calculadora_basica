package domain;

public abstract class OperacionBase implements Operacion {
    private final String nombre;
    protected OperacionBase(String nombre) { 
        this.nombre = nombre; 
        }

    @Override public String nombre() { 
        return nombre; 
        }
}
