package com.axitera.graph;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//from  w  w w.  java  2  s . c o m
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;

public class ApiTest {
    //    public static void main(String[] args) throws IOException, Pdfcrowd.Error {
    public void myMethod() throws IOException {
//        try {
//            // create the API client instance
//            Pdfcrowd.HtmlToImageClient client =
//                    new Pdfcrowd.HtmlToImageClient("demo", "ce544b6ea52a5621fb9d55f8b542d14d");
//
//            // configure the conversion
//            client.setOutputFormat("png");
//
//            // run the conversion and write the result to a file
//            client.convertUrlToFile("http://google.de", "example.png");
////            client.convertUrlToFile("templates/employees/list.html", "example.png");
//            System.out.println("running" + client.getDebugLogUrl());
//        } catch (Pdfcrowd.Error why) {
//            // report the error
//            System.err.println("Pdfcrowd Error: " + why);
//
//            // rethrow or handle the exception
//            throw why;
//        } catch (IOException why) {
//            // report the error
//            System.err.println("IO Error: " + why);
//
//            // rethrow or handle the exception
//            throw why;
//        }

            String html = "<h1>Hello, world.</h1>";
            int width = 200, height = 100;

            BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice().getDefaultConfiguration()
                    .createCompatibleImage(width, height);

            Graphics graphics = image.createGraphics();

            JEditorPane jep = new JEditorPane("text/html", html);
            jep.setSize(width, height);
            jep.print(graphics);

            ImageIO.write(image, "png", new File("Image.png"));

    }
}