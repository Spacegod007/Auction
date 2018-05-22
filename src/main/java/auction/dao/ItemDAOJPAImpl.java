package auction.dao;

import auction.domain.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAOJPAImpl implements ItemDAO
{
    private static final Logger LOGGER = Logger.getLogger(ItemDAOJPAImpl.class.getName());

    private static final String ERROR_MESSAGE = "Something went wrong while interacting with the database";
    private final EntityManagerFactory entityManagerFactory;

    public ItemDAOJPAImpl()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("auction");
    }

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
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }

        return returnable;
    }

    private int count(EntityManager entityManager)
    {
        Query query = entityManager.createNamedQuery("Item.count", Item.class);
        return (Integer) query.getSingleResult();
    }

    @Override
    public void create(Item item)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            create(entityManager, item);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }
    }

    private void create(EntityManager entityManager, Item item)
    {
        entityManager.persist(item);
    }

    @Override
    public void edit(Item item)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            edit(entityManager, item);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }
    }

    private void edit(EntityManager entityManager, Item item)
    {
        entityManager.merge(item);
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
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }
        return  returnItem;

    }

    private Item find(EntityManager entityManager, Long id)
    {
        return entityManager.createNamedQuery("Item.find", Item.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Item> findAll()
    {
        List<Item> returnable = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            returnable = findAll(entityManager);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }

        return returnable;
    }

    private List<Item> findAll(EntityManager entityManager)
    {
        return entityManager.createNamedQuery("Item.findAll", Item.class).getResultList();
    }

    @Override
    public List<Item> findByDescription(String description)
    {
        List<Item> returnable = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            returnable = findByDescription(entityManager, description);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }

        return returnable;
    }

    private List<Item> findByDescription(EntityManager entityManager, String description)
    {
        return entityManager.createNamedQuery("Item.findByDescription", Item.class)
                .setParameter("description", description)
                .getResultList();
    }

    @Override
    public void remove(Item item)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            remove(entityManager, item);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
            entityManager.getTransaction().rollback();
        }
        finally
        {
            entityManager.close();
        }
    }

    private void remove(EntityManager entityManager, Item item)
    {
        entityManager.remove(entityManager.merge(item));
    }
}
