package org.example.view;

import org.example.model.Book;
import org.example.model.Client;
import org.example.model.Genre;
import org.example.repository.BookRepository;
import org.example.repository.ClientRepository;

import java.util.Scanner;

public class BookView {
    public Book serviceClient(Client client){
        Scanner console = new Scanner(System.in);

        System.out.println("Заполните пожалуйста данные книги");
        System.out.println("Автор?");
        String clientAuthor = console.nextLine();
        System.out.println("Название книги?");
        String clientTitle = console.nextLine();
        System.out.println("Жанр?");
        String clientGenre = console.nextLine();

        Genre clientGenreEnum = Genre.fromTitle(clientGenre);
        Book clientBook = new Book(clientGenreEnum, clientAuthor, clientTitle);
        return clientBook;
    }
    public void BookList(){
        for (int i = 0; i< BookRepository.books.size(); i++){
            System.out.println(BookRepository.books.get(i));
        }
    }
    public void ClientList(){
        for (int i = 0; i< ClientRepository.clients.size(); i++){
            System.out.println(ClientRepository.clients.get(i));
        }
    }
    public void GenreList(){
        Genre[] genres = Genre.values();
        for (Genre genre:genres){
            System.out.println(genre.getTitleGenre());
        }
    }
}
