package com.wsm.lottery.JSSC10;

import com.wsm.lottery.base.BaseDAO;
import com.wsm.lottery.dao.LotteryJsscDAOImpl;
import com.wsm.lottery.dao.LotteryJsscDO;

import java.util.List;

public class DruidTest {

    public static void main(String[] args){
        BaseDAO lotteryDao = new LotteryJsscDAOImpl();
        LotteryJsscDO lotteryJsscDO = new LotteryJsscDO();

        List<LotteryJsscDO> lotteryJsscDOS = lotteryDao.selectListByEO(lotteryJsscDO);

        System.out.println(lotteryJsscDOS);


    }
}
