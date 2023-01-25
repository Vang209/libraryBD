package org.example.repository;

import org.example.model.Book;
import org.example.model.Client;
import org.example.model.DomainModel;
import org.example.model.Log;

import java.io.*;
import java.util.List;

public class Domain implements Serializable {

    public static void ReadFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Domain.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        DomainModel domainRead = (DomainModel) ois.readObject();

        ois.close();
        fis.close();

        BookRepository.books = domainRead.getBookList();
        ClientRepository.clients = domainRead.getClientList();
        LogRepository.logs = domainRead.getLogList();
    }

    public static void WriteFile(List<Book> books, List<Client> clients, List<Log> logs) throws IOException {
        FileOutputStream fos = new FileOutputStream("Domain.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        DomainModel domain = new DomainModel(books, clients, logs);
        oos.writeObject(domain);
        oos.close();
        fos.close();
    }
}
