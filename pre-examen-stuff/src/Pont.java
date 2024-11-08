class Pont {
    private int vehiculosEnPuente = 0;
    private final int capacidadMaxima = 3;
    private String sentidoActual = "";

    // Método sincronizado para que los vehículos lleguen al puente
    public synchronized void llegarAlPuente(String sentido) throws InterruptedException {
        while ((vehiculosEnPuente >= capacidadMaxima) || (!sentidoActual.equals("") && !sentidoActual.equals(sentido))) {
            wait();
        }

        // ajustar el sentido actual si no hay vehículos
        if (vehiculosEnPuente == 0) {
            sentidoActual = sentido;
        }

        vehiculosEnPuente++;
        System.out.println("Vehículo entrando. Sentido: " + sentido + ". Vehículos en el puente: " + vehiculosEnPuente);
    }

    // cruzar puente
    public synchronized void cruzarPuente(String sentido) throws InterruptedException {
        System.out.println("Vehículo cruzando el puente en dirección: " + sentido);
        Thread.sleep((long) (Math.random() * 2000 + 500)); // Simula el tiempo que tarda en cruzar
    }

    // salir del puente
    public synchronized void salirDelPuente(String sentido) {
        vehiculosEnPuente--;
        System.out.println("Vehículo saliendo. Sentido: " + sentido + ". Vehículos en el puente: " + vehiculosEnPuente);

        if (vehiculosEnPuente == 0) {
            sentidoActual = "";
        }
        notifyAll();
    }
}