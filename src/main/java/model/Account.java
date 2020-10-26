package model;

public class Account implements JSONReadable<Account>, JSONWritable<Account>{

    private String accountID, displayName;
    private boolean suspended;

    public Account(){}

    public Account(String accountID, String displayName, boolean suspended){
        this.accountID = accountID;
        this.displayName = displayName;
        this.suspended = suspended;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
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
