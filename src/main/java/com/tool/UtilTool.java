package com.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UtilTool {
    //判断文件是否存在
    public static boolean  fileExist(String filePath, String fileName) {
        boolean flag = false;
        String fileSbso = filePath + fileName;
        File file = new File(fileSbso);
        flag = file.exists();
        return flag;
    }
    //创建txt文件
    public static void saveAsFileWriter(String content,String filePath) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, true);
            fwriter.write(content+ "\r\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //删除文件和文件夹的方法
    public static void deleteFile(File file){
        //传入的参数为空
        if(!file.exists()){
            return;
        }
        //删除文件
        if(file.isFile() || file.list() == null){
            file.delete();
        }else {
            File[] files = file.listFiles();
            for(File a:files){
                deleteFile(a);
            }
            file.delete();
        }
    }
    //仅删除文件的方法
    public static void deleteFileName(File file){
        //传入的参数为空
        if(!file.exists()){
            return;
        }else{
            deleteFile(file);
        }
    }
    //



}
