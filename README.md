# AdjustRGB
用java8实现的一个对图像进行处理的库，尽可能达到使用时简单明了。


## 说明
### 1 简单操作
SimpleImage 主要对图像RGB进行简单的调节，计算RGB色差，同时支持批量调节。
### 2 进阶操作
Cv4jeImage 基于[cv4j](https://github.com/imageprocessor/cv4j)，对[cv4j](https://github.com/imageprocessor/cv4j)功能进行封装，可以更方便的使用其中功能，cv4j提供了许多强大的滤镜和图像进阶的一些操作。

## 使用
使用起来相当方便，几行代码就可以实现想要的功能。
### 1 SimpleImage
```java
SimpleImage simpleImage = new SimpleImage();
simpleImage.adjust();
```
### 2 Cv4jeImage
