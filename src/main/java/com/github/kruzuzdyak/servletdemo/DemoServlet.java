package com.github.kruzuzdyak.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "demo", value = "/demo")
public class DemoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String queryString = request.getQueryString();

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("response to get request");
        out.println("query string: " + queryString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("response to post request");
        out.println("query string: " + queryString);
        out.println("parameters: ");
        parameterMap.forEach((key, value) -> out.println(key + " - " + Arrays.toString(value)));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        String params;
        try (BufferedInputStream stream = new BufferedInputStream(request.getInputStream())){
            params = new String(stream.readAllBytes());
        }
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("response to put request");
        out.println("query string: " + queryString);
        out.println("parameters: ");
        out.println(params);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("response to delete request");
        out.println("query string: " + queryString);
        out.println("parameters: ");
        parameterMap.forEach((key, value) -> out.println(key + " - " + Arrays.toString(value)));
    }
}