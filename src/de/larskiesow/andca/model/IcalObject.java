package de.larskiesow.andca.model;


public class IcalObject {
    public String start;
    public String end;


    public IcalObject() {

    }
 @Override
    public String toString(){
    return this.start+this.end;

}

}
