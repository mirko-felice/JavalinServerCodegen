package model;

/**
*   
*/
public class Tuple {
        
    
    private String tuple;
    
    public Tuple() { }

    public Tuple(String tuple){
        this.tuple = tuple;
    }

    public String getTuple(){
        return this.tuple;
    }

    public void setTuple(String tuple){
        this.tuple = tuple;
    }

    public String toString(){
        return "tuple : " + tuple;
    }

    public boolean equals(Tuple other){
        return this.tuple.equals(other.getTuple());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.tuple.hashCode();
        
        return result;
    }
}
