package com.storm.kafka;

import java.time.LocalDateTime;

/**
 * @author 李斯
 * @date 2018年8月11日 上午10:20:45 
 * @version V1.0
 */
public class Message {
    private Long id;
    private String msg;
    private LocalDateTime sendTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getSendTime() {
		return sendTime;
	}
	public void setSendTime(LocalDateTime sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", msg=" + msg + ", sendTime=" + sendTime + "]";
	}
    
}