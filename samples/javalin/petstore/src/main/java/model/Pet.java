package model;

import java.util.List;
import model.Category;
import model.Tag;
/**
*   
*/
public class Pet {
    
    public enum StatusEnum{
        
        AVAILABLE,
        
        PENDING,
        
        SOLD;

        private String value;

        static {
            AVAILABLE.value = "available";
            PENDING.value = "pending";
            SOLD.value = "sold";
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
    
    private Category category;
    
    private String name;
    
    private List<String> photoUrls;
    
    private List<Tag> tags;
    /**
    *   pet status in the store
    */
    private StatusEnum status;
    
    public Pet() { }

    public Pet(Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, StatusEnum status){
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Category getCategory(){
        return this.category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<String> getPhotoUrls(){
        return this.photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls){
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags(){
        return this.tags;
    }

    public void setTags(List<Tag> tags){
        this.tags = tags;
    }

    public StatusEnum getStatus(){
        return this.status;
    }

    public void setStatus(StatusEnum status){
        this.status = status;
    }

    public String toString(){
        return "id : " + id +
        "category : " + category +
        "name : " + name +
        "photoUrls : " + photoUrls +
        "tags : " + tags +
        "status : " + status;
    }

    public boolean equals(Pet other){
        return this.id.equals(other.getId()) &&
        this.category.equals(other.getCategory()) &&
        this.name.equals(other.getName()) &&
        this.photoUrls.equals(other.getPhotoUrls()) &&
        this.tags.equals(other.getTags()) &&
        this.status.equals(other.getStatus());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.id.hashCode();
        result = prime * result + this.category.hashCode();
        result = prime * result + this.name.hashCode();
        result = prime * result + this.photoUrls.hashCode();
        result = prime * result + this.tags.hashCode();
        result = prime * result + this.status.hashCode();
        
        return result;
    }
}
