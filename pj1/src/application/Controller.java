package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;

public class Controller {
	@FXML
	private TableView<Song> list;
	@FXML
	private TableColumn<String, Song> songColumn;
	@FXML
	private TableColumn<String, Song> artistColumn;
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
	
	private List<Song> list2;
	private HashSet<Song> hashSet;
//	public void readFromFile() {
//		File file = new File("C:\\Users\\wangz\\eclipse-workspace\\hello\\src\\application\\data.txt");
//		try {
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			String line;
//			String[] arr;
//			while((line=bufferedReader.readLine())!=null) {
//				for(int i = 0;i<4;i++) {
//					
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	public void add(ActionEvent event) {

	}
	public void edit(ActionEvent event) {
		
	}
	public void delete(ActionEvent event) {
		
	}
}
