package pojo;
// Generated Jul 3, 2021 10:54:01 AM by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userId;
     private String userReg;
     private String userFullName;
     private String userName;
     private String userPassword;
     private String userEmail;
     private String userAddres;
     private String userState;
     private String userOtp;
     private String userEmailState;
     private String userTel;

    public User() {
    }

    public User(String userReg, String userFullName, String userName, String userPassword, String userEmail, String userAddres, String userState, String userOtp, String userEmailState, String userTel) {
       this.userReg = userReg;
       this.userFullName = userFullName;
       this.userName = userName;
       this.userPassword = userPassword;
       this.userEmail = userEmail;
       this.userAddres = userAddres;
       this.userState = userState;
       this.userOtp = userOtp;
       this.userEmailState = userEmailState;
       this.userTel = userTel;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserReg() {
        return this.userReg;
    }
    
    public void setUserReg(String userReg) {
        this.userReg = userReg;
    }
    public String getUserFullName() {
        return this.userFullName;
    }
    
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserAddres() {
        return this.userAddres;
    }
    
    public void setUserAddres(String userAddres) {
        this.userAddres = userAddres;
    }
    public String getUserState() {
        return this.userState;
    }
    
    public void setUserState(String userState) {
        this.userState = userState;
    }
    public String getUserOtp() {
        return this.userOtp;
    }
    
    public void setUserOtp(String userOtp) {
        this.userOtp = userOtp;
    }
    public String getUserEmailState() {
        return this.userEmailState;
    }
    
    public void setUserEmailState(String userEmailState) {
        this.userEmailState = userEmailState;
    }
    public String getUserTel() {
        return this.userTel;
    }
    
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }




}


