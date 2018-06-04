package io.github.zenmerlin11.coffeerun.web;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.zenmerlin11.coffeerun.domain.CoffeeOrder;
import io.github.zenmerlin11.coffeerun.domain.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    @GetMapping("/coffeeorders")
    public Map<String, CoffeeOrder> retrieveAllCoffeeOrders() {
        List<CoffeeOrder> coffeeOrders = coffeeOrderRepository.findAll();
        Map<String, CoffeeOrder> coffeeOrdersByEmail = new HashMap<>();

        for (CoffeeOrder coffeeOrder : coffeeOrders) {
            coffeeOrdersByEmail.put(coffeeOrder.getEmailAddress(), coffeeOrder);
        }

        return coffeeOrdersByEmail;
    }

    @GetMapping("/coffeeorders/{emailAddress}")
    public CoffeeOrder retrieveCoffeeOrder(@PathVariable String emailAddress) {
        List<CoffeeOrder> coffeeOrders = coffeeOrderRepository.findAll();

        CoffeeOrder retrievedCoffeeOrder = null;

        for (CoffeeOrder coffeeOrder : coffeeOrders) {
            if (coffeeOrder.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                retrievedCoffeeOrder = coffeeOrder;
                break;
            }
        }

        if (coffeeOrders == null) {
            throw new CoffeeOrderNotFoundException("email: " + emailAddress);
        }

        return retrievedCoffeeOrder;
    }

    @DeleteMapping("/coffeeorders/{emailAddress}")
    public void deleteCoffeeOrder(@PathVariable String emailAddress) {
        List<CoffeeOrder> coffeeOrders = coffeeOrderRepository.findAll();

        for (CoffeeOrder coffeeOrder : coffeeOrders) {
            if (coffeeOrder.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                coffeeOrderRepository.delete(coffeeOrder);
            }
        }
    }

    @RequestMapping(value = "/coffeeorders", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Object> createCoffeeOrder(CoffeeOrder coffeeOrder) {
        CoffeeOrder savedCoffeeOrder = coffeeOrderRepository.save(coffeeOrder);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{emailAddress}")
                .buildAndExpand(savedCoffeeOrder.getEmailAddress()).toUri();

        return ResponseEntity.created(location).build();
    }
}
