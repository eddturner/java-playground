package uk.ac.edd.patterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.edd.response.ProcessOutcome;

import java.io.File;

/**
 * Created 13/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class FileLegacyProcessor implements LegacyProcessor<File, ProcessOutcome> {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(FileLegacyProcessor.class);

    @Override
    public ProcessOutcome process(File entity) {
        logger.info("processing: {}", entity.getName());
        return ProcessOutcome.newBuilder().withName("FileProcessor has produced outcome.").build();
    }
}
