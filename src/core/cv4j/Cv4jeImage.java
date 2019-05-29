package core.cv4j;

import com.cv4j.core.datamodel.ByteProcessor;
import com.cv4j.core.datamodel.CV4JImage;
import com.cv4j.core.filters.CommonFilter;
import core.AbstractImage;
import core.AdjustException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * ClassName: Cv4jeImage
 * Description: use cv4j handle image
 * Date: 2019/5/27 17:27
 *
 * @author LU
 */
public class Cv4jeImage extends AbstractImage {

    private CV4JImage cv4JImage;

    public Cv4jeImage(File file) {
        super(file);
        init();
    }

    public Cv4jeImage(BufferedImage bi) {
        super(bi);
        init();
    }

    @Override
    protected void init() {
        cv4JImage = new CV4JImage(bi);
    }

    @Override
    public boolean out(File dir, String name, String type) {
        if (dir == null || name == null) {
            throw new AdjustException("Output File path and name is not null!");
        }
        try {
            return ImageIO.write(cv4JImage.toBitmap(), type==null?"jpg":type, new File(dir, name));
        } catch (IOException e) {
            throw new AdjustException("Write file error: " + e.getMessage());
        }
    }

    /**
     * Add one Filter from filter name, but this Filter param is default.
     * if you setting Filter param, please use {@link #filter(CommonFilter)}
     * @param filterName Filter enum's name
     * @return this
     */
    public Cv4jeImage filter(Filter filterName) {
        if (filterName == null) {
            throw new AdjustException("Filter name is not null");
        }
        cv4JImage = new CV4JImage(FilterUtil.getFilter(filterName).filter(cv4JImage.getProcessor()));
        return this;
    }

    /**
     * Add one Filter, the filter can set param by set method or constructor method.
     * @param filter Filter entity implement CommonFilter Interface.
     * @return this
     */
    public Cv4jeImage filter(CommonFilter filter) {
        if (filter == null) {
            throw new AdjustException("Filter is not null");
        }
        cv4JImage = new CV4JImage(filter.filter(cv4JImage.getProcessor()));
        return this;
    }

    /**
     * Convert image to gray image.
     * @return this
     */
    public Cv4jeImage convert2Gray() {
        cv4JImage = cv4JImage.convert2Gray();
        return this;
    }


    /**
     * Process image binary information, use lambda expression that binary process class's entity in
     * {@link com.cv4j.core.binary} package.<br/>
     * eg1:
     * Cv4jeImage cv4jeImage = new Cv4jeImage(new File("C:\\input\\00044_0.jpg"));
     * cv4jeImage.convert2Gray()
     *           .process(t -> new Threshold().process(t, Threshold.THRESH_MEANSHIFT, Threshold.METHOD_THRESH_BINARY_INV, 255))
     *           .out(new File("C:\\image\\output"), "test.jpg", "jpg");
     *
     * eg2:
     * int[] num = new int[1];
     * cv4jeImage.convert2Gray()
     *           ...
     *           .process(t -> {
     *                              int a = new ConnectedAreaLabel().process(t, new int[t.getHeight() * t.getWidth()]);
     *                              b[0] = a;
     *                    })
     *           .out(...);
     * print(num[0]);
     *
     * @param consumer lambda expression, eg: t -> new Threshold().process(t, Threshold.THRESH_MEANSHIFT, Threshold.METHOD_THRESH_BINARY_INV, 255)
     * @return this
     */
    public Cv4jeImage process(Consumer<ByteProcessor> consumer) {
        consumer.accept((ByteProcessor)this.cv4JImage.getProcessor());
        return this;
    }

    /**
     * Return one new Cv4jeImage Object that has new bufferedImage and new ImageProcessor.
     * @return new Cv4jeImage
     */
    public Cv4jeImage getNew() {
        cv4JImage.resetBitmap();
        this.bi = cv4JImage.getProcessor().getImage().toBitmap();
        this.cv4JImage = new CV4JImage(bi);
        return this;
    }

}
