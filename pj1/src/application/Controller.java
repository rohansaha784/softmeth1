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
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
	@FXML
	private Label signLabel;
	@FXML
	private Label signLabel2;
	String selected;
	ArrayList<Song> songs = new ArrayList<Song>();
	ObservableList<String> list1= FXCollections.observableArrayList();
	public void setSongs() {
		File file = new File("C:\\Users\\wangz\\eclipse-workspace\\pj1\\src\\application\\a.txt");
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string;
			String[] slist;
			try {
				while((string=bufferedReader.readLine())!=null) {
					slist = string.split(" ");
					String temp = slist[0]+"\t"+slist[1];
					list1.add(temp);
					Song song = new Song(slist[0],slist[1],slist[2],Integer.parseInt(slist[3]));
					songs.add(song);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!songs.isEmpty()) {
			Song song = songs.get(0);
			songLabel.setText(song.getSong());
			albumLabel.setText(song.getAlbum());
			artistLabel.setText(song.getArtist());
			yearLabel.setText(""+song.getYear());
		}
	}
	public void add(ActionEvent event) {
		if(!warning()) return;
		String string = newSong.getText().trim();
		String string2 = newArtist.getText().trim();
		String string3 = newAblum.getText().trim();
		String string4 = newYear.getText().trim();
		if(string4!=""&&!isinteger(string4)) {signLabel.setText("year need to be Integer!!!");
		return;}
		Song song;
		if(string==""||string2=="") {
			signLabel.setText("Fail!");
			tfToDefault();
			return;
		}
		if(string3 == "") {
			if(string4=="") {
				song = new Song(string,string2);
			}
			else {
				song = new Song(string, string2,"NULL",Integer.parseInt(string4));
			}
		}
		else if(string4 =="") song = new Song(string, string2, string3,0);
		else song = new Song(string,string2,string3,Integer.parseInt(string4));
		for(int i =0;i<songs.size();i++) {
			Song tempSong = songs.get(i);
			if((tempSong.getArtist().equals(song.getArtist()))
					&&(song.getSong().equals(tempSong.getSong()))) {
				signLabel.setText("Duplicate!!!");
				return;
			}
		}
		songs.add(song);
		list.getItems().removeAll(list1);
		list1.add(string+"\t"+string2);
		FXCollections.sort(list1);
		list.getItems().addAll(list1);
		songLabel.setText(string);
		artistLabel.setText(string2);
		albumLabel.setText(string3);
		yearLabel.setText(string4);
		tfToDefault();
		signLabel.setText("Success!!!");
	}
	public void edit(ActionEvent event) {
		if(!warning()) return;
		if(list.getItems().isEmpty()) return;
		if(list.getSelectionModel().getSelectedItem()==null) return;
		String string = newSong.getText().trim();
		String string2 = newArtist.getText().trim();
		String string3 = newAblum.getText().trim();
		String string4 = newYear.getText().trim();
		if(string4!=""&&!isinteger(string4)) {signLabel.setText("year need to be Integer!!!");
		return;}
		if(string=="") string = songLabel.getText();
		if(string2=="") string2 = artistLabel.getText();
		if(string3=="") string3 = albumLabel.getText();
		if(string4=="") string4 = yearLabel.getText();
		String string5 = list.getSelectionModel().getSelectedItem();
		String temp[] = string5.split("\t");
		list.getItems().removeAll(list1);
		list1.remove(string5);
		for(int i =0;i<songs.size();i++) {
			Song song = songs.get(i);
			if(song.getArtist().equals(temp[1])&&song.getSong().equals(temp[0])) {
				song.setAlbum(string3);
				song.setArtist(string2);
				song.setSong(string);
				song.setYear(Integer.parseInt(string4));
				string5 = song.getSong()+"\t"+song.getArtist();
				break;
			}
		}
		list1.add(string5);
		FXCollections.sort(list1);
		list.getItems().addAll(list1);
		songLabel.setText(string);
		artistLabel.setText(string2);
		albumLabel.setText(string3);
		yearLabel.setText(string4);
		signLabel.setText("Success!!!");
		tfToDefault();
		
	}
	public void delete(ActionEvent event) {
		if(!warning()) return;
		if(list.getItems().isEmpty()) {
			return;
		}
		if(list.getSelectionModel().getSelectedItem()==null) return;
		String string = list.getSelectionModel().getSelectedItem();
		list.getItems().removeAll(list1);
		list1.remove(string);
		FXCollections.sort(list1);
		list.getItems().addAll(list1);
		String[] temp = string.split("\t");
		for(int i =0;i<songs.size();i++) {
			Song song = songs.get(i);
			if(song.getSong()==temp[0]&&song.getArtist()==temp[1]) {
				songs.remove(i);
			}
		}
		signLabel2.setText("Success!!!");
		tfToDefault();
		labelToDefault();
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
		setSongs();
		list.getItems().addAll(list1);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				selected = list.getSelectionModel().getSelectedItem();
				if(selected==null) return;
				String temp = selected.split("\t")[0];
				for(int i=0;i<songs.size();i++) {
					Song song = songs.get(i);
					if(temp.equals(song.getSong())) {
						songLabel.setText(temp);
						artistLabel.setText(song.getArtist());
						yearLabel.setText(""+song.getYear());
						albumLabel.setText(song.getAlbum());
					}
				}
			}
		});
	}
	public boolean warning() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Warning!!!");
		alert.setHeaderText("Are you sure???");
		alert.getButtonTypes().setAll(ButtonType.CANCEL,ButtonType.OK);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get()==ButtonType.OK) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isinteger(String str) {
		for(int i =0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
