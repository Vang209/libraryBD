package org.example.repository;

import org.example.model.Book;
import org.example.model.Client;
import org.example.model.DatabaseConnection;
import org.example.model.Log;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UpdatingTheDatabase {

    public static void UpdateBook(List<Book> books, Book book){
        DatabaseConnection database = new DatabaseConnection();

        int bookNumber = 0;

        for (int i=0;i<books.size();i++){
            if(books.get(i).equals(book)){
                bookNumber=i+1;
            }
            break;
        }

        try(Connection connection = database.getConnection(); Statement statement = connection.createStatement()){
            statement.executeUpdate("update books set clientId="+ book.getClientId() +" where id="+bookNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void UpdateLogs(Log log){
        DatabaseConnection database = new DatabaseConnection();

        try(Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("insert into log(book, clientId, date, takeOrReturn) values("+log.getBook()+", "+log.getClientId()+", "+log.getDate()+", "+log.getTakeOrReturned()+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void FillingInTheDatabase(){

    }
}
