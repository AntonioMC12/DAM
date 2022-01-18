package controller;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class PrimaryController {

    @FXML
    private Button btn_play;

    @FXML
    private Slider sl_numberPlayer;

    @FXML
    private Label txt_players;
    
    protected static int nPlayers = 0;
    
    /**
     * Inicializa el slider e inserta un listener para cambiar el label conforme se actualize el slider
     */
    public void initialize() {
		sl_numberPlayer.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				nPlayers = newValue.intValue();
				txt_players.setText(Integer.toString(newValue.intValue()));
			}
		});
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
