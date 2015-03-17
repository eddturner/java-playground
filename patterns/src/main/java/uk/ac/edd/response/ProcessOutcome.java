package uk.ac.edd.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 13/03/15
 *
 * @author Edd <eddturner@ebi.ac.uk>
 */
public class ProcessOutcome {
    private String name;
    private List<String> results;

    private ProcessOutcome(Builder builder) {
        name = builder.name;
        results = builder.results;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public List<String> getResults() {
        return results;
    }

    public static final class Builder {
        private String name;
        private List<String> results  = new ArrayList<String>();

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withResults(List<String> results) {
            this.results = results;
            return this;
        }

        public ProcessOutcome build() {
            return new ProcessOutcome(this);
        }
    }
}
