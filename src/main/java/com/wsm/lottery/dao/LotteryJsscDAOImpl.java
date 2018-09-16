/**
 * 
 */
package com.wsm.lottery.dao;

import com.wsm.lottery.config.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访问接口默认实现
 * @author		siming.wang 
 * @create		2018-09-15 21:34:49
 */
public class LotteryJsscDAOImpl extends BaseLotteryJsscDAOImpl {

    private static final String namespace = "com.wsm.lottery.dao.LotteryJsscDAO.";
    private static SqlSession session = MyBatisUtil.getSession();

    @Override
    public Long insert(LotteryJsscDO lotteryJsscDO) {
        int sysoNo = session.insert(namespace+"insert", lotteryJsscDO);
        session.commit();
        return Long.valueOf(sysoNo);
    }

    @Override
    public void batchInsert(List<LotteryJsscDO> lotteryJsscDOS, boolean generateKey) {

    }

    @Override
    public LotteryJsscDO select(Long id) {
        return null;
    }

    @Override
    public LotteryJsscDO selectAndLock(Long id) {
        return null;
    }

    @Override
    public LotteryJsscDO selectByEO(LotteryJsscDO lotteryJsscDO) {
        return null;
    }

    @Override
    public List<LotteryJsscDO> selectListByEO(LotteryJsscDO lotteryJsscDO) {
        List<LotteryJsscDO> lotteryJsscDOS = null;
        lotteryJsscDO.setCreateTime(null);
        Map param = new HashMap();
        param.put("period", lotteryJsscDO.getPeriod());
        try {
            lotteryJsscDOS = session.selectList(namespace + "selectEOByEO", param);
            //注意：此处有陷阱，如果做了更新、插入或删除操作，必须使用：
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
        return lotteryJsscDOS;
    }

    @Override
    public List<LotteryJsscDO> selectListByIdList(List<Long> ids, boolean isLock) {
        return null;
    }

    @Override
    public List<LotteryJsscDO> selectListByEO(LotteryJsscDO lotteryJsscDO, int pageNO, int pageSize) {
        return null;
    }

    @Override
    public int countByEO(LotteryJsscDO lotteryJsscDO) {
        return 0;
    }

    @Override
    public int update(LotteryJsscDO lotteryJsscDO) {
        return 0;
    }

    @Override
    public void batchUpdate(List<LotteryJsscDO> lotteryJsscDOS) {

    }

    @Override
    public int updateByField(LotteryJsscDO oldObj, LotteryJsscDO newObj) {
        return 0;
    }

    @Override
    public int delete(LotteryJsscDO lotteryJsscDO) {
        return 0;
    }
}
