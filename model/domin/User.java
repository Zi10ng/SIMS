package model.domin;

import java.util.Objects;

/**
 * 存放登录的信息
 * @author 王石博
 * @date 2019年6月4日08:09:08
 */
public class User implements Comparable<User>{

    private String userName;
    private String password;

    public User(){}
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public int compareTo(User s) {
        return this.getUserName().compareTo(s.getUserName());
    }

}
