package com.company.examples.m2.sample2_http_server;

public class HTTPServer {
    private int port;
    private String path;
    private ListenThread listenThread;

    public HTTPServer(int port, String path) {
        this.port = port;
        this.path = path;
    }

    public void start() {
        listenThread = new ListenThread(port, path);
        listenThread.start();
    }
    
    public void stop() {
    	listenThread.interrupt();
    }
}