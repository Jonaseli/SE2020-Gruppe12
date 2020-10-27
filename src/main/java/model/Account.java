package model;

import java.util.UUID;

public class Account {

    private UUID accountId;
    private String displayName;
    private boolean suspended;

    public Account(){}

    public Account(String displayName, boolean suspended){
        this.accountId = UUID.randomUUID();
        this.displayName = displayName;
        this.suspended = suspended;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

}
