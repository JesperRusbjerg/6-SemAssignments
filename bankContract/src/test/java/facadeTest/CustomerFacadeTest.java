package facadeTest;

import contract.CustomerContract;
import dto.CustomerDTO;
import org.junit.Test;

import static org.junit.Assert.*;


public class CustomerFacadeTest {

    @Test
    public void CustomerFacade_Test_get_Customer(){

        CustomerContract cf = ContractHolder.customerContract;
        CustomerDTO cd = cf.getCusomter("test");
        assertNotNull(cd);
    }
}
