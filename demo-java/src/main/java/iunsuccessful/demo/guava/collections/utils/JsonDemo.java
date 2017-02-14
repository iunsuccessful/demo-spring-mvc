package iunsuccessful.demo.guava.collections.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by LiQZ on 2017/2/14.
 */
public class JsonDemo {

    public static void main(String[] args) {
        String jsonString = "[{\"pic\":\"\\/2015\\/12\\/20\\/15\\/02debebb095fca44f4d82714cb3c50acf6.jpg\",\"num\":\"\"},{\"pic\":\"\\/2015\\/12\\/20\\/15\\/02ba017bd3ce3e3bb1df93d08000d46bab.jpg\",\"num\":\"\"},{\"pic\":\"\\/2015\\/12\\/20\\/15\\/0132728e2bbdf5c124deaddb83c78acec5.jpg\",\"num\":\"\"},{\"pic\":\"\\/2015\\/12\\/20\\/15\\/018a95e6fc4a50b253eb3efcdf2a92a2ed.jpg\",\"num\":\"\"}]";
        System.out.println(JSON.parseArray(jsonString).size());
    }

}
