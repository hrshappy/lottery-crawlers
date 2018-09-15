/**
 * 
 */
package com.wsm.lottery.dao;

import com.wsm.lottery.config.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 访问接口默认实现
 * @author		siming.wang 
 * @create		2018-09-15 21:34:49
 */
public class LotteryJsscDAOImpl extends BaseLotteryJsscDAOImpl {

    private static final String namespace = "com.wsm.lottery.dao.LotteryJsscDAO.";

    @Override
    public Long insert(LotteryJsscDO lotteryJsscDO) {
        return null;
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
        SqlSession session = MyBatisUtil.getSession();
        try {
            lotteryJsscDOS = session.selectList(namespace + "selectEOByEO", LotteryJsscDO.class);
            //注意：此处有陷阱，如果做了更新、插入或删除操作，必须使用：
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSession(session);
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
