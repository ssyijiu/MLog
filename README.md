#MLog
一个简洁的Log工具。
##项目特色
1. Tag自动产生，格式：TAG:[className.methodName(fileName:lineNumber)]
2. 支持修改TAG来自定义Tag，默认""
3. 打印任意Object类，null打印字符串"null"，否则打印toString，toString返回null打印字符串"null"
4. 可以通过设置Log级别来控制是否打印Log
5. 只有一个Java类，简单小巧

##使用方法
- 直接复制 MLog/library/src/main/java\com/ssyijiu/library/MLog.java 到项目中。
- Gradle

   root gradle

   ```
   allprojects {
      repositories {
         jcenter()
         maven { url "https://jitpack.io" }  // 新增这一行
      }
   }
   ```
   app gradle
   ```
   compile 'com.github.ssyijiu:MLog:1.0.1'
   ```
```java
MLog.setLogLev(MLog.LogLev.D);        // 设置Log级别为D，只打印 DEBUG、INFO、WARN、ERROR级别的Log
MLog.setLogLev(MLog.LogLev.NO_LOG);   // 关闭Log打印
MLog.TAG = "ssyijiu";                 // 设置全局TAG
MLog.v("ssyijiu");  
MLog.e("E","ssyijiu");                // 设置本次打印的TAG
```

## 联系作者
- Github: [ssyijiu](https://github.com/ssyijiu)
- E-mail: lxmyijiu@163.com
- WeChat: ssyijiu11

##License

```
Copyright 2016 ssyijiu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
