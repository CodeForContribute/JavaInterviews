package DesignWareHouseManagement;
import java.util.List;

public class UserController {
    private List<User>userList;
    public UserController(List<User>userList){
        this.userList= userList;
    }
    // add User
    public void addUser(User user){
        this.userList.add(user);
    }
    // remove user
    public void removeUser(User user){
        this.userList.remove(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    //get particular user
    public User getUser(int userId){
        for (User user:this.userList){
            if (user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }
}
