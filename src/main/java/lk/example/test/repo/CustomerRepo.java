package lk.example.test.repo;

import lk.example.test.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/
public interface CustomerRepo extends JpaRepository<Customer,String> {

}
