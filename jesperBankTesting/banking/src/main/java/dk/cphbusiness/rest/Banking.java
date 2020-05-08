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

        IDataLayer d = new DataLayerImpl();

        AccountFacade af = new AccountFacade(d);

        AccountDTO adto = af.getAccount(number);

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
        //Switch boolean to true once realDB is setup

        IDataLayer d = new DataLayerImpl();

        Account a1 = (Account) d.getAccountONNumber(accFrom);

        Account a2 = (Account) d.getAccountONNumber(accTo);

        try {
            a1.transfer(amount, a2);
        } catch (Exception e) {
            //Goes here if insufficient funds!
        }

        try {
            d.transaction(a1, a2);

            List<AccountDTO> adto = new ArrayList<>();
            adto.add(new AccountDTO(a1));
            adto.add(new AccountDTO(a2));
            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = "";
            try {
                jsonString = mapper.writeValueAsString(adto);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();

        } catch (SQLException throwables) {
            //GOes here if SQL fails
        }
        return null;

    }


}


