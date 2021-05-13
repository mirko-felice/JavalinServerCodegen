package model;

import java.util.ArrayList;
import java.util.List;
import model.Name;
/**
*   
*/
public class ListOfNames {
        
    private List<Name> listOfNames = new ArrayList<Name>();

    public ListOfNames() { }

    public ListOfNames(List<Name> listOfNames){
        this.listOfNames = listOfNames;
    }

    public List<Name> getListOfNames(){
        return this.listOfNames;
    }

    public void setListOfNames(List<Name> listOfNames){
        this.listOfNames = listOfNames;
    }

    public String toString(){
        return "listOfNames : " + listOfNames;
    }

    public boolean equals(ListOfNames other){
        return this.listOfNames.equals(other.getListOfNames());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.listOfNames.hashCode();

        return result;
    }
}
