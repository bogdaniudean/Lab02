package controller;

import model.Client;
import model.Issue;
import repository.DataManager;

import java.util.ArrayList;

public class ClientController
{
    private DataManager _dataManager;

    public ClientController()
    {
        _dataManager = new DataManager();
    }

    private String ValidateClient(String name, String address, String id)
    {
        if (!name.equals("") && !address.equals("") && !name.equals(" "))
        {
            for (int i = 0; i < name.length(); i++)
            {
                if ((!Character.isUpperCase(name.charAt(i))) && (!Character.isLowerCase(name.charAt(i))) && (!Character.isSpaceChar(name.charAt(i))))
                {
                    return "Invalid character: " + name.charAt(i);
                }
            }
            return null;
        }
        else
        {
            return "Name or address cannot be empty!";
        }
    }

    public String AddClient(String name, String address, String id)
    {
        //validation
        String valid;
        if ((valid = ValidateClient(name, address, id)) != null)
        {
            return valid;
        }
        Client c = new Client(name, address, id);
        //uniqueness
        for (int j = 0; j < _dataManager.Clients.size(); j++)
        {
            if (_dataManager.Clients.get(j).equals(c))
            {
                return "Client already exists!";
            }
        }
        try
        {
            _dataManager.Clients.add(c);
            _dataManager.SaveChanges();
            return null;
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    }

    public String AddClientIndex(Client c, int year, int month, float toPay)
    {
        if (year > 0)
        {
            if (month > 0)
            {
                if (toPay >= 0)
                {
                    //check if client exist
                    Boolean exist = false;
                    for (int i = 0; i < _dataManager.Clients.size(); i++)
                    {
                        System.out.println("C1: " + _dataManager.Clients.get(i));
                        System.out.println("C2: " + c);
                        if (_dataManager.Clients.get(i).equals(c))
                        {
                            exist = true;
                            break;
                        }
                    }

                    if (exist)
                    {
                        Issue i = new Issue(c, year, month, toPay, 0);
                        //uniqueness
                        for (int j = 0; j < _dataManager.Issues.size(); j++)
                        {
                            if (_dataManager.Issues.get(j).equals(i))
                            {
                                return "Monthly index already exists!";
                            }
                        }

                        _dataManager.Issues.add(i);
                        _dataManager.SaveChanges();
                        return null;
                    }
                    else
                    {
                        return "Client does not exist!";
                    }
                }
                else
                {
                    return "Money to pay can't be less than 0!";
                }
            }
            else
            {
                return "Month can't be 0 or less!";
            }
        }
        else
        {
            return "Year can't be 0 or less!";
        }
    }

    public void ListIssue(Client c)
    {
        String s = "";
        String pen = "";
        Double total = 0.0;
        Issue last = null, beforeLast;
        for (int i = 0; i < _dataManager.Issues.size(); i++)
        {
            if (_dataManager.Issues.get(i).Client.equals(c))
            {
                System.out.println((_dataManager.Issues.get(i).Year + " " + _dataManager.Issues.get(i).Month + " " + _dataManager.Issues.get(i).ToPay + "\n"));
            }
        }
    }

    public ArrayList<Client> getClients()
    {
        return _dataManager.getClients();
    }
}
