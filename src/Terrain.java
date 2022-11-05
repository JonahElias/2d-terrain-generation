import noise.Noise;

public class Terrain {

    public static float scaleRange(float min, float max, float a, float b, float x) {
        return (b - a) * (x - min) / (max - min) + a;
    }

    public static int terrainOne(Noise noise, int x, int y){
        float noiseValue = scaleRange(-1, 1, 0, 255, noise.interpolatedNoise(x * .02f, y * .02f));
        noiseValue += scaleRange(-1, 1, 0, 255,  noise.interpolatedNoise(x * 0.03f, y * 0.03f));

        noiseValue /= 2f;
        return Math.round(noiseValue);
    }



    public static int getRGB(int height){
        int red = 0;
        int green = 0;
        int blue = 0;


        if (height >= 170){
            red = 230;
            green = 230;
            blue = 230;
        }
        else if (height >= 165){
            red = 180;
            green = 180;
            blue = 180;
        }else if(height > 155){
            red = 135;
            green = 135;
            blue = 135;
        }else if (height > 145){
            red = 100;
            green = 100;
            blue = 100;
        }
        else if (height > 115){
            red = 105;
            green = 225;
            blue = 72;
        }else if (height > 107){
            red = 240;
            green = 240;
            blue = 133;
        }

        else {
            red = 42;
            green = 125;
            blue = 235;
        }


        return ((255 << 24) | red << 16 | green << 8 | blue);
    }




}
