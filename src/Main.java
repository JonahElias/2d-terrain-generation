import noise.ImageExporter;
import noise.Noise;

import javax.xml.stream.util.StreamReaderDelegate;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        Random r = new Random();
        int length = 500;
        int [][] map = TileGenerator.generateArray(length, r.nextInt());
        StdDraw.setCanvasSize(650, 650);
        StdDraw.setScale(0, length);
        StdDraw.picture(length / 2, length / 2, "map.png", length, length);


    }



}




