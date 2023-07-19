package activities;

//Abstract class
abstract class Book {
    String title;
    //Abstract method
    abstract void setTitle(String s);
    //Concrete method
    public String getTitle() {
        return title;
    }
}

class MyBook extends Book {
    //Define abstract method
    public void setTitle(String s) {
        title = s;
    }
}

public class activity5 {

    public static void main(String []args) {
        //Initialize title of the book
        String title = "How to move cheese";
        //Create object for MyBook
        Book newNovel = new MyBook();
        //Set title
        newNovel.setTitle(title);

        //Print result
        System.out.println("The title is: " + newNovel.getTitle());
    }
}
