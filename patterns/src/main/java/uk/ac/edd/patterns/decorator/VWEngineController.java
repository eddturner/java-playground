package uk.ac.edd.patterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created 18/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class VWEngineController extends EngineControllerDecorator {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(VWEngineController.class);

    public VWEngineController(EngineController engineController) {
        this.engineController = engineController;
    }

    @Override
    public boolean selfCheck() {
        return this.engineController.selfCheck() // forward request to decorated instance
                && checkMechanicalParts()        // ... and apply additional behaviour
                && checkElectricalParts();
    }

    public boolean checkMechanicalParts() {
        logger.debug("mechanical components all fine");
        return true;
    }

    public boolean checkElectricalParts() {
        logger.debug("electrical components all fine");
        return true;
    }
}
