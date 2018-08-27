package database.DAO;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class Book {

    private StringProperty rate;
    private StringProperty title;
    private StringProperty author;
    private SimpleObjectProperty<Date> date;
    private StringProperty description;
    private StringProperty type;

    public Book(){
        this.author = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.rate = new SimpleStringProperty();
        this.date = new SimpleObjectProperty();
        this.description = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
    }

    public String getRate() {
        return rate.get();
    }

    public StringProperty rateProperty() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate.set(rate);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public Date getDate() {
        return date.get();
    }

    public SimpleObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
