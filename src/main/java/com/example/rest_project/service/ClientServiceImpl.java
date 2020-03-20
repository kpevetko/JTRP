package com.example.rest_project.service;

import com.example.rest_project.model.Order;
import com.example.rest_project.model.OrderDAOImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    //объект нашего OrderDAO
    private OrderDAOImpl orderDAO = new OrderDAOImpl();

    public ClientServiceImpl(){}

    @Override
    public void create(Order order) {
        orderDAO.save(order);
    }

    @Override
    public List<Order> readAll() {
        return new ArrayList<>(orderDAO.findAll());
    }

    @Override
    public Order read(int id) {
        return orderDAO.findById(id);
    }

    @Override
    public boolean update(Order order, int id) {
       if (orderDAO.findById(id)!=null) {
            order.setId(id);
            orderDAO.update(order);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if(orderDAO.findById(id)!=null){
            orderDAO.delete(orderDAO.findById(id));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Order> findByDate(String fromDate, String toDate) throws ParseException {
        return new ArrayList<>(orderDAO.findByDate(fromDate,toDate));
    }

    @Override
    public List<Order> findByDate(String fromDate, String toDate,int id) throws ParseException {
        return new ArrayList<>(orderDAO.findByDate(fromDate,toDate,id));
    }


}
