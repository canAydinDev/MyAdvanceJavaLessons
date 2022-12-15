package Generics.Bounding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericLowerBoundAndWildCard {
    public static void main(String[] args) {
        //***addElemet***
        List<Object> ol=new ArrayList<>();
        addElements(ol);

        List<Number> nl=new ArrayList<>();
        addElements(nl);
        List<Integer> il=new ArrayList<>();
        addElements(il);

//        List<Double> dl=new ArrayList<>();
//        addElements(dl);//CTE verdi. generic oncesinde RunTE verirdi


        //****printElement****
//        List<String> st=new ArrayList<>();
//        printElements(st);
        printElements(new ArrayList<String>());

        //*****printObject******
//        List<String> strList=new ArrayList<>();
//        printObj(strList);//CTE veriyor---> data auto casting nedeniyle kabul etmedi

        List<Object> objList= new ArrayList<>();
        objList.add(1);
        objList.add(2);
        printObj(objList);


    }

    //super Integer--> bana Integer'in parent'larini getir
    public static void addElements(List<? super Integer> list){
        //? : WildCard (tipi bilinmeyen)
        for (int i=1; i<=10; i++){
            list.add(i);
        }
    }
    //WildCard Sinirlamalari
    public static void printElements(List<?> listOfUnKnown){
    // listOfUnKnown.add("Java");--> ?'den dolayi data type netlesmeden add gibi islemleri yaptirmaz
    //    listOfUnKnown.add(null);// illa eklenecekse null'a izin verir
        for (Object obj:listOfUnKnown){
            System.out.println(obj);
        }


    }
    public static void printObj(List<Object> listOfObject){
        listOfObject.add("Java");
        for (Object object :listOfObject ){
            System.out.print(object+" ");
        }

    }
}
