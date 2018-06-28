package com.task.dao;

import com.task.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by duminda on 6/17/18.
 */
@Repository
public class TasksDAOImpl implements TasksDAO {

    private static final Logger logger = LoggerFactory.getLogger(TasksDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void insertRecord(Task task) {
        Session sc = sessionFactory.getCurrentSession();
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTime().getTime());
        task.setDate(today);
        sc.persist(task);

    }

    @Override
    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    public void updateRecord(Task task) {
        Session sc = sessionFactory.getCurrentSession();
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTime().getTime());
        task.setDate(today);
        sc.update(task);
    }

    @Override
    public Task getRecordById(int id) {
        Session sc = sessionFactory.getCurrentSession();

        Task t = sc.load(Task.class, new Integer(id));
        logger.info("Get Task : ", t);

        return t;
    }

    @Override
    public List<Task> getAllRecords() {
        Session sc = sessionFactory.getCurrentSession();
        List<Task> tasks = sc.createQuery("from Task").list();
        for (Task t : tasks){
            logger.info("Task : ", t);
        }
        return tasks;
    }

    @Override
    public int deleteRecord(int id) {
        int toDelete = 0;
        Session sc = sessionFactory.getCurrentSession();
        Task t = sc.load(Task.class, new Integer(id));
        if(t !=null){
            toDelete = t.getId();
            sc.delete(t);
        }

        return toDelete;
    }
}
