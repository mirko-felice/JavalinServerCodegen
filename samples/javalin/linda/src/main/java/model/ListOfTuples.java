package model;

import java.util.ArrayList;
import java.util.List;
import model.Tuple;
/**
*   
*/
public class ListOfTuples {
        
    private List<Tuple> listOfTuples = new ArrayList<Tuple>();

    public ListOfTuples() { }

    public ListOfTuples(List<Tuple> listOfTuples){
        this.listOfTuples = listOfTuples;
    }

    public List<Tuple> getListOfTuples(){
        return this.listOfTuples;
    }

    public void setListOfTuples(List<Tuple> listOfTuples){
        this.listOfTuples = listOfTuples;
    }

    public String toString(){
        return "listOfTuples : " + listOfTuples;
    }

    public boolean equals(ListOfTuples other){
        return this.listOfTuples.equals(other.getListOfTuples());
    }

    @Override
    public int hashCode(){
        int prime = 19;
        int result = 31;
        result = prime * result + this.listOfTuples.hashCode();

        return result;
    }
}
