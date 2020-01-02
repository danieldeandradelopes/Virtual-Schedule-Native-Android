package jacode.com.br.agendavirtual.Entidades;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private String email;
    private String sex;
    private String keyUser;
    private String password;
    private String uid;
    public Map<String, Boolean> users = new HashMap<>();

    public User() {

    }

    public User(String name, String email, String sex, String keyUser, String uid) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.keyUser = keyUser;
        this.uid = uid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getKeyUser() {
        return keyUser;
    }

    public void setKeyUser(String keyUser) {
        this.keyUser = keyUser;
    }

    @Exclude
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("email", email);
        result.put("sex", sex);
        result.put("keyUser", keyUser);
        result.put("uid", uid);
        result.put("users", users);

        return result;
    }

}
