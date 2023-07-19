package activities;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class activity9 {
    static String list[] = new String[]{"Apple", "Mango", "Orange", "Grapes", "Papaya"};

    public static void main(String[] args) {
    List<String> arrList = new ArrayList<String>();
//    for (int i=0; i<list.length;i++){
//    arrList.add(list[i]);
        for(String li : list){
            arrList.add(li);
        }System.out.println("The new Array list ss: "+arrList);

        String thirdElement = arrList.get(2);
        System.out.println("The third element in the Array List is: "+thirdElement);
        System.out.println("Does the array contains Mango? "+arrList.contains("Mango"));
        System.out.println("The size of the array is: "+arrList.size());
        System.out.println(arrList.remove("Mango")+"The new array list is: "+arrList);
        System.out.println("The updated size of the array is: "+arrList.size());
    }
}