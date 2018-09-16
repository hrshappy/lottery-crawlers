package com.wsm.lottery.JSSC10;

import com.wsm.lottery.dao.LotteryJsscDAO;
import com.wsm.lottery.dao.LotteryJsscDAOImpl;
import com.wsm.lottery.dao.LotteryJsscDO;
import com.wsm.lottery.utils.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSSC10Analysize {

    private static final LotteryJsscDAO lotteryDao = new LotteryJsscDAOImpl();
    private static String drawTimeFrom = " 07:00:30";
    private static String drawTimeTo = " 05:59:15";

    public static void main(String[] args){
        Map paramDb = new HashMap();

        Date today = new Date();
        Date yestoday = DateUtils.addDay(today,-1);

        drawTimeFrom = DateUtils.dateToString(yestoday) + drawTimeFrom;
        drawTimeTo = DateUtils.dateToString(today) + drawTimeTo;



        paramDb.put("drawTimeFrom", drawTimeFrom);
        paramDb.put("drawTimeTo", drawTimeTo);

        List<LotteryJsscDO> lotteryJsscDOS = lotteryDao.selectListByMap(paramDb);

        System.out.println(lotteryJsscDOS);


    }
}
