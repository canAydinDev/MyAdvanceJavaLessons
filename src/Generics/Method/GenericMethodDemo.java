package Generics.Method;

//Generic method'lar hangi durumda bize kolayluik sagliyor
public class GenericMethodDemo {

    public static void main(String[] args) {


        GenericMethodDemo obj1=new GenericMethodDemo();
        Integer[] intArray={1,23,54,56,45};
        Double [] doubleArray={1.21,3.43,2.34};

        obj1.print(intArray);
        obj1.print(doubleArray);

    }

    //KOTU ORNEK
//    public void print(Integer []arr){
//         //...
//    }
//    public void print(Double [] arr1){
//        //...
//    }

    //generic method
    public <T> void print (T [] array){
        for (T t :array){
            System.out.print(t);
        }
    }
}
