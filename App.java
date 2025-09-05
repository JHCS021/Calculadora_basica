import factory.OperacionFactory;
import service.CalculadoraService;
import domain.Operacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var service = new CalculadoraService();
        var factory = new OperacionFactory();

        System.out.println("== Calculadora Básica ==");
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Ingrese el primer número: ");
                double num1 = sc.nextDouble();

                System.out.print("Ingrese el segundo número: ");
                double num2 = sc.nextDouble();

                System.out.println("Seleccione la operación:");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();

                // Requisito: llamar métodos separados desde main
                double resultadoMetodos = switch (opcion) {
                    case 1 -> service.sumar(num1, num2);
                    case 2 -> service.restar(num1, num2);
                    case 3 -> service.multiplicar(num1, num2);
                    case 4 -> service.dividir(num1, num2);
                    default -> {
                        System.out.println("Opción inválida.");
                        yield Double.NaN;
                    }
                };

                if (!Double.isNaN(resultadoMetodos)) {
                    // En paralelo, demostramos polimorfismo (POO full)
                    Operacion op = factory.fromOption(opcion);
                    double resultadoPOO = op.aplicar(num1, num2);

                    System.out.println("Resultado (métodos): " + resultadoMetodos);
                    System.out.println("Resultado (polimórfico): " + resultadoPOO);
                }

            } catch (InputMismatchException ex) {
                System.out.println("Entrada no válida. Use números (ej: 12.5).");
                sc.nextLine(); // limpiar buffer
            } catch (ArithmeticException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.print("¿Desea realizar otra operación? (s/n): ");
            String resp = sc.next().trim().toLowerCase();
            continuar = resp.equals("s") || resp.equals("si") || resp.equals("sí");
            System.out.println();
        }

        System.out.println("¡Hasta luego!");
        sc.close();
    }
}
