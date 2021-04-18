package com.tickethub.ua.controller;

import com.tickethub.ua.models.Ticket;
import com.tickethub.ua.models.User;
import com.tickethub.ua.service.EmailSenderService;
import com.tickethub.ua.service.TicketService;
import com.tickethub.ua.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<Ticket> sendTicket(@PathVariable("id") Ticket ticket, User user){
        ticketService.findById(ticket.getTicketId());


        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Ticket");
        mailMessage.setFrom("vaduk2000@gmail.com");
        mailMessage.setText(
                "Thank you for registering."
                        + user.getFirstName() + " " + user.getLastName() + " Date start: " + ticket.getBeginTime()
                        + "Date end: " + ticket.getEndTime() + "From city: " + ticket.getFromCity() + "To city: " + ticket.getToCity());

       emailSenderService.sendEmail(mailMessage);
       return ResponseEntity.ok().body(ticket);
    }

}