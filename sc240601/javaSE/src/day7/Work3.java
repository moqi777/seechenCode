package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 11:23
 **/
//实现斗地主随机发牌的功能 一共54张牌
//   牌的花色分为   梅花   红桃   黑桃  方片
//   牌有  3  4 5 6 7 8 9 10 J  Q K  A  2  大王 小王
//   随机发给两个农民 和一个地主      地主 多三张牌
//   最后显示每人的牌的结果
public class Work3 {
    public static void main(String[] args) {
        //1.保存所有牌
        List<Card> cards = new ArrayList<Card>();
        String[] color={"♣","♦","♠","♥"};
        String[] nums = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A","2"};
        for (String s : color) {
            for (int i = 0; i < nums.length; i++) {
                cards.add(new Card(s+nums[i],i+1));
            }
        }
        cards.add(new Card("大王",nums.length+1));
        cards.add(new Card("小王",nums.length+2));
        System.out.println("==============存储牌成功===============");
        System.out.println(cards);
        //2.洗牌
        Collections.shuffle(cards);
        System.out.println("=============开始洗牌================");
        System.out.println(cards);
        //3.按顺序发牌 每次发第一张（发一次少一次）
        List<Card> farmer1 = new ArrayList<>();
        List<Card> farmer2 = new ArrayList<>();
        List<Card> dizhu = new ArrayList<>();
        while (true){
            farmer1.add(cards.remove(0));
            farmer2.add(cards.remove(0));
            dizhu.add(cards.remove(0));
            if (cards.size()==3) break;
        }
        for (Card card : cards) {
            dizhu.add(card);
        }
        //4.打印结果
        System.out.println("=============发牌结束================");
        System.out.println(farmer1);
        System.out.println(farmer2);
        System.out.println(dizhu);
        //5.排序
        Collections.sort(farmer1,(o1,o2)->o1.sort-o2.sort);
        Collections.sort(farmer2,(o1,o2)->o1.sort-o2.sort);
        Collections.sort(dizhu,(o1,o2)->o1.sort-o2.sort);
        //6.再打印结果
        System.out.println("==============排序后===============");
        System.out.println(farmer1);
        System.out.println(farmer2);
        System.out.println(dizhu);
    }
}

class Card{
    @Override
    public String toString() {
        return str;
    }

    String str;//梅花3 方片4
    int sort;//排序3 J11 Q12 K13 A14 2 15 16 17

    public Card(String str, int sort) {
        this.str = str;
        this.sort = sort;
    }
}
