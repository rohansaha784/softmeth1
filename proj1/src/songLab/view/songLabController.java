package songLab.view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.security.Signature;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class songLabController implements Initializable{
	//buttons
	@FXML
	private Button addSong;
	@FXML
	private Button deletesong;
	//text input
	@FXML 
	private TextField newSong;
	@FXML 
	private TextField newArtist;
	@FXML 
	private TextField newYear;
	@FXML
	private TextField newAlbum;
	//table column
	@FXML
	private TableColumn<String,String> songlist;
	@FXML
	private TableColumn<String, String> artistlist;
	//labels
	@FXML
	private Label songDetail;
	@FXML
	private Label artistDetail;
	@FXML
	private Label yearDetail;
	@FXML
	private Label albumDetail;
	@FXML
	private Label sign;
	//access control
	Boolean boolean1 = false;
	Boolean boolean2 = false;
	//set scene
	public static Scene show() throws IOException{
		URL url = songLabController.class.getResource("SongLab.fxml");
		assert(url!=null);
		AnchorPane anchorPane = FXMLLoader.load(url);
		return new Scene(anchorPane,640,480);
	}
	@FXML
	//input new song
	public void newSong(ActionEvent event){
		String song = newSong.getText();
		boolean1 = true;
		//song & artist cannot be null;
	}
	//input new Artist
	@FXML
	public void newArtist(ActionEvent event){
		String Artist = newArtist.getText();
		boolean2 = true;
		//song & artist cannot be null;
	}
	//input new Year
	@FXML
	public void newYear(ActionEvent event){	
		String Year = newYear.getText();
	}
	//input new Album
	@FXML
	public void newAlbum(ActionEvent event){
		String Album = newAlbum.getText();
	}
	//add button
	@FXML
	public void addSong(){
		if(boolean1&&boolean2){
			//write in the file
			sign.setText("New Song has been added");
		}
		else{
			sign.setText("Song's name and artist required");
			//failed to write in
		}
	}
	//delete button
	public void deleteSong() {
		
	}
	//songdetail
	public void sd() {
		
	}
	//artistdetail
	public void ad() {
		
	}
	//yeardetail
	public void yd() {
		
	}
	//albumdetail
	public void ald() {
		
	}
	//songlist
	public void sl() {
	}
	//artistlist
	public void al() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
