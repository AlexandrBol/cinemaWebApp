package ua.org.bolshakov.service.impl;


import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.OrderDTO;
import ua.org.bolshakov.mapper.BeanMapper;
import ua.org.bolshakov.model.Order;
import ua.org.bolshakov.service.api.Service;

import java.util.List;

public class OrderServiceImpl implements Service<Integer, OrderDTO> {

    private static OrderServiceImpl service;
    private Dao<Integer, Order> orderDao;
    private BeanMapper beanMapper;

    private OrderServiceImpl() {
        orderDao = DaoFactory.getInstance().getOrderDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized OrderServiceImpl getInstance() {
        if (service == null) {
            service = new OrderServiceImpl();
        }
        return service;
    }


    @Override
    public List<OrderDTO> getAll() {
        List<Order> orders = orderDao.getAll();
        List<OrderDTO> orderDTOs = beanMapper.listMapToList(orders, OrderDTO.class);
        return orderDTOs;
    }

    @Override
    public void save(OrderDTO orderDTO) {
        Order order = beanMapper.singleMapper(orderDTO, Order.class);
        orderDao.save(order);
    }

    @Override
    public OrderDTO getById(Integer id) {
        Order order = orderDao.getById(id);
        OrderDTO orderDTO = beanMapper.singleMapper(order, OrderDTO.class);
        return orderDTO;
    }


    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(OrderDTO orderDTO) {
        Order order = beanMapper.singleMapper(orderDTO, Order.class);
        orderDao.save(order);
    }
}
