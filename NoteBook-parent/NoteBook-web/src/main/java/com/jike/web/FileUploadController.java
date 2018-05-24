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


    //  �ϴ�ͼƬ�Ĵ�С
        private static Double Mb = 1024.0 * 1024.0;
        private static Double maxSize = 3.0;
    //  ͼƬ�ظ����Ƽ���
        private static Integer index = 1;
        //�ϴ�ͼƬ����Ŀ��/����
        @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
        @ResponseBody
        public String uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        	response.setHeader("Access-Control-Allow-Origin", "*");
        	//����ļ���Ϊ�գ�д���ϴ�·��
            if(!file.isEmpty()) {
                if(!checkSize(file)){
                    return "OUTOFSIZE";//�������ƴ�С
                }
//                String widthAndHeight = this.getWidthAndHeight(file);
//                if(widthAndHeight.equals("ERROR")){
//                    return "ERROR";
//                }
                //�ļ�����������,��image.jpg
                String filename = file.getOriginalFilename();
                //�ļ���,��image
                String name = filename.substring(0,filename.indexOf("."));
                //�ļ���׺,��.jpg
                String suffix = filename.substring(filename.lastIndexOf("."));
                //�ϴ��ļ�·����
                // 1���ϴ�����Ŀ��
                String path = request.getServletContext().getRealPath("/resources/upload");
                // 2���ϴ�������
//                String path = "D:\\pic";
                File filepath = new File(path,filename);
                //���ļ�����������,�����ļ����磺image(1).jpg ���ϴ�
                String newFilename = filename;
                while(filepath.exists()) {
                    newFilename = name+"("+index+")"+suffix;
                    String parentPath = filepath.getParent();
                    filepath = new File(parentPath+File.separator+newFilename);
                    filename = newFilename;
                    index++;
                }
                //�ж�·���Ƿ���ڣ���������ھʹ���һ��
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //���ϴ��ļ����浽һ��Ŀ���ļ�����
                file.transferTo(new File(path + File.separator + filename));
                return filename;
            }
                return "EMPTY";
        }
        /**
         * У���С���ϴ�ͼƬ���ܴ���3M
         * @param file
         * @return
         */
        public static boolean checkSize(MultipartFile file){
            //У���С
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
//            //����ļ���Ϊ�գ�д���ϴ�·��
//            if(!file.isEmpty()) {
//                //�ļ�����������,��image.jpg
//                String filename = file.getOriginalFilename();
//                //�ļ���,��image
//                String name = filename.substring(0,filename.indexOf("."));
//                //�ļ���׺,��.jpg
//                String suffix = filename.substring(filename.lastIndexOf("."));
//                //�ļ�·����
//                String path = "D:\\pic";
//                File filepath = new File(path,filename);
//                //���ļ�����������,�����ļ����磺image(1).jpg ���ϴ�
//                String newFilename = filename;
//                while(filepath.exists()) {
//                    newFilename = name+"("+index+")"+suffix;
//                    String parentPath = filepath.getParent();
//                    filepath = new File(parentPath+File.separator+newFilename);
//                    filename = newFilename;
//                    index++;
//                }
//                //�ж�·���Ƿ���ڣ���������ھʹ���һ��
//                if (!filepath.getParentFile().exists()) {
//                    filepath.getParentFile().mkdirs();
//                }
//                //���ϴ��ļ����浽һ��Ŀ���ļ�����
//                file.transferTo(new File(path + File.separator + filename));
//                /**
//                 * ��ţ�ϴ�
//                 */
//                String URL = "";
//                QiNiuUtil qiniuUtil = new QiNiuUtil();
//                try {
//                    path = path + "\\"+filename;
//                    //�ϴ�����ţ��
//                    URL = qiniuUtil.upload(path, filename);
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    URL = "�ϴ�����ţ��ʧ�ܣ�";
//                    e.printStackTrace();
//                }
//                // ����ͼƬ���ӵ�ַ��ǰ��
//                return URL;
//            }
//            return "EMPTY";
//        }
//

}
