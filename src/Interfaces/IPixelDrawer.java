package Interfaces;

import java.awt.*;

public interface IPixelDrawer {
    void drawPixel(int x, int y, Color c);

    void drawPixel(int x, int y, Color c, int transparency);
}
