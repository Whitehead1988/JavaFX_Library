package app.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import database.DAO.Book;
import database.DAO.BookDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddBookPageController implements Initializable, ControlledScreen {

    ScreensPageController myController;

    @FXML
    private JFXTextField title;

    @FXML
    private JFXTextField author;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField type;

    @FXML
    private JFXTextField description;

    @FXML
    private JFXComboBox rate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        rate.setItems(FXCollections.observableArrayList(list));
    }

    @Override
    public void setScreenParent(ScreensPageController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void addBook(ActionEvent event) {
        Book book = new Book();
        book.setAuthor(author.getText());
        book.setDate(date.getValue());
        book.setDescription(description.getText());
        book.setRate(rate.getValue().toString());
        book.setTitle(title.getText());
        book.setType(type.getText());
        BookDAO.insertBook(book);
    }
}
