package doudou5G.server;

import doudou5G.util.PrintFileToFilePath;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:查看资费说明
 * @DateTime:2024/7/6 12:16
 **/
public class SelectPackageView {
    public SelectPackageView() {
        System.out.println("\n*****资费说明*****");
        PrintFileToFilePath.start("./javaSE/src/doudou5G/资费说明.txt");
    }
}

