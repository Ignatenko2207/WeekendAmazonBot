package org.itstep.service;

public class Timer {

	public static void waitSec(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
