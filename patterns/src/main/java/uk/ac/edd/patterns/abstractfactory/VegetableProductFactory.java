package uk.ac.edd.patterns.abstractfactory;

/**
 * Created 17/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class VegetableProductFactory implements AbstractProductFactory {
    @Override
    public Product createProduct() {
        return new VegetableProduct();
    }
}
