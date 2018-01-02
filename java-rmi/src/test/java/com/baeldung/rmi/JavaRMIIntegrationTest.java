package com.baeldung.rmi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Test;
import org.junit.Before;

public class JavaRMIIntegrationTest {

    @Before
    public void setUp() throws RemoteException {	
        MessengerServiceImpl server = new MessengerServiceImpl();
        server.createStubAndBind();
    }

    @Test
    public void whenClientSendsMessageToServer_thenServerSendsResponseMessage()
      throws NotBoundException, RemoteException {		
        Registry registry = LocateRegistry.getRegistry();	
        MessengerService server = (MessengerService) registry.lookup("MessengerService");			 
        String responseMessage = server.send("Client Message");			
        String expectedMessage = "Server Message";			
        assertEquals(expectedMessage, responseMessage);
    }	
}
