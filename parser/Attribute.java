package parser;

import java.io.Serializable;

public class Attribute implements Serializable {
    private String name;
    private String value;

    public Attribute(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName(){ return name; }

    public String getValue(){ return value; }
}
