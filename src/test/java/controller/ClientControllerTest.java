package controller;

import model.Client;
import org.junit.Test;
import repository.DataManager;

import static org.junit.Assert.*;

public class ClientControllerTest
{

    private ClientController clientController;

    private void testSuccessful(Client client) throws Exception
    {

        clientController = new ClientController();
        int size = clientController.getClients().size();
        clientController.AddClient(client.Name, client.Address, client.idClient);
        assertEquals(size+1, clientController.getClients().size());
    }

    private void testUnsuccessful(Client client)
    {
        clientController = new ClientController();
        int size = clientController.getClients().size();
        try
        {
            clientController.AddClient(client.Name, client.Address, client.idClient);
            assertTrue(false);
        }
        catch (Exception ex) {
            assertEquals(size, clientController.getClients().size());
        }
    }

    @org.junit.Test
    public void addClient() throws Exception
    {
        // we get the initial size of the repo
        ClientController clientController = new ClientController();

        int initialSize = clientController.getClients().size();

        clientController.AddClient("z","z","Z");

        assertTrue(initialSize + 1 == clientController.getClients().size());

    }

    @Test
    public void addClientIndex()
    {
        ClientController clientController = new ClientController();
        Client client = new Client("Rares", "Address", "ID");

        assert clientController.AddClientIndex(client, -3, 3, 3).equals("Year can't be 0 or less!");
        assert clientController.AddClientIndex(client, 3, -3, 3).equals("Month can't be 0 or less!");
        assert clientController.AddClientIndex(client, 3, 3, -3).equals("Money to pay can't be less than 0!");

        assert clientController.AddClientIndex(new Client("R", "R", "R"), 3, 3, 3).equals("Client does not exist!");
    }

    @org.junit.Test
    public void listIssue() throws Exception
    {
    }

    @org.junit.Test
    public void getClients() throws Exception
    {
        clientController = new ClientController();

        DataManager dataManager = new DataManager();
        int size = dataManager.getClients().size();

        assertTrue(clientController.getClients().size() == size);
    }

}