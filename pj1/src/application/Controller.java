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

import javax.swing.text.StyledEditorKit.ForegroundAction;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
					Song song = new Song(slist[1],slist[0],slist[2],Integer.parseInt(slist[3]));
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
	}
	public void add(ActionEvent event) {
		String string = newSong.getText().trim();
		String string2 = newArtist.getText().trim();
		String string3 = newAblum.getText().trim();
		String string4 = newYear.getText().trim();
		if(string==""||string2=="") {
			signLabel.setText("Fail!");
			tfToDefault();
			return;
		}
		Song song = new Song(string2,string,string3,Integer.parseInt(string4));
		songs.add(song);
		list.getItems().removeAll(list1);
		list1.add(string+"\t"+string2);
		list.getItems().addAll(list1);
//		songLabel.setText(string);
//		artistLabel.setText(string2);
//		albumLabel.setText(string3);
//		yearLabel.setText(string4);
		tfToDefault();
		signLabel.setText("Success!!!");
	}
	public void edit(ActionEvent event) {
		tfToDefault();
		
	}
	
	public void delete(ActionEvent event) {
		labelToDefault();
		tfToDefault();
		signLabel2.setText("success!!!");
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
}
