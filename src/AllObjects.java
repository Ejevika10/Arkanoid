import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.JPanel;

public class AllObjects extends JPanel {
    ArrayList<DisplayObject> allObj;
    Blocks blocks;
    Platforms platform;
    Balls balls;
    Platform activePlatform;
    int pos = 0;
    public Timer MyTimer;
    public int ballCounter = 1;
    static EventSource eventSource;

    AllObjects(int width, int height)
    {
        eventSource = new EventSource();
        allObj = new ArrayList<>();
        blocks = new Blocks(width);
        allObj.addAll(blocks.blocks);
        for (Block bl:blocks.blocks){
            eventSource.addObserver(bl);
            eventSource.addObserver(bl.bonus);
        }
        for (Block block: blocks.blocks) {
            allObj.add(block.bonus);
            allObj.addAll(block.points);
        }
        platform = new Platforms(width,height);
        activePlatform = platform.platforms.get(0);
        allObj.addAll(platform.platforms);

        balls = new Balls(width,height);
        allObj.addAll(balls.balls);

        setFocusable(true);
        requestFocusInWindow();
    }
    public void addObj(ArrayList<DisplayObject> obj){
        allObj.addAll(obj);
    }
    public void gameCicle() throws InterruptedException {
        MyTimer = new javax.swing.Timer(8,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (DisplayObject obj: allObj) {
                    if (obj.movable == 1) {
                        obj.move();
                        for (DisplayObject obj2: allObj)
                        {
                            if (obj.visible == 1 && obj2.visible == 2) {
                                if (obj.checkCollision(obj2)) {
                                    if (obj.getClass().toString().equals("class Ball") && obj2.getClass().toString().equals("class Block")) {
                                        Block block = (Block) obj2;
                                        EventBlock event = new EventBlock(block);
                                        eventSource.fireEvent(event);
                                        StatisticsBar.updStat();


                                    }else if(obj.getClass().toString().equals("class Bonus") && obj2.getClass().toString().equals("class Platform")) {
                                        Bonus bonus = (Bonus) obj;
                                        //bonus.getBonus();
                                        EventBonus event = new EventBonus(bonus);
                                        eventSource.fireEvent(event);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                if(ballCounter > Game.players.players[0].balls.balls.size()){
                    Balls dopBalls = new Balls(Game.gameField.width,Game.gameField.height);
                    Game.gameField.allObj.allObj.addAll(dopBalls.balls);
                    Game.players.players[0].balls.balls.addAll(dopBalls.balls);
                }
                repaint();
            }
        });
        MyTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.LIGHT_GRAY);
        g2d.clearRect(0, 0, getParent().getWidth(), getParent().getHeight());

        for (DisplayObject object:allObj) {
            object.draw(g2d);
        }
    }

    public void fromJson(JsonNode rootNode) throws JsonProcessingException {
        allObj.clear();
        Game.players.players[0].balls.balls.clear();
        Game.players.players[0].platform = null;
        Game.gameField.allObj.ballCounter = 0;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode objectsNode = rootNode.get("objects");
        for (JsonNode objectNode : objectsNode) {
            int classType = objectNode.get("type").asInt();
            switch (classType) {
                case 2 -> {
                    Block bl = mapper.readValue(objectNode.toString(), Block.class);
                    bl.bonus = new Bonus(bl.x, bl.y, bl.width, bl.height);
                    allObj.add(bl);
                    allObj.add(bl.bonus);
                    break;
                }
                case 1 -> {
                    Ball ball = mapper.readValue(objectNode.toString(), Ball.class);
                    allObj.add(ball);
                    Game.players.players[0].balls.balls.add(ball);
                    Game.gameField.allObj.ballCounter++;
                    break;
                }
                case 3 -> {
                    Platform pl = mapper.readValue(objectNode.toString(), Platform.class);
                    allObj.add(pl);
                    activePlatform = pl;
                    Game.players.players[0].platform = pl;

                    break;
                }
                default -> {
                }
            }
        }
    }
    public void chSize(int width, int height){
        int blWidth = (width - 135)/9 - 10;
        for (int i = 0; i < 27; i+=3) {
            if (allObj.get(i) instanceof Block) {
                ((Block) allObj.get(i)).chSize(5+(i/3)*(blWidth + 10) + blWidth/2, blWidth);
            }
            if (allObj.get(i + 1) instanceof Block) {
                ((Block) allObj.get(i + 1)).chSize(5+(i/3)*(blWidth + 10) + blWidth/2, blWidth);
            }
            if (allObj.get(i + 2) instanceof Block) {
                ((Block) allObj.get(i + 2)).chSize(5+(i/3)*(blWidth + 10) + blWidth/2, blWidth);
            }
        }
        for (DisplayObject object: Game.gameField.allObj.allObj) {
            if (object instanceof Platform) {
                ((Platform) object).chSize(width,height);
            }
            if (object instanceof Ball) {
                ((Ball) object).chSize(width,height);
            }
        }
        repaint();
    }
}
