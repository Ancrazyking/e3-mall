package com.ancrazyking.controller;

import com.ancrazyking.common.util.FastDFSClient;
import com.ancrazyking.common.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ancrazyking
 * @date 2018/5/23 15:20
 **/
@Controller
public class PictureController
{

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;


    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile){
        try
        {
            //1.取文件的扩展名
            String originalFilename=uploadFile.getOriginalFilename();
            //文件的后缀名
            String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            //2.创建一个FastDFSClient客户端
            FastDFSClient fastDFSClient=new FastDFSClient("H:\\Project in action\\shop\\shop-manager-web\\src\\main\\resources\\conf\\client.conf");
            //3.执行上传处理
            String path=fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
            //4.拼接返回的url和ip地址,拼装成完整的url
            String url=IMAGE_SERVER_URL+path;
            //5.返回Map
            Map result=new HashMap<>();
            result.put("error",0);
            result.put("url",url);
            String json= JsonUtils.objectToJson(result);
            return json;
        }catch (Exception e){
            e.printStackTrace();
            //返回Map
            Map result=new HashMap<>();
            result.put("error",1);
            result.put("message","图片上传失败!");
            String json=JsonUtils.objectToJson(result);
            return json;
        }

    }












}
