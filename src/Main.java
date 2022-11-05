import noise.ImageExporter;
import noise.Noise;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main {

    public static int[][] generateArray(int length, int seed){
        Noise noise = new Noise(seed);
        int[][] map = new int[length][length];
        for(int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                int height = Terrain.terrainOne(noise, x, y);
                map[y][x] = Terrain.getRGB(height);
                //System.out.println("x: " + x);
                //System.out.println("y : " + y);
                //System.out.println("height : " + height);

            }
        }
        return map;
    }

    public static void main(String[] args){
        int length = 1000;

        Random r = new Random();

        int [][] map = generateArray(length, r.nextInt());

        BufferedImage colorImage = ImageExporter.convertRGBArray(map);
        ImageExporter.saveAsFile("map.png", colorImage);

        StdDraw.setCanvasSize(650, 650);
        StdDraw.setScale(0, length);
        StdDraw.picture(length / 2, length / 2, "map.png", length, length);


    }



}




