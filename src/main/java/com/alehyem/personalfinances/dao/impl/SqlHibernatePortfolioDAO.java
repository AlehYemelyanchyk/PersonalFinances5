package com.alehyem.personalfinances.dao.impl;

import com.alehyem.personalfinances.dao.PortfolioDAO;
import com.alehyem.personalfinances.entity.Portfolio;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SqlHibernatePortfolioDAO implements PortfolioDAO {

    private EntityManager entityManager;

    @Autowired
    public SqlHibernatePortfolioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Portfolio> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Portfolio> query = session.createQuery("from Portfolio order by name", Portfolio.class);
        List<Portfolio> portfolioList = query.getResultList();
        return portfolioList;
    }

    @Override
    public List<Portfolio> findAllUserPortfolios(int userId) {
        return null;
    }

    @Override
    public Portfolio findById(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Portfolio.class, id);
    }

    @Override
    public void save(Portfolio object) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(object);
    }

    @Override
    public Portfolio update(Portfolio object) {
        return null;
    }

    @Override
    public void delete(Portfolio object) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Portfolio where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
