package pl.zajavka.mortgage.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class RateAmounts {

    BigDecimal rateAmount;
    BigDecimal interestAmount;
    BigDecimal capitalAmount;
    Overpayment overpayment;

}
