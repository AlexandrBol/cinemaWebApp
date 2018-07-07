package ua.org.bolshakov.service.impl;


import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.TicketDTO;
import ua.org.bolshakov.mapper.BeanMapper;
import ua.org.bolshakov.model.Ticket;
import ua.org.bolshakov.service.api.Service;

import java.util.List;

public class TicketServiceImpl implements Service<Integer, TicketDTO> {

    private static TicketServiceImpl service;
    private Dao<Integer, Ticket> ticketDao;
    private BeanMapper beanMapper;

    private TicketServiceImpl() {
        ticketDao = DaoFactory.getInstance().getTicketDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized TicketServiceImpl getInstance() {
        if (service == null) {
            service = new TicketServiceImpl();
        }
        return service;
    }


    @Override
    public List<TicketDTO> getAll() {
        List<Ticket> tickets = ticketDao.getAll();
        List<TicketDTO> ticketDTOs = beanMapper.listMapToList(tickets, TicketDTO.class);
        return ticketDTOs;
    }

    @Override
    public void save(TicketDTO ticketDTO) {
        Ticket ticket = beanMapper.singleMapper(ticketDTO, Ticket.class);
        ticketDao.save(ticket);
    }

    @Override
    public TicketDTO getById(Integer id) {
        Ticket ticket = ticketDao.getById(id);
        TicketDTO ticketDTO = beanMapper.singleMapper(ticket, TicketDTO.class);
        return ticketDTO;
    }


    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(TicketDTO ticketDTO) {
        Ticket ticket = beanMapper.singleMapper(ticketDTO, Ticket.class);
        ticketDao.save(ticket);
    }
}

