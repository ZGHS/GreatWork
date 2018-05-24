package com.jike.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

@Controller
public class FileUploadController {


    //  上传图片的大小
        private static Double Mb = 1024.0 * 1024.0;
        private static Double maxSize = 3.0;
    //  图片重复名称计数
        private static Integer index = 1;
        //上传图片到项目中/本地
        @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
        @ResponseBody
        public String uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        	response.setHeader("Access-Control-Allow-Origin", "*");
        	//如果文件不为空，写入上传路径
            if(!file.isEmpty()) {
                if(!checkSize(file)){
                    return "OUTOFSIZE";//超出限制大小
                }
//                String widthAndHeight = this.getWidthAndHeight(file);
//                if(widthAndHeight.equals("ERROR")){
//                    return "ERROR";
//                }
                //文件的完整名称,如image.jpg
                String filename = file.getOriginalFilename();
                //文件名,如image
                String name = filename.substring(0,filename.indexOf("."));
                //文件后缀,如.jpg
                String suffix = filename.substring(filename.lastIndexOf("."));
                //上传文件路径：
                // 1、上传到项目中
                String path = request.getServletContext().getRealPath("/resources/upload");
                // 2、上传到本地
//                String path = "D:\\pic";
                File filepath = new File(path,filename);
                //若文件存在重命名,更改文件名如：image(1).jpg 后上传
                String newFilename = filename;
                while(filepath.exists()) {
                    newFilename = name+"("+index+")"+suffix;
                    String parentPath = filepath.getParent();
                    filepath = new File(parentPath+File.separator+newFilename);
                    filename = newFilename;
                    index++;
                }
                //判断路径是否存在，如果不存在就创建一个
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + File.separator + filename));
                return filename;
            }
                return "EMPTY";
        }
        /**
         * 校验大小，上传图片不能大于3M
         * @param file
         * @return
         */
        public static boolean checkSize(MultipartFile file){
            //校验大小
            double ratio = file.getSize() / Mb;
            if(ratio > maxSize){
                return false;
            }else{
                return true;
            }
        }

//        @RequestMapping(value = "/uploadQiuNiu", method = RequestMethod.POST)
//        @ResponseBody
//        public String uploadQiNiu(@RequestParam("file") MultipartFile file) throws Exception{
//            //如果文件不为空，写入上传路径
//            if(!file.isEmpty()) {
//                //文件的完整名称,如image.jpg
//                String filename = file.getOriginalFilename();
//                //文件名,如image
//                String name = filename.substring(0,filename.indexOf("."));
//                //文件后缀,如.jpg
//                String suffix = filename.substring(filename.lastIndexOf("."));
//                //文件路径：
//                String path = "D:\\pic";
//                File filepath = new File(path,filename);
//                //若文件存在重命名,更改文件名如：image(1).jpg 后上传
//                String newFilename = filename;
//                while(filepath.exists()) {
//                    newFilename = name+"("+index+")"+suffix;
//                    String parentPath = filepath.getParent();
//                    filepath = new File(parentPath+File.separator+newFilename);
//                    filename = newFilename;
//                    index++;
//                }
//                //判断路径是否存在，如果不存在就创建一个
//                if (!filepath.getParentFile().exists()) {
//                    filepath.getParentFile().mkdirs();
//                }
//                //将上传文件保存到一个目标文件当中
//                file.transferTo(new File(path + File.separator + filename));
//                /**
//                 * 七牛上传
//                 */
//                String URL = "";
//                QiNiuUtil qiniuUtil = new QiNiuUtil();
//                try {
//                    path = path + "\\"+filename;
//                    //上传到七牛云
//                    URL = qiniuUtil.upload(path, filename);
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    URL = "上传到七牛云失败！";
//                    e.printStackTrace();
//                }
//                // 返回图片链接地址给前端
//                return URL;
//            }
//            return "EMPTY";
//        }
//

}
