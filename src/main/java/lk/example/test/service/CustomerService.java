package lk.example.test.service;

import lk.example.test.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/
public interface CustomerService {
    void saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

}
