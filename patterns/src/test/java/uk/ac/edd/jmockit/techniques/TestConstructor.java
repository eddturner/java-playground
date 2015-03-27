package uk.ac.edd.jmockit.techniques;

import mockit.*;
import org.junit.Test;
import uk.ac.edd.patterns.decorator.BasicEngineController;
import uk.ac.edd.patterns.decorator.EngineController;
import uk.ac.edd.patterns.decorator.SupermanCarEngineController;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created 24/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class TestConstructor {
    @Test
    public void shouldMockConstuctorWithSparkPlugsOKFalse() {
        new MockUp<BasicEngineController>() {
            @Mock
            public void $init(Invocation invocation) {
                BasicEngineController instance = invocation.getInvokedInstance();
                Deencapsulation.setField(instance, "sparkPlugsOk", false);
            }
        };

        BasicEngineController basicEC = new BasicEngineController();

        assertThat(basicEC.selfCheck(), is(false));
    }

    @Test
    public void shouldMockConstuctorWithSparkPlugsOKTrue() {
        new MockUp<BasicEngineController>() {
            @Mock
            public void $init(Invocation invocation) {
                BasicEngineController instance = invocation.getInvokedInstance();
                Deencapsulation.setField(instance, "sparkPlugsOk", true);
            }
        };

        BasicEngineController basicEC = new BasicEngineController();

        assertThat(basicEC.selfCheck(), is(true));
    }

    @Test
    public void shouldMockConstuctorWithSparkPlugsDefault() {
        BasicEngineController basicEC = new BasicEngineController();

        assertThat(basicEC.selfCheck(), is(true));
    }

    @Test
    public void shouldNotMockParameterizedConstructor() {
        EngineController basicEC = new BasicEngineController();
        final SupermanCarEngineController supermanEC = new SupermanCarEngineController(basicEC);

        supermanEC.selfCheck();

        new Verifications() {{
            supermanEC.checkKryptoniteProximityOk();
            supermanEC.isWithinCoveredServicePeriod();
        }};
    }

    /**
     * Here we don't actually mock the SupermanEngineController but its constructor
     * parameter, BasicEngineController
     */
    @Test
    public void shouldMockParameterizedConstructor() {
        new MockUp<BasicEngineController>() {
            @Mock(invocations = 1)
            boolean selfCheck() {
                return false;
            }
        };

        final BasicEngineController basicEC = new BasicEngineController();
        final SupermanCarEngineController supermanEC = new SupermanCarEngineController(basicEC);

        final boolean supermanECSelfCheckValue = supermanEC.selfCheck();

        new Verifications() {{
            assertThat(supermanECSelfCheckValue, is(false));
            supermanEC.checkKryptoniteProximityOk();
            supermanEC.isWithinCoveredServicePeriod();
        }};
    }

    @Test
    public void shouldMockBothBasicAndSuperman(@Mocked final BasicEngineController basicEC) {
        new Expectations() {{
            basicEC.selfCheck();
            result = false;
            times = 1;
        }};

        final SupermanCarEngineController supermanEC = new SupermanCarEngineController(basicEC);

        final boolean supermanECSelfCheckValue = supermanEC.selfCheck();

        new Verifications() {{
            assertThat(supermanECSelfCheckValue, is(false));
            supermanEC.checkKryptoniteProximityOk();
            supermanEC.isWithinCoveredServicePeriod();
        }};
    }
}
