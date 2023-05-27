public class User {
    private String userName;
    private String userID;
    private String userPassword;
    private boolean flag;
    private String BorrowBooK;

    public User() {
    }

    public User(String userName, String userID, String userPassword,boolean flag,String BorrowBooK) {
        this.userName = userName;
        this.userID = userID;
        this.userPassword = userPassword;
        this.flag=flag;
        this.BorrowBooK=BorrowBooK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getBorrowBooK() {
        return BorrowBooK;
    }

    public void setBorrowBooK(String borrowBooK) {
        BorrowBooK = borrowBooK;
    }

}
