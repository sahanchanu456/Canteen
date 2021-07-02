package pojo;
// Generated Jun 15, 2021 9:09:56 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer itemId;
     private String itemName;
     private int itemPrice;
     private int itemQuntity;
     private Date itemUpDate;
     private String itemState;
     private String itemCatagory;
     private String itemImg;

    public Item() {
    }

    public Item(String itemName, int itemPrice, int itemQuntity, Date itemUpDate, String itemState, String itemCatagory, String itemImg) {
       this.itemName = itemName;
       this.itemPrice = itemPrice;
       this.itemQuntity = itemQuntity;
       this.itemUpDate = itemUpDate;
       this.itemState = itemState;
       this.itemCatagory = itemCatagory;
       this.itemImg = itemImg;
    }
   
    public Integer getItemId() {
        return this.itemId;
    }
    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemPrice() {
        return this.itemPrice;
    }
    
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getItemQuntity() {
        return this.itemQuntity;
    }
    
    public void setItemQuntity(int itemQuntity) {
        this.itemQuntity = itemQuntity;
    }
    public Date getItemUpDate() {
        return this.itemUpDate;
    }
    
    public void setItemUpDate(Date itemUpDate) {
        this.itemUpDate = itemUpDate;
    }
    public String getItemState() {
        return this.itemState;
    }
    
    public void setItemState(String itemState) {
        this.itemState = itemState;
    }
    public String getItemCatagory() {
        return this.itemCatagory;
    }
    
    public void setItemCatagory(String itemCatagory) {
        this.itemCatagory = itemCatagory;
    }
    public String getItemImg() {
        return this.itemImg;
    }
    
    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }




}


