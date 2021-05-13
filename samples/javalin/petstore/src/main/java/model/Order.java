package model;

import java.util.Date;
/**
*   
*/
public class Order {
    
    public enum StatusEnum{
        
        PLACED,
        
        APPROVED,
        
        DELIVERED;

        private String value;

        static {
            PLACED.value = "placed";
            APPROVED.value = "approved";
            DELIVERED.value = "delivered";
        }

        public static StatusEnum fromValue(String value){
            for (StatusEnum status : values()){
                if (status.value.equals(value))
                    return status;
            }
            return null;
        }

        public String getValue(){
            return this.value;
        }

        public String toString(){
            return String.valueOf(this.value);
        }
    }
    
    
    private Long id;
    
    private Long petId;
    
    private Integer quantity;
    
    private Date shipDate;
    /**
    *   Order Status
    */
    private StatusEnum status;
    
    private Boolean complete;
    
    public Order() { }

    public Order(Long id, Long petId, Integer quantity, Date shipDate, StatusEnum status, Boolean complete){
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getPetId(){
        return this.petId;
    }

    public void setPetId(Long petId){
        this.petId = petId;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public Date getShipDate(){
        return this.shipDate;
    }

    public void setShipDate(Date shipDate){
        this.shipDate = shipDate;
    }

    public StatusEnum getStatus(){
        return this.status;
    }

    public void setStatus(StatusEnum status){
        this.status = status;
    }

    public Boolean getComplete(){
        return this.complete;
    }

    public void setComplete(Boolean complete){
        this.complete = complete;
    }

    public String toString(){
        return "id : " + id +
        "petId : " + petId +
        "quantity : " + quantity +
        "shipDate : " + shipDate +
        "status : " + status +
        "complete : " + complete;
    }

    public boolean equals(Order other){
        return this.id.equals(other.getId()) &&
        this.petId.equals(other.getPetId()) &&
        this.quantity.equals(other.getQuantity()) &&
        this.shipDate.equals(other.getShipDate()) &&
        this.status.equals(other.getStatus()) &&
        this.complete.equals(other.getComplete());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.id.hashCode();
        result = prime * result + this.petId.hashCode();
        result = prime * result + this.quantity.hashCode();
        result = prime * result + this.shipDate.hashCode();
        result = prime * result + this.status.hashCode();
        result = prime * result + this.complete.hashCode();
        
        return result;
    }
}
