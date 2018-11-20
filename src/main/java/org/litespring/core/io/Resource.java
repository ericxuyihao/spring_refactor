package org.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuyihao on 2018/11/20 10:23
 */

public interface Resource {
    public InputStream getInputStream() throws IOException;
    public String getDescription();
}
