package Generics.Bounding;

public class GenericUpperBound<T extends Number> {// !!ustten sinirliyorum

    private T[] numberArray;


    //constructor

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //array'in icindeki degerlerin ort. bulan method

    public double getAverage(){
        double sum=0;
        for (T t: numberArray){
            sum+=t.doubleValue();//double type'ine donduruyor
        }
        double avg=sum/ numberArray.length;
        return avg;
    }

    public static void main(String[] args) {
        Integer [] intArray={2,4,7,33};
        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArray);
        System.out.println(obj1.getAverage());

        Double[] doubleArray={2.4,3.4,5.4};
        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubleArray);
        System.out.println(obj2.getAverage());

//        String[] stArray={"hello", "word"};
//        GenericUpperBound<String> obj3=new GenericUpperBound<String>(stArray);//runtime exception hatasindan bizi kurtariyor
    }

}
