package com.wsm.lottery.dao;

import com.wsm.lottery.base.BaseObject;

import java.util.Date;

/**
 * 实体对象
 * @author		siming.wang
 * @create		2018-09-15 21:42:18
 */
public abstract class BaseLotteryJsscDO extends BaseObject implements java.io.Serializable {
	/**
	 * 
	 */
	protected Long sysNo;

	/**
	 * 
	 */
	protected String period;

	/**
	 * 
	 */
	protected Date drawTime;

	/**
	 * 
	 */
	protected Integer ballOne;

	/**
	 * 
	 */
	protected Integer ballTwo;

	/**
	 * 
	 */
	protected Integer ballThree;

	/**
	 * 
	 */
	protected Integer ballFour;

	/**
	 * 
	 */
	protected Integer ballFive;

	/**
	 * 
	 */
	protected Integer ballSix;

	/**
	 * 
	 */
	protected Integer ballSeven;

	/**
	 * 
	 */
	protected Integer ballEight;

	/**
	 * 
	 */
	protected Integer ballNine;

	/**
	 * 
	 */
	protected Integer ballTen;

	/**
	 * 
	 */
	protected Date createTime;

	/**
	 * 
	 */
	protected String createPin;

	/**
	 * 
	 */
	protected String yn;

	/**
	 * 取得 
	 */
	public Long getSysNo() {
		return sysNo;
	}

	/**
	 * 设置 
	 */
	public void setSysNo(Long sysNo) {
		this.sysNo = sysNo;
	}

	/**
	 * 取得 
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * 设置 
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * 取得 
	 */
	public Date getDrawTime() {
		return drawTime;
	}

	/**
	 * 设置 
	 */
	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}

	/**
	 * 取得 
	 */
	public Integer getBallOne() {
		return ballOne;
	}

	/**
	 * 设置 
	 */
	public void setBallOne(Integer ballOne) {
		this.ballOne = ballOne;
	}

	/**
	 * 取得 
	 */
	public Integer getBallTwo() {
		return ballTwo;
	}

	/**
	 * 设置 
	 */
	public void setBallTwo(Integer ballTwo) {
		this.ballTwo = ballTwo;
	}

	/**
	 * 取得 
	 */
	public Integer getBallThree() {
		return ballThree;
	}

	/**
	 * 设置 
	 */
	public void setBallThree(Integer ballThree) {
		this.ballThree = ballThree;
	}

	/**
	 * 取得 
	 */
	public Integer getBallFour() {
		return ballFour;
	}

	/**
	 * 设置 
	 */
	public void setBallFour(Integer ballFour) {
		this.ballFour = ballFour;
	}

	/**
	 * 取得 
	 */
	public Integer getBallFive() {
		return ballFive;
	}

	/**
	 * 设置 
	 */
	public void setBallFive(Integer ballFive) {
		this.ballFive = ballFive;
	}

	/**
	 * 取得 
	 */
	public Integer getBallSix() {
		return ballSix;
	}

	/**
	 * 设置 
	 */
	public void setBallSix(Integer ballSix) {
		this.ballSix = ballSix;
	}

	/**
	 * 取得 
	 */
	public Integer getBallSeven() {
		return ballSeven;
	}

	/**
	 * 设置 
	 */
	public void setBallSeven(Integer ballSeven) {
		this.ballSeven = ballSeven;
	}

	/**
	 * 取得 
	 */
	public Integer getBallEight() {
		return ballEight;
	}

	/**
	 * 设置 
	 */
	public void setBallEight(Integer ballEight) {
		this.ballEight = ballEight;
	}

	/**
	 * 取得 
	 */
	public Integer getBallNine() {
		return ballNine;
	}

	/**
	 * 设置 
	 */
	public void setBallNine(Integer ballNine) {
		this.ballNine = ballNine;
	}

	/**
	 * 取得 
	 */
	public Integer getBallTen() {
		return ballTen;
	}

	/**
	 * 设置 
	 */
	public void setBallTen(Integer ballTen) {
		this.ballTen = ballTen;
	}

	/**
	 * 取得 
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 取得 
	 */
	public String getCreatePin() {
		return createPin;
	}

	/**
	 * 设置 
	 */
	public void setCreatePin(String createPin) {
		this.createPin = createPin;
	}

	/**
	 * 取得 
	 */
	public String getYn() {
		return yn;
	}

	/**
	 * 设置 
	 */
	public void setYn(String yn) {
		this.yn = yn;
	}

}