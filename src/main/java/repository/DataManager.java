package repository;

import model.Client;
import model.Issue;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DataManager
{
    private final static String fileClient = "client.txt";
    private final static String fileIssue = "issue.txt";
    public ArrayList<Client> Clients;
    public ArrayList<Issue> Issues;

    public DataManager()
    {
        Clients = new ArrayList<>();
        Issues = new ArrayList<>();

        LoadClient();
        LoadIssues();
    }

    private void LoadClient()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileClient));
            String line;
            while ((line = br.readLine()) != null)
            {
                String lines[] = line.split(",");

                String name = lines[0];
                String address = lines[1];
                String id = lines[2];

                Clients.add(new Client(name, address, id));
            }
            br.close();
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    private void LoadIssues()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileIssue));
            String line;
            Boolean b = true;
            String name = "";
            String address = "";
            String id = "";
            String sYear;
            String sMonth;
            String sToPay;
            String sPaid;

            while ((line = br.readLine()) != null)
            {
                String lines[] = line.split(",");

                name = lines[0];
                address = lines[1];
                id = lines[2];


                sYear = lines[3];
                sMonth = lines[4];
                sToPay = lines[5];
                sPaid = lines[6];

//                System.out.println(sYear + " " + sMonth + " " + sToPay + " " + sPaid);


                Issues.add(new Issue(
                        new Client(name, address, id),
                        Integer.parseInt(sYear), Integer.parseInt(sMonth), Float.parseFloat(sToPay), Float.parseFloat(sPaid)));
            }
            System.out.println(Issues.get(0));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void SaveChanges()
    {
        try
        {
            File fClient = new File(fileClient);
            File fIssue = new File(fileIssue);

            FileWriter pwClient = new FileWriter(fClient.getAbsolutePath());
            FileWriter pwIssue = new FileWriter(fIssue.getAbsolutePath());

            String s;
            try (BufferedWriter bwc = new BufferedWriter(pwClient))
            {
                s = "";
                for (Iterator<Client> i = Clients.iterator(); i.hasNext(); )
                {
                    Client c = i.next();
                    s += c.toString() + ",";
                }
                bwc.write(s);
            }
            try (BufferedWriter bwi = new BufferedWriter(pwIssue))
            {
                s = "";
                for (Iterator<Issue> i = Issues.iterator(); i.hasNext(); )
                {
                    Issue iss = i.next();
                    s += iss.toString() + "," + "\n";
                }
                bwi.write(s);
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<Client> getClients()
    {
        return Clients;
    }

    public ArrayList<Issue> getInvoicesList()
    {
        return Issues;
    }

    public ArrayList<Client> getClientsList()
    {
        return Clients;
    }
}
