/*
 * Copyright (c) 2017-present, CV4J Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cv4j.core.datamodel.lut;

/**
 * The filter which is ranges from blue to red, and passes through the colors cyan, yellow, and orange.
 * It is a variation of the hsv colormap.
 * The jet colormap is associated with an astrophysical fluid jet simulation from the National Center
 * for Supercomputer Applications.
 * <p>
 * For more information please see:
 * <a target="_blank" href="http://baike.baidu.com/link?url=kysXstK853g0mEbTgPIdkrqO5qTTbgfW-B0O1FJP4MYYzp
 * G5_6E_LlaP_6T9XTn2c97Ge6hJUojJzkppCdnO-mJxIee_XsNASTsy82RaQZe">About ColorMap</a> <p>
 * Or see:
 * <a target="_blank" href="http://matlab.izmiran.ru/help/techdoc/ref/colormap.html">MATLAB Function Reference - colormap</a>
 *
 */
public class JetLUT {

    public static int[][] JET_LUT = new int[][]{
            {0, 1, 128}, {0, 0, 130}, {0, 0, 132}, {1, 0, 136}, {0, 0, 142},
            {0, 0, 145}, {0, 0, 150}, {1, 0, 154}, {0, 0, 158}, {1, 0, 163},
            {0, 0, 166}, {0, 0, 170}, {0, 0, 175}, {0, 0, 179}, {0, 0, 182},
            {0, 0, 186}, {0, 1, 190}, {0, 0, 194}, {1, 1, 197}, {1, 0, 200},
            {0, 1, 207}, {0, 0, 210}, {1, 0, 215}, {1, 0, 218}, {0, 0, 222},
            {1, 0, 226}, {0, 0, 230}, {0, 0, 234}, {0, 0, 240}, {0, 0, 244},
            {0, 0, 246}, {0, 1, 249}, {1, 2, 253}, {0, 5, 254}, {0, 8, 255},
            {1, 13, 255}, {0, 17, 255}, {0, 21, 254}, {1, 25, 255}, {0, 29, 255},
            {0, 33, 255}, {0, 38, 255}, {0, 41, 255}, {0, 44, 254}, {1, 49, 255},
            {0, 53, 253}, {0, 56, 255}, {1, 61, 255}, {0, 65, 255}, {0, 70, 254},
            {0, 73, 255}, {0, 77, 255}, {0, 82, 255}, {0, 86, 254}, {0, 89, 255},
            {0, 94, 254}, {0, 97, 255}, {0, 101, 255}, {1, 105, 255}, {0, 109, 254},
            {0, 113, 254}, {0, 118, 254}, {0, 120, 255}, {0, 124, 253}, {0, 128, 255},
            {0, 133, 254}, {1, 135, 255}, {0, 140, 255}, {0, 144, 255}, {0, 148, 254},
            {0, 151, 254}, {0, 157, 254}, {0, 160, 255}, {0, 164, 254}, {0, 168, 255},
            {0, 172, 254}, {0, 175, 254}, {0, 180, 254}, {1, 183, 255}, {0, 187, 254},
            {0, 192, 255}, {0, 196, 254}, {0, 199, 255}, {0, 204, 255}, {0, 208, 255},
            {0, 213, 255}, {0, 216, 255}, {0, 220, 254}, {1, 226, 255}, {0, 229, 255},
            {0, 232, 255}, {0, 237, 255}, {0, 240, 255}, {0, 244, 254}, {1, 248, 255},
            {2, 251, 255}, {4, 254, 252}, {6, 255, 249}, {10, 255, 245}, {13, 255, 241},
            {18, 255, 237}, {22, 255, 233}, {27, 255, 230}, {30, 255, 225}, {34, 255, 222},
            {37, 255, 218}, {43, 255, 215}, {45, 255, 208}, {52, 254, 206}, {56, 254, 201},
            {60, 255, 197}, {62, 255, 192}, {66, 255, 189}, {70, 255, 185}, {73, 255, 181},
            {77, 255, 177}, {82, 255, 175}, {86, 255, 168}, {90, 254, 165}, {94, 255, 161},
            {97, 255, 158}, {101, 255, 154}, {105, 254, 150}, {109, 255, 144}, {116, 254, 142},
            {120, 255, 137}, {122, 254, 132}, {126, 255, 128}, {129, 255, 125}, {131, 255, 120},
            {135, 255, 117}, {139, 255, 113}, {146, 255, 110}, {149, 255, 105}, {154, 255, 101},
            {158, 255, 98}, {161, 255, 94}, {164, 255, 90}, {169, 255, 86}, {173, 255, 82},
            {178, 255, 79}, {181, 255, 74}, {185, 255, 69}, {189, 255, 65}, {193, 254, 62},
            {197, 255, 57}, {201, 255, 55}, {204, 255, 50}, {209, 254, 47}, {212, 255, 41},
            {218, 255, 38}, {221, 255, 34}, {224, 255, 30}, {228, 255, 26}, {233, 255, 24},
            {237, 255, 17}, {243, 254, 14}, {246, 254, 10}, {250, 254, 7}, {254, 255, 4},
            {255, 251, 2}, {255, 248, 0}, {254, 244, 0}, {255, 240, 0}, {254, 237, 0},
            {254, 232, 0}, {255, 228, 0}, {255, 225, 0}, {254, 220, 0}, {255, 216, 0},
            {255, 212, 0}, {255, 207, 0}, {255, 204, 1}, {255, 200, 1}, {254, 196, 1},
            {255, 192, 0}, {255, 188, 1}, {254, 184, 0}, {255, 180, 0}, {254, 177, 0},
            {254, 172, 0}, {255, 168, 1}, {255, 164, 1}, {255, 159, 0}, {255, 156, 1},
            {255, 151, 0}, {255, 148, 0}, {255, 143, 2}, {255, 139, 0}, {255, 136, 0},
            {255, 132, 2}, {255, 128, 0}, {255, 125, 1}, {255, 121, 0}, {255, 117, 0},
            {255, 113, 0}, {255, 108, 0}, {255, 104, 0}, {255, 101, 0}, {255, 97, 0},
            {255, 93, 0}, {254, 89, 0}, {254, 85, 0}, {254, 81, 2}, {255, 76, 1},
            {255, 72, 0}, {255, 69, 2}, {255, 64, 0}, {255, 61, 0}, {255, 57, 0},
            {254, 53, 0}, {255, 49, 0}, {254, 46, 0}, {254, 41, 1}, {255, 37, 1},
            {255, 33, 0}, {253, 28, 0}, {255, 25, 1}, {255, 21, 0}, {255, 16, 1},
            {255, 13, 1}, {255, 9, 0}, {254, 5, 1}, {252, 3, 0}, {250, 0, 1},
            {246, 1, 0}, {244, 0, 0}, {239, 0, 0}, {234, 0, 1}, {230, 0, 0},
            {226, 0, 1}, {223, 1, 0}, {218, 0, 0}, {214, 0, 0}, {210, 0, 0},
            {206, 0, 0}, {201, 1, 1}, {197, 1, 2}, {194, 0, 1}, {190, 0, 0},
            {186, 1, 0}, {183, 1, 0}, {180, 0, 0}, {175, 0, 0}, {170, 0, 0},
            {166, 1, 0}, {163, 0, 1}, {159, 1, 0}, {154, 0, 0}, {150, 0, 0},
            {146, 0, 1}, {143, 1, 0}, {139, 1, 1}, {134, 0, 0}, {132, 0, 0},
            {129, 0, 0}
    };

}
