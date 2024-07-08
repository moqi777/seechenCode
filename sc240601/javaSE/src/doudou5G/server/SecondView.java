package doudou5G.server;

import doudou5G.util.ScannerYN;
import doudou5G.util.SelectMobileCardToCardNumber;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:二级页面
 * @DateTime:2024/7/4 11:40
 **/
public class SecondView {
    public SecondView() {
        //进入到二级页面，如果有正在等待执行的任务，取消掉。即刷新登录状态，如果退出重新询问是否需要保存登录状态
        //isDone()：检查任务是否已经完成
        if (Index.scheduledFuture != null && !Index.scheduledFuture.isDone()) {
            Index.scheduledFuture.cancel(true);//取消任务执行
            Index.ses.shutdown();//关闭线程池
        }
        //每次进入二级菜单，都要重新从文件中读取用户数据，保证数据同步性
        Index.nowMobileCard = SelectMobileCardToCardNumber.select(Index.nowMobileCard.getCardNumber());
        while (true){
            System.out.println("\n****************兜兜5G移动用户菜单***************");
            System.out.println("1.本月账单查询\n2.套餐余量查询\n3.打印消费详单\n4.查看当前套餐\n5.套餐变更\n6.办理退网\n7.客服支持");
            System.out.print("请选择(输入1-7选择功能，输入0返回上一级)：");
            String next = Index.scanner.next();
            int verify = ScannerYN.verify(next, 0, 7);
            switch (verify){
                case 1:new MonthBillView();break;
                case 2:new RemainSerPackageView();break;
                case 3:new PrintBuyBillView();break;
                case 4:new SelectNowPackageView();break;
                case 5:new UpdatePackageView();break;
                case 6:new DeleteUserView();return;
                case 7:new ChatOrService();break;
                case 0:
                    System.out.print("是否(Y/N)保留登录状态30s(其他输入默认不保存)：");
                    next = Index.scanner.next();
                    if (next.equalsIgnoreCase("y")){
                        //使用可周期定长线程池定时30s后登录状态失效，此处两个变量被赋值给了共享变量
                        Index.ses = Executors.newScheduledThreadPool(1);
                        Index.scheduledFuture = Index.ses.schedule(() -> {
                            Index.nowMobileCard = null;
                            System.out.print("\n登录状态失效，请重新登录使用！！！\n");
                        }, 30, TimeUnit.SECONDS);
                    }else {
                        Index.nowMobileCard = null;
                    }
                    return;
            }
        }
    }
}

