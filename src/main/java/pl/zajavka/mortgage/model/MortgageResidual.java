package pl.zajavka.mortgage.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class MortgageResidual {

    BigDecimal residualAmount;
    BigDecimal residualDuration;

}
