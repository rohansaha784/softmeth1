package songLab.view;

import java.awt.event.ItemEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class songLabController implements Initializable{
	ObservableList<String> list = FXCollections.observableArrayList("map1","map2","map3");
	ObservableList<String> list2 = FXCollections.observableArrayList("country1","country2","country3");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	@FXML
	public void addMusic() {
		System.out.println("hit button!");
	}

}
