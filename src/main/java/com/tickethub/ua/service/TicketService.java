package com.tickethub.ua.service;

import com.tickethub.ua.models.Ticket;
import com.tickethub.ua.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketService implements AbstractService<Ticket> {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.getOne(id);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
}
