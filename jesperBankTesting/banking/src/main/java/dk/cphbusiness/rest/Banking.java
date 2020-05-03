package dk.cphbusiness.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.facade.AccountFacade;
import dk.cphbusiness.facade.AccountFacadeDummy;
import dk.cphbusiness.facade.CustomerFacadeDummy;
import dto.AccountDTO;
import dto.BankDTO;
import dto.CustomerDTO;
import org.glassfish.jersey.internal.inject.Custom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/banking")
public class Banking {

    public Banking() {
    }

    @Path("/customer/{id}")
    @GET
    public Response getCustomerFromID(@PathParam("id") final String id) {
        CustomerFacadeDummy cf = new CustomerFacadeDummy();

        CustomerDTO customer = cf.getCusomter(id);

        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }

    @Path("/account/{number}")
    @GET
    public Response getAccountFromNumber(@PathParam("number") final String number) {
        //Switch boolean to true once realDB is setup
        AccountFacade af = new AccountFacade(new DataLayerImpl(false));

        BankDTO b = new BankDTO();
        AccountDTO adto = af.getAccount(number);
        adto.setBank(b);

        Account a = new Account(null, null ,  "ss");

        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(a);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }

    public static void main(String[] args) {

        AccountFacade af = new AccountFacade(new DataLayerImpl(false));

        BankDTO b = new BankDTO();
        AccountDTO adto = af.getAccount("333");
        adto.setBank(b);
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(adto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        boolean x = false;
    }

}


