package refactoring.ch4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Getter;

@Getter
public class Province {

    private String name;
    private List<Producer> producers = new ArrayList<>();
    private int totalProduction = 0;
    private int demand;
    private int price;

    public Province(String name, int demand, int price, List<Producer> producers) {
        this.name = name;
        this.demand = demand;
        this.price = price;
        producers.forEach(this::addProducer);
    }

    public int shortfall() {
        return demand - totalProduction;
    }

    public int profit() {
        return demandValue() - demandCost();
    }

    private int demandValue() {
        return satisfiedDemand() * price;
    }

    private int satisfiedDemand() {
        return Math.min(demand, totalProduction);
    }

    private int demandCost() {
        int remainingDemand = demand;
        int result = 0;

        List<Producer> sortedProducers = producers.stream()
                .sorted(Comparator.comparingInt(Producer::getCost))
                .toList();

        for (Producer producer : sortedProducers) {
            int contribution = Math.min(remainingDemand, producer.getProduction());
            remainingDemand -= contribution;
            result += contribution * producer.getCost();
        }

        return result;
    }

    public void addProducer(Producer producer) {
        producers.add(producer);
        totalProduction += producer.getProduction();
    }

    public void setTotalProduction(int totalProduction) {
        this.totalProduction = totalProduction;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
