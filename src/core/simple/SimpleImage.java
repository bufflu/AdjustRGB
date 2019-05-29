package core.simple;

import core.AbstractImage;
import core.AdjustException;
import core.cv4j.Cv4jeImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * ClassName: SimpleImage
 * Description: simply handle image's pixels
 * Date: 2019/5/24 10:59
 *
 * @author LU
 */
public class SimpleImage extends AbstractImage {

    //private BufferedImage bi;
    private Pixel[] pixels;
    private int pixelSize = 0;

    public SimpleImage(File file) {
        super(file);
        init();
    }

    // init
    @Override
    protected void init() {
        pixelSize = bi.getHeight() * bi.getWidth();
        pixels = new Pixel[pixelSize];
        pixelsIterator(t -> {
            int pixel = bi.getRGB(t.getI(), t.getJ());
            t.setRgb(getRGB(pixel));
            t.setP(pixel);
            pixels[t.getC()] = t;
        });
    }


    // iterator
    private void pixelsIterator(Consumer<Pixel> consumer) {
        int c = 0;
        for (int i = bi.getMinX(); i < bi.getWidth(); i++) {
            for (int j = bi.getMinY(); j < bi.getHeight(); j++) {
                consumer.accept(new Pixel(c++, i, j));
            }
        }
    }

    // getRGB
    private RGB getRGB(int pixel) {
        return new RGB(0,
                (pixel & 0xff0000) >> 16,
                (pixel & 0xff00) >> 8,
                pixel & 0xff);
    }

    // out
    @Override
    public boolean out(File dir, String name, String type) {
        if (pixels == null || pixelSize == 0) {
            throw new AdjustException("NO call init method!");
        }
        if (dir == null || name == null) {
            throw new AdjustException("Output File path and name is not null!");
        }
        pixelsIterator(t -> bi.setRGB(t.getI(), t.getJ(), pixels[t.getC()].getP()));
        try {
            return ImageIO.write(bi, type == null?"jpg":type, new File(dir, name));
        } catch (IOException e) {
            throw new AdjustException("Write file error: " + e.getMessage());
        }
    }

    // simple adjust image color
    // every pixel adding r g b value
    public SimpleImage adjust(int r, int g, int b) {
        for (Pixel pixel : pixels) {
            RGB rgb = pixel.getRgb();
            rgb.r = rgb.r + r;
            rgb.g = rgb.g + g;
            rgb.b = rgb.b + b;
            // < 0 || > 255
            rgb.r = rgb.r<0 ? 0 : rgb.r>255 ? 255 : rgb.r;
            rgb.g = rgb.g<0 ? 0 : rgb.g>255 ? 255 : rgb.g;
            rgb.b = rgb.b<0 ? 0 : rgb.b>255 ? 255 : rgb.b;
            pixel.setP((rgb.r << 16) | (rgb.g << 8) | rgb.b);
        }
        return this;
    }

    // return dst - src values
    public static long[] referenceValue(File src, File dst) {
        if (src == null || dst == null) {
            throw new AdjustException("Directory names is not null");
        }
        if (!src.isDirectory() || !dst.isDirectory()) {
            throw new AdjustException("File name is not a Directory");
        }

        long[] fbbAvgRGB = getAvgRGB(src.listFiles());
        long[] ftmAvgRGB = getAvgRGB(dst.listFiles());
        long[] refValue = new long[3];
        refValue[0] = ftmAvgRGB[0] - fbbAvgRGB[0];
        refValue[1] = ftmAvgRGB[1] - fbbAvgRGB[1];
        refValue[2] = ftmAvgRGB[2] - fbbAvgRGB[2];
        return refValue;

    }

    private static long[] getAvgRGB(File[] files) {
        if (files == null || files.length == 0) {
            throw new AdjustException("Not Found Files");
        }
        int fileSize = files.length;
        long[][] rgbs = new long[fileSize][];
        for (int c = 0; c < fileSize; c++) {
            File fbb = files[c];
            if (!fbb.getName().endsWith(".jpg") && !fbb.getName().equals(".png")) continue;
            BufferedImage bi = null;
            try {
                bi = ImageIO.read(fbb);
            } catch (Exception e) {
                e.printStackTrace();
                throw new AdjustException("Read file error: " + e.getMessage());
            }
            long[] rgb = new long[3];
            long p = 0;
            for (int i = bi.getMinX(); i < bi.getWidth(); i++) {
                for (int j = bi.getMinY(); j < bi.getHeight(); j++) {
                    int pixel = bi.getRGB(i, j);
                    rgb[0] += (pixel & 0xff0000) >> 16;
                    rgb[1] += (pixel & 0xff00) >> 8;
                    rgb[2] += (pixel & 0xff);
                    p++;
                }
            }
            rgb[0] = rgb[0] / p;
            rgb[1] = rgb[1] / p;
            rgb[2] = rgb[2] / p;
            rgbs[c] = rgb;
        }
        long[] result = new long[3];
        for (int i = 0; i < fileSize; i++) {
            result[0] += rgbs[i][0];
            result[1] += rgbs[i][1];
            result[2] += rgbs[i][2];
        }
        result[0] = result[0] / fileSize;
        result[1] = result[1] / fileSize;
        result[2] = result[2] / fileSize;
        return result;
    }

    // to cv4j
    public Cv4jeImage toCv4j() {
        pixelsIterator(t -> bi.setRGB(t.getI(), t.getJ(), pixels[t.getC()].getP()));
        return new Cv4jeImage(bi);
    }
}
