package uk.ac.edd.patterns.decorator;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class EngineControllerTest {
    @Test
    public void testBasicEngineController() {
        BasicEngineController ctrl = mock(BasicEngineController.class);
        ctrl.selfCheck();

        verify(ctrl).selfCheck();
    }

    @Test
    public void testVWEngineController() {
        BasicEngineController basicEC = new BasicEngineController();
        VWEngineController spiedEC = spy(new VWEngineController(basicEC));
        spiedEC.selfCheck();

        verify(spiedEC).selfCheck();
        verify(spiedEC).checkMechanicalParts();
        verify(spiedEC).checkElectricalParts();
    }

    @Test
    public void testSupermanEC() {
        BasicEngineController basicEC = new BasicEngineController();
        SupermanCarEngineController spiedEC = spy(new SupermanCarEngineController(basicEC));

        spiedEC.selfCheck();

        verify(spiedEC).selfCheck();
        verify(spiedEC).checkKryptoniteProximityOk();
        verify(spiedEC).isWithinCoveredServicePeriod();
    }
}