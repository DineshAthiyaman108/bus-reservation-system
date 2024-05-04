package com.BusReservation.Project.SignUp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="Sign_In")
public class SignUp {

   
    @jakarta.persistence.Id
    private int userAadhar;

    @Column(name="user_name")
    private String userName;
 
    @Column(name="user_phone") 
    private long userPhone;

    @Column(name="user_email")
    private String userEmail;
    
    @Column(name="user_password")
    private String userPassword;

    public SignUp(String userEmail, String userName, String userPassword, int userAadhar, long userPhone) {
        this.userAadhar = userAadhar;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    public SignUp( String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
