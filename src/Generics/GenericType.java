package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType<T> {

    /*
    <>-->diamond operator
    E-->Elemet : collection gibi yapilarda kullanilir
    K-->Key
    V-->Value       map<K,V>
    N-->Number
    T-->Type
    S,U,V vb -->2. 3. 4. tipler icin
    */
    private  T type; //field, variable ayni

    //geter-setter
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    //main method
    public static void main(String[] args) {
        //generic yapi kullanarak ayni class'dan 2 farkli data turunde obje olusturun
        GenericType<String> obj1=new GenericType<>();
        //Trick : Diamond icine sadece non-primitive type kullanabiliriz
        obj1.setType("Generic Types");
        //GenericType<String> obj2=new GenericType<>();
        //obj2.setType(65);  //String girmem gerekirken int data turu girince CTE verdi

        //Note: Cast probleminden nasil kurtulurum
        GenericType<Integer> obj3=new GenericType<>();
        obj3.setType(65);
        int a=obj3.getType();//!!! Cast probleminden kurtulduk

        //note: ClassCastException probleminden(RTE) nasil kurtulurum
        List<String> list=new ArrayList<>();
        list.add("Alper");
        list.add("Halide");
        //list.add(22); //!!! ClassCastExceptiondan kurtulduk(Eskiden RTE alacagim hatayi CTE olarak almami sagladi)

        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Generic");
        //map.put("Generic",1);



    }
}
