package app.controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import database.DAO.BookDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BooksPageController implements Initializable, ControlledScreen {

    ScreensPageController myController;

    @FXML
    private JFXTreeTableView<Book> treeView;

    @Override
    public void setScreenParent(ScreensPageController screenPage) {
        myController = screenPage;
    }

    //Define the image cell
    class ButtonCell extends TreeTableCell<Book, String> {
//        Image image2;
//        ImageView imageView2;
//        ButtonCell(){
//
//            cellButton.setOnAction(new EventHandler<ActionEvent>(){
//
//                @Override
//                public void handle(ActionEvent t) {
//                    // do something when button clicked
//                    //...
//                }
//            });
//        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(String t, boolean empty) {
//            super.updateItem(t, empty);
//            if (t == "" || t == null) {
//                image2 = new Image(getClass().getResource("/images/add.png").toExternalForm());
//            } else {
//                image2 = new Image(getClass().getResource(t).toExternalForm());
//            }
//            if (!empty) {
//                imageView2 = new ImageView(image2);
//                imageView2.setFitHeight(15);
//                imageView2.setFitWidth(15);
//                setGraphic(imageView2);
//            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        ObservableList<Book> users = FXCollections.observableArrayList();
//        users.add(new Book("/images/book-5.png","Oskar i Pani Różat", "Eric-Emmanuel Schmitt", "12.07.2006", "", ""));
//        users.add(new Book("Harry Potter i Komnata Tajemnic", "Joanne K. Rowling", "04.05.2006", "", 4, "Fantastyka"));
//        users.add(new Book("Żaba", "Małgorzata Musierowicz", "17.12.2012", "/images/book-5.png", 2, "Dramat"));
//        users.add(new Book("Harry Potter i Więzień Azkabanu", "Joanne K. Rowling", "17.01.2016", "", 3, "Fantastyka"));
//        users.add(new Book("Harry Potter i Więzień Azkabanut", "Joanne K. Rowling", "11.04.2014", "", 3, "Fantastyka"));
//        users.add(new Book("Amulet z Samarkandy", "Jonathan Stround", "08.02.2010", "", 2, ""));
//        users.add(new Book("Ferdydurka", "Witold Gombrowicz", "30.10.2008", "", 2, "Dramat"));
//        users.add(new Book("Miliony", "Frank Cottrell Boyce", "23.08.2009", "", 2, "Thriller"));
//
//        users.add(new Book("Opowieści z Narnii- Lew, Czarownica i Stara Szafa", "C. S. Lewis", "12.07.2006", "", 2, "Fantastyka"));
//        users.add(new Book("Harry Potter i Książę Półkrwi", "Joanne K. Rowling", "03.03.2018", "", 4, "Fantastyka"));
//        users.add(new Book("Falbanki", "Krystyna Siesicka", "15.03.2013", "", 2, "Obyczajowa"));
//        users.add(new Book("Moja droga Aleksandra", "Krystyna Siesicka", "", "", 3, "Obyczajowa"));
//        users.add(new Book("", "Pamiętaj, że tam są schody", "Krystyna Siesicka", "", "", ""));
//        users.add(new Book("", "W stronę tamtego lasu", "Krystyna Siesicka", "", "", ""));
//        users.add(new Book("", "Mitologia", "Jan Parandowski", "", "", ""));
//        users.add(new Book("" , "Walerio wróć", "Krystyna Siesickae", "", "", ""));

        ObservableList<Book> users = null;
        try {
            users = BookDAO.searchBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final TreeItem<Book> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);


        JFXTreeTableColumn rate = new JFXTreeTableColumn("Rate");
        rate.setPrefWidth(100);
        rate.setCellValueFactory(
                new Callback<TreeTableColumn.CellDataFeatures<Book, String>,
                        ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Book, String> p) {
                        return p.getValue().getValue().rate;
                    }
                });

        rate.setCellFactory(
                new Callback<TreeTableColumn<Book, String>, TreeTableCell<Book, String>>() {

                    @Override
                    public TreeTableCell<Book, String> call(TreeTableColumn<Book, String> p) {
                        return new ButtonCell();
                    }

                });

        JFXTreeTableColumn title = new JFXTreeTableColumn("Title");
        title.setPrefWidth(250);
        title.setCellValueFactory((Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>) param -> param.getValue().getValue().title);

        JFXTreeTableColumn author = new JFXTreeTableColumn("Author");
        author.setPrefWidth(200);
        author.setCellValueFactory((Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>) param -> param.getValue().getValue().author);

        JFXTreeTableColumn date = new JFXTreeTableColumn("Date");
        date.setPrefWidth(200);
        date.setStyle("-fx-alignment: CENTER");
        date.setCellValueFactory((Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>) param -> param.getValue().getValue().date);

        JFXTreeTableColumn type = new JFXTreeTableColumn("Type");
        type.setPrefWidth(150);
        type.setCellValueFactory((Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>) param -> param.getValue().getValue().type);

        JFXTreeTableColumn description = new JFXTreeTableColumn("Description");
        description.setPrefWidth(200);
        description.setCellValueFactory((Callback<TreeTableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>) param -> param.getValue().getValue().description);

        description.setSortable(false);

        treeView.getColumns().setAll(rate, title, author, date, type, description);
        treeView.setRoot(root);
        treeView.setShowRoot(false);

    }

    public static class Book extends RecursiveTreeObject<Book> {
        StringProperty rate;
        StringProperty title;
        StringProperty author;
        StringProperty date;
        StringProperty description;
        StringProperty type;

        public Book(String rate, String title, String author, String date, String description, String type) {
            this.title = new SimpleStringProperty(title);
            this.author = new SimpleStringProperty(author);
            this.date = new SimpleStringProperty(date);
            this.description = new SimpleStringProperty(description);
            this.type = new SimpleStringProperty(type);
            this.rate = new SimpleStringProperty(rate);
        }
    }
}
