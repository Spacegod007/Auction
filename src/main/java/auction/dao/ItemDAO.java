package auction.dao;

import auction.domain.Item;
import java.util.List;

public interface ItemDAO {

    /**
     *
     * @return number of item instances
     */
    int count();

    /**
     * The item is persisted. If a item with the same id allready exists an EntityExistsException is thrown
     * @param item
     */
    void create(Item item);

    /**
     * Merge the state of the given item into persistant context. If the item did not exist an IllegalArgumentException is thrown
     * @param item
     */
    void edit(Item item);

    /**
     *
     * @param id
     * @return the found entity instance or null if the entity does not exist
     */
    Item find(Long id);

    /**
     *
     * @return list of item instances
     */
    List<Item> findAll();
    /**
     *
     * @param description 
     * @return list of item instances having specified description
     */
    List<Item> findByDescription(String description);

    /**
     * Remove the entity instance
     * @param item - entity instance
     */
    void remove(Item item);
}
