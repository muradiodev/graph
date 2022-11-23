package com.axitera.graph;

import com.pdfcrowd.*;

import java.io.*;

public class ApiTest {
    //    public static void main(String[] args) throws IOException, Pdfcrowd.Error {
    public void myMethod() throws IOException {
        try {
            // create the API client instance
            Pdfcrowd.HtmlToImageClient client =
                    new Pdfcrowd.HtmlToImageClient("demo", "ce544b6ea52a5621fb9d55f8b542d14d");

            // configure the conversion
            client.setOutputFormat("png");

            // run the conversion and write the result to a file
            client.convertUrlToFile("http://google.de", "example.png");
//            client.convertUrlToFile("templates/employees/list.html", "example.png");
            System.out.println("running" + client.getDebugLogUrl());
        } catch (Pdfcrowd.Error why) {
            // report the error
            System.err.println("Pdfcrowd Error: " + why);

            // rethrow or handle the exception
            throw why;
        } catch (IOException why) {
            // report the error
            System.err.println("IO Error: " + why);

            // rethrow or handle the exception
            throw why;
        }


    }
}