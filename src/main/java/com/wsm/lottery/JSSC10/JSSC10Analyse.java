package com.wsm.lottery.JSSC10;

import com.google.common.collect.Maps;
import com.wsm.lottery.dao.LotteryJsscDAO;
import com.wsm.lottery.dao.LotteryJsscDAOImpl;
import com.wsm.lottery.dao.LotteryJsscDO;
import com.wsm.lottery.model.JSSC10;
import com.wsm.lottery.utils.DateUtils;

import java.util.*;

public class JSSC10Analyse {

    private static final LotteryJsscDAO lotteryDao = new LotteryJsscDAOImpl();

//    public static void main(String[] args){
//        while (true){
//            System.out.println("请输入要分析几天前的数据( 1 表示分析一天前的数据,回车确认):");
//            Scanner sc = new Scanner(System.in);
//            String input = sc.next();
//            if("exit".equals(input)){
//                break;
//            }
//            int i = Integer.valueOf(input)-1;
//            startAnanlyse(i);
//
//        }
//
//        System.out.println("程序结束，感谢您的使用！");
//
//
//
//    }
    public static void main(String[] args){
        int i = 0;
        while (i<30){
            startAnanlyse(i);
            i++;
        }

        System.out.println("程序结束，感谢您的使用！");



    }

    public static void startAnanlyse(int i){
        Date nowDay = new Date();
        Date today = DateUtils.addDay(nowDay,-i);
        Date yestoday = DateUtils.addDay(nowDay,-(i+1));
        String drawTimeFrom = " 07:00:30";
        String drawTimeTo = " 05:59:15";

        drawTimeFrom = DateUtils.dateToString(yestoday) + drawTimeFrom;
        drawTimeTo = DateUtils.dateToString(today) + drawTimeTo;

        System.out.println("----------开始分析从"+drawTimeFrom+"到"+drawTimeTo+"的数据-----------");

        Map paramDb = new HashMap();
        paramDb.put("drawTimeFrom", drawTimeFrom);
        paramDb.put("drawTimeTo", drawTimeTo);

        List<LotteryJsscDO> lotteryJsscDOS = lotteryDao.selectListByMap(paramDb);

        //处理数据
        int periordFirst = Integer.valueOf(lotteryJsscDOS.get(0).getPeriod());
        List<JSSC10> datas = new ArrayList<>();

        for(LotteryJsscDO lotteryJsscDO : lotteryJsscDOS){
            if(!lotteryJsscDO.getPeriod().equals(periordFirst+"")){
                throw new RuntimeException("期数不匹配");
            }
            JSSC10 jssc10 = new JSSC10();
            jssc10.setPeriod(lotteryJsscDO.getPeriod());
            jssc10.setDrawTime(lotteryJsscDO.getDrawTime());
            List<Integer> balls = new ArrayList<>();
            balls.add(lotteryJsscDO.getBallOne());
            balls.add(lotteryJsscDO.getBallTwo());
            balls.add(lotteryJsscDO.getBallThree());
            balls.add(lotteryJsscDO.getBallFour());
            balls.add(lotteryJsscDO.getBallFive());
            balls.add(lotteryJsscDO.getBallSix());
            balls.add(lotteryJsscDO.getBallSeven());
            balls.add(lotteryJsscDO.getBallEight());
            balls.add(lotteryJsscDO.getBallNine());
            balls.add(lotteryJsscDO.getBallTen());
            jssc10.setBallNames(balls);

            datas.add(jssc10);

            periordFirst++;
        }

        //三种分析
        Map<Integer, Integer> one = analyseOne(datas);
        Map<Integer, Integer> two = analyseTwo(datas);
        Map<Integer, Integer> three = analyseThree(datas);

        System.out.println("分析1，出现对子，就买13568 10 :");
        for(Map.Entry<Integer,Integer> entry : one.entrySet()){
            System.out.println(entry.getKey() + "期购买中奖次数：" + entry.getValue());
        }

        System.out.println("分析2，出现对子12359，就买68 10 :");
        for(Map.Entry<Integer,Integer> entry : two.entrySet()){
            System.out.println(entry.getKey() + "期购买中奖次数：" + entry.getValue());
        }

        System.out.println("分析3，出现对子46780，就买135 :");
        for(Map.Entry<Integer,Integer> entry : three.entrySet()){
            System.out.println(entry.getKey() + "期购买中奖次数：" + entry.getValue());
        }


        //分析结束

        System.out.println("---------------"+DateUtils.dateToString(yestoday)+" 数据分析结束！");
        System.out.println("*");

    }



    //分析1，出现对子，就买13568 10
    public static Map<Integer,Integer> analyseOne(List<JSSC10> datas){
        Map<Integer,Integer> qishuProbabilityMap = Maps.newHashMap();

        boolean findFlag = false;
        int cishu = 0;
        for(int i=0; i<datas.size()-2; i++){
            for (int j=0; j<10; j++){
                if(findFlag){
                    cishu ++;
                    if(datas.get(i).getBallNames().get(j).equals(1) ||
                            datas.get(i).getBallNames().get(j).equals(3) ||
                            datas.get(i).getBallNames().get(j).equals(5) ||
                            datas.get(i).getBallNames().get(j).equals(6) ||
                            datas.get(i).getBallNames().get(j).equals(8) ||
                            datas.get(i).getBallNames().get(j).equals(10) ){
                        if(qishuProbabilityMap.containsKey(cishu)){
                            qishuProbabilityMap.put(cishu,
                                    qishuProbabilityMap.get(cishu) + 1);
                        }else {
                            qishuProbabilityMap.put(cishu, 1);
                        }
                        findFlag = false;
                        cishu = 0;
                    }
                    continue;
                }
                if(datas.get(i).getBallNames().get(j).equals(
                        datas.get(i+1).getBallNames().get(j))){
                    findFlag = true;
                    i++;
                }
            }

        }

        return qishuProbabilityMap;
    }



    //分析2，出现对子12359，就买68 10
    public static Map<Integer,Integer> analyseTwo(List<JSSC10> datas){
        Map<Integer,Integer> qishuProbabilityMap = Maps.newHashMap();

        boolean findFlag = false;
        int cishu = 0;
        for(int i=0; i<datas.size()-2; i++){
            for (int j=0; j<10; j++){
                if(findFlag){
                    cishu ++;
                    if(datas.get(i).getBallNames().get(j).equals(6) ||
                            datas.get(i).getBallNames().get(j).equals(8) ||
                            datas.get(i).getBallNames().get(j).equals(10)){
                        if(qishuProbabilityMap.containsKey(cishu)){
                            qishuProbabilityMap.put(cishu,
                                    qishuProbabilityMap.get(cishu) + 1);
                        }else {
                            qishuProbabilityMap.put(cishu, 1);
                        }
                        findFlag = false;
                        cishu = 0;
                    }
                    continue;
                }
                //出现对子12359
                if(datas.get(i).getBallNames().get(j).equals(1) ||
                        datas.get(i).getBallNames().get(j).equals(2) ||
                        datas.get(i).getBallNames().get(j).equals(3) ||
                        datas.get(i).getBallNames().get(j).equals(5) ||
                        datas.get(i).getBallNames().get(j).equals(9)){
                    if(datas.get(i).getBallNames().get(j).equals(
                            datas.get(i+1).getBallNames().get(j))){
                        findFlag = true;
                        i++;
                    }
                }

            }

        }

        return qishuProbabilityMap;
    }




    //分析3，出现对子46780，就买135
    public static Map<Integer,Integer> analyseThree(List<JSSC10> datas){
        Map<Integer,Integer> qishuProbabilityMap = Maps.newHashMap();

        boolean findFlag = false;
        int cishu = 0;
        for(int i=0; i<datas.size()-3; i++){
            for (int j=0; j<10; j++){
                if(findFlag){
                    cishu ++;
                    if(datas.get(i).getBallNames().get(j).equals(1) ||
                            datas.get(i).getBallNames().get(j).equals(3) ||
                            datas.get(i).getBallNames().get(j).equals(5)){
                        if(qishuProbabilityMap.containsKey(cishu)){
                            qishuProbabilityMap.put(cishu,
                                    qishuProbabilityMap.get(cishu) + 1);
                        }else {
                            qishuProbabilityMap.put(cishu, 1);
                        }
                        findFlag = false;
                        cishu = 0;
                    }
                    continue;
                }
                //出现对子46780
                if(datas.get(i).getBallNames().get(j).equals(4) ||
                        datas.get(i).getBallNames().get(j).equals(6) ||
                        datas.get(i).getBallNames().get(j).equals(7) ||
                        datas.get(i).getBallNames().get(j).equals(8) ||
                        datas.get(i).getBallNames().get(j).equals(0)){
                    if(datas.get(i).getBallNames().get(j).equals(
                            datas.get(i+1).getBallNames().get(j))){
                        findFlag = true;
                        i++;
                    }
                }

            }

        }

        return qishuProbabilityMap;
    }



}
