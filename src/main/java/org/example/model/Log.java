package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Log{
    private Book book;
    private UUID clientId;
    private String takeOrReturned;
    private LocalDate date;



    @Override
    public String toString() {
        return "Log{" +
                "book=" + book +
                ", clientId=" + clientId +
                ", takeOrReturned='" + takeOrReturned + '\'' +
                ", date=" + date +
                '}';
    }

    public Log(Book book, UUID clientId, String takeOrReturned, LocalDate date){
        this.book = book;
        this.clientId = clientId;
        this.takeOrReturned = takeOrReturned;
        this.date = date;
    }

    public String getTakeOrReturned() {
        return takeOrReturned;
    }

    public void setTakeOrReturned(String takeOrReturned) {
        this.takeOrReturned = takeOrReturned;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}
}
