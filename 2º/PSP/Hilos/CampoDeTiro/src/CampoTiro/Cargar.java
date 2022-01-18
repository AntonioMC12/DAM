package CampoTiro;

public class Cargar extends Thread {
    private Pistola arma;
    private int cartucho;

    public Cargar(Pistola arma, int cartucho) {
        this.arma = arma;
        this.cartucho = cartucho;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            arma.apuntar();
            System.out.println("Apuntar #" + this.cartucho
                               + " bala: " + i);
        }
    }
}