package org.example;

import org.example.pojo.CreditCard;

import java.io.*;

public class DeserializeTest {

    public static void main( String[] args ) {
        CreditCard creditCard;

        File file = new File("object.dat");
        try(ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream(file))) {
            Object o = objectOutputStream.readObject();
            if(o instanceof CreditCard)
            {
                creditCard = (CreditCard) o;
                System.out.println(creditCard);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
