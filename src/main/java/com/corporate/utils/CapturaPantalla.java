package com.corporate.utils;

import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class CapturaPantalla {

    public static void capturarPantalla(String Nombre) throws AWTException, IOException {
        BufferedImage captura = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // Guardar Como JPEG
        File file = new File("C:\\Users\\acamac4\\IdeaProjects\\UAT_Una_a_Muchas\\imagenes\\"+Nombre+".jpg");
        ImageIO.write(captura, "jpg", file);
    }
}
