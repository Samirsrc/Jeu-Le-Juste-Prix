package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller4 implements Initializable {
	@FXML
	private Button rejouer;

	@FXML
	void rejouer(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("View2.fxml"));
		Scene scene = new Scene(root);
		Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Window.setScene(scene);
		Window.show();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
