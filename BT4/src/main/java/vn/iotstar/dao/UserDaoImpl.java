package vn.iotstar.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iotstar.config.JPAConfig;
import vn.iotstar.entity.User;

public class UserDaoImpl implements UserDao {
	
	@Override
	public User create(User entity) {
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
	public User update(User entity) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			User merged = em.merge(entity);
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
			User entity = em.find(User.class, id);
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
	public User findById(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			return em.find(User.class, id);
		} finally {
			em.close();
		}
	}

	@Override
	public List<User> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public User findByUsername(String username) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName", User.class);
			query.setParameter("userName", username);
			return query.getResultStream().findFirst().orElse(null);
		} finally {
			em.close();
		}
	}

	@Override
	public User findByEmail(String email) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
			query.setParameter("email", email);
			return query.getResultStream().findFirst().orElse(null);
		} finally {
			em.close();
		}
	}

}
