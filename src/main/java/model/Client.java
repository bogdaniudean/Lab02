package model;

import java.util.Objects;

public class Client
{
    public String Name;
    public String Address;
    public String idClient;

    public Client()
    {
        this.Name = "";
        this.Address = "";
        this.idClient = "";
    }

    public Client(Client client)
    {
        this.Name = client.Name;
        this.Address = client.Address;
        this.idClient = client.idClient;
    }

    public Client(String name, String address, String idC)
    {
        this.Name = name;
        this.Address = address;
        this.idClient = idC;
    }

    @Override
    public String toString()
    {
        return Name + "," + Address + "," + idClient;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(Name, client.Name) &&
                Objects.equals(Address, client.Address) &&
                Objects.equals(idClient, client.idClient);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Name, Address, idClient);
    }
}
