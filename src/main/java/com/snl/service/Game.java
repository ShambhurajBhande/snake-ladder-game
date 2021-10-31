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
    private int winnerNumber;
    private Board board;
    private Queue<Player> playerQueue;
    private Map<Integer,Player> winners;
    private Dice dice;

    public Game(
            final Board board,
            final List<Player> players,
            final Dice dice) {
        this.board = board;
        this.playerQueue = new ArrayDeque<>(players);
        this.winners = new HashMap<>();
        this.dice = dice;
    }

    public Player getNextPlayerToPlay() {
        if(playerQueue.size()<1)
            System.out.println("Game is already over...");
        return playerQueue.poll();
    }

    public void play(Player player) {
        if (!hasPlayerWon(player)) {
            movePlayer(player, dice.rollDice());
            updatePlayerPositionAfterGoingThroughSnakeAndLadder(player);
            updateGameStatus(player);
        } else {
            System.out.println("Player already won...");
        }

    }

    private void updateGameStatus(final Player player) {
        if (hasPlayerWon(player)) {
            winners.put(++winnerNumber,player);
            if (playerQueue.size() == 1) {
                winners.put(++winnerNumber, playerQueue.poll());
            }
        }else {
            playerQueue.add(player);
        }
    }

    private void updatePlayerPositionAfterGoingThroughSnakeAndLadder(final Player player) {
        for (Snake snake:board.getSnakes()) {
            if (snake.getStart() == player.getPosition()) {
                player.setPosition(snake.getEnd());
                System.out.println("Snake");
            }
        }

        for (Ladder ladder:board.getLadders()) {
            if (ladder.getStart() == player.getPosition()) {
                player.setPosition(ladder.getEnd());
                System.out.println("Ladder");
            }
        }

    }

    private boolean hasPlayerWon(Player player) {
        return player.getPosition()==board.getBoardSize();

    }

    private void movePlayer(final Player player,final int rollDice) {
        int newPosition=player.getPosition()+rollDice;
        if (newPosition<=board.getBoardSize()){
            player.setPosition(newPosition);
        }
    }

    public static void main(String[] args) throws Exception {
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
        Player playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
        game.play(playerToPlay);
        System.out.println(playerToPlay.getPosition());
    }

}
