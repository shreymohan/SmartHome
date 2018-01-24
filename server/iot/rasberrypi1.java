package iot;

public class rasberrypi1 {
	static String secSystem="disarmed";
	static String garageDoor1="closed";
	static String mode="heat";
    static String garageDoor2="closed";
	static String fan="off";
	static String curTemp="85";
	double conTemp;
	static String light="Off";
	String lightLoc2;
	String lightLoc3;
	String lightLoc4;
	int dimVal1;
	int dimVal2;
	int dimVal3;
	int dimVal4;
	static String frontdoor="Locked";
	static String backdoor="Locked";
	String garageLock;
	static String windowSense="off";
	String doorSense2;
	String doorSense3;
	static String motionDetect="off";
	String door2;
	String door3;
	public static String getSecSystem() {
		return secSystem;
	}
	public static void setSecSystem(String secSystem) {
		rasberrypi1.secSystem = secSystem;
	}
	public static String getGarageDoor1() {
		return garageDoor1;
	}
	public static void setGarageDoor1(String garageDoor1) {
		rasberrypi1.garageDoor1 = garageDoor1;
	}
	public static String getMode() {
		return mode;
	}
	public static void setMode(String mode) {
		rasberrypi1.mode = mode;
	}
	public static String getGarageDoor2() {
		return garageDoor2;
	}
	public static void setGarageDoor2(String garageDoor2) {
		rasberrypi1.garageDoor2 = garageDoor2;
	}
	public static String getFan() {
		return fan;
	}
	public static void setFan(String fan) {
		rasberrypi1.fan = fan;
	}
	public static String getCurTemp() {
		return curTemp;
	}
	public static void setCurTemp(String curTemp) {
		rasberrypi1.curTemp = curTemp;
	}
	public double getConTemp() {
		return conTemp;
	}
	public void setConTemp(double conTemp) {
		this.conTemp = conTemp;
	}
	public static String getLight() {
		return light;
	}
	public static void setLight(String light) {
		rasberrypi1.light = light;
	}
	public String getLightLoc2() {
		return lightLoc2;
	}
	public void setLightLoc2(String lightLoc2) {
		this.lightLoc2 = lightLoc2;
	}
	public String getLightLoc3() {
		return lightLoc3;
	}
	public void setLightLoc3(String lightLoc3) {
		this.lightLoc3 = lightLoc3;
	}
	public String getLightLoc4() {
		return lightLoc4;
	}
	public void setLightLoc4(String lightLoc4) {
		this.lightLoc4 = lightLoc4;
	}
	public int getDimVal1() {
		return dimVal1;
	}
	public void setDimVal1(int dimVal1) {
		this.dimVal1 = dimVal1;
	}
	public int getDimVal2() {
		return dimVal2;
	}
	public void setDimVal2(int dimVal2) {
		this.dimVal2 = dimVal2;
	}
	public int getDimVal3() {
		return dimVal3;
	}
	public void setDimVal3(int dimVal3) {
		this.dimVal3 = dimVal3;
	}
	public int getDimVal4() {
		return dimVal4;
	}
	public void setDimVal4(int dimVal4) {
		this.dimVal4 = dimVal4;
	}
	public static String getFrontdoor() {
		return frontdoor;
	}
	public static void setFrontdoor(String frontdoor) {
		rasberrypi1.frontdoor = frontdoor;
	}
	public static String getBackdoor() {
		return backdoor;
	}
	public static void setBackdoor(String backdoor) {
		rasberrypi1.backdoor = backdoor;
	}
	public String getGarageLock() {
		return garageLock;
	}
	public void setGarageLock(String garageLock) {
		this.garageLock = garageLock;
	}
	public static String getWindowSense() {
		return windowSense;
	}
	public static void setWindowSense(String windowSense) {
		rasberrypi1.windowSense = windowSense;
	}
	public String getDoorSense2() {
		return doorSense2;
	}
	public void setDoorSense2(String doorSense2) {
		this.doorSense2 = doorSense2;
	}
	public String getDoorSense3() {
		return doorSense3;
	}
	public void setDoorSense3(String doorSense3) {
		this.doorSense3 = doorSense3;
	}
	public static String getMotionDetect() {
		return motionDetect;
	}
	public static void setMotionDetect(String motionDetect) {
		rasberrypi1.motionDetect = motionDetect;
	}
	public String getDoor2() {
		return door2;
	}
	public void setDoor2(String door2) {
		this.door2 = door2;
	}
	public String getDoor3() {
		return door3;
	}
	public void setDoor3(String door3) {
		this.door3 = door3;
	}


}



