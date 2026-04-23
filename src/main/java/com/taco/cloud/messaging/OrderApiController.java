package com.taco.cloud.messaging;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taco.cloud.models.tacoOrder;
import com.taco.cloud.repository.orderRepositoryInterface;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderApiController {
    private OrderMessagingService orderMessagingService;
    private orderRepositoryInterface orderRepo;

    public OrderApiController(OrderMessagingService orderMessagingService, orderRepositoryInterface orderRepo) {
        this.orderMessagingService = orderMessagingService;
        this.orderRepo = orderRepo;
    }
    @GetMapping(produces = "application/json")
    public Iterable<tacoOrder> allOrders() {
        return orderRepo.findAll();
    }

    @PostMapping(consumes = "application/json")
    public tacoOrder postOrder(@RequestBody tacoOrder order) {
        orderRepo.save(order);
        orderMessagingService.sendOrder(order);
        return order;
    }
}
