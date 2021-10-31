package com.snl.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
public class Snake {
    private int start;
    private int end;

    public Snake(final int start, final int end) throws Exception {
        if (isValidPosition(start,end)) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean isValidPosition(int start,int end) throws Exception {
        if (start > end)
            return true;
        else throw new Exception("Snake start position always greater than end position");
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Snake snake = (Snake) o;
        return start == snake.start && end == snake.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
