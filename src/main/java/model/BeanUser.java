package model;

public class BeanUser {
    private int id;
    private String username;

    private String curp;

    private String birthday;

    public BeanUser() {
    }

    public BeanUser(int id,String username, String curp, String birthday) {
        this.id = id;
        this.username = username;
        this.curp = curp;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
