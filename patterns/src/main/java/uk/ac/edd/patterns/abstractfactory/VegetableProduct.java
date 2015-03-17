package uk.ac.edd.patterns.abstractfactory;

/**
 * Created 17/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class VegetableProduct implements Product {
    private static final String VEGETABLE = "vegetable: ";
    String name;
    double price;

    @Override
    public void setName(String name) {
        this.name = VEGETABLE + name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
