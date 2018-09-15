package com.wsm.lottery.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 所有自定义类型的基础类
 *
 * @author  mandy.hu
 */
public class BaseObject implements Serializable {

    /**
     * 默认当前类版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 输出实例信息
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}