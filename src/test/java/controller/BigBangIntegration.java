package controller;

/**
 * *  Created by rares on 4/17/2018.
 */


public class BigBangIntegration
{
    @org.junit.Test
    public void run()
    {
        ClientControllerTest clientControllerTest = new ClientControllerTest();

        clientControllerTest.addClient();
        clientControllerTest.addClientIndex();
        clientControllerTest.getClients();
    }
}
