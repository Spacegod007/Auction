package auction.dao;

public interface DAO<DBO>
{
    /**
     * The dataBaseObject is persisted. If a dataBaseObject with the same id already exists an EntityExistsException is thrown
     * @param dataBaseObject - entity instance
     */
    DBO create(DBO dataBaseObject);

    /**
     * Merge the state of the given dataBaseObject into persistent context. If the dataBaseObject did not exist an IllegalArgumentException is thrown
     * @param dataBaseObject - entity instance
     */
    void edit(DBO dataBaseObject);

    /**
     * Remove the entity instance
     * @param dataBaseObject - entity instance
     */
    void remove(DBO dataBaseObject);

    /**
     * Refreshes the entity instance
     * @param dataBaseObject - entity instance
     */
    void refresh(DBO dataBaseObject);
}
