package com.example.rest_project.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface OrderDAO {
    public Order findById(int id);
    public void save(Order order);
    public void update(Order order);
    public void delete(Order order);
    public List<Order> findAll();
    public List<Order> findByDate(String fromDate, String toDate) throws ParseException;
    public List<Order> findByDate(String fromDate, String toDate,int id) throws ParseException;

}
