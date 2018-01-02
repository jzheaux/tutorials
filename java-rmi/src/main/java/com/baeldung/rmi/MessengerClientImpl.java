package com.baeldung.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MessengerClientImpl {

    /** Make sure that you have the server running before running
        this class. You can find the server in MessengerServiceImpl.java **/

    public static void main(String[] args) throws RemoteException, NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup("MessengerService");
            String responseMessage = server.send("Client Message");
            System.out.println("From Server: " + responseMessage);
        } catch ( RemoteException e ) {
            System.out.println("Failed to talk to server, are you sure it is up?");
            throw e;
        }
    }
}
