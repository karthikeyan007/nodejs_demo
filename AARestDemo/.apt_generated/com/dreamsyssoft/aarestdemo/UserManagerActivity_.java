//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.dreamsyssoft.aarestdemo;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.dreamsyssoft.aarestdemo.R.layout;
import com.dreamsyssoft.aarestdemo.model.User;
import com.dreamsyssoft.aarestdemo.rest.UserManager_;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class UserManagerActivity_
    extends UserManagerActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private Handler handler_ = new Handler();

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        userManager = new UserManager_();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.activity_user_manager);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static UserManagerActivity_.IntentBuilder_ intent(Context context) {
        return new UserManagerActivity_.IntentBuilder_(context);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        list = ((ListView) hasViews.findViewById(android.R.id.list));
        {
            AdapterView<?> view = ((AdapterView<?> ) hasViews.findViewById(android.R.id.list));
            if (view!= null) {
                view.setOnItemClickListener(new OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        listItemClicked(((User) parent.getAdapter().getItem(position)));
                    }

                }
                );
            }
        }
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(com.dreamsyssoft.aarestdemo.R.menu.activity_user_manager, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = super.onOptionsItemSelected(item);
        if (handled) {
            return true;
        }
        int itemId_ = item.getItemId();
        if (itemId_ == com.dreamsyssoft.aarestdemo.R.id.menu_user_del) {
            onDeleteUser();
            return true;
        }
        if (itemId_ == com.dreamsyssoft.aarestdemo.R.id.menu_user_add) {
            onAddUser();
            return true;
        }
        if (itemId_ == com.dreamsyssoft.aarestdemo.R.id.menu_user_refresh) {
            refreshUsers();
            return true;
        }
        return false;
    }

    @Override
    public void updateAdapter(final List<User> users) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            UserManagerActivity_.super.updateAdapter(users);
            return ;
        }
        handler_.post(new Runnable() {


            @Override
            public void run() {
                UserManagerActivity_.super.updateAdapter(users);
            }

        }
        );
    }

    @Override
    public void refreshUsers() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                UserManagerActivity_.super.refreshUsers();
            }

        }
        );
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, UserManagerActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public UserManagerActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (context_ instanceof Activity) {
                ((Activity) context_).startActivityForResult(intent_, requestCode);
            } else {
                context_.startActivity(intent_);
            }
        }

    }

}
