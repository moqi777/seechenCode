package doudou5G.server;

import doudou5G.util.DeleteMobileCard;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:办理退网
 * @DateTime:2024/7/6 11:53
 **/
public class DeleteUserView {
    public DeleteUserView() {
        System.out.println("\n*****办理退网*****");
        //将数据库中该用户信息删除
        boolean isOk = DeleteMobileCard.delete(Index.nowMobileCard);
        if (!isOk){//如果失败直接return
            return;
        }
        System.out.println("卡号"+Index.nowMobileCard.getCardNumber()+"办理退网成功！\n谢谢使用！");
        //删除Index.nowMobileCard
        Index.nowMobileCard = null;
    }
}

