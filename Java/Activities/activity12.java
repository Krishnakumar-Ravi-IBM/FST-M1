package activities;

@FunctionalInterface
interface Addable {
    int add(int a, int b);
}
//class test1 implements Addable{
//    public void add(int num1, int num2){
//        int ad1 = num1+num2;
//        System.out.println("The result is: "+ad1);
//    }
//}

public class activity12 {

    public static void main(String[] args) {
        Addable ad1 = (num1, num2)->(num1+num2);
        System.out.println("The addition1 results is: "+ad1.add(10,20));
//            ad1 = num1+num2;
//            System.out.println("The result is: "+ad1);
//        ad1.add(10,20);
        Addable ad2 = (num1, num2)->{ return num1+num2;};
//        ad2.add(10,10);
        System.out.println("The addition2 results is: "+ad2.add(50,50));

    }

}
