package com.zcl.nio;

import java.io.*;
import java.net.Socket;

public class SocketIO {
    public static DataInputStream getinput(Socket socket) throws IOException {
        //接收缓存区大小，socket获取输入流之前设置
        socket.setReceiveBufferSize(10);
        InputStream inputStream = socket.getInputStream();
        return new DataInputStream(inputStream);
    }

    public static DataOutputStream getOutput(Socket socket) throws IOException {
        //发送缓存区大小，socket获取输出流之前设置
        socket.setSendBufferSize(10);
        OutputStream output = socket.getOutputStream();
        return new DataOutputStream(output);
    }
}
