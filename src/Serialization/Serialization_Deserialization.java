package Serialization;

import java.io.*;

public class Serialization_Deserialization {
    public static void main(String[] args) {

        //writeObjects();
        readObjects();
    }

    //writeObject()
    private static void writeObjects(){
        System.out.println("user objeleri olusturuluyor");
        User user1=new User(1l,"Yunus","123456");
        User user2=new User(2l,"Yusuf","234567");
        User user3=new User(3l,"Betul","345678");

        try(FileOutputStream fos = new FileOutputStream("user.dat")){//bu dosyayi yazmak icin
            try(ObjectOutputStream oos=new ObjectOutputStream(fos)){//bu objeleri yazmak icin
                oos.writeObject(user1);
                oos.writeObject(user2);
                oos.writeObject(user3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readObjects(){
        //java da file islemlerinde read islemi yaparken FileInputStream class kullanilir
        try(FileInputStream fis=new FileInputStream("user.dat")){ //okunacak dosyayi belirledik
           try (ObjectInputStream ois=new ObjectInputStream(fis)){//obje olarak okunacak
              User user1=(User) ois.readObject(); //user data type'a cast edip user1 e attik
              User user2=(User) ois.readObject();
              User user3=(User) ois.readObject();

               System.out.println(user1);
               System.out.println(user2);
               System.out.println(user3);

           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//user class'ini transfer edilebilsin diye isaretledik
 class User implements Serializable{

    //private field
    private Long id;
    private String name;
    private String tcKimlikNo;

    //const.

    public User(Long id, String name, String tcKimlikNo) {
        this.id = id;
        this.name = name;
        this.tcKimlikNo = tcKimlikNo;
    }

    //Getter-Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    //toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcKimlikNo='" + tcKimlikNo + '\'' +
                '}';
    }
}
