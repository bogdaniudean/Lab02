package controller;

import model.Client;
import repository.DataManager;

import static org.junit.Assert.*;

public class ClientControllerTest
{
    @org.junit.Test
    public void addClient() throws Exception
    {
        // we get the initial size of the repo
        ClientController clientController = new ClientController();

        int initialSize = clientController.getClients().size();

        clientController.AddClient("z","z","Z");

        assertTrue(initialSize + 1 == clientController.getClients().size());

    }

    @org.junit.Test
    public void addClientIndex() throws Exception
    {
    }

    @org.junit.Test
    public void listIssue() throws Exception
    {
    }

    @org.junit.Test
    public void getClients() throws Exception
    {
        ClientController ctrl = new ClientController();

        assertTrue(ctrl.getClients().size() == 1);
    }

}