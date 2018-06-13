package com.zfg.test.binder;

import com.zfg.test.binder.Book;

interface IBookManager{
List<Book>  getBookList();
void addBook(in Book book);
}