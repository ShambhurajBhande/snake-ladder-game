package com.snl.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class Ladder {
        private final int start;
        private final int end;

        public Ladder(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Ladder ladder = (Ladder) o;
            return start == ladder.start && end == ladder.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
}
