package org.cshaifasweng.winter.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@JsonTypeName("income_report")
public class IncomeReport extends Report {

    @ElementCollection
    private List<Double> incomeByDay;

    private Double totalIncome;

    public IncomeReport() {
        this.incomeByDay = new ArrayList<>();
        this.totalIncome = 0.0;
    }

    public List<Double> getIncomeByDay() {
        return incomeByDay;
    }

    public void setIncomeByDay(List<Double> incomeByDay) {
        this.incomeByDay = incomeByDay;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }
}
