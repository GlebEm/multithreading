package task1631;

import task1631.common.*;

import java.io.Reader;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        if (imageTypes == ImageTypes.JPG) {
            return new JpgReader();
        } else if (imageTypes == ImageTypes.BMP) {
            return new BmpReader();
        } else if (imageTypes == ImageTypes.PNG) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("передан неправильный параметр");
        }
    }
}