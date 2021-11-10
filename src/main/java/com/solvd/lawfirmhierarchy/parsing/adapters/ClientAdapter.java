package com.solvd.lawfirmhierarchy.parsing.adapters;

import com.solvd.lawfirmhierarchy.people.Client;
import com.solvd.lawfirmhierarchy.people.Lawyer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ClientAdapter extends XmlAdapter<ClientAdapter.AdaptedClient, Client> {

    @Override
    public AdaptedClient marshal(Client client)
            throws Exception {
        if (client == null) {
            return null;
        }
        AdaptedClient adaptedClient = new AdaptedClient();
        adaptedClient.lastName = client.getLastName();
        adaptedClient.caseType = client.getCaseType();
        adaptedClient.lawyer = client.getLawyer();
        return adaptedClient;
    }

    @Override
    public Client unmarshal(AdaptedClient adaptedClient)
            throws Exception {
        if (null == adaptedClient) {
            return null;
        }
        Client client = new Client();
        client.setLastName(adaptedClient.lastName);
        client.setCaseType(adaptedClient.caseType);
        client.setLawyer(adaptedClient.lawyer);
        return client;
    }

    public static class AdaptedClient {
        @XmlElement
        public String lastName;
        @XmlElement
        public String caseType;
        @XmlElement
        public Lawyer lawyer;
    }
}
