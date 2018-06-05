package auction.dao;

public interface DAO<DBO>
{
    /**
     * The dataBaseObject is persisted. If a dataBaseObject with the same id already exists an EntityExistsException is thrown
     * @param dataBaseObject
     */
    void create(DBO dataBaseObject);

    /**
     * Merge the state of the given dataBaseObject into persistent context. If the dataBaseObject did not exist an IllegalArgumentException is thrown
     * @param dataBaseObject
     */
    void edit(DBO dataBaseObject);

    /**
     * Remove the entity instance
     * @param dataBaseObject - entity instance
     */
    void remove(DBO dataBaseObject);
}
