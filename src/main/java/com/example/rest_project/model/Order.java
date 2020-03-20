package com.example.rest_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/*
 * POJO класс Заказы
 * создаем из нее сущность
 * */
@Entity
@Table(name = "orders")
public class Order {

    //номер заказа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //дата заказа (парсинг с даты через JSON) в виде дд-мм-гггг
    //@Column(name="orderDate")

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date orderDate;
    //время заказа (парсинг с даты через JSON) в виде чч-мм-сс
    //@Column(name="orderTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date orderTime;
    //отметка о выполнении
    //@Column(name="orderComplete")
    private boolean orderComplete;
    //имя клиента
    private String clientName;
    //номер телефона клиента
    private String clientPhone;
    //эдаки флажок срыва доставки, если он true (его может сделать таким курьер) - колл-центр должен сделать звонок и
    //договориться о другом времени доставки
    private boolean deliveryFail;

    public Order() {
    }

    public boolean isDeliveryFail() {
        return deliveryFail;
    }

    public void setDeliveryFail(boolean deliveryFail) {
        this.deliveryFail = deliveryFail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public boolean isOrderComplete() {
        return orderComplete;
    }

    public void setOrderComplete(boolean orderComplete) {
        this.orderComplete = orderComplete;
    }
}
