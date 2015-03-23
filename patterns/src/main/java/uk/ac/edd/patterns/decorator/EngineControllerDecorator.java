package uk.ac.edd.patterns.decorator;

/**
 * Created 18/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public abstract class EngineControllerDecorator implements EngineController {
    // the wrapped engine controller
    protected EngineController engineController;
}
