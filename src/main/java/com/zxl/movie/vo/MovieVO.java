package com.zxl.movie.vo;

import com.zxl.movie.domain.Movie;

public class MovieVO extends Movie{
	private String timeStart;//上映开始时间
	private String timeEnd;
	private String durationStart;//电影时间长
	private String durationEnd;
	private String priceStart;//最低价格
	private String priceEnd;
	private String orderByColumn; //排序字段
	private String orderByMethod;//排序方法 asc desc
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getDurationStart() {
		return durationStart;
	}
	public void setDurationStart(String durationStart) {
		this.durationStart = durationStart;
	}
	public String getDurationEnd() {
		return durationEnd;
	}
	public void setDurationEnd(String durationEnd) {
		this.durationEnd = durationEnd;
	}
	public String getPriceStart() {
		return priceStart;
	}
	public void setPriceStart(String priceStart) {
		this.priceStart = priceStart;
	}
	public String getPriceEnd() {
		return priceEnd;
	}
	public void setPriceEnd(String priceEnd) {
		this.priceEnd = priceEnd;
	}
	public String getOrderByColumn() {
		return orderByColumn;
	}
	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}
	public String getOrderByMethod() {
		return orderByMethod;
	}
	public void setOrderByMethod(String orderByMethod) {
		this.orderByMethod = orderByMethod;
	}
	
}
