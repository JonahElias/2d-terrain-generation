import noise.ImageExporter;
import noise.Noise;

import javax.xml.stream.util.StreamReaderDelegate;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        Random r = new Random();
        int length = 100;
        int [][] map = TileGenerator.generateArray(length, r.nextInt());
        StdDraw.setCanvasSize(650, 650);
        StdDraw.setScale(0, length);

        for(int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {


                int num = map[x][y];
                if (num == 0){
                    StdDraw.setPenColor(Color.BLUE);
                }else{
                    StdDraw.setPenColor(Color.GREEN);
                }
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                //StdDraw.filledCircle(x, y + 1, 0.5);



            }

        }
        StdDraw.save("map.png");
    }



}




