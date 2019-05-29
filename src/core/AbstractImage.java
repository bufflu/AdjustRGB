package core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ClassName: AbstractImage
 * Description: desc
 * Date: 2019/5/27 17:33
 *
 * @author LU
 */
public abstract class AbstractImage {

    protected BufferedImage bi;

    /**
     * Input a image file that transform bufferedImage.
     * @param file image file
     */
    public AbstractImage(File file) {
        if (!file.isFile()) {
            throw new AdjustException("This is not file path");
        }
        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {
            throw new AdjustException("Read file error: " + e.getMessage());
        }
    }

    public AbstractImage(BufferedImage bi) {
        this.bi = bi;
    }

    /**
     * init method.
     */
    protected abstract void init();

    /**
     * Image's bufferedImage information out put a file.
     * @param dir file path
     * @param name file name
     * @param type file type, eg: jpg, png.
     * @return true / false
     */
    protected abstract boolean out(File dir, String name, String type);
}
