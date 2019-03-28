package com.zfg.test.binder;

import com.zfg.test.binder.Book;
//作用是定义方法接口
interface BookManager{
//所有返回值之前都不需要加任何东西，不管是什么数据类型
List<Book>  getBookList();
//传参时除了java基本类型以及String CharSequence之外的类型
//都需要在前面加上定向TAG  具体加什么
void addBook(in Book book);
}