package uk.ac.edd.patterns.adapter;

/**
 * Created 13/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public interface LegacyProcessor<E, R> {
    public R process(E entity);
}
