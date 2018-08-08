package eeethirdRefactor;

public class Boundary {
    public final Integer lowerBounds;
    public final Integer upperBounds;

    public Boundary(final Integer lowerBounds, Integer upperBounds) {
        this.lowerBounds = lowerBounds;
        this.upperBounds = upperBounds;
    }

    @Override
    public String toString() {
        return "Boundary{" +
                "lowerBounds=" + lowerBounds +
                ", upperBounds=" + upperBounds +
                '}';
    }

}
