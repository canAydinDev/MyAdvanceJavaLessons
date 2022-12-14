package Generics.interfaceType;

//eger bir "generic interface" implement ederseniz , Class da generic olmali
public class GenericClassImpl<T> implements  GenericInterface<T>{

    @Override
    public void setValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
