package com.baeldung.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessengerService extends Remote {

    String send(String clientMessage) throws RemoteException;

    Message send(Message clientMessage) throws RemoteException;
}
