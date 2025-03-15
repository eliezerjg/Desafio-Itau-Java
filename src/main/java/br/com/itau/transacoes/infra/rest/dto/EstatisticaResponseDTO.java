package br.com.itau.transacoes.infra.rest.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EstatisticaResponseDTO implements Serializable {
    private int count;
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal min;
    private BigDecimal max;

    public static EstatisticaResponseDTO filledWithZeroInstance(){
        EstatisticaResponseDTO empty = new  EstatisticaResponseDTO();
        empty.setCount(0);
        empty.setSum(BigDecimal.ZERO);
        empty.setAvg(BigDecimal.ZERO);
        empty.setMin(BigDecimal.ZERO);
        empty.setMax(BigDecimal.ZERO);
        return empty;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }
}
