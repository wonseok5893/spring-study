package com.wonseok.spring.demo.chapter3.templateCallback;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 제네릭스를 이용한 콜백 인터페이스 / 템플릿 콜백 패턴
 */
public class Calculator {

    public <T> T template(String filePath, LineCallback<T> callback, T initValue)throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filePath));
            T res = initValue;
            String line = null;
            while((line = br.readLine())!=null){
                res = callback.doSomething(line, res);
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try{
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
