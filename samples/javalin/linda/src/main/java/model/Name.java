package model;

/**
*   
*/
public class Name {
        
    private String name;
    
    public Name() { }

    public Name(String name){
        this.name = name;
        
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "name : " + name;
    }

    public boolean equals(Name other){
        return this.name.equals(other.getName());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.name.hashCode();
        
        return result;
    }
}
