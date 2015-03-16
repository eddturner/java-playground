package uk.ac.edd.patterns.adapter;

/**
 * Created 13/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public interface NewProcessor<E, R> {
    public R preProcess(E entity);
    public R process(E entity);
    public R postProcess(E entity);
}