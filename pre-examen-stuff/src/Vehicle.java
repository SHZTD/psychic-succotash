class Vehicle implements Runnable {
    private String sentido;
    private Pont puente;

    public Vehicle(String sentido, Pont puente) {
        this.sentido = sentido;
        this.puente = puente;
    }

    @Override
    public void run() {
        try {
            puente.llegarAlPuente(sentido);
            puente.cruzarPuente(sentido);
            puente.salirDelPuente(sentido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}