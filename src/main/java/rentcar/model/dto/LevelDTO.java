package rentcar.model.dto;

public class LevelDTO {

    private String level;
    private double discountRate;

    public LevelDTO() {}

    public LevelDTO(String level, double discountRate) {
        this.level = level;
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "LevelDTO{" +
                "level='" + level + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
