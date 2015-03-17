package uk.ac.edd.patterns.abstractfactory;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductFactoryTest {
    @Test
    public void testMeatProductCreation() {
        AbstractProductFactory abstractProductFactory = new MeatProductFactory();
        Product product = ProductFactory.createProduct(abstractProductFactory);
        assertThat(product, instanceOf(MeatProduct.class));
    }

    @Test
    public void testVegetableProductCreation() {
        AbstractProductFactory abstractProductFactory = new VegetableProductFactory();
        Product product = ProductFactory.createProduct(abstractProductFactory);
        assertThat(product, instanceOf(VegetableProduct.class));
    }
}