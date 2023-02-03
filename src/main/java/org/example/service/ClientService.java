package org.example.service;

import org.example.model.Client;
import org.example.repository.*;
import org.example.view.ClientView;

import java.io.IOException;
import java.util.UUID;

public class ClientService {



    public Client Login(String nameClient) throws IOException, ClassNotFoundException {
        ClientView clientView = new ClientView();
        UUID uuid = UUID.randomUUID();
        Client client = new Client(uuid,nameClient);
        for(int i = 0; i< ClientRepository.getClients().size(); i++){
            if(nameClient.equals(ClientRepository.getClients().get(i))){
//                System.out.println("Вы авторизовались, добро пожаловать, "+nameClient);
                client = ClientRepository.getClients().get(i);
//                DatabaseRepository.ReadDatabase();
                break;
            }
        }
        if(client != null){
            return client;
        } else return null;
        //                System.out.println("У нас нет такого пользователя");
    }
    public void ExitingTheApp() throws IOException {
        DatabaseRepository.WriteDatabase();
    }
}
