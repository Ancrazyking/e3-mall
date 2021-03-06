package com.ancrazyking.fast;

import com.ancrazyking.common.util.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @author Ancrazyking
 * @date 2018/5/23 14:27
 **/
public class FastDfsTest
{
    @Test
    public void testUpload() throws Exception {
        //创建一个配置文件。文件名任意。内容就是tracker服务器的地址。
        //使用全局对象加载配置文件。
        ClientGlobal.init("H:\\Project in action\\shop\\shop-manager-web\\src\\main\\resources\\conf\\client.conf");
        //创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackClient获得一个TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //创建一个StrorageServer的引用，可以是null
        StorageServer storageServer = null;
        //创建一个StorageClient，参数需要TrackerServer和StrorageServer
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //使用StorageClient上传文件。
        String[] strings = storageClient.upload_file("H:/lol/timo.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }

    }


    @Test
    public void testFastFastDfsClient()throws Exception{
        FastDFSClient fastDFSClient=new FastDFSClient("H:\\Project in action\\shop\\shop-manager-web\\src\\main\\resources\\conf\\client.conf");
        String string=fastDFSClient.uploadFile("H:/lol/亚索.png");
        System.out.println(string);
    }






}
