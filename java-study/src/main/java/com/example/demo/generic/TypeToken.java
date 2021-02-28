package com.example.demo.generic;

public class TypeToken {

    static <T>T create(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }
    public static void main(String[] args) throws Exception {
        String str = create(String.class);
        System.out.println(str.length());

        //Integer o = create(Integer.class);
        //System.out.println(o.getClass());
        // 에러발생 -> Integer는 default 생성자가 없다.
        //Integer o1 = new Integer();
    }
}
