package com.ssyijiu.library;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by ssyijiu on 2016/8/16.
 * Github: ssyijiu
 * E-mail: lxmyijiu@163.com
 */
public class MLog {

	/** 日志的TAG */
	public static String TAG = "";

	/** 临时TAG */
	public static String tmpTAG = "";

	/** 日志级别，默认为 V */
	private static LogLev MLev;

	private MLog(){
		/* cannot be instantiated */
		throw new UnsupportedOperationException("MLog cannot be instantiated !");
	}


	/**
	 * 设置日志级别，只有高于设置级别的日志才打印。
	 * @param lev
     */
	public static void setLogLev(LogLev lev) {
		MLev = lev;
	}


	public static void v(Object obj) {
		if(MLev.lev <= MLog.LogLev.V.lev) {
			printLog(MLog.LogLev.V, getMsg(obj));
		}
	}

	public static void v(String tag, Object obj) {

		if(MLev.lev <= MLog.LogLev.V.lev) {
			tmpTAG = TAG;
			TAG = tag;
			printLog(MLog.LogLev.V, getMsg(obj));
			TAG = tmpTAG;
		}
	}

	public static void d(Object obj) {
		if(MLev.lev <= MLog.LogLev.D.lev) {
			printLog(MLog.LogLev.D, getMsg(obj));
		}
	}

	public static void d(String tag, Object obj) {

		if(MLev.lev <= MLog.LogLev.D.lev) {
			tmpTAG = TAG;
			TAG = tag;
			printLog(MLog.LogLev.D, getMsg(obj));
			TAG = tmpTAG;
		}
	}

	public static void i(Object obj) {
		if(MLev.lev <= MLog.LogLev.I.lev) {
			printLog(MLog.LogLev.I, getMsg(obj));
		}
	}

	public static void i(String tag, Object obj) {

		if(MLev.lev <= MLog.LogLev.I.lev) {
			tmpTAG = TAG;
			TAG = tag;
			printLog(MLog.LogLev.I, getMsg(obj));
			TAG = tmpTAG;
		}
	}

	public static void w(Object obj) {
		if(MLev.lev <= MLog.LogLev.W.lev) {
			printLog(MLog.LogLev.W, getMsg(obj));
		}
	}

	public static void w(String tag, Object obj) {

		if(MLev.lev <= MLog.LogLev.W.lev) {
			tmpTAG = TAG;
			TAG = tag;
			printLog(MLog.LogLev.W, getMsg(obj));
			TAG = tmpTAG;
		}
	}

	public static void e(Object obj) {
		if(MLev.lev <= MLog.LogLev.E.lev) {
			printLog(MLog.LogLev.E, getMsg(obj));
		}
	}

	public static void e(String tag, Object obj) {

		if(MLev.lev <= MLog.LogLev.E.lev) {
			tmpTAG = TAG;
			TAG = tag;
			printLog(MLog.LogLev.E, getMsg(obj));
			TAG = tmpTAG;
		}
	}


	/**
	 * 日志打印
	 * @param lev 级别
	 * @param msg Message
     */
	private static void printLog(LogLev lev, String msg) {

		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		byte index = 4;
		String fileName = stackTrace[index].getFileName();
		String className = stackTrace[index].getClassName();
		className = className.substring(className.lastIndexOf(".") + 1);
		String methodName = stackTrace[index].getMethodName();
		int lineNumber = stackTrace[index].getLineNumber();
		String tag = "[%s.%s(%s:%d)]";
		tag = String.format(tag, new Object[]{className, methodName, fileName, Integer.valueOf(lineNumber)});
		tag = TextUtils.isEmpty(TAG) ? tag : TAG + ":" + tag;

		switch (lev) {
			case V:
				Log.v(tag, msg);
				break;
			case D:
				Log.d(tag, msg);
				break;
			case I:
				Log.i(tag, msg);
				break;
			case W:
				Log.w(tag, msg);
				break;
			case E:
				Log.e(tag, msg);
				break;
			case NO_LOG:
				break;

		}
	}

	public static String getMsg(Object obj) {
		return obj != null && obj.toString() != null ? obj.toString() : "null";
	}

	static {
		MLev = MLog.LogLev.V;
	}

	public static enum LogLev {
		V(1),
		D(2),
		I(3),
		W(4),
		E(5),
		NO_LOG(6);

		int lev = 1;

		private LogLev(int i) {
			this.lev = i;
		}
	}
}

