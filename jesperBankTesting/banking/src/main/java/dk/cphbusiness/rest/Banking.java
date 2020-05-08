package dk.cphbusiness.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

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


}


