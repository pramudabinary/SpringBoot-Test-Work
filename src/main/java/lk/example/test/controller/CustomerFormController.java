package lk.example.test.controller;

import lk.example.test.dto.CustomerDTO;
import lk.example.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public void saveCustomer(@RequestBody CustomerDTO dto){
        service.saveCustomer(dto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,path = "/update")
    public void updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
    }

    @GetMapping(params = {"id"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomer(@RequestParam String id){
        service.deleteCustomer(id);
    }

    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void searchCustomer(@PathVariable String id){
        service.searchCustomer(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void getAllCustomers(){
        service.getAllCustomers();
    }


}
