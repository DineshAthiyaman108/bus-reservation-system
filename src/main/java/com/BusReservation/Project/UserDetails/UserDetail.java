package com.BusReservation.Project.UserDetails;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User_detail")
public class UserDetail {
    
    @Id
    @Column(name="Addhar_num")
    private int addarNum;
    
    @Column(name="seats")
    private int seats;

    @Column(name="user_name")
    private String name;
 
    @Column(name="user_phone") 
    private long phone;

    @Column(name="user_email")
    private String email;

    @Column(name="user_busNo") 
    private int busNo;

    @Column(name="user_date")
    private String date; 

    public UserDetail(String name, Long number,int aadharNum , int busNo)
    {
        this.addarNum=aadharNum;
        this.name=name;
        this.busNo=busNo;
        this.addarNum=aadharNum;
    }
    
    
}
