package model;

import java.math.BigDecimal;
/**
*   
*/
public class Number {
        
    private BigDecimal number;
    
    public Number() { }

    public Number(BigDecimal number){
        this.number = number;
        
    }

    public BigDecimal getNumber(){
        return this.number;
    }

    public void setNumber(BigDecimal number){
        this.number = number;
    }

    public String toString(){
        return "number : " + number;
    }

    public boolean equals(Number other){
        return this.number.equals(other.getNumber());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.number.hashCode();
        
        return result;
    }
}
