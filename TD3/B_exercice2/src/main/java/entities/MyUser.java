package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyUser {
    @Id
    //tototo
    private String login;
    private String password;

    public MyUser(){}

    public MyUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    /*
    On n'autorise pas la modif de login, qui est la clé...
    public void setLogin(String login) {
        this.login = login;
    }
     */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
