package priv.seesea.seeseabookclub.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String args[]){
        boolean a  = false;
        if(a){
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            for(int i = 0;i<1;i++){
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        Map<String,Object> m = new HashMap<>();
                        m.put("code","utf-8");
                        m.put("q","卡");
                        m.put("callback","http:www.baidu.com");

                        try {
                            HttpClientUtil.post("http://suggest.taobao.com/sug",m);
                            m.put("a","dd");
                            HttpClientUtil.post("http://www.baidu.com",m);
                            m.remove("a");
                            HttpClientUtil.post("http://www.baidu.com",m);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }else {
            Map<String,Object> m = new HashMap<>();
            m.put("code","utf-8");
            m.put("q","卡");
            m.put("callback","http:www.baidu.com");

            try {
                HttpClientUtil.post("http://suggest.taobao.com/sug",m);
                m.put("a","dd");
                HttpClientUtil.post("http://www.baidu.com",m);
                m.remove("a");
                HttpClientUtil.post("http://suggest.taobao.com/sug",m);

                HttpClientUtil.post("http://www.baidu.com",m);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
