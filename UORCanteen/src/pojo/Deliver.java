package pojo;
// Generated Jul 3, 2021 10:54:01 AM by Hibernate Tools 4.3.1



/**
 * Deliver generated by hbm2java
 */
public class Deliver  implements java.io.Serializable {


     private Integer deliverId;
     private int deliverQunToday;
     private int deliverQunMonth;
     private String deliverName;
     private String deliverTel;

    public Deliver() {
    }

    public Deliver(int deliverQunToday, int deliverQunMonth, String deliverName, String deliverTel) {
       this.deliverQunToday = deliverQunToday;
       this.deliverQunMonth = deliverQunMonth;
       this.deliverName = deliverName;
       this.deliverTel = deliverTel;
    }
   
    public Integer getDeliverId() {
        return this.deliverId;
    }
    
    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }
    public int getDeliverQunToday() {
        return this.deliverQunToday;
    }
    
    public void setDeliverQunToday(int deliverQunToday) {
        this.deliverQunToday = deliverQunToday;
    }
    public int getDeliverQunMonth() {
        return this.deliverQunMonth;
    }
    
    public void setDeliverQunMonth(int deliverQunMonth) {
        this.deliverQunMonth = deliverQunMonth;
    }
    public String getDeliverName() {
        return this.deliverName;
    }
    
    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }
    public String getDeliverTel() {
        return this.deliverTel;
    }
    
    public void setDeliverTel(String deliverTel) {
        this.deliverTel = deliverTel;
    }




}


