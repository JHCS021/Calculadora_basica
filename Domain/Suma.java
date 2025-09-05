package Domain;

public class Suma extends OperacionBase {
    public Suma() {
        super("Suma");
    }

    @Override
    public double aplicar(double a, double b) {
        return a + b;
    }
}
