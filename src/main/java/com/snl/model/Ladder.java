package com.snl.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class Ladder {
        private int start;
        private int end;

        public Ladder(final int start, final int end) throws Exception {
            if (isValidPosition(start,end)) {
                this.start = start;
                this.end = end;
            }
        }

        public boolean isValidPosition(int start,int end) throws Exception {
            if (start < end)
                return true;
            else throw new Exception("Ladder start position always lesser than end position");
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
