package fr.dataup.myquiz;

public class MainTest {
    public static void main(String[] args) {
        String s = "Hello [World]";
        //remove  only the brackets and keep the content inside  
        String result = s.replaceAll("[\\[\\](){}]", "");
        System.out.println(result);
    }
}
