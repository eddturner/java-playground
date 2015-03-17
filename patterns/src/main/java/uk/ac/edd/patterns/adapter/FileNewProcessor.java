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
public class FileNewProcessor implements NewProcessor<File, ProcessOutcome> {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(FileNewProcessor.class);

    @Override
    public ProcessOutcome preProcess(File entity) {
        logger.info("preprocessing: {}", entity.getName());
        return ProcessOutcome.newBuilder().withName("FilePreProcessor has produced outcome.").build();
    }

    @Override
    public ProcessOutcome process(File entity) {
        logger.info("processing: {}", entity.getName());
        return ProcessOutcome.newBuilder().withName("FilePreProcessor has produced outcome.").build();
    }

    @Override
    public ProcessOutcome postProcess(File entity) {
        logger.info("postprocessing: {}", entity.getName());
        return ProcessOutcome.newBuilder().withName("FilePreProcessor has produced outcome.").build();
    }
}
