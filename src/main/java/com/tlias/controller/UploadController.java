package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    AliOSSUtils aliOSSUtils;
    //本地存储文件方式
    @PostMapping("/uploadlocal")
    public Result upload(String username, Integer age, @RequestParam("image") MultipartFile file) throws IOException {
        log.info("文件上传：{},{},{}",username,age,file);
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //构造唯一文件名（不能重复) -uuid(通用唯一识别码 fb87aa74-1092-49d1-bfab-a6987d8f25e9）
        assert originalFilename != null;
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名：{}",newFileName);
        //将文件存储在服务器的磁盘目录中：/Users/fengliang/Documents/workspace/javaWeb-2023/transferTo_upload_save
        String path_save = "/Users/fengliang/Documents/workspace/javaWeb-2023/transferTo_upload_save/";
        file.transferTo(new File(path_save + newFileName));
        return Result.success();
    }
    @PostMapping("/upload")
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException {
        log.info("文件上传：{}",file.getOriginalFilename());
        //调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(file);
        log.info("文件上传完成，文件访问的url：{}",url);
        return  Result.success(url);



    }
}
