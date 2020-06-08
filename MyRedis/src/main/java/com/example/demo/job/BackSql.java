package com.example.demo.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BackSql {
    @Value("${user.mysqldumppath}")
    String mysqldumppath;

    String myPath = "127.0.0.1";
    String uname = "root";
    String pwd = "123456";
    String dbName = "project3";
    String savePath = "";

    public BackSql(){
        savePath = System.getProperty("user.dir") + "/";

    }


    public void back(String name) throws IOException {
        String fileName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date()) + ".sql";

        String command1 = mysqldumppath + "mysqldump -h"
                + myPath +
                " -u"
                + uname + " -p" + pwd + " --set-charset=UTF8 " + dbName;
        Process process =
                Runtime.getRuntime().exec(mysqldumppath + "mysqldump -h"
                         + myPath +
                        " -u"
                + uname + " -p" + pwd + " " + dbName );
//        Process process =
//                Runtime.getRuntime().exec(mysqldumppath + "mysqldump --no-defaults -h"
//                         + myPath +
//                        " -u"
//                + name + " -p" + pwd + " --set-charset=UTF8 " + dbName);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line="aaaaaaaaa";
        while((line = bufferedReader.readLine())!= null){
            printWriter.println(line);
            System.out.println("===========");
        }
        printWriter.flush();

        printWriter.close();
        inputStreamReader.close();
        System.out.println(mysqldumppath);
        System.out.println(command1);

        System.out.println("备份完毕"+savePath);
//        PrintWriter printWriter =
//                new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName)));
//
//        InputStreamReader inputStreamReader =
//                new InputStreamReader(process.getInputStream(), "utf8");
//
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String line;
//        while ((line = bufferedReader.readLine())!=null) {
//            printWriter.println(line);
//            System.out.println("============");
//        }
//
//        printWriter.flush();
//        printWriter.close();
//        inputStreamReader.close();
//        System.out.println("备份完毕"+savePath);
    }

}
