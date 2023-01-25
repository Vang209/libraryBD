package org.example.view;

import org.example.model.Book;
import org.example.model.Client;
import org.example.service.BookService;
import org.example.service.ClientService;
import org.example.service.LogService;


import java.io.IOException;
import java.util.Scanner;

public class ClientView {
    BookView bookView = new BookView();
    ClientService clientService = new ClientService();
    BookService bookService = new BookService();

    public void MyBook(Client client){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Вы хотите взять или вернуть книгу?");
        System.out.println("1. Взять");
        System.out.println("2. Вернуть");
        System.out.println("3. Книги которые у меня есть");
        System.out.println("4. Вернуться в меню");

        int clientMyBook = scanner.nextInt();
        if(clientMyBook == 1){
            Book book = bookView.serviceClient(client);
            bookService.TakeBook(client, book);
        } else if (clientMyBook == 2) {
            Book book = bookView.serviceClient(client);
            bookService.ReturnBook(client, book);
        } else if (clientMyBook == 3) {
            bookService.ClientBook(client);
        }
    }



    public void Menu(Client client){
        Scanner scanner = new Scanner(System.in);
        int numberCommand = scanner.nextInt();
        LogService logService = new LogService();


        System.out.println("Пожалуйста ввидите номер команды");

        if (numberCommand == 1) {
            numberCommand = 0;
            while (numberCommand != 1) {
                System.out.println("Что вы хотите?");
                System.out.println("1. Завершить работу");
                System.out.println("2. Список книг");
                System.out.println("3. Спиоск жанров");
                System.out.println("4. Список клиентов");
                System.out.println("5. Мои книги");
                System.out.println("6. Список операций");

                numberCommand = scanner.nextInt();

                if (numberCommand == 2) {
                    bookView.BookList();
                } else if (numberCommand == 3) {
                    bookView.GenreList();
                } else if (numberCommand == 4) {
                    bookView.ClientList();
                } else if (numberCommand == 5) {
                    MyBook(client);
                } else if (numberCommand == 6) {
                    LogMenu();
                }
            }
        }
    }

    public Client LoginClient() throws IOException, ClassNotFoundException {
        System.out.println("Пожалуйста авторизуйтесь");
        Scanner scanner = new Scanner(System.in);
        String clientString = scanner.nextLine();

        return clientService.Login(clientString);
    }

    public void LogMenu(){
        Scanner scanner = new Scanner(System.in);
        LogService logService = new LogService();
        int numberCommand;

        System.out.println("1.Вывести все операции за все время");
        System.out.println("2.Вывести операции за сегодня");
        System.out.println("3.Вывести операции за неделю");
        System.out.println("4.Вывести операции за месяц");
        System.out.println("5.Вывести операции за год");
        numberCommand = scanner.nextInt();

        if (numberCommand==1){
            logService.LogList();
        } else if (numberCommand==2) {
            logService.LogTheDay();
        } else if (numberCommand==3) {
            logService.LogTheWeek();
        } else if (numberCommand==4) {
            logService.LogTheMonth();
        } else if (numberCommand==5) {
            logService.LogTheYear();
        }
    }




}
