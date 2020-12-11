package org.example.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.example.enums.CardType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class CreditCard implements Serializable {

    private CardType cardType;
    private String bankName;
    private String cardNumber;
    private transient Date exp;
    private transient int cvv;


}
