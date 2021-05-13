package model;

/**
*   
*/
public class Category {
        
    
    private Long id;
    
    private String name;
    
    public Category() { }

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "id : " + id +
        "name : " + name;
    }

    public boolean equals(Category other){
        return this.id.equals(other.getId()) &&
        this.name.equals(other.getName());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.id.hashCode();
        result = prime * result + this.name.hashCode();
        
        return result;
    }
}
