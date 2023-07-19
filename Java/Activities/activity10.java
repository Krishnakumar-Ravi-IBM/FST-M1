package activities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class activity10 {
    static String list[] = new String[]{"Obj1","Obj2","Obj3","Obj4","Obj5","Obj6"};

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        for(String li: list){
            names.add(li);
        }
        System.out.println("The Hashset contains \""+names.size()+"\" objects");
//        System.out.println(names);
        names.remove("Obj1" );
        System.out.println("The Hashset after removing Obj1 is as below : \n"+names);
        //Remove element that is not present
        if(names.remove("Obj9")) {
            System.out.println("Obj9 is removed from the Set");
        } else {
            System.out.println("You are trying to remove an Object which is not present in the Set, Kindly review");
        }
        System.out.println("Does the Hashset contains Obj1? "+names.contains("Obj1"));
        System.out.println("The updated Hashset is as following : "+names);
    }
}
