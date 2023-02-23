package org.example.service;

import org.example.model.Client;
import org.example.repository.*;
import org.example.view.ClientView;

import java.io.IOException;
import java.util.UUID;

public class ClientService {



    public Client Login(String nameClient){
        for(int i = 0; i< ClientRepository.clients.size(); i++){
            if(ClientRepository.clients.get(i).getNameClient().equals(nameClient)){
                System.out.println("Вы авторизовались, добро пожаловать, "+nameClient);
                return ClientRepository.getClients().get(i);
            }
        }
        System.out.println("Нам не удалось найти такого пользователя :(");
        return null;
    }
}
