####MLog工具简介

1. 本工具基于xUtils中的LogUtils实现，整合了KLog中将JOSN数据格式化打印的功能
2. 只有一个Java类，简单小巧，功能强大
3. Tag自动产生(customTagPrefix:className.methodName(L:lineNumber))，打印方便
4. 支持修改customTagPrefix来自定义Tag，默认""
5. 支持打印任意Object类，null打印字符串"null"，否则打印toString，toString返回null打印字符串"null"



####使用方法
1. 将MLog.java拷贝到自己的项目中
2. 修改package com.ssyijiu.mlog为自己的包名
3. 修改customTagPrefix变量为自己打印Log的Tag，默认""

			
		MLog.v("ssyijiu");
		MLog.d("ssyijiu");
		MLog.i("ssyijiu");
		MLog.w("ssyijiu");
		MLog.e("ssyijiu");
		MLog.json(json字符串);


####联系作者
* Email: lxmyijiu@163.com
* V: ssyijiu11


