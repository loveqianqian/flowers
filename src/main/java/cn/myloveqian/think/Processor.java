package cn.myloveqian.think;

import cn.myloveqian.Machine;
import cn.myloveqian.Message;

import java.util.Map;

/**
 * cn.myloveqian.think
 *
 * @author zhiwei
 * @create 2016-12-03 20:28.
 */
public interface Processor<T> extends Machine {

    Map<String, Object> transfer(Message<T> message);

}
