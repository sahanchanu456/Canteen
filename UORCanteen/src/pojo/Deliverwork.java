package pojo;
// Generated Jul 3, 2021 10:54:01 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Deliverwork generated by hbm2java
 */
public class Deliverwork  implements java.io.Serializable {


     private Integer deliverworkId;
     private int deliverworkDeliverId;
     private Date deliverworkStartDate;
     private Date deliverworkStartTime;
     private String deliverworkState;

    public Deliverwork() {
    }

    public Deliverwork(int deliverworkDeliverId, Date deliverworkStartDate, Date deliverworkStartTime, String deliverworkState) {
       this.deliverworkDeliverId = deliverworkDeliverId;
       this.deliverworkStartDate = deliverworkStartDate;
       this.deliverworkStartTime = deliverworkStartTime;
       this.deliverworkState = deliverworkState;
    }
   
    public Integer getDeliverworkId() {
        return this.deliverworkId;
    }
    
    public void setDeliverworkId(Integer deliverworkId) {
        this.deliverworkId = deliverworkId;
    }
    public int getDeliverworkDeliverId() {
        return this.deliverworkDeliverId;
    }
    
    public void setDeliverworkDeliverId(int deliverworkDeliverId) {
        this.deliverworkDeliverId = deliverworkDeliverId;
    }
    public Date getDeliverworkStartDate() {
        return this.deliverworkStartDate;
    }
    
    public void setDeliverworkStartDate(Date deliverworkStartDate) {
        this.deliverworkStartDate = deliverworkStartDate;
    }
    public Date getDeliverworkStartTime() {
        return this.deliverworkStartTime;
    }
    
    public void setDeliverworkStartTime(Date deliverworkStartTime) {
        this.deliverworkStartTime = deliverworkStartTime;
    }
    public String getDeliverworkState() {
        return this.deliverworkState;
    }
    
    public void setDeliverworkState(String deliverworkState) {
        this.deliverworkState = deliverworkState;
    }




}


