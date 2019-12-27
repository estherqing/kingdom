package com.vivo.jovi.scene.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijun
 * @date 2018/11/13
 * @describe 二维码生成工具
 */
public class QrCodeUtils {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    private static final String IMG_FORMAT = "jpg";

    public static void createQrCode(String url, OutputStream out) {
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        writeToClient(bitMatrix, IMG_FORMAT, out);
    }

    private static void writeToClient(BitMatrix matrix, String format, OutputStream out) {
        BufferedImage image = toBufferImage(matrix);
        try {
            ImageIO.write(image, format, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedImage toBufferImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }
}
