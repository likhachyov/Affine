package drawers;

import Interfaces.IPixelDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedImagePixelDrawer implements IPixelDrawer {

    private BufferedImage image;

    public BufferedImagePixelDrawer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void drawPixel(int x, int y, Color c) {
        if (x >= 0 && x < image.getWidth()
        && y >= 0 && y < image.getHeight()) {
            image.setRGB(x, y, c.getRGB());
        }
    }

    @Override
    public void drawPixel(int x, int y, Color c, int transparency) {
        if (x >= 0 && x < image.getWidth()
                && y >= 0 && y < image.getHeight()) {
            image.setRGB(x, y, c.getRGB());
        }
    }
}
