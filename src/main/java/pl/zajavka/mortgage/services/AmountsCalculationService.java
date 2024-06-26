package pl.zajavka.mortgage.services;

import lombok.extern.slf4j.Slf4j;
import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Overpayment;
import pl.zajavka.mortgage.model.Rate;
import pl.zajavka.mortgage.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface AmountsCalculationService {

    BigDecimal YEAR = BigDecimal.valueOf(12);

    RateAmounts calculate(final InputData inputData, final Overpayment overpayment);

    RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate);

    static BigDecimal calculateInterestAmount(final BigDecimal residualAmount, final BigDecimal interestPercentValue) {
        return residualAmount.multiply(interestPercentValue).divide(AmountsCalculationService.YEAR, 2, RoundingMode.HALF_UP);
    }

    static BigDecimal calculateQ(final BigDecimal interestPercent) {
        return interestPercent.divide(AmountsCalculationService.YEAR, 10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
    }

    static BigDecimal compareCapitalWithResidual(final BigDecimal capitalAmount, final BigDecimal residualAmount) {
        if (capitalAmount.compareTo(residualAmount) >= 0) {
            return residualAmount;
        }
        return capitalAmount;
    }

}
