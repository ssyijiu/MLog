package com.ssyijiu.mlog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

/**
 * Log工具，将xUtils中LogUtils提取成一个java类，整合了KLog中打印josn数据功能
 * <br>tag自动产生，格式: customTagPrefix:className.methodName(L:lineNumber),
 * <br>customTagPrefix 为空时只输出：className.methodName(L:lineNumber)
 * <p>
 * Author: ssyijiu 
 * Date: 16-3-27 
 * Time: 上午9:05
 */
public class MLog {

	public static String customTagPrefix = "";

	private MLog() {
	}

	public static boolean allowE = true;
	public static boolean allowW = true;
	public static boolean allowI = true;
	public static boolean allowD = true;
	public static boolean allowV = true;
	public static boolean allowWtf = true;
	public static boolean allowJson = true;
	
	public static void closeLog() {
		allowE = false;
		allowW = false;
		allowI = false;
		allowD = false;
		allowV = false;
		allowWtf = false;
		allowJson = false;
	}
	
	private static String generateTag(StackTraceElement caller) {
		String tag = "%s.%s(L:%d)";
		String callerClazzName = caller.getClassName();
		callerClazzName = callerClazzName.substring(callerClazzName
				.lastIndexOf(".") + 1);
		tag = String.format(tag, callerClazzName, caller.getMethodName(),
				caller.getLineNumber());
		tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":"
				+ tag;
		return tag;
	}

	public static StackTraceElement getCallerStackTraceElement() {
		return Thread.currentThread().getStackTrace()[4];
	}

	public static void d(Object content) {
		if (!allowD)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		
		Log.d(tag, (content==null || content.toString()==null) ? "null" : content.toString());
	}

	public static void d(Object content, Throwable tr) {
		if (!allowD)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.d(tag, (content==null || content.toString()==null) ? "null" : content.toString(),tr);
	}

	public static void e(Object content) {
		if (!allowE)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.e(tag, (content==null || content.toString()==null) ? "null" : content.toString());
	}

	public static void e(Object content, Throwable tr) {
		if (!allowE)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.e(tag, (content==null || content.toString()==null) ? "null" : content.toString(),tr);
	}

	public static void i(Object content) {
		if (!allowI)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		
		Log.i(tag, (content==null || content.toString()==null) ? "null" : content.toString());
	}

	public static void i(Object content, Throwable tr) {
		if (!allowI)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.i(tag, (content==null || content.toString()==null) ? "null" : content.toString(),tr);
	}

	public static void v(Object content) {
		if (!allowV)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.v(tag, (content==null || content.toString()==null) ? "null" : content.toString());
	}

	public static void v(Object content, Throwable tr) {
		if (!allowV)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.v(tag, (content==null || content.toString()==null) ? "null" : content.toString(),tr);
	}

	public static void w(Object content) {
		if (!allowW)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.w(tag, (content==null || content.toString()==null) ? "null" : content.toString());
	}

	public static void w(Object content, Throwable tr) {
		if (!allowW)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.w(tag, (content==null || content.toString()==null) ? "null" : content.toString(),tr);
	}

	public static void w(Throwable tr) {
		if (!allowW)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.w(tag, tr);
	}

	// What a Terrible Failure
	public static void wtf(Object content) {
		if (!allowWtf)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.wtf(tag, (content==null || content.toString()==null) ? "null" : content.toString());
	}

	public static void wtf(Object content, Throwable tr) {
		if (!allowWtf)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.wtf(tag, (content==null || content.toString()==null) ? "null" : content.toString(),tr);
	}

	public static void wtf(Throwable tr) {
		if (!allowWtf)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		Log.wtf(tag, tr);
	}

	public static void json(String content) {
		if (!allowJson)
			return;
		StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String tag = generateTag(caller);
		JsonLog.printJson(tag, content);
	}
}

class JsonLog {

	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	public static final int JSON_INDENT = 4;

	public static void printJson(String tag, String msg) {

		if (isEmpty(msg)) {
			MLog.e("the json is empty");
			return;
		}

		String message = "";

		try {
			if (msg.startsWith("{")) {
				JSONObject jsonObject = new JSONObject(msg);
				message = jsonObject.toString(JSON_INDENT);
			} else if (msg.startsWith("[")) {
				JSONArray jsonArray = new JSONArray(msg);
				message = jsonArray.toString(JSON_INDENT);
			} else {
				message = msg;
			}
		} catch (JSONException e) {
			message = msg;
		}

		printLine(tag, true);
		String[] lines = message.split(LINE_SEPARATOR);
		for (String line : lines) {
			Log.i(tag, "│ " + line);
		}
		printLine(tag, false);
	}

	public static boolean isEmpty(String line) {
		return TextUtils.isEmpty(line) || line.equals("\n")
				|| line.equals("\t") || TextUtils.isEmpty(line.trim());
	}

	public static void printLine(String tag, boolean isTop) {
		if (isTop) {
			Log.i(tag,"┌──────────────────────────────────JSON──────────────────────────────────────");
		} else {
			Log.i(tag,"└──────────────────────────────────JSON──────────────────────────────────────");
		}
	}
}
