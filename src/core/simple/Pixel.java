package core.simple;

/**
 * ClassName: Pixel
 * Description: record single pixel's pixel value, coordinate point(i, j), and RGB value.
 * Date: 2019/5/24 11:39
 *
 * @author LU
 */
public class Pixel {

    private int c;
    private int p;
    private int i;
    private int j;
    private RGB rgb;

    public Pixel(int c, int i, int j) {
        this.c = c;
        this.i = i;
        this.j = j;
    }

    public Pixel(int c, int p, int i, int j, RGB rgb) {
        this.c = c;
        this.p = p;
        this.i = i;
        this.j = j;
        this.rgb = rgb;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public RGB getRgb() {
        return rgb;
    }

    public void setRgb(RGB rgb) {
        this.rgb = rgb;
    }
}
class RGB {
    int a;
    int r;
    int g;
    int b;

    public RGB(int a, int r, int g, int b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
}