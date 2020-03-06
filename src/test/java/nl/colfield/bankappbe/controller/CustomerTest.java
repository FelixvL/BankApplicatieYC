package nl.colfield.bankappbe.controller;
import nl.colfield.bankappbe.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





public class CustomerTest {


    @Test
    public void checkId(){
        Customer customer = new Customer();
        customer.setId(3);
        Assertions.assertEquals(customer.getId(),3);
    }

    @Test
    public void checkFirstName(){
        Customer customer = new Customer();
        customer.setFirstName(null);
        Assertions.assertEquals(customer.getFirstName(),"onbekend");
    }







}
