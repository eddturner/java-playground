package uk.ac.edd.patterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created 18/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class SupermanCarEngineController extends EngineControllerDecorator {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(SupermanCarEngineController.class);

    public SupermanCarEngineController(EngineController engineController) {
        this.engineController = engineController;
    }

    @Override
    public boolean selfCheck() {
        return this.engineController.selfCheck() // forward request to decorated instance
                && checkKryptoniteProximityOk()  // ... and apply additional behaviour
                && isWithinCoveredServicePeriod();
    }

    public boolean checkKryptoniteProximityOk() {
        logger.debug("kryptonite not detected");
        return true;
    }

    public boolean isWithinCoveredServicePeriod() {
        logger.debug("within covered servicing period: all looking good");
        return true;
    }

    public void goSuperSonic() {
        logger.info("GOING SUPERSONIC!");
    }
}
