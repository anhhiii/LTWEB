package vn.iotstar.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iotstar.config.JPAConfig;
import vn.iotstar.entity.Category;

public class CategoryDaoImpl implements CategoryDao{
	
	@Override
	public Category get(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(Category.class, id); 
        } finally {
            em.close();
        }
	}
	
    @Override
    public Category create(Category entity) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Category update(Category entity) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            Category merged = em.merge(entity);
            em.getTransaction().commit();
            return merged;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void remove(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            Category entity = em.find(Category.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Category findById(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Category> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
       
    @Override
    public boolean isExistName(String name) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM Category c WHERE c.cateName = :name",
                Long.class
            );
            query.setParameter("name", name);
            Long count = query.getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean isExistName(String name, int userId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM Category c WHERE c.cateName = :name AND c.user.id = :userId",
                Long.class
            );
            query.setParameter("name", name);
            query.setParameter("userId", userId);
            Long count = query.getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }


    @Override
    public List<Category> findByUser(int userId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.user.id = :userId", Category.class
            );
            query.setParameter("userId", userId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
