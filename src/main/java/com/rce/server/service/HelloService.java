package com.rce.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
     String hello() throws RemoteException;
}
