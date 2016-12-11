package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuxing01.long on 2016/12/9.
 */
public class Abser {
    private static final int _1MB = 1024*512;

    public static void main(String[] args) {
        final List<Object> objectList = new ArrayList<>();

       Thread s =  new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    objectList.clear();
                    objectList.add(new Byte[_1MB]);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        s.start();

    }
}
