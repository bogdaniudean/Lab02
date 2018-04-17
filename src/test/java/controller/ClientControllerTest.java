package controller;

import model.Client;
import org.junit.Test;
import repository.DataManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ClientControllerTest
{
    private ClientController clientController;

    private void testSuccessful(Client client)
    {
        clientController = new ClientController();

        int nr = clientController.getClients().size();

        clientController.AddClient(client.Name, client.Address, client.idClient);

        assertEquals(nr + 1, clientController.getClients().size());
    }

//    private void testUnsuccessful(Student student)
//    {
//        dataManager = new StudentRepository("src/test/java/ssvv/students.txt");
//        int nr = dataManager.findAll().size();
//        clientController1 = new Controller(dataManager, null, null);
//        try
//        {
//            clientController1.saveStudent(student);
//            assertTrue(false);
//        }
//        catch (CustomException ex)
//        {
//            assertEquals(nr, dataManager.findAll().size());
//        }
//    }
    
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