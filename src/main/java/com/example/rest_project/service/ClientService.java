package com.example.rest_project.service;

import com.example.rest_project.model.Order;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ClientService {

    /**
     * Создает нового клиента
     * @param order - клиент для создания
     */
    void create(Order order);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Order> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Order read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param order - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Order order, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return
     */
    boolean delete(int id);

    /**
     * Поиск в БД и вывод по определнной дате
     * @param fromDate- начальная дата
     * @param toDate - конечная дата
     * @return
     */
    List<Order> findByDate(String  fromDate, String toDate) throws ParseException;
    List<Order> findByDate(String  fromDate, String toDate, int id) throws ParseException;

    /**
     * указывает что не курьер не успевает доставить заказ
     * @param id - ориентируемся по номеру заказа
     * @return - возвращает true, если заказ не может быть выполнен в срок
     */

}