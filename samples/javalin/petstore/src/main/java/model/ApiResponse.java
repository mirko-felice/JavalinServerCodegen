package model;

/**
*   
*/
public class ApiResponse {
        
    
    private Integer code;
    
    private String type;
    
    private String message;
    
    public ApiResponse() { }

    public ApiResponse(Integer code, String type, String message){
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String toString(){
        return "code : " + code +
        "type : " + type +
        "message : " + message;
    }

    public boolean equals(ApiResponse other){
        return this.code.equals(other.getCode()) &&
        this.type.equals(other.getType()) &&
        this.message.equals(other.getMessage());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.code.hashCode();
        result = prime * result + this.type.hashCode();
        result = prime * result + this.message.hashCode();
        
        return result;
    }
}
