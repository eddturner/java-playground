package uk.ac.edd.patterns.adapter;

import uk.ac.edd.patterns.response.ProcessOutcome;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created 13/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class LegacyProcessorAdapter implements LegacyProcessor<File, ProcessOutcome> {
    private NewProcessor<File, ProcessOutcome> newProcessor;

    public LegacyProcessorAdapter(NewProcessor<File, ProcessOutcome> newProcessor) {
        this.newProcessor = newProcessor;
    }

    @Override

    public ProcessOutcome process(File entity) {
        List<String> results = new ArrayList<String>();
        ProcessOutcome processOutcome = newProcessor.preProcess(entity);
        results.addAll(processOutcome.getResults());

        processOutcome = newProcessor.process(entity);
        results.addAll(processOutcome.getResults());

        processOutcome = newProcessor.postProcess(entity);
        results.addAll(processOutcome.getResults());

        return ProcessOutcome.newBuilder().withName("LegacyProcessorAdaptor has produced outcome.").withResults(results)
                .build();
    }
}
