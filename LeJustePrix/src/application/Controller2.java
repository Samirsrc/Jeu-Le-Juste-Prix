package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller2 implements Initializable {

	@FXML
	private Label pseudo;

	@FXML
	private Label textEcran;

	@FXML
	private Label prixEcran;

	@FXML
	private TextField prixInput;

	@FXML
	private Button profil;

	@FXML
	private Button rejouer;

	@FXML
	private ImageView logo;

	public static String somme;
	private int nbr = (int) (Math.random() * 100);
	private int nbrEssai = 0;

	@FXML
	void prixInput(ActionEvent event) throws IOException {

		try {
			@SuppressWarnings("unused")
			int ex = Integer.parseInt(prixInput.getText());
		} catch (NumberFormatException e) {
			prixInput.setText("");
			return;

		}
		this.prixEcran.setText(prixInput.getText());
		nbrEssai++;
		if (Integer.parseInt(prixInput.getText()) == nbr) {
			somme = prixInput.getText();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("View3.fxml"));
			Scene scene = new Scene(root);
			Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Window.setScene(scene);
			Window.show();

		} else if (Integer.parseInt(prixInput.getText()) > nbr) {
			if (nbrEssai == 10) {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("View4.fxml"));
				Scene scene = new Scene(root);
				Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Window.setScene(scene);
				Window.show();
			}
			textEcran.setText("Plus petit !");

		} else {
			if (nbrEssai == 10) {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("View4.fxml"));
				Scene scene = new Scene(root);
				Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Window.setScene(scene);
				Window.show();
			}
			textEcran.setText("Plus grand !");

		}
		prixInput.setText("");
	}

	@FXML
	void profil(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("App.fxml"));
		Scene scene = new Scene(root);
		Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Window.setScene(scene);
		Window.show();

	}

	@FXML
	void rejouer(ActionEvent event) {
		this.nbr = (int) (Math.random() * 100);
		nbrEssai = 0;
		this.prixEcran.setText("");
		this.textEcran.setText("");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.textEcran.setAlignment(Pos.CENTER);
		this.prixEcran.setAlignment(Pos.CENTER);
		this.pseudo.setText(Controller.nom);
		this.prixEcran.setText("");
		this.textEcran.setText("");

	}

}
