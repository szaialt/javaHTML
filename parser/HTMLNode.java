package parser;

import java.util.List;
import java.util.ArrayList;

public class HTMLNode {
    protected List<HTMLNode> children;
    protected List<Attribute> attributes;
    protected String text;
    protected String name;
    protected boolean isEmptyElement;
    
    HTMLNode(){
        children = new ArrayList<HTMLNode>();
        attributes = new ArrayList<Attribute>();
        text = "";
        name = "";
        isEmptyElement = false;
    }
    
    public void add(HTMLNode child){
        children.add(child);
    }
    
    public void add(String text){
        this.text = text;
    }
    
    public void add(String name, String value){
        if (isEmptyElement) throw new IllegalArgumentException("An empty element can't have any attribute.");
        Attribute attribute = new Attribute(name, value);
        add(attribute);
    }
    
    public void add(Attribute attribute){
        if (isEmptyElement) throw new IllegalArgumentException("An empty element can't have any attribute.");
        attributes.add(attribute);
    }
    
    public String printHtml() {
        StringBuilder builder = new StringBuilder();
        if (isEmptyElement) {
            builder.append("<"+name+">\n");
        }
        else {
            builder.append("<"+name);
            for (Attribute attr : attributes) {
                String attrName = attr.getName();
                String value = attr.getValue();
                builder.append(" "+attrName+"="+value);
            }
            builder.append(">\n");
            builder.append(text);
            for (HTMLNode child : children){
                builder.append(child.printHtml());
            }
            builder.append("</"+name+">\n");
            
        }
        return builder.toString();

    }
  
}
