import actions.*;

import javax.swing.*;
import java.awt.*;


public class PictureProcessingUI extends JFrame {
    /**
     * 主程序入口
     * @param args
     */
    public static void main(String[] args) {
        new PictureProcessingUI();
    }

    //无参构造方法
    public PictureProcessingUI() {
        initUI();
    }

    //Frame设置
    private JFrame frameInitUI(){
        setTitle ("PictureProcessing");
        setSize (1920, 1080);
        setLocationRelativeTo (null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // setVisible (true);
        // 默认边框布局
        return this;
    }

    public void initUI() {
        JFrame jFrame = frameInitUI();


        //Visible
        jFrame.setVisible(true);

        //Components
        JButton loadGraphBtn = new JButton("Load Graph");
        JButton mosaicBtn = new JButton("Mosaic");
        JButton binaryBtn = new JButton("Binary (graying - base)");
        JButton grayingBtn = new JButton("Graying");
        JButton oilPaintingBtn = new JButton("OilPainting");


        //Add Components
        jFrame.add(loadGraphBtn);
        jFrame.add(mosaicBtn);
        jFrame.add(grayingBtn);
        jFrame.add(binaryBtn);
        jFrame.add(oilPaintingBtn);

        //
        Graphics graphics = jFrame.getGraphics();


        //Action
        //Load
        LoadGraphBtnAction loadGraphBtnAction = new LoadGraphBtnAction();
        loadGraphBtn.addActionListener(loadGraphBtnAction);
        loadGraphBtnAction.graphics = graphics;
        //Mosaic
        MosaicBtnAction mosaicBtnAction = new MosaicBtnAction();
        mosaicBtn.addActionListener(mosaicBtnAction);
        mosaicBtnAction.graphics = graphics;
        //Graying
        GrayingBtnAction grayingBtnAction = new GrayingBtnAction();
        grayingBtn.addActionListener(grayingBtnAction);
        grayingBtnAction.graphics = graphics;
        //binary (graying - base)
        BinaryBtnAction binaryBtnAction = new BinaryBtnAction();
        binaryBtn.addActionListener(binaryBtnAction);
        binaryBtnAction.graphics = graphics;
        //Oil painting
        OilPaintingBtnAction oilPaintingBtnAction = new OilPaintingBtnAction();
        oilPaintingBtn.addActionListener(oilPaintingBtnAction);
        oilPaintingBtnAction.graphics = graphics;
    }


}
