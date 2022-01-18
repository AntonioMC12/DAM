package CampoTiro;

public class Pistola {
    private boolean enposicion = true;

    public synchronized void disparar(int cartucho) {
        while (enposicion == false) {
            try {
                // Esperar a apuntar
                wait();
            } catch (InterruptedException e) { }
        }
        enposicion = false;
        notifyAll();
    }
 
    public synchronized void apuntar() {
      while (enposicion == true) {
            try {
                // Esperar a disparar
                wait();
            } catch (InterruptedException e) { }
        }
        enposicion = true;
        notifyAll();
    }

}