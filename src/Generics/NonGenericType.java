package Generics;

public class NonGenericType {

    private Object o;

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public static void main(String[] args) {
        NonGenericType obj1=new NonGenericType();
        NonGenericType obj2=new NonGenericType();

        obj1.setO("Mirac");//String ile set ettik
        obj2.setO(65);
        String str1=(String) obj1.getO();//cast problemi
        System.out.println(str1);

        String str2=(String) obj2.getO();//!!! RunTE verir(ClassCastException). biz CTE almak isteriz
        //String.valueOf(obj2.getO());
        //Integer.parseInt(String)
    }
}

