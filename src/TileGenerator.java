import noise.Noise;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Arrays;

public class TileGenerator {


    public static float scaleRange(float min, float max, float a, float b, float x) {
        return (b - a) * (x - min) / (max - min) + a;
    }




    public static int[][] generateArray(int length, int seed){
        Noise noise = new Noise(seed);
        int[][] map = new int[length][length];
        for(int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {


                float noiseValue = noise.smoothNoise(x, y);
                float scaled = scaleRange(-1, 1, 0, 1, noiseValue);
                int height = Math.round(scaled);
                map[y][x] = height;






                /*
                float noiseValue = 0;
                noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.01f, y * 0.01f));
                noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.02f, y * 0.02f));

                noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.04f, y * 0.04f));
                noiseValue += scaleRange(-1, 1, 0, 1, noise.interpolatedNoise(x * 0.08f, y * 0.08f));
                int roundedValue = Math.round(noiseValue / 4f);
                map[y][x] = roundedValue;

                 */





                System.out.println("x: " + x);
                System.out.println("y : " + y);
                System.out.println("height : " + map[x][y]);

            }
        }

        return map;
    }



}
