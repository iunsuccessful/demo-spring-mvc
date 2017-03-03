package iunsuccessful.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LiQZ on 2017/2/23.
 */
public class JsonDemo {

    public static void main(String[] args) {
        JSONArray array = JSON.parseArray("[{\"img\":\"http:\\/\\/img01.yohoboys.com\\/contentimg\\/2016\\/12\\/20\\/14\\/01d4454f2e43666e3bf19f6cbc0fabaebc.jpg\",\"size\":\"394\\u00d7494\"},{\"img\":\"http:\\/\\/img01.yohoboys.com\\/contentimg\\/2016\\/12\\/20\\/14\\/017cbeba95a83c7c19e651119beebf94d1.jpg\",\"size\":\"202\\u00d7206\"},{\"img\":\"http:\\/\\/img01.yohoboys.com\\/contentimg\\/2016\\/12\\/20\\/14\\/01a711feef639700ceb378170deaa9f628.jpg\",\"size\":\"390\\u00d7572\"}]");
        List<String> imgs1 = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            imgs1.add(array.getJSONObject(i).getString("img"));
        }
        PrintUtils.print(imgs1);
        List<String> imgs =  array.stream().map(o -> ((JSONObject) o).getString("img")).collect(Collectors.toList());
        PrintUtils.print(imgs);

        List<Picture> pics = JSON.parseArray("[{\"img\":\"http:\\/\\/img01.yohoboys.com\\/contentimg\\/2016\\/12\\/20\\/14\\/01d4454f2e43666e3bf19f6cbc0fabaebc.jpg\",\"size\":\"394\\u00d7494\"},{\"img\":\"http:\\/\\/img01.yohoboys.com\\/contentimg\\/2016\\/12\\/20\\/14\\/017cbeba95a83c7c19e651119beebf94d1.jpg\",\"size\":\"202\\u00d7206\"},{\"img\":\"http:\\/\\/img01.yohoboys.com\\/contentimg\\/2016\\/12\\/20\\/14\\/01a711feef639700ceb378170deaa9f628.jpg\",\"size\":\"390\\u00d7572\"}]", Picture.class);
        PrintUtils.print(pics);


    }

    class Picture {

        private String img;
        private String size;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Picture{" +
                    "img='" + img + '\'' +
                    ", size='" + size + '\'' +
                    '}';
        }
    }

}
