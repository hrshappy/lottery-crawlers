/**
 * 
 */
package com.wsm.lottery.dao;


import com.wsm.lottery.base.BaseDAO;

import java.util.List;
import java.util.Map;

/**
 * 访问接口
 * @author		siming.wang
 * @create		2018-09-15 21:34:49
 */
public interface LotteryJsscDAO extends BaseDAO<LotteryJsscDO, Long> {
    List<LotteryJsscDO> selectListByMap(Map param);
}
