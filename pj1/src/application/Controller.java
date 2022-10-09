package application;


import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;

public class Controller implements Initializable{
	@FXML
	private ListView<String> list;
	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button editButton;
	@FXML
	private TextArea newSong;
	@FXML
	private TextArea newArtist;
	@FXML
	private TextArea newAblum;
	@FXML
	private TextArea newYear;
	@FXML
	private Label songLabel;
	@FXML
	private Label artistLabel;
	@FXML
	private Label albumLabel;
	@FXML 
	private Label yearLabel;
	String selected;
	String[] data = {"1","2","3","4"};
	public void add(ActionEvent event) {
		String string = newSong.getText();
		String string2 = newArtist.getText();
		String string3 = newAblum.getText();
		String string4 = newYear.getText();
		songLabel.setText(string);
		artistLabel.setText(string2);
		albumLabel.setText(string3);
		yearLabel.setText(string4);
		tfToDefault();
	}
	public void edit(ActionEvent event) {
		tfToDefault();
		
	}
	public void delete(ActionEvent event) {
		labelToDefault();
		tfToDefault();
	}
	public void labelToDefault() {
		songLabel.setText("");
		artistLabel.setText("");
		albumLabel.setText("");
		yearLabel.setText("");
	}
	public void tfToDefault() {
		newSong.setText("");
		newAblum.setText("");
		newArtist.setText("");
		newYear.setText("");
	}
	@Override
	public void initialize(URL arg0,ResourceBundle arg1) {
		list.getItems().addAll(data);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				selected = list.getSelectionModel().getSelectedItem();
				songLabel.setText(selected);
			}
		});
	}
}
