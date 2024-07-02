package day6;

import java.sql.Connection;
import java.util.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/1 20:11
 **/
//实现斗地主随机发牌的功能 一共54张牌
//   牌的花色分为   梅花   红桃   黑桃  方片
//   牌有  3  4 5 6 7 8 9 10 J  Q K  A  2  大王 小王
//   随机发给两个农民 和一个地主      地主 多三张牌
//   最后显示每人的牌的结果
public class Job3 {
    public static void main(String[] args) {
        //造一副牌
        ArrayList<Playing> playings = new ArrayList<Playing>();
        for (int i = 1; i <= 13; i++) {
            playings.add(new Playing(i, '♣', 0));
            playings.add(new Playing(i, '♥', 0));
            playings.add(new Playing(i, '♠', 0));
            playings.add(new Playing(i, '♦', 0));
        }
        playings.add(new Playing(0, ' ', 1));
        playings.add(new Playing(0, ' ', 2));

        //随机打乱牌
        Collections.shuffle(playings);

        //声明比较器
        Comparator<Playing> com = (o1,o2)->{
            // 首先按花色排序
            int suitCompare = o1.huaSe - o2.huaSe;
            if (suitCompare != 0) {
                return suitCompare;
            }
            // 然后按牌面大小排序
            return o1.num - o2.num;
        };

        //三个角色
        TreeSet<Playing> nongMing1 = new TreeSet<>(com);
        TreeSet<Playing> nongMing2 = new TreeSet<>(com);
        TreeSet<Playing> diZhu = new TreeSet<>(com);

        //给他们发牌
        for (int i = 0; i < playings.size(); i++) {
            if (i<17) {
                nongMing1.add(playings.get(i));
            }else if (i<34){
                nongMing2.add(playings.get(i));
            }else {
                diZhu.add(playings.get(i));
            }
        }

        //看一下他们的牌
        System.out.println("农民1"+nongMing1);
        System.out.println("农民2"+nongMing2);
        System.out.println("地主"+diZhu);

        //继续完成斗地主的题目  给俩个农民和一个地主的牌 进行降序排列

    }
}

class Playing{
    @Override
    public String toString() {
        if (bigSmall==0){
            switch (num){
                case 1:
                    return huaSe+"A";
                case 11:
                    return huaSe+"J";
                case 12:
                    return huaSe+"Q";
                case 13:
                    return huaSe+"K";
                default:
                    return huaSe+""+num;

            }
        }else if(bigSmall==1){
            return "大王";
        }else {
            return "小王";
        }
    }

    public Playing(int num, char huaSe, int bigSmall) {
        this.num = num;
        this.huaSe = huaSe;
        this.bigSmall = bigSmall;
    }

    int num;//A=1，J=11，Q=12，K=13
    char huaSe;//♣ ♥ ♠ ♦
    int bigSmall;//0表示不是任何一个，1是大王，2是小王
}







