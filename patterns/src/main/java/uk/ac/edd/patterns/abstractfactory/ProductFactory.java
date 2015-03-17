package uk.ac.edd.patterns.abstractfactory;

/**
 * Created 17/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class ProductFactory {
    public static Product createProduct(AbstractProductFactory abstractProductFactory) {
        return abstractProductFactory.createProduct();
    }
}
