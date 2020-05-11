package dk.cphbusiness.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.cphbusiness.banking.Account;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.datalayer.IDataLayer;
import dk.cphbusiness.facade.AccountFacade;
import dto.AccountDTO;
import dto.CustomerDTO;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/banking")
public class Banking {

    public Banking() {
    }


    @Path("/account/{number}")
    @GET
    public Response getAccountFromNumber(@PathParam("number") final String number) {
        //Switch boolean to true once realDB is setup
        ObjectMapper mapper = new ObjectMapper();
        IDataLayer d = new DataLayerImpl();
        String jsonString = "";

        AccountFacade af = new AccountFacade(d);

        AccountDTO adto;
        try {
            adto = af.getAccount(number);
        } catch (Exception e) {
            JSONObject json = new JSONObject();
            json.put("message", e.getMessage());

            return Response.status(404).entity(json.toString()).type(MediaType.APPLICATION_JSON).build();
        }


        //Converting the Object to JSONString

        try {
            jsonString = mapper.writeValueAsString(adto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }

    @Path("/account/all")
    @GET
    public Response getAllAccounts() {
        //Switch boolean to true once realDB is setup

        AccountFacade af = new AccountFacade(new DataLayerImpl());

        List<AccountDTO> adto = af.getAllAccounts();

        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(adto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }

    @Path("/account/{accFrom}/{accTo}/{amount}")
    @GET
    public Response transferMoney(@PathParam("accFrom") final String accFrom,
                                  @PathParam("accTo") final String accTo,
                                  @PathParam("amount") final int amount) {
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = "";
        IDataLayer d = new DataLayerImpl();
        AccountFacade f = new AccountFacade(d);

        List<AccountDTO> Dtos;
        try {
            Dtos = f.transaction(accFrom, accTo, amount);
        } catch (Exception e) {
            JSONObject json = new JSONObject();
            json.put("message", e.getMessage());
            return Response.status(404).entity(json.toString()).type(MediaType.APPLICATION_JSON).build();
        }

        try {
            jsonString = mapper.writeValueAsString(Dtos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }


}


