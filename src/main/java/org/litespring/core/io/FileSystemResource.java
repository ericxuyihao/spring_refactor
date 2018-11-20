package org.litespring.core.io;

import org.litespring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuyihao on 2018/11/20 10:36
 */

public class FileSystemResource implements Resource {
    private   String path;
    private File file;

    public FileSystemResource(String path) {
        Assert.notNull(path,"Path must not be Null");
        this.file=new File(path);
        this.path = path;
    }

    public InputStream getInputStream() throws IOException {

        return new FileInputStream(file);
    }

    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }

}
