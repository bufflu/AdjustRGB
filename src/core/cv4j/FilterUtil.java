package core.cv4j;

import com.cv4j.core.filters.*;
import com.cv4j.core.filters.face.BeautySkinFilter;
import com.cv4j.core.spatial.conv.*;

/**
 * ClassName: FilterUtil
 * Description: Get one CommonFilter from Filter enum value, The CommonFilter use default constructor method.
 * Date: 2019/5/27 21:55
 *
 * @author LU
 */
public class FilterUtil {

    public static CommonFilter getFilter(Filter filter) {
        switch (filter) {
            case BEAUTY_SKIN:
                return new BeautySkinFilter();
            case BOX_BLUR:
                return new BoxBlurFilter();
            case CARVE:
                return new CarveFilter();
            case COLOR:
                return new ColorFilter();
            case CON_BRI:
                return new ConBriFilter();
            case EMBOSS:
                return new EmbossFilter();
            case EXPOSURE:
                return new ExposureFilter();
            case FAST_BLUR2D:
                return new FastBlur2D();
            case FAST_EP:
                return new FastEPFilter();
            case FLO_STE_DITHERING:
                return new FloSteDitheringFilter();
            case GAMMA:
                return new GammaFilter();
            case GAUSSIAN_BLUR:
                return new GaussianBlurFilter();
            case GAUSSIAN_NOISE:
                return new GaussianNoiseFilter();
            case GLOW:
                return new GlowFilter();
            //case GRADIENT: return new GradientFilter();
            case MEANS_BINARY:
                return new MeansBinaryFilter();
            case MOSAIC:
                return new MosaicFilter();
            case MOTION:
                return new MotionFilter();
            case NATURE:
                return new NatureFilter();
            case OIL_PAINT:
                return new OilPaintFilter();
            case SEPIA_TONE:
                return new SepiaToneFilter();
            case SIN_CITY:
                return new SinCityFilter();
            case SPOTLIGHT:
                return new SpotlightFilter();
            case STROKE_AREA:
                return new StrokeAreaFilter();
            case VIGNETTE:
                return new VignetteFilter();
            case WATER:
                return new WaterFilter();
            case WHITE_IMAGE:
                return new WhiteImageFilter();
            case CONVOLUTION_HV:
                return new ConvolutionHVFilter();
            case CONV_FIND_EDGE:
                return new FindEdgeFilter();
            case CONV_LAPLAS:
                return new LaplasFilter();
            case CONV_MAER_OPERATOR:
                return new MaerOperatorFilter();
            case CONV_MEDIMA:
                return new MedimaFilter();
            case CONV_MIN_MAX:
                return new MinMaxFilter();
            case CONV_SAP_NOISE:
                return new SAPNoiseFilter();
            case CONV_SHARP:
                return new SharpFilter();
            case CONV_SOBEL:
                return new SobelFilter();
            case CONV_USM:
                return new USMFilter();
            case CONV_VARIANCE:
            default:
                return new VarianceFilter();
        }
    }
}
