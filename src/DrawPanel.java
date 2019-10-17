import Interfaces.IFigure;
import Interfaces.ILineDrawer;
import affines.Affine;
import drawers.BufferedImagePixelDrawer;
import drawers.WuLineDrawer;
import modules.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {

    private ILineDrawer ld;
    private ScreenConverter screenConverter;
    private IFigure figure;
    private TranslationMarker marker;
    private Affine affine;

    public DrawPanel(int width, int height) {
        affine = new Affine();
        ld = new WuLineDrawer();
        screenConverter = new ScreenConverter(width, height, width, height);
        figure = new Rhombus(new MyPoint(0, 0), 300, 500);

        marker = new TranslationMarker(figure, affine);

        setFocusable(true);
        this.addMouseMotionListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MyPoint myE = screenConverter.screenToReal(e.getPoint());
                if (marker.inside(myE)){
                    marker.setCurPoint(myE);
                    marker.setFocused(true);
                }
                else
                    marker.setFocused(false);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImagePixelDrawer pd = new BufferedImagePixelDrawer(bi);
        if (figure != null)
            figure.draw(screenConverter, pd, ld, Color.RED);
        marker.draw(screenConverter, pd, ld, Color.RED);
        g.drawImage(bi, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MyPoint myE = screenConverter.screenToReal(e.getPoint());
        System.out.println("eX");
        System.out.println(myE.x);
        System.out.println("eY");
        System.out.println(myE.y);
//        System.out.println("curX");
//        System.out.println(marker.getCurPoint().x);
//        System.out.println("curY");
//        System.out.println(marker.getCurPoint().y);
        System.out.println("cx");
        System.out.println(marker.getCenter().x);
        System.out.println("cy");
        System.out.println(marker.getCenter().y);
        if (marker.isFocused()){
            marker.moveMarker(marker.getCurPoint(), myE);
            marker.setCurPoint(myE);

        }
        else
            System.out.println("STOP");
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
