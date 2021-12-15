package actions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadGraphBtnAction implements ActionListener{
    public Graphics graphics;



    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Test");
        //get file path
        String path = "src/main/resources/b126.jpg";
        File file = new File(path);

        //2.get graph pixel
        int[][] arrPixel = null;

        try {
            BufferedImage bfI = ImageIO.read(file);
            //get graph width and height
            int width = bfI.getWidth();
            int height = bfI.getHeight();
            System.out.println(width + " " + height);
            arrPixel = new int[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    //获取每个位置的像素点对应的RBG值
                    int pixelColor = bfI.getRGB(i, j);
                    arrPixel[i][j] = pixelColor;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //3. repaint
        for (int i = 0; i < arrPixel.length; i++) {
            for (int j = 0; j < arrPixel[i].length; j++) {
                int pixelColor = arrPixel[i][j];
                //pixel --> RGB color
                int red = (pixelColor >> 16) & 0xff;
                int green = (pixelColor >> 8) & 0xff;
                int blue = pixelColor & 0xff;
                Color color = new Color(red, green, blue);
                graphics.setColor(color);
                graphics.fillRect(i, j, 1, 1);
            }
        }
    }


}
