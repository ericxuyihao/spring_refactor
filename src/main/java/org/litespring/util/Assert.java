package org.litespring.util;

/**
 * Created by xuyihao on 2018/11/20 10:42
 */

public class Assert {
    public static void notNull(Object object,String messsage){
        if (object==null){
            throw new IllegalArgumentException(messsage);
        }
    }
}
