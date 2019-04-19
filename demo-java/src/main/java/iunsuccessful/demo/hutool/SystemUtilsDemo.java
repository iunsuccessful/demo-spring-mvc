package iunsuccessful.demo.hutool;


import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取 IP 地址
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/16 .
 */
public class SystemUtilsDemo {

    public static void main(String[] args) {
        HostInfo hostInfo = SystemUtil.getHostInfo();
        System.out.println(hostInfo.getAddress());

        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
