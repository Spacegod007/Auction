package auction.dao;

import auction.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class UserDAOJPAImpl extends DAOJPAImpl<User> implements UserDAO
{
    public UserDAOJPAImpl()
    {
        super();
    }

    @Override
    public int count()
    {
        int result = 0;

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            result = count(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        } finally
        {
            entityManager.close();
        }

        return result;
    }

    private int count(EntityManager entityManager) throws Exception
    {
        Query query = entityManager.createNamedQuery("User.count", User.class);
        return (Integer) query.getSingleResult();
    }


    @Override
    public List<User> findAll()
    {
        List<User> result = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            result = findAll(entityManager);
            entityManager.getTransaction().commit();
        } catch (NoResultException e)
        {
            LOGGER.log(Level.INFO, NO_RESULT_ERROR_MESSAGE);
        } catch (Exception e)
        {

            LOGGER.log(Level.SEVERE, ERROR_MESSAGE);
        } finally
        {
            entityManager.close();
        }
        return result;
//        return new ArrayList<User>(users.values());
    }

    private List<User> findAll(EntityManager entityManager)  throws Exception
    {
        return entityManager.createNamedQuery("User.getAll", User.class)
                .getResultList();
    }

    @Override
    public User findByEmail(String email)
    {
        User result = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            result = findByEmail(entityManager, email);
            entityManager.getTransaction().commit();
        } catch (NoResultException e)
        {
            LOGGER.log(Level.INFO, NO_RESULT_ERROR_MESSAGE);
        } catch (Exception e)
        {

            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        } finally
        {
            entityManager.close();
        }
        return result;
//        return users.get(email);
    }

    private User findByEmail(EntityManager entityManager, String email) throws Exception
    {
        return entityManager.createNamedQuery("User.findByEmail", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
