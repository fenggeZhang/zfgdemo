package com.zfg.test.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2019/3/27
 */
public class AIDLService extends Service {

    public final String TAG = this.getClass().getSimpleName();

    private List<Book> mBooks = new ArrayList<>();

    private final BookManager.Stub mBookManager = new BookManager.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            synchronized (this) {
                Log.e(TAG, mBooks.toString());
                if (mBooks != null) {
                    return mBooks;
                }
            }
            return new ArrayList<>();
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                if (mBooks == null) {
                    mBooks = new ArrayList<>();
                }
                if (book == null) {
                    book = new Book();
                }
//                book.setBookName("《Android开发探索》");
                if (!mBooks.contains(book)) {
                    mBooks.add(book);
                }
                //打印mBooks列表，观察客户端传过来的值
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBooks.toString());
            }
        }

    };

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setBookName("《Android高级进阶》");
        book.setBookId(1);
        mBooks.add(book);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBookManager;
    }
}
