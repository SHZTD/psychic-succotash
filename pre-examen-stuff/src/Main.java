public class Main {
    public static void main(String[] args) {
        Pont puente = new Pont();

        // hilos para simular vehículos
        Thread[] vehiculos = new Thread[10];
        for (int i = 0; i < 10; i++) {
            String sentido = (i % 2 == 0) ? "izquierda" : "derecha";
            vehiculos[i] = new Thread(new Vehicle(sentido, puente));
        }

        for (Thread vehiculo : vehiculos) {
            vehiculo.start();
        }
    }
}
