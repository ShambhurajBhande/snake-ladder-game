package com.snl.service;

import com.snl.model.Board;
import com.snl.model.Ladder;
import com.snl.model.Player;
import com.snl.model.Snake;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Getter
@Setter
public class Game {
    private int winnerNumber=1;
    private Board board;
    private Queue<Player> players;
    private Map<Integer,Player> winners;
    private Dice dice;

    public Game(
            final Board board,
            final List<Player> players,
            final Dice dice) {
        this.board = board;
        this.players = new ArrayDeque<>(players);
        this.winners = new HashMap<>();
        this.dice = dice;
    }

    public static void main(String[] args) {
        Snake snake=new Snake(30,20);
        Ladder ladder=new Ladder(15,45);
        Player player=new Player(0,"A");
        List<Player> players=new ArrayList<>();
        players.add(player);

        Board board=new Board(100);

        List<Ladder> ladders= new ArrayList<>();
        ladders.add(ladder);
        board.setLadders(ladders);

        List<Snake> snakes=new ArrayList<>();
        snakes.add(snake);
        board.setSnakes(snakes);

        Game game=new Game(board,players,new NormalDice());
        game.play();

    }

}
