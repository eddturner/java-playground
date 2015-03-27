package uk.ac.edd.patterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created 18/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class BasicEngineController implements EngineController {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(BasicEngineController.class);
    boolean sparkPlugsOk = true;

    @Override
    public boolean selfCheck() {
        logger.info("checking spark plugs: {}", sparkPlugsOk);
        return sparkPlugsOk;
    }
}
