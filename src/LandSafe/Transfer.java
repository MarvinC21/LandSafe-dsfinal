package LandSafe;


/**
 * The Transfer class represents a transfer of ownership from one person to another.
 * It includes information about the current owner, the new owner, and the date of transfer.
 */
public class Transfer {

    private Person currentOwner;
    private Person newOwner;
    private String date;

    /**
     * Constructs a Transfer object with the specified current owner, new owner, and date.
     *
     * @param from the current owner of the property
     * @param to the new owner of the property
     * @param date the date of the transfer
     */
    public Transfer(Person from, Person to, String date) {
        this.currentOwner = from;
        this.newOwner = to;
        this.date = date;
    }

    /**
     * Returns the current owner of the property.
        return currentOwner;
     * @return the current owner
     */
    public Person getFrom() {
        return currentOwner;
    }

    /**
     * Returns the new owner of the property.
     *
     * @return the new owner
     */
    public Person getTo() {
        return newOwner;
    }

    /**
     * Returns the date of the transfer.
     *
     * @return the date of the transfer
     */
    public String getDate() {
        return date;
    }
}