//文件的作用就是引入一个序列化的对象  BOOK提供给其他的AIDL文件使用
//注意 Book.aidl 与Book.java的包名应该是一样的
package com.zfg.test.binder;
//注意 parcelable 是小写
parcelable Book;