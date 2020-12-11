package org.example;

import org.example.enums.CardType;
import org.example.pojo.CreditCard;

import java.io.*;
import java.util.Date;

public class SerializeTest {

    public static void main( String[] args ) {
        CreditCard creditCard = CreditCard.builder()
                .cardNumber("1111 2222 3333 4444")
                .cardType(CardType.MASTERCARD)
                .bankName("A-bank")
                .exp(new Date())
                .cvv(111)
                .build();

        File file = new File("object.dat");
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(creditCard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
