package cn.myloveqian.read;

import cn.myloveqian.Machine;
import cn.myloveqian.Message;

/**
 * cn.myloveqian.read
 *
 * @author zhiwei
 * @create 2016-12-03 20:21.
 */
public interface Scanner<T> extends Machine {

    Message<T> read();
}
