package cn.myloveqian.read;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * cn.myloveqian.read
 *
 * @author zhiwei
 * @create 2016-12-04 22:31.
 */
public class ScannerMemory<T> implements Serializable {

    public static final Object key = new Object();

    private ConcurrentMap<String, T> petalsMemory = new ConcurrentHashMap<String, T>();

    public synchronized ConcurrentMap<String, T> getPetalsMemory() {
        synchronized (key) {
            return petalsMemory;
        }
    }

    public void setPetalsMemory(ConcurrentMap<String, T> petalsMemory) {
        synchronized (key) {
            this.petalsMemory = petalsMemory;
        }
    }
}
