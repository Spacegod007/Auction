package auction.dao;

import auction.domain.Item;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ItemDAOJPAImpl extends DAOJPAImpl<Item> implements ItemDAO
{
    @Override
    public int count()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int returnable = -1;

        try
        {
            returnable = count(entityManager);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);

        }
        finally
        {
            entityManager.close();
        }

        return returnable;
    }

    private int count(EntityManager entityManager) throws Exception
    {
        Query query = entityManager.createNamedQuery("Item.count", Item.class);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Item find(Long id)
    {
        Item returnItem = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try
        {
           returnItem = find(entityManager, id);
            entityManager.getTransaction().commit();
        }
        catch (NoResultException e)
        {
            LOGGER.log(Level.INFO, NO_RESULT_ERROR_MESSAGE);
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);

        }
        finally
        {
            entityManager.close();
        }
        return  returnItem;

    }

    private Item find(EntityManager entityManager, Long id) throws Exception
    {
        return entityManager.createNamedQuery("Item.find", Item.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Item> findAll()
    {
        List<Item> returnable = new ArrayList<Item>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            returnable = findAll(entityManager);
            entityManager.getTransaction().commit();
        }
        catch (NoResultException e)
        {
            LOGGER.log(Level.INFO, NO_RESULT_ERROR_MESSAGE);
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        finally
        {
            entityManager.close();
        }

        return returnable;
    }

    private List<Item> findAll(EntityManager entityManager) throws Exception
    {
        return entityManager.createNamedQuery("Item.findAll", Item.class).getResultList();
    }

    @Override
    public List<Item> findByDescription(String description)
    {
        List<Item> returnable = new ArrayList<Item>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            returnable = findByDescription(entityManager, description);
            entityManager.getTransaction().commit();
        }
        catch (NoResultException e)
        {
            LOGGER.log(Level.INFO, NO_RESULT_ERROR_MESSAGE);
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        finally
        {
            entityManager.close();
        }

        return returnable;
    }

    private List<Item> findByDescription(EntityManager entityManager, String description) throws Exception
    {
        return entityManager.createNamedQuery("Item.findByDescription", Item.class)
                .setParameter("description", description)
                .getResultList();
    }
}
