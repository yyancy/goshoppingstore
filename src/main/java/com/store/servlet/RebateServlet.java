package com.store.servlet;

public class RebateServlet {
    private static RebateServlet ourInstance = new RebateServlet();

    public static RebateServlet getInstance() {
        return ourInstance;
    }

    private RebateServlet() {
    }
}
