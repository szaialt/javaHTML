import parser.*;

public class Test{
    public static void main(String[] args){
        HtmlDocument d = new HtmlDocument();
        d.add(new Div());
        Span s = new Span();
        s.add("Hello World");
        d.add(s);
        s.add("color", "blue");
        String str = d.printHtml();
        System.out.println(str);
    }
}
