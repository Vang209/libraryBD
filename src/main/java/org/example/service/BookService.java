package org.example.service;

import org.example.model.Book;
import org.example.model.Client;
import org.example.model.Log;
import org.example.repository.BookRepository;
import org.example.repository.LogRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookService {


    public TakeReturn TakeBook(Client client, Book clientBook){
        int numberOfBooks = 0;
        for (int i = 0; i < BookRepository.books.size(); i++) {
            if (clientBook.equals(BookRepository.books.get(i)) && BookRepository.books.get(i).getClientId() == null) {
                numberOfBooks++;
//                System.out.println("Да, у нас есть такая книга, мы добавили ее в ваш раздел 'Мои книги'");
                BookRepository.books.get(i).setClientId(client.getUuid());
                LocalDate date = LocalDate.now();
                LogRepository.logs.add(new Log(BookRepository.books.get(i), client.getUuid(), "Взял", date));
            }
        }
        if (numberOfBooks == 0) {
            return null;
        } else return TakeReturn.TAKE_BOOK;
    }
    public TakeReturn ReturnBook(Client client, Book filingBookData){
        Book clientBook = filingBookData;
        int numBookClient = 1;
        for (int i = 0; i < BookRepository.books.size(); i++) {
            if (clientBook.equals(BookRepository.books.get(i)) && client.getUuid().equals(BookRepository.books.get(i).getId())) {
                LocalDate date = LocalDate.now();
                LogRepository.logs.add(new Log(BookRepository.books.get(i), client.getUuid(), "Вернул", date));
                BookRepository.books.get(i).setClientId(null);
            }
        }
        if(numBookClient == 1){
            return null;
        } else return TakeReturn.RETURN_BOOK;

    }


    public List<Book> ClientBook(Client client){
        int numberOfBooksTheClientHas = 0;
        List<Book> bookReturn = new ArrayList<>();
        for (int i = 0; i < BookRepository.books.size(); i++) {
            if (BookRepository.books.get(i).getClientId() != null) {
                if (BookRepository.books.get(i).getClientId().equals(client.getUuid())) {
                    numberOfBooksTheClientHas++;
                    bookReturn.add(BookRepository.books.get(i));
                }
            }
        }
        if (numberOfBooksTheClientHas == 0) {
            return null;
        } else return bookReturn;
    }

    public enum TakeReturn{
        TAKE_BOOK("Взял"),
        RETURN_BOOK("Вернул");

        private String action;

        TakeReturn(String action){this.action = action;}

        public String getAction(){return action;}
    }
}
