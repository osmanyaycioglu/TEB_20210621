package com.training.ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
              "/tebservlet"
})
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -5392850307492889511L;

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {

        String isimLoc = reqParam.getParameter("isim");
        System.out.println("parts : " + isimLoc);
        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println("{\r\n"
                          + "    \"name\" :\""
                          + isimLoc
                          + "\",\r\n"
                          + "    \"surname\":\"soy:yaycıoğlu\",\r\n"
                          + "    \"age\":52\r\n"
                          + "}");
        respParam.addHeader("Content-Type",
                            "application/json");
    }

    @Override
    protected void doPost(final HttpServletRequest reqParam,
                          final HttpServletResponse respParam) throws ServletException, IOException {

        String isimLoc = reqParam.getParameter("isim");
        System.out.println("parts : " + isimLoc);
        // NIO2
        //        ByteBuffer bytb = ByteBuffer.allocate(2048);
        //        ReadableByteChannel newChannelLoc = Channels.newChannel(inputStreamLoc);
        //        int read2Loc = newChannelLoc.read(bytb);
        ServletInputStream inputStreamLoc = reqParam.getInputStream();
        byte[] testBytes = new byte[2048];
        int readLoc = inputStreamLoc.read(testBytes);
        String stringLoc = new String(testBytes,
                                      0,
                                      readLoc,
                                      "UTF-8");
        System.out.println(stringLoc);


        //        BufferedReader readerLoc = reqParam.getReader();
        //        String lineStr = null;
        // List<String> collectLoc = readerLoc.lines().collect(Collectors.toList());
        //        readerLoc.lines()
        //                 .forEach(System.out::println);
        //        while ((lineStr = readerLoc.readLine()) != null) {
        //            System.out.println(lineStr);
        //        }
        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println("{\r\n"
                          + "    \"name\" :\""
                          + isimLoc
                          + "\",\r\n"
                          + "    \"surname\":\"soy:yaycıoğlu\",\r\n"
                          + "    \"age\":52\r\n"
                          + "}");
        respParam.addHeader("Content-Type",
                            "application/json");

    }

}
