package com.snl.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
public class Player {
    private int position;
    private String name;

    public Player(
            final int position,
            final String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return position == player.position && name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
