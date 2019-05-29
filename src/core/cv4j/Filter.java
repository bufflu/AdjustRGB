package core.cv4j;

/**
 * ClassName: Filter
 * Description: Filter enum
 * Date: 2019/5/27 21:38
 *
 * @author LU
 */
public enum Filter {
    BEAUTY_SKIN,        // 美颜
    BOX_BLUR,           // 均值模糊
    CARVE,              // 雕刻
    COLOR,              // 颜色
    CON_BRI,            // 鲜明
    EMBOSS,             // 突出
    EXPOSURE,           // 曝光
    FAST_BLUR2D,        // 快速模糊2d
    FAST_EP,            // 快速光滑
    FLO_STE_DITHERING,  // f-s抖动
    GAMMA,              // GAMMA
    GAUSSIAN_BLUR,      // 高斯模糊
    GAUSSIAN_NOISE,     // 高斯噪声
    GLOW,               // 热
    //GRADIENT,
    MEANS_BINARY,       // 二值
    MOSAIC,             // 马赛克
    MOTION,             // 运动
    NATURE,             // 自然
    OIL_PAINT,          // 油漆
    SEPIA_TONE,         // 棕色
    SIN_CITY,           // 罪恶都市
    SPOTLIGHT,          // 聚光灯
    STROKE_AREA,        // 画笔
    VIGNETTE,           // 晕映
    WATER,              // 水波
    WHITE_IMAGE,        // 白色

    CONVOLUTION_HV,     // 卷积(模糊或降噪)
    CONV_FIND_EDGE,     // 寻找边缘(梯度提取)
    CONV_LAPLAS,        // 拉普拉斯(边缘提取)
    CONV_MAER_OPERATOR, // 马尔操作(高通滤波)
    CONV_MEDIMA,        // 中值滤波(去噪声)
    CONV_MIN_MAX,       // 最大最小滤波(去噪声)
    CONV_SAP_NOISE,     // 椒盐噪声(增加噪声)
    CONV_SHARP,         // 锐化(增强)
    CONV_SOBEL,         // 梯度(xy方向梯度提取)
    CONV_USM,           // usm(增强)
    CONV_VARIANCE,      // 方差滤波(高通滤波)
}
