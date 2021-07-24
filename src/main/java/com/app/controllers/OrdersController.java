package com.app.controllers;

import com.app.entities.Orders;
import com.app.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/o")
public class OrdersController {
    OrdersRepository ordersRepository;

    @Autowired
    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Orders> orders = (List<Orders>) ordersRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/showFormForAdd")
    public String addOrders(Model model) {
        Orders orders = new Orders();
        model.addAttribute("orders", orders);
        return "orders-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("tempOrder") int id, Model model) {
        Orders orders = ordersRepository
                .findById(Integer.toUnsignedLong(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
        model.addAttribute("orders", orders);

        return "orders-form";
    }


    @PostMapping("/save")
    public String saveUsers(@ModelAttribute("orders") Orders orders, Model model) {
        ordersRepository.save(orders);
        model.addAttribute("orders", ordersRepository.findAll());
        return "orders";
    }
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        ordersRepository.deleteById(id);
        return "orders";
    }
}
