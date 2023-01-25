package org.example.model;
import java.io.Serializable;
import java.util.List;

public class DomainModel implements Serializable {
    List<Book> bookList;
    List<Client> clientList;
    List<Log> logList;

    public DomainModel(List<Book> bookList, List<Client> clientList, List<Log> logList){
        this.bookList = bookList;
        this.clientList = clientList;
        this.logList = logList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Log> getLogList() {return logList;}

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }
}
