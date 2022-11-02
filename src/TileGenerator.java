import noise.ImageExporter;
import noise.Noise;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class TileGenerator {


    public static float scaleRange(float min, float max, float a, float b, float x) {
        return (b - a) * (x - min) / (max - min) + a;
    }

    public static int terrainOne(Noise noise, int x, int y){
        float noiseValue = noise.interpolatedNoise(x * .02f, y * .02f);
        noiseValue += noise.interpolatedNoise(x * 0.08f, y * 0.08f);
        noiseValue /= 2;
        float scaled = scaleRange(-1, 1, 0, 1, noiseValue);
        int height = Math.round(scaled);
        return height;
    }

    public static int terrainTwo(Noise noise, int x, int y){
        float noiseValue = 0;
        noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.01f, y * 0.01f));
        noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.02f, y * 0.02f));
        noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.04f, y * 0.04f));
        noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.08f, y * 0.08f));
        int roundedValue = Math.round(noiseValue / 4f);
        return roundedValue;
    }

    public static int getRGBValue(Noise noise, int height){
        //float noiseValue = noise.smoothNoise(x, y);
        int scaled = Math.round(scaleRange(-1, 1, 0, 255, height));
        int red = 0;
        int green = 0;
        int blue = 0;

       if(scaled > 155) {
            red = 140;
            green = 166;
            blue = 83;
        }else {
            red = 30;
            green = 110;
            blue = 160;
        }
        return ((255 << 24) | red << 16 | green << 8 | blue);
    }



    public static int[][] generateArray(int length, int seed){
        Noise noise = new Noise(seed);
        int[][] map = new int[length][length];
        for(int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {


                int height = terrainOne(noise, x, y);
                map[y][x] = getRGBValue(noise, height);
                System.out.println("x: " + x);
                System.out.println("y : " + y);
                System.out.println("height : " + map[x][y]);

            }
        }

        BufferedImage colorImage = ImageExporter.convertRGBArray(map);
        ImageExporter.saveAsFile("map.png", colorImage);

        return map;
    }



}
