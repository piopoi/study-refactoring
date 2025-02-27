package refactoring.ch4;

import lombok.Getter;

@Getter
public class Producer {

    private String name;
    private Province province;
    private int cost;
    private int production;

    public Producer(String name, Province province, int cost, int production) {
        this.name = name;
        this.province = province;
        this.cost = cost;
        this.production = production;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setProduction(int production) {
        this.province.setTotalProduction(this.production + production);
        this.production = production;
    }
}
