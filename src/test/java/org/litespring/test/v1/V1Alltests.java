package org.litespring.test.v1;

/**
 * Created by xuyihao on 2018/11/20 10:08
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class})
public class V1Alltests {
}
