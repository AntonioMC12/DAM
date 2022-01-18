package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Banca;
import model.Cola;
import model.Consumidor;
import model.Contador;
import model.IngresarDinero;
import model.Jugador;
import model.Productor;
import model.SacarDinero;
import model.hiloContador;

public class SecondaryController implements Observer {

	@FXML
	private ImageView img_confeti;

	@FXML
	private ImageView img_lisa;

	@FXML
	private ImageView img_trophy;

	@FXML
	private Label lb_bankMoney;

	@FXML
	private Label lb_number;

	@FXML
	private Label lb_userMoney;

	@FXML
	private Slider sl_bet;

	@FXML
	private TextField txt_bet;

	@FXML
	private TextArea txt_prompt;

	@FXML
	private Button btn_play;

	Timer timer = new Timer();

	public static boolean isFinished = false;

	public Jugador player = new Jugador(50, "Antonio");
	public List<Jugador> jugadores = new ArrayList<>();
	public Banca bank = new Banca(500);

	/**
	 * Inicializa las variables visuales, botones y textos Inicializa el número de
	 * jugadores. Añade el listner del slider para las apuestas.
	 */
	public void initialize() {
		sl_bet.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				txt_bet.setText(Integer.toString(newValue.intValue()));
				player.setApuesta(newValue.intValue());
			}
		});

		jugadores.add(player);
		initializeJugadores();

		this.img_lisa.setVisible(false);
		this.img_confeti.setVisible(false);
		this.img_trophy.setVisible(false);

	}

	/**
	 * Hace uso del productor/consumidor para obtener el número ganador, siendo el
	 * último número obtenido de la cola el ganador. También añade el observador
	 * para ver los cambios de número en tiempo real y poder hacer uso de la función
	 * update.
	 */
	public void makePlay() {
		Cola cola = new Cola();
		Productor productor = new Productor(cola);
		Consumidor consumidor = new Consumidor(cola);

		for (Jugador jugador : jugadores) {
			if (!jugador.equals(player)) {
				jugador.makeApuesta();
			}
		}

		cola.addObserver(this);
		productor.start();
		consumidor.start();
	}

	/**
	 * Método que actualiza el label de los números
	 */
	public void changeNumber(int number) {
		this.lb_number.setText(Integer.toString(number));
	}

	@Override
	/**
	 * Método que se ejecuta cada vez que cambia el número. Una vez ha terminado el
	 * productor/consumidor y hay un número ganador Ejecuta la función play.
	 */
	public void update(Observable o, Object arg) {
		Platform.runLater(() -> {
			changeNumber((int) arg);
			if (isFinished) {
				play((int) arg);
				this.txt_prompt.appendText("EL TOTAL DE LOS JUGADORES ES: "+cuentaTotalJugadores());
				if (this.txt_bet.getText().equals(Integer.toString((int) arg))) {
					showTrophy();

				} else {
					showLisa();
				}
			}
		});

	}

	/**
	 * Método que muestra una imagen de lisa cuando y la esconde pasando 2 segundos.
	 */
	public void showLisa() {
		this.img_lisa.setVisible(true);
		TimerTask task = new TimerTask() {
			public void run() {
				hideLisa();
			}

		};
		timer.schedule(task, 2000l);

	}

	/**
	 * Método que esconde la imagen de lisa.
	 */
	public void hideLisa() {
		this.img_lisa.setVisible(false);
	}

	/**
	 * Método que muestra la imagen de ganador y la esconda tras 4 segundos.
	 */
	public void showTrophy() {
		this.img_confeti.setVisible(true);
		this.img_trophy.setVisible(true);
		TimerTask task = new TimerTask() {
			public void run() {
				hideTrophy();
			}

		};
		timer.schedule(task, 4000l);
	}

	/**
	 * Método que esconde la imagen de ganador.s
	 */
	public void hideTrophy() {
		this.img_trophy.setVisible(false);
		this.img_confeti.setVisible(false);
	}

	/**
	 * Método que inicializa los jugadores según los seleccionados en la pantalla
	 * anterior.
	 */
	public void initializeJugadores() {
		for (int i = 0; i < PrimaryController.nPlayers; i++) {
			this.jugadores.add(new Jugador(50, "Jugador " + i + 1));
		}
	}
	
	/**
	 * Método que crea N hilos para contar los restante de la banca
	 */
	public int cuentaTotalJugadores() {
		Contador.cont = 0;
		for (Jugador jugador : jugadores) {
			hiloContador h = new hiloContador(jugador);
			h.run();
		}
		return Contador.cont;
	}

	/**
	 * Método que recorre la lista de jugadores y ve si han acertado o no su
	 * apuesta, realizando las consiguientes operaciones si han acertado o no.
	 * Sumando y restando dinero del banco y sumando o restando puntos de los
	 * jugadores.
	 * 
	 * @param bet_number
	 */
	public void play(int bet_number) {
		synchronized (bank) {
			for (Jugador jugador : jugadores) {
				txt_prompt.appendText(jugador.getNombre() + " APUESTA A " + jugador.getApuesta());
				txt_prompt.appendText("\n");
				// Compruebo si los jugadores tienen dinero para jugar.
				if (jugador.getDinero() > 0) {
					// Compruebo si los jugadores han acertado.
					if (jugador.getApuesta() == bet_number) {
						// En caso de que hayan acertado, sacan 50 puntos/dinero de la banca y se lo
						// ingresan a ellos.
						SacarDinero sg = new SacarDinero(bank, jugador, 50);
						sg.run();
						jugador.setDinero(jugador.getDinero() + 50);
						txt_prompt.appendText(jugador.getNombre() + " Ha ganado!");
						txt_prompt.appendText(jugador.getNombre() + " Tiene " + jugador.getDinero() + " Puntos");
						txt_prompt.appendText("\n");
						lb_userMoney.setText(Integer.toString(player.getDinero()));
						try {
							lb_bankMoney.setText(Integer.toString(bank.getDinero()));
							if (bank.getDinero() == 0)
								btn_play.setDisable(true);
							// Espero para ejecutar cada hilo en orden.
							sg.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// Si los jugadores no han acertado, se le retiran 5 puntos/Dinero y se le
					// ingresan a la banca.
					else {
						IngresarDinero ig = new IngresarDinero(bank, jugador, 5);
						ig.run();
						jugador.setDinero(jugador.getDinero() - 5);
						if (player.getDinero() == 0)
							btn_play.setDisable(true);
						txt_prompt.appendText(jugador.getNombre() + " Ha Perdido!");
						txt_prompt.appendText(jugador.getNombre() + " Tiene " + jugador.getDinero() + " Puntos");
						txt_prompt.appendText("\n");
						lb_userMoney.setText(Integer.toString(player.getDinero()));
						try {
							lb_bankMoney.setText(Integer.toString(bank.getDinero()));
							ig.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}