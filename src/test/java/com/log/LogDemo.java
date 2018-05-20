package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {
    private  static Logger log = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        log.info("current Time: {}",System.currentTimeMillis());
        log.info("current Time: "+System.currentTimeMillis());
        log.info("current Time: {}",System.currentTimeMillis());
        log.trace("trace log");
        log.warn("warn log");
        log.debug("debug log");
        log.info("info log");
        log.error("error log");
    }
}
