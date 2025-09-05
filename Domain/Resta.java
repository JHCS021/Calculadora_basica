package domain;

public class Resta extends OperacionBase {
    public Resta() { 
        super("Resta"); 
        }

    @Override public double aplicar(double a, double b) { 
        return a - b; 
        }
}
