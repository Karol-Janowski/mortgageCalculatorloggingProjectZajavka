package pl.zajavka.mortgage.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Rate {

    BigDecimal rateNumber;
    TimePoint timePoint;
    RateAmounts rateAmounts;
    MortgageResidual mortgageResidual;
    MortgageReference mortgageReference;

}
