package parser;

public class Doctype extends HTMLNode {
    Doctype(){
        this.name = "!DOCTYPE html";
        this.isEmptyElement = true;
    }
}
