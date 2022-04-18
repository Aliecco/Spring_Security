package web.security.spring_security.dao;

import org.springframework.stereotype.Repository;
import web.security.spring_security.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from " + User.class.getSimpleName(), User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return entityManager.createQuery(
                        "SELECT user FROM User user WHERE user.email =:email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}