package com.snl.service;

import com.snl.model.Board;
import com.snl.model.Ladder;
import com.snl.model.NormalDiceMock;
import com.snl.model.Player;
import com.snl.model.Snake;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class GameTest {
    private Game game;
    List<Player> playerList;
    Board board;
    Dice dice;

    @Before
    public void before() {
        playerList = new ArrayList<>();
        playerList.add(new Player(0, "A"));
        board = new Board(100);
        dice = new NormalDiceMock();
        game = new Game(board,playerList, dice);
    }

    @Test
    public void playTest() throws Exception {
        Player p = new Player(1, "Test");
        game.play(p);
        Assert.assertEquals(p.getPosition(), 21);
    }

    @Test
    public void test_endToEndTestWithOutSnakeAndLadder() throws Exception {
        Player playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(10, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(20, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(30, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(40, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(50, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(60, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(70, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(80, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(90, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(100, playerToPlay.getPosition());

        Assert.assertEquals(playerToPlay, game.getWinners().get(1));
        playerToPlay.setPosition(0);
        game.getPlayerQueue().add(playerToPlay);
    }

    @Test
    public void test_endToEndTestWithLadder() throws Exception {

        Ladder  ladder=new Ladder(30,80);
        List<Ladder> ladders=new ArrayList<>();
        ladders.add(ladder);
        board.setLadders(ladders);

        Player playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(10, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(20, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(80, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(90, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(100, playerToPlay.getPosition());

        Assert.assertEquals(playerToPlay, game.getWinners().get(1));
        playerToPlay.setPosition(0);
        game.getPlayerQueue().add(playerToPlay);
    }


    @Test
    public void test_endToEndTestWithSnake() throws Exception {

        Snake  snake=new Snake(30,10);
        List<Snake> snakes=new ArrayList<>();
        snakes.add(snake);
        board.setSnakes(snakes);

        Player playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(10, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(20, playerToPlay.getPosition());

        playerToPlay=game.getNextPlayerToPlay();
        game.play(playerToPlay);
        Assert.assertEquals(10, playerToPlay.getPosition());
    }

    @Test(expected = Exception.class)
    public void test_alreadyWonPlayerPlay() {
        Player player = new Player(1, "Test");
        game.getWinners().put(1,player);
        player.setPosition(100);
        game.play(player);
    }


}
