package com.baeldung.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MessengerServiceImpl implements MessengerService {

    @Override
    public String send(String clientMessage) {
		
        String serverMessage = null;
        if ("Client Message".equals(clientMessage)) {
            serverMessage = "Server Message";
        }
	
        return serverMessage;
    }
	
    void createStubAndBind() throws RemoteException {

        MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject((MessengerService) this, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("MessengerService", stub);
    }
	
    @Override
    public Message send(Message clientMessage) throws RemoteException {
		
        Message serverMessage = null;
        if (clientMessage != null) {
            return new Message(send(clientMessage.getMessageText()),
	                       "text/plain");
        }

        return serverMessage;
    }
	
    public static void main(String[] args) throws RemoteException {

        MessengerServiceImpl msgInf = new MessengerServiceImpl();
        msgInf.createStubAndBind();
        System.out.println("Server is up and listening on port 1099");
    }
}
