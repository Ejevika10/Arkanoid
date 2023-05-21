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
import java.util.HashMap;
import javax.swing.*;
import javax.swing.JPanel;

public class AllObjects extends JPanel {
    DisplayObject[] allObj;
    Blocks blocks;
    Platforms platform;
    Balls balls;
    Platform activePlatform;
    int pos = 0;
    public Timer MyTimer;

    AllObjects(int width, int height)
    {
        allObj = new DisplayObject[29];
        blocks = new Blocks(width);
        addObj(blocks.blocks);
        platform = new Platforms(width,height);
        activePlatform = platform.platforms[0];
        addObj(platform.platforms);
        balls = new Balls(width,height);
        addObj(balls.balls);
        setFocusable(true);
        requestFocusInWindow();
    }
    public void addObj(DisplayObject obj[]){
        for (DisplayObject block:obj)
        {
            allObj[pos] = block;
            pos++;
        }
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
                            if (!obj.equals(obj2) && obj2.visible == 1)
                                if (obj.checkCollision(obj2)){
                                    if (obj2.getClass().toString().equals("class Block")) {
                                        Block block = (Block) obj2;
                                        block.changeHardness();
                                        Game.players.players[0].stat.score++;
                                        StatisticsBar.updStat();
                                        System.out.println("det\n");
                                        Ball ball = (Ball) obj;
                                        System.out.println(ball.angle);
                                    }
                                    break;
                                }
                        }
                    }
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
        int i = 0;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode objectsNode = rootNode.get("objects");
        for (JsonNode objectNode : objectsNode) {
            int classType = objectNode.get("type").asInt();
            switch (classType) {
                case 2 -> {
                    allObj[i] =  mapper.readValue(objectNode.toString(), Block.class);
                    i++;
                    break;
                }
                case 1 -> {
                    allObj[i] =  mapper.readValue(objectNode.toString(), Ball.class);
                    i++;
                    break;
                }
                case 3 -> {
                    allObj[i] =  mapper.readValue(objectNode.toString(), Platform.class);
                    activePlatform = (Platform) Game.gameField.allObj.allObj[i];
                    i++;
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
            if (allObj[i] instanceof Block) {
                ((Block) allObj[i]).chSize(5+(i/3)*(blWidth + 10) + blWidth/2, blWidth);
            }
            if (allObj[i + 1] instanceof Block) {
                ((Block) allObj[i+ 1]).chSize(5+(i/3)*(blWidth + 10) + blWidth/2, blWidth);
            }
            if (allObj[i + 2] instanceof Block) {
                ((Block) allObj[i+ 2]).chSize(5+(i/3)*(blWidth + 10) + blWidth/2, blWidth);
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
