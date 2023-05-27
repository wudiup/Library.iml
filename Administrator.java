public class Administrator {
    private String name;
    private String administratorID;
    private String administratorPassword;

    public Administrator() {
    }

    public Administrator(String name, String administratorID, String administratorPassword) {
        this.name = name;
        this.administratorID = administratorID;
        this.administratorPassword = administratorPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(String administratorID) {
        this.administratorID = administratorID;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }
}
