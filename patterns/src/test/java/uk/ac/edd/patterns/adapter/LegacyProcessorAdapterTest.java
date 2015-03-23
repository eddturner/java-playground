package uk.ac.edd.patterns.adapter;

import org.junit.Test;
import org.mockito.InOrder;
import uk.ac.edd.response.ProcessOutcome;

import java.io.File;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LegacyProcessorAdapterTest {
    @Test
    public void testLegacyProcessorUsage() {
        File file = new File("test");
        LegacyProcessor<File, ProcessOutcome> processor = mock(FileLegacyProcessor.class);

        ProcessOutcome processOutcome = processor.process(file);
        verify(processor).process(file);
    }

    @Test
    public void testNewProcessorUsage() {
        File file = new File("test");
        FileNewProcessor mockNewProcessor = mock(FileNewProcessor.class);
        ProcessOutcome realProcessOutcome = ProcessOutcome.newBuilder().withName("testing").build();
        when(mockNewProcessor.preProcess(any(File.class))).thenReturn(realProcessOutcome);
        when(mockNewProcessor.process(any(File.class))).thenReturn(realProcessOutcome);
        when(mockNewProcessor.postProcess(any(File.class))).thenReturn(realProcessOutcome);

        LegacyProcessor<File, ProcessOutcome> processor = new LegacyProcessorAdapter(mockNewProcessor);

        ProcessOutcome processOutcome = processor.process(file);
        InOrder orderChecker = inOrder(mockNewProcessor);

        orderChecker.verify(mockNewProcessor).preProcess(file);
        orderChecker.verify(mockNewProcessor).process(file);
        orderChecker.verify(mockNewProcessor).postProcess(file);
    }
}