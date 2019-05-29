

import com.cv4j.core.binary.ConnectedAreaLabel;
import com.cv4j.core.binary.Erode;
import com.cv4j.core.binary.MorphOpen;
import com.cv4j.core.binary.Threshold;
import com.cv4j.core.datamodel.*;
import com.cv4j.core.filters.BoxBlurFilter;
import com.cv4j.core.filters.CommonFilter;
import com.cv4j.image.util.Tools;
import core.cv4j.Cv4jeImage;
import core.cv4j.Filter;
import core.simple.SimpleImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: classname
 * Description: desc
 * Date: 2019/5/24 10:04
 *
 * @author LU
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*ImageSimpleHand simpleHand = new ImageSimpleHand();
        simpleHand.execute();
        //simpleHand.refValue();*/
/*        BufferedImage bi = ImageIO.read(new File("C:\\Users\\LU\\Desktop\\image\\output\\00044_0.jpg"));
        CV4JImage cv4JImage = new CV4JImage(bi);
        CommonFilter filter = new BoxBlurFilter();
        ImageProcessor filter1 = filter.filter(cv4JImage.getProcessor());
        CV4JImage result = new CV4JImage(filter1);
        ImageIO.write(result.toBitmap(), "jpg", new File("C:\\Users\\LU\\Desktop\\image\\output\\cv4j"+System.currentTimeMillis()+".jpg"));
*/
        /*
        Cv4jeImage cv4jeImage = new Cv4jeImage(new File("C:\\Users\\LU\\Desktop\\image\\output\\00044_0.jpg"));
        cv4jeImage.filter(Filter.CONV_MIN_MAX).out(new File("C:\\Users\\LU\\Desktop\\image\\output"), "cv4j"+System.currentTimeMillis()+".jpg", null);
        //*/


        process();
    }

    private static void simpleExample1() {
        SimpleImage simpleImage = new SimpleImage(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
        simpleImage.adjust(20, 20, 20)
                .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "test" + System.currentTimeMillis() + ".jpg", "jpg");

    }

    private static void cv4jeExample1() {
        Cv4jeImage cv4jeImage = new Cv4jeImage(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
        cv4jeImage.filter(Filter.NATURE)
                .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "test" + System.currentTimeMillis() + ".jpg", "jpg");
    }

    private static void cv4jeExample2() {
        Cv4jeImage cv4jeImage = new Cv4jeImage(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
        int[] b = new int[1];
        cv4jeImage.convert2Gray()
                .process(t -> new Threshold().process(t, Threshold.THRESH_TRIANGLE, Threshold.METHOD_THRESH_BINARY_INV, 255))
                .process(t -> new Erode().process(t, new Size(3), 3))
                .process(t -> {
                    int a = new ConnectedAreaLabel().process(t, new int[t.getHeight() * t.getWidth()]);
                    b[0] = a;
                })
                .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "test" + System.currentTimeMillis() + ".jpg", "jpg");
    }


    private static void process() throws IOException {

        BufferedImage bi = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
        CV4JImage cv4JImage = new CV4JImage(bi);
        Threshold threshold = new Threshold();
        threshold.process((ByteProcessor) cv4JImage.convert2Gray().getProcessor(), Threshold.THRESH_MEANSHIFT, Threshold.METHOD_THRESH_BINARY_INV, 255);
        /*MorphOpen morphOpen = new MorphOpen();
        //cv4JImage.resetBitmap();
        morphOpen.process((ByteProcessor) cv4JImage.getProcessor(), new Size(10));*/
        /*
        ImageIO.write(cv4JImage.getProcessor().getImage().toBitmap(), "jpg", new File("C:\\Users\\LU\\Desktop\\image\\output\\cv4j"+System.currentTimeMillis()+".jpg"));
        */

        int[] b = new int[1];
        Cv4jeImage cv4jeImage = new Cv4jeImage(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
        cv4jeImage.convert2Gray()
                .process(t -> new Threshold().process(t, Threshold.THRESH_TRIANGLE, Threshold.METHOD_THRESH_BINARY_INV, 255))
                .process(t -> new Erode().process(t, new Size(3), 3))
                .process(t -> {int a = new ConnectedAreaLabel().process(t, new int[t.getHeight() * t.getWidth()]);
                                b[0] = a;
                })
                .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "cv4j" + System.currentTimeMillis() + ".jpg", null);

        System.out.println(b[0]);

        //*/
        /*List<Rect> rectList = new ArrayList<>();

        ConnectedAreaLabel cal = new ConnectedAreaLabel();
        cal.process((ByteProcessor) cv4JImage.getProcessor(),
                new int[cv4JImage.getProcessor().getHeight() * cv4JImage.getProcessor().getWidth()],
                rectList, true);

        com.cv4j.image.util.Tools.ec*/


    }


}
