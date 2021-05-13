package model;

/**
*   
*/
public class Template {
        
    
    private String template;
    
    public Template() { }

    public Template(String template){
        this.template = template;
    }

    public String getTemplate(){
        return this.template;
    }

    public void setTemplate(String template){
        this.template = template;
    }

    public String toString(){
        return "template : " + template;
    }

    public boolean equals(Template other){
        return this.template.equals(other.getTemplate());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.template.hashCode();
        
        return result;
    }
}
