package com.wsm.lottery.JSSC10;

import com.alibaba.fastjson.JSON;
import com.wsm.lottery.base.BaseDAO;
import com.wsm.lottery.dao.LotteryJsscDAOImpl;
import com.wsm.lottery.dao.LotteryJsscDO;
import main.java.com.wsm.lottery.model.JSSC10;
import main.java.com.wsm.lottery.utils.DateUtils;
import main.java.com.wsm.lottery.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;

public class JSSC10Crawler {

    private static final String JSSC10Url = "http://666662cp.com/";

    private static final BaseDAO lotteryDao = new LotteryJsscDAOImpl();

    public static void main(String[] args) throws Exception{

        String today = DateUtils.getCurrentDate();

        System.out.println(today);

        Date date = new Date();
        int i=1;
        while(i<=2){
            Date newDate = DateUtils.addDay(date,-i);
            i++;
            String todayNew = DateUtils.dateToString(newDate);
            spiderDataIntoDB(todayNew);
        }





    }


    public static void spiderDataIntoDB(String today) throws Exception{
        //1、获取sessionID
        String cashUrl = JSSC10Url + "/cashlogin";
        Map param = new HashMap();

        param.put("account","!guest!");
        param.put("password","!guest!");

        String sessionId = JSON.parseObject(HttpUtils.postForm(cashUrl,param)).getString("message");

        //2、获取游客权限--将session注入  测试无需。
        //GET member/agreement?_OLID_=2ba5aebd150775549fa83a5cfba750297d887bd1 HTTP/1.1
        System.out.println(sessionId);
//        HttpUtils.getSessionId(JSSC10Crawler+"member/agreement?"+sessionId);


        //3、请求历史记录
        //87c1bf6e271f = sessionId
        Map headMap = new HashMap();
        headMap.put("Cookie","87c1bf6e271f"+sessionId.substring(sessionId.indexOf("=")));
        String jsUrl = JSSC10Url + "member/dresult?lottery=PK10JSC&date=";

        String resHtml = HttpUtils.get(jsUrl+today,headMap);

        Document resultDocument = Jsoup.parse(resHtml);



        //#drawTable > table > tbody > tr:nth-child(1) > td.period
        //#drawTable > table > tbody > tr:nth-child(1) > td.drawTime
        //#drawTable > table > tbody > tr:nth-child(1) > td:nth-child(3) > span
        //#drawTable > table > tbody > tr:nth-child(1104) > td:nth-child(3) > span



        //4、解析html
        List<JSSC10> jssc10List = new ArrayList<>();
        int i = 1;
        while (true){

            String trChild = "tr:nth-child("+i+")";
            Elements period = resultDocument.select("#drawTable")
                    .select("table").select("tbody").select(trChild).select("td.period");
            Elements drawTime = resultDocument.select("#drawTable")
                    .select("table").select("tbody").select(trChild).select("td.drawTime");

            if (period.isEmpty()){
                break;
            }
            JSSC10 jssc10 = new JSSC10();
            jssc10.setPeriod(period.text());

            String time = drawTime.text();
            time = "2018-" + time.substring(0,5) + time.substring(7);

            jssc10.setDrawTime(DateUtils.stringToDate(time,DateUtils.DATE_TIME_FORMAT));
            List<Integer> ballNames = new ArrayList<>();

            for (int j=3; j<=12; j++){

                String tdChild = "td:nth-child("+j+")";
                Elements ballName = resultDocument.select("#drawTable")
                        .select("table").select("tbody").select(trChild).select(tdChild).select("span");

                ballNames.add(Integer.valueOf(ballName.text()));
            }

            jssc10.setBallNames(ballNames);
            System.out.println(jssc10);
            jssc10List.add(jssc10);
            i ++;

        }


        //分析数据
        System.out.println(jssc10List);


        //插入DB

        for(JSSC10 jssc10 : jssc10List){
            LotteryJsscDO lotteryJsscDO = new LotteryJsscDO();

            lotteryJsscDO.setCreatePin("siming.wang");
            lotteryJsscDO.setCreateTime(new Date());
            lotteryJsscDO.setPeriod(jssc10.getPeriod());
            lotteryJsscDO.setDrawTime(jssc10.getDrawTime());

            List<Integer> ballNames = jssc10.getBallNames();
            lotteryJsscDO.setBallOne(ballNames.get(0));
            lotteryJsscDO.setBallTwo(ballNames.get(1));
            lotteryJsscDO.setBallThree(ballNames.get(2));
            lotteryJsscDO.setBallFour(ballNames.get(3));
            lotteryJsscDO.setBallFive(ballNames.get(4));
            lotteryJsscDO.setBallSix(ballNames.get(5));
            lotteryJsscDO.setBallSeven(ballNames.get(6));
            lotteryJsscDO.setBallEight(ballNames.get(7));
            lotteryJsscDO.setBallNine(ballNames.get(8));
            lotteryJsscDO.setBallTen(ballNames.get(9));
            lotteryJsscDO.setYn("Y");

            List<LotteryJsscDO> lotteryJsscDOS = lotteryDao.selectListByEO(lotteryJsscDO);

            if(lotteryDao.selectListByEO(lotteryJsscDO).isEmpty()){
                lotteryDao.insert(lotteryJsscDO);
            }


        }
    }




}
