package org.example.repository;

import org.example.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DatabaseRepository {

    public static void ReadDatabase(){
        DatabaseConnection database = new DatabaseConnection();

        try {
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSetBook = statement.executeQuery("select book from library");
            ResultSet resultSetClient = statement.executeQuery("select client from library");
            ResultSet resultSetLog = statement.executeQuery("select log from library");

            int lineNumber=1;
            while (resultSetBook.next()){

                int id = resultSetBook.getInt(lineNumber);
                String author = resultSetBook.getString(lineNumber);
                int clientId = resultSetBook.getInt(lineNumber);
                String genre = resultSetBook.getString(lineNumber);
                String title = resultSetBook.getString(lineNumber);

                BookRepository.books.add(new Book(Genre.fromTitle(genre), author, title));

                lineNumber++;
            }

            lineNumber = 1;
            while (resultSetClient.next()){

                int id = resultSetClient.getInt(lineNumber);
                String client = resultSetClient.getString(lineNumber);
                UUID uuid = (UUID) resultSetClient.getObject(lineNumber);

                ClientRepository.clients.add(new Client(uuid, client));

                lineNumber++;
            }

            lineNumber = 1;
            while (resultSetLog.next()){

                int id = resultSetLog.getInt(lineNumber);
                Book book =(Book) resultSetLog.getObject(lineNumber);
                UUID clientId =(UUID) resultSetLog.getObject(lineNumber);
                LocalDate date =(LocalDate) resultSetLog.getObject(lineNumber);
                String takeOrReturn = resultSetLog.getString(lineNumber);

                LogRepository.logs.add(new Log(book, clientId, takeOrReturn, date));

                lineNumber++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WriteDatabase(){ //оставил для того чтобы заполнить базу данных, дальше данный метод не будет использоваться
        DatabaseConnection database = new DatabaseConnection();

        final String INSERT_NEW_BOOK="INSERT INTO books VALUES(?,?,?,?,?)";
        final String INSERT_NEW_CLIENT="INSERT INTO client VALUES(?,?,?)";
        final String INSERT_NEW_LOG="INSERT INTO log VALUES(?,?,?,?,?)";

        try(Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {

            statement.execute("delete * from books");
            statement.execute("delete * from client");
            statement.execute("delete * from log");

            PreparedStatement preparedStatement = null;



            for(int i=0; i<BookRepository.books.size(); i++){
                preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK);

                preparedStatement.setInt(1,i+1);
                preparedStatement.setString(2,BookRepository.books.get(i).getAuthor());
                preparedStatement.setObject(3, BookRepository.books.get(i).getClientId());
                preparedStatement.setString(4, BookRepository.books.get(i).getGenre().toString());
                preparedStatement.setString(5, BookRepository.books.get(i).getTitle());

                preparedStatement.execute();
            }

            for (int i=0;i<ClientRepository.clients.size();i++){
                preparedStatement = connection.prepareStatement(INSERT_NEW_CLIENT);

                preparedStatement.setInt(1, i+1);
                preparedStatement.setString(2, ClientRepository.clients.get(i).nameClient);
                preparedStatement.setObject(3, ClientRepository.clients.get(i).getUuid());

                preparedStatement.execute();
            }

            for (int i=0;i<LogRepository.logs.size();i++){
                preparedStatement = connection.prepareStatement(INSERT_NEW_LOG);

                preparedStatement.setInt(1,i+1);
                preparedStatement.setObject(2, LogRepository.logs.get(i).getBook());
                preparedStatement.setObject(3, LogRepository.logs.get(i).getClientId());
                preparedStatement.setObject(4, LogRepository.logs.get(i).getDate());
                preparedStatement.setString(5, LogRepository.logs.get(i).getTakeOrReturned());

                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
