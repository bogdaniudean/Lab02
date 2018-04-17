package controller;


import model.Client;
import org.junit.Test;
import repository.DataManager;

import static org.junit.Assert.assertTrue;

public class BigBangIntegration
{

    private ClientController clientController;

    @org.junit.Test
    public void run()
    {
        ClientControllerTest clientControllerTest = new ClientControllerTest();

        addClient();
        addClientIndex();
        getClients() ;
    }

    @org.junit.Test
    public void addClient()
    {
        ClientController clientController = new ClientController();

        assert clientController.getClients().size() == 1;
        clientController.AddClient("Rares", "Address", "ID");
        assert clientController.getClients().size() == 2;
    }


    @Test
    public void addClientIndex()
    {
        ClientController clientController = new ClientController();
        Client client = new Client("Bogdan", "Address", "ID");

        clientController.AddClient(client.Name, client.Address, client.idClient);

        assert clientController.AddClientIndex(client, -3, 3, 3).equals("Year can't be 0 or less!");
        assert clientController.AddClientIndex(client, 3, -3, 3).equals("Month can't be 0 or less!");
        assert clientController.AddClientIndex(client, 3, 3, -3).equals("Money to pay can't be less than 0!");

        assert clientController.AddClientIndex(new Client("R", "R", "R"), 3, 3, 3).equals("Client does not exist!");
//        assert clientController.AddClientIndex(client, 3, 3, 3) == null;
    }

    @org.junit.Test
    public void getClients()
    {
        clientController = new ClientController();

        DataManager dataManager = new DataManager();
        int size = dataManager.getClients().size();

        assertTrue(clientController.getClients().size() == size);
    }

}
