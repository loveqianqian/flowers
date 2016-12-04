package cn.myloveqian.write;

import java.util.Map;

/**
 * cn.myloveqian.write
 *
 * @author zhiwei
 * @create 2016-12-03 20:38.
 */
public interface Printer<T> {

    String print(T type, Map<String, Object> message);
}
