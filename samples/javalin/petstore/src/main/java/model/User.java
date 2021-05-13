package model;

/**
*   
*/
public class User {
        
    
    private Long id;
    
    private String username;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String password;
    
    private String phone;
    /**
    *   User Status
    */
    private Integer userStatus;
    
    public User() { }

    public User(Long id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus){
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Integer getUserStatus(){
        return this.userStatus;
    }

    public void setUserStatus(Integer userStatus){
        this.userStatus = userStatus;
    }

    public String toString(){
        return "id : " + id +
        "username : " + username +
        "firstName : " + firstName +
        "lastName : " + lastName +
        "email : " + email +
        "password : " + password +
        "phone : " + phone +
        "userStatus : " + userStatus;
    }

    public boolean equals(User other){
        return this.id.equals(other.getId()) &&
        this.username.equals(other.getUsername()) &&
        this.firstName.equals(other.getFirstName()) &&
        this.lastName.equals(other.getLastName()) &&
        this.email.equals(other.getEmail()) &&
        this.password.equals(other.getPassword()) &&
        this.phone.equals(other.getPhone()) &&
        this.userStatus.equals(other.getUserStatus());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.id.hashCode();
        result = prime * result + this.username.hashCode();
        result = prime * result + this.firstName.hashCode();
        result = prime * result + this.lastName.hashCode();
        result = prime * result + this.email.hashCode();
        result = prime * result + this.password.hashCode();
        result = prime * result + this.phone.hashCode();
        result = prime * result + this.userStatus.hashCode();
        
        return result;
    }
}
