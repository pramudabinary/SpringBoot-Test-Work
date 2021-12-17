package lk.example.test.controller;

import lk.example.test.dto.CustomerDTO;
import lk.example.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/
@RestController
@RequestMapping("api/v1/customer")
public class CustomerFormController {

    @Autowired
    private CustomerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,path = "/save")
    public void saveCustomer(CustomerDTO dto){
        service.saveCustomer(dto);
    }


}
