package auction.dao;

import auction.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOJPAImpl implements UserDAO
{
    private static final Logger LOGGER = Logger.getLogger(UserDAOJPAImpl.class.getName());

    private static final String ERROR_MESSAGE = "Something went wrong while interacting with the database";
    private static final String NO_RESULT_ERROR_MESSAGE = "No result was found in the database";

//    private HashMap<String, User> users;

    private final EntityManagerFactory factory;

    public UserDAOJPAImpl()
    {
//        users = new HashMap<String, User>();
        factory = Persistence.createEntityManagerFactory("auction");
    }

    @Override
    public int count()
    {
        int result = 0;

        EntityManager entityManager = factory.createEntityManager();
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
    public void create(User user)
    {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            create(entityManager, user);
            entityManager.getTransaction().commit();
        } catch (Exception e)
        {

            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        } finally
        {
            entityManager.close();
        }

//         if (findByEmail(user.getEmail()) != null) {
//            throw new EntityExistsException();
//        }
//        users.put(user.getEmail(), user);
    }

    private void create(EntityManager entityManager, User user) throws Exception
    {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user)
    {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            edit(entityManager, user);
            entityManager.getTransaction().commit();
        } catch (Exception e)
        {

            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        } finally
        {
            entityManager.close();
        }
//        if (findByEmail(user.getEmail()) == null) {
//            throw new IllegalArgumentException();
//        }
//        users.put(user.getEmail(), user);
    }

    private void edit(EntityManager entityManager, User user) throws Exception
    {
        entityManager.merge(user);
    }


    @Override
    public List<User> findAll()
    {
        List<User> result = new ArrayList<>();
        EntityManager entityManager = factory.createEntityManager();
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
        EntityManager entityManager = factory.createEntityManager();
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

    @Override
    public void remove(User user)
    {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            remove(entityManager, user);
            entityManager.getTransaction().commit();
        } catch (Exception e)
        {

            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        } finally
        {
            entityManager.close();
        }
//        users.remove(user.getEmail());
    }

    private void remove(EntityManager entityManager, User user)  throws Exception
    {
        entityManager.remove(entityManager.merge(user));
    }
}
