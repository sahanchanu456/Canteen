package pojo;
// Generated Jun 15, 2021 9:09:56 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Summorder generated by hbm2java
 */
public class Summorder  implements java.io.Serializable {


     private Integer summorderId;
     private int neworderId;
     private int neworderItemId;
     private int neworderQuntity;
     private Date neworderDate;
     private long neworderTime;
     private int neworderUserId;
     private String neworderNewAddres;
     private String neworderState;
     private int summorderDeliverId;
     private Date summorderSubDate;
     private int summorderSubTime;

    public Summorder() {
    }

    public Summorder(int neworderId, int neworderItemId, int neworderQuntity, Date neworderDate, long neworderTime, int neworderUserId, String neworderNewAddres, String neworderState, int summorderDeliverId, Date summorderSubDate, int summorderSubTime) {
       this.neworderId = neworderId;
       this.neworderItemId = neworderItemId;
       this.neworderQuntity = neworderQuntity;
       this.neworderDate = neworderDate;
       this.neworderTime = neworderTime;
       this.neworderUserId = neworderUserId;
       this.neworderNewAddres = neworderNewAddres;
       this.neworderState = neworderState;
       this.summorderDeliverId = summorderDeliverId;
       this.summorderSubDate = summorderSubDate;
       this.summorderSubTime = summorderSubTime;
    }
   
    public Integer getSummorderId() {
        return this.summorderId;
    }
    
    public void setSummorderId(Integer summorderId) {
        this.summorderId = summorderId;
    }
    public int getNeworderId() {
        return this.neworderId;
    }
    
    public void setNeworderId(int neworderId) {
        this.neworderId = neworderId;
    }
    public int getNeworderItemId() {
        return this.neworderItemId;
    }
    
    public void setNeworderItemId(int neworderItemId) {
        this.neworderItemId = neworderItemId;
    }
    public int getNeworderQuntity() {
        return this.neworderQuntity;
    }
    
    public void setNeworderQuntity(int neworderQuntity) {
        this.neworderQuntity = neworderQuntity;
    }
    public Date getNeworderDate() {
        return this.neworderDate;
    }
    
    public void setNeworderDate(Date neworderDate) {
        this.neworderDate = neworderDate;
    }
    public long getNeworderTime() {
        return this.neworderTime;
    }
    
    public void setNeworderTime(long neworderTime) {
        this.neworderTime = neworderTime;
    }
    public int getNeworderUserId() {
        return this.neworderUserId;
    }
    
    public void setNeworderUserId(int neworderUserId) {
        this.neworderUserId = neworderUserId;
    }
    public String getNeworderNewAddres() {
        return this.neworderNewAddres;
    }
    
    public void setNeworderNewAddres(String neworderNewAddres) {
        this.neworderNewAddres = neworderNewAddres;
    }
    public String getNeworderState() {
        return this.neworderState;
    }
    
    public void setNeworderState(String neworderState) {
        this.neworderState = neworderState;
    }
    public int getSummorderDeliverId() {
        return this.summorderDeliverId;
    }
    
    public void setSummorderDeliverId(int summorderDeliverId) {
        this.summorderDeliverId = summorderDeliverId;
    }
    public Date getSummorderSubDate() {
        return this.summorderSubDate;
    }
    
    public void setSummorderSubDate(Date summorderSubDate) {
        this.summorderSubDate = summorderSubDate;
    }
    public int getSummorderSubTime() {
        return this.summorderSubTime;
    }
    
    public void setSummorderSubTime(int summorderSubTime) {
        this.summorderSubTime = summorderSubTime;
    }




}

