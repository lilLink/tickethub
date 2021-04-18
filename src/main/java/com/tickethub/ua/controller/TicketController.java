package com.tickethub.ua.controller;

import com.tickethub.ua.models.Ticket;
import com.tickethub.ua.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping
    public List<Ticket> getAll(){
        return ticketService.findAll();
    }

    @GetMapping("{id}")
    public Ticket getOne(@PathVariable("id") Ticket ticket){
        return ticket;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.create(ticket);
    }

    @PutMapping("{id}")
    public Ticket update(@PathVariable("id") Ticket ticketFromDB, @RequestBody Ticket ticket){
        BeanUtils.copyProperties(ticket, ticketFromDB, "id");
        return ticketService.update(ticketFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Ticket ticket){
        ticketService.deleteById(ticket.getTicketId());
    }
}
