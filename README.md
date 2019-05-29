# AdjustRGB
用java8实现的一个对图像进行处理的库，尽可能达到使用时简单明了。


## 说明
### 1. 简单操作
SimpleImage 主要对图像RGB进行简单的调节，计算RGB色差，同时支持批量调节。
### 2. 进阶操作
Cv4jeImage 基于[cv4j](https://github.com/imageprocessor/cv4j)，对[cv4j](https://github.com/imageprocessor/cv4j)功能进行封装，可以更方便的使用其中功能，cv4j提供了许多强大的滤镜和图像进阶的一些操作。后续会在两位原作者实现功能基础上继续补充。

## 使用示例
使用起来相当方便，几行代码就可以实现想要的功能。可以查看[详细使用]()。
### 1. SimpleImage
+ 调节亮度
```java
SimpleImage simpleImage = new SimpleImage(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
simpleImage.adjust(20, 20, 20)
        .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "test" + System.currentTimeMillis() + ".jpg", "jpg");
```

### 2. Cv4jeImage
+ 使用滤镜
```java
Cv4jeImage cv4jeImage = new Cv4jeImage(new File("C:\\Users\\Administrator\\Desktop\\test\\result\\00001_01.jpg"));
cv4jeImage.filter(Filter.NATURE)
        .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "test" + System.currentTimeMillis() + ".jpg", "jpg");
```
+ 二值图像分析
```java
int[] b = new int[1];
cv4jeImage.convert2Gray()
        .process(t -> new Threshold().process(t, Threshold.THRESH_TRIANGLE, Threshold.METHOD_THRESH_BINARY_INV, 255))
        .process(t -> new Erode().process(t, new Size(3), 3))
        .process(t -> {
             int a = new ConnectedAreaLabel().process(t, new int[t.getHeight() * t.getWidth()]);
             b[0] = a;
        })
        .out(new File("C:\\Users\\Administrator\\Desktop\\test\\result"), "test" + System.currentTimeMillis() + ".jpg", "jpg");
```