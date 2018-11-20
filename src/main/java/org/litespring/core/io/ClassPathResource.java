package org.litespring.core.io;

import org.litespring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuyihao on 2018/11/20 10:25
 */

public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,(ClassLoader)null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader!=null?classLoader: ClassUtils.getDefaultClassLoader());
    }

    public InputStream getInputStream() throws IOException {
        InputStream is=this.classLoader.getResourceAsStream(this.path);
        if (is==null){
            throw  new FileNotFoundException(path+"can not be opened");
        }
        return is;
    }

    public String getDescription() {
        return this.path;
    }
}
