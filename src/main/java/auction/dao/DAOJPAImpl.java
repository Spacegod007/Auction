package auction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class DAOJPAImpl<DBO> implements DAO<DBO>
{
    static final Logger LOGGER = Logger.getLogger(DAOJPAImpl.class.getName());

    static final String ERROR_MESSAGE = "Something went wrong while interacting with the database";
    static final String NO_RESULT_ERROR_MESSAGE = "No result was found in the database";

    static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("auction");

    @Override
    public DBO create(DBO dataBaseObject)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            create(entityManager, dataBaseObject);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        finally
        {
            entityManager.refresh(dataBaseObject);
            entityManager.close();
        }
        return dataBaseObject;
    }

    private void create(EntityManager entityManager, DBO dataBaseObject) throws Exception
    {
        entityManager.persist(dataBaseObject);
  //      entityManager.refresh(dataBaseObject);
    }

    @Override
    public void edit(DBO dataBaseObject)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            edit(entityManager, dataBaseObject);
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
    }

    private void edit(EntityManager entityManager, DBO dataBaseObject) throws Exception
    {
        entityManager.merge(dataBaseObject);
    }

    @Override
    public void remove(DBO dataBaseObject)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            remove(entityManager, dataBaseObject);
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
    }

    private void remove(EntityManager entityManager, DBO dataBaseObject)
    {
        entityManager.remove(entityManager.merge(dataBaseObject));
    }
}
