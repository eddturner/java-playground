package uk.ac.edd.patterns.abstractfactory;

/**
 * Created 17/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class MeatProduct implements Product {
    private static final String MEAT = "meat: ";
    String name;
    double price;

    @Override
    public void setName(String name) {
        this.name = MEAT + name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
