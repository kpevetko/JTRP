package com.example.rest_project.model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Order findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Order.class, id);
    }

    //создать новый заказ
    @Override
    public void save(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
    }

    //изменить данные в заказе
    @Override
    public void update(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
    }

    //удалить заказ
    @Override
    public void delete(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(order);
        tx.commit();
        session.close();
    }

    //вывести всех на экран
    @Override
    public List<Order> findAll() {
        List<Order> allOrders = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Order").list();
        return allOrders;
    }

    /**
     * поиск в БД по дате От и До
     *
     * @param fromDate - дата от
     * @param toDate   - дата до
     * @return - вернет список совпадений (заказов)
     * @throws ParseException
     */
    @Override
    public List<Order> findByDate(String fromDate, String toDate) throws ParseException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date d = sdf.parse(fromDate);
        Query query = session.createQuery("from Order where orderDate between :from  and :to");
        query.setParameter("from", sdf.parse(fromDate));
        query.setParameter("to", sdf.parse(toDate));

        List<Order> formDataOrders = query.list();

        return formDataOrders;
    }

    /**
     * то же что и выше, но так же принимает id (номер заказа) в качестве параметра
     *
     * @param fromDate
     * @param toDate
     * @param id       - номер заказа
     * @return
     * @throws ParseException
     */
    @Override
    public List<Order> findByDate(String fromDate, String toDate, int id) throws ParseException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date d = sdf.parse(fromDate);
        Query query = session.createQuery("from Order where id = :idNum  AND orderDate between :from  and :to");
        query.setParameter("from", sdf.parse(fromDate));
        query.setParameter("to", sdf.parse(toDate));
        query.setParameter("idNum", id);

        List<Order> formDataOrders = query.list();

        return formDataOrders;
    }

}
