package model;

public class Corporation extends Account {

    public Corporation(){}

    public Corporation(String accountID, String displayName, boolean suspended) {
        super(accountID, displayName, suspended);
    }

    public String getCorporation_ID(String accountID){
        return accountID;
    }

    public String getCorporation_Name(String displayName){
        return displayName;
    }

    public boolean getCorporation_Suspended_Status(boolean suspended){
        return suspended;
    }

    //TODO
    //interface funksjon under

}
