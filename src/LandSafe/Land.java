package LandSafe;

import java.util.ArrayList;
import java.util.List;

public class Land {
    private List<Transfer> transfers;
    private Person owner;
    private List<Person> ownerHistory;
    private String id;

    public Land(String id, Person owner) {
        this.id = id;
        this.owner = owner;
        this.transfers = new ArrayList<>();
        this.ownerHistory = new ArrayList<>();
        this.ownerHistory.add(owner);
    }
    /*
     * This method returns the current owner of the land
     * @addTransfer(Transfer transfer) This method handles the transfer of land ownership
     * @param transfer the transfer of land ownership
     * @throws IllegalArgumentException if the transfer is null or the new owner is null
     * 
     */
    public void addTransfer(Transfer transfer) {
        if (transfer != null && transfer.getTo() != null) {
            this.transfers.add(transfer);
            this.ownerHistory.add(transfer.getTo()); // Add the new owner to the owner history
            this.owner = transfer.getTo();
        } else {
            throw new IllegalArgumentException("Invalid transfer or new owner.");
        }
    }

    // Getters
    public List<Transfer> getTransfers() {
        return transfers;
    }
    public Person getOwner() {
        return owner;
    }
    public List<Person> getOwnerHistory() {
        return ownerHistory;
    }
    public String getId() {
        return id;
    }
    //setters
    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
    public void setOwnerHistory(List<Person> ownerHistory) {
        this.ownerHistory = ownerHistory;
    }
    public void setId(String id) {
        this.id = id;
    }
    /*
     * This method returns a string representation of the Land object
     * @return a string representation of the Land object
     * Also, it returns the id, owner, ownerHistory, and the number of transfers
     */
    public String toString() {
        return "Land [id=" + id + ", owner=" + owner.getName() + ", ownerHistory=" 
        + ownerHistory.size() + ", transfers=" + transfers.size() + "]";
    }
   
}
