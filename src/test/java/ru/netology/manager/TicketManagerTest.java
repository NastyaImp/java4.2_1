package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1,2000,"EGO", "DME", 120);
    private Ticket second = new Ticket(2,1500,"LED", "RHV", 60);
    private Ticket third = new Ticket(3,1000,"EGO", "DME", 150);
    private Ticket fourth = new Ticket(4,7000,"AER", "LED", 90);
    private Ticket fifth = new Ticket(5,9000,"DME", "FRU", 120);

    @Test
    public void shouldSearchOneTicket() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchTicket("LED", "RHV");
        Ticket[] expected = new Ticket[]{second};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchTwoTicket() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchTicket("EGO", "DME");
        Ticket[] expected = new Ticket[]{third, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchNoOneTicket() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchTicket("DME", "EGO");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

}