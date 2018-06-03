package com.zbms.carinfomanage.vo;

import com.zbms.all.domain.carInfo;

public class carInfoAndOtherInfo {
	private Object object;
	private carInfo carInfo;

	public carInfoAndOtherInfo() {
	}

	public carInfoAndOtherInfo(Object object, carInfo carInfo) {
		this.object = object;
		this.carInfo = carInfo;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public carInfo getcarInfo() {
		return carInfo;
	}

	public void setcarInfo(carInfo carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public String toString() {
		return "carInfoAndOtherInfo [object=" + object + ", carInfo=" + carInfo + "]";
	}

}
