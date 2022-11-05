import noise.Noise;

public class Test {


    public static float scaleRange(float min, float max, float a, float b, float x) {
        return (b - a) * (x - min) / (max - min) + a;
    }

    public static int terrainTwo(Noise noise, int x, int y){
        float noiseValue = 0;
        noiseValue += scaleRange(-1, 1, 0, 255, noise.interpolatedNoise(x * 0.01f, y * 0.01f));
        noiseValue += scaleRange(-1, 1, 0, 255, noise.interpolatedNoise(x * 0.02f, y * 0.02f));
        noiseValue += scaleRange(-1, 1, 0, 255, noise.interpolatedNoise(x * 0.04f, y * 0.04f));
        noiseValue += scaleRange(-1, 1, 0, 255, noise.interpolatedNoise(x * 0.08f, y * 0.08f));
        int roundedValue = Math.round(noiseValue / 4f);
        return roundedValue;
    }

    public static int getRGB(int scaledValue){
        int red = 0;
        int green = 0;
        int blue = 0;

        System.out.println(scaledValue);
        if(scaledValue > 155) {
            // light grey
            red = 195;
            green = 193;
            blue = 187;
        } else if(scaledValue > 150) {
            // medium grey
            red = 155;
            green = 153;
            blue = 147;
        } else if(scaledValue > 140) {
            // dark grey
            red = 118;
            green = 110;
            blue = 116;
        } else if(scaledValue > 135) {
            // light green
            red = 140;
            green = 166;
            blue = 83;
        } else if(scaledValue > 130) {
            // sandy yellow
            red = 220;
            green = 217;
            blue = 180;
        } else {
            // ocean blue
            red = 30;
            green = 110;
            blue = 160;
        }

        return ((255 << 24) | red << 16 | green << 8 | blue);
    }
}
