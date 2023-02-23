package org.example;

import org.example.model.Book;
import org.example.model.Client;
import org.example.model.DatabaseConnection;
import org.example.model.Genre;
import org.example.repository.BookRepository;
import org.example.repository.ClientRepository;
import org.example.repository.DatabaseRepository;
import org.example.service.ClientService;
import org.example.view.ClientView;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatabaseConnection connection = new DatabaseConnection();
        ClientService clientService = new ClientService();
        ClientView clientView = new ClientView();


        BookRepository.books.add(new Book(Genre.fromTitle("Ужасы"),"Автор1", "Название1"));
        BookRepository.books.add(new Book(Genre.fromTitle("Драма"),"Автор2", "Название2"));
        BookRepository.books.add(new Book(Genre.fromTitle("Триллер"),"Автор1 Автор2", "Название3"));

        ClientRepository.clients.add(Client.addClient("Клиент1"));
        ClientRepository.clients.add(Client.addClient("Клиент2"));

        clientView.LoginClient();

    }
}