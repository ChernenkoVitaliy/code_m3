package com.company.examples.m2.sample2_http_server;

import java.util.List;

public interface Processor {
    byte[] process(byte[] data, List<String> headers);
}