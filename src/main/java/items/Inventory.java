package items;

import containers.LinkedList;


/**
 * An Inventory is composed of n slots. Each slot may store only
 * one type of item--specified by *slots*.
 * <p>
 * Once all slots are filled, no additional Item types may be
 * stored. Individual slots may contain any number of the same
 * Item--if the Item is stackable.
 */
public class Inventory
{
    /**
     * This is the Default Inventory size.
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * Individual item slots--each ItemStack occupies one slot.
     */
    private LinkedList<ItemStack> slots;

    /**
     * Total number of distinct Item types that can be stored.
     */
    private int capacity;

    /**
     * Default to an inventory with 10 slots.
     */
    public Inventory()
    {
        this(DEFAULT_SIZE);
    }

    /**
     * Create an inventory with n slots.
     *
     * @param desiredCapacity size of the new Inventory
     */
    public Inventory(int desiredCapacity)
    {
        this.slots    = new LinkedList<ItemStack>();
        this.capacity = desiredCapacity;
    }

    /**
     * Determine the number of slots currently in use.
     */
    public int utilizedSlots()
    {
        return this.slots.currentSize;
    }

    /**
     * Determine the number of empty (unused) slots.
     */
    public int emptySlots()
    {
        return this.totalSlots() - this.utilizedSlots();
    }

    /**
     * Retrieve the capacity (number of distinct types of items) that this
     * inventory can store.
     */
    public int totalSlots()
    {
        return this.capacity;
    }

    /**
     * Determine if the inventory is considered full.
     *
     * @return true if the current size is equal to capacity
     */
    public boolean isFull()
    {
        // Replace the next line
        return false;
    }

    /**
     * Determine if the inventory is empty.
     *
     * @return true if current size is zero
     */
    public boolean isEmpty()
    {
        return this.slots.currentSize == 0;
    }

    /**
     * This is the standard Linked List append operation from Review 01
     *
     * @param toAdd data that we want to store in a Node and add to the list
     */
    public void addItemStackNoCheck(ItemStack toAdd)
    {
        LinkedList.Node<ItemStack> newNode = new LinkedList.Node<>(toAdd);

        // Use the appendNode/add logic from Review 1 as your starting point
        // Once we reach this function... we know that `toAdd` must be stored
    }

    /**
     * Add one or more items to the inventory list.
     *
     * @param stack new stack of items to add
     *
     * @return true if *stack* was added and false otherwise
     */
    public boolean addItems(ItemStack stack)
    {
        if (!this.isFull()) {
            this.addItemStackNoCheck(stack);
            return true;
        }

        return false;
    }

    /**
     * *Print* a Summary of the Inventory and all Items contained within.
     */
    @Override
    public String toString()
    {
        String summaryLine = String.format(
            " -Used %d of %d slots%n", this.slots.currentSize, this.capacity
        );

        StringBuilder strBld = new StringBuilder();
        strBld.append(summaryLine);

        LinkedList.Node<ItemStack> it = this.slots.head;

        while (it != null) {
            String itemLine = String.format("  %s%n", it.data);
            strBld.append(itemLine);

            it = it.next;
        }

        return strBld.toString();
    }
}
