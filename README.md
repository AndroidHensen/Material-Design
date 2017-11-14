# Android基础控件——MaterialDesign所有组件前来报到，搭建5.0项目开始的第一步

## 前言

眼看Android8.0要出啦，Android5.0的知识是时候找一天的时间终结一下了，本文最低支持Android5.0的版本，老版本的适配就留给各位实现吧。这里只是带着大家入门一下主要的一些控件，只是让大家更快的入手做项目，把更多的时间花费在逻辑上

## 效果演示

在真机测试状态栏更漂亮哦

![这里写图片描述](http://img.blog.csdn.net/20171114175801299?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzAzNzk2ODk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 组件内容

* CoordinatorLayout
* DrawerLayout
* NavigationView
* AppBarLayout
* CollapsingToolbarLayout
* Toolbar
* NestedScrollView
* FloatingActionButton
* CardView

## 项目结构

项目其实很简单，只是布局的嵌套要准确就可以实现这样的效果，错一个都出不来

![这里写图片描述](http://img.blog.csdn.net/20171114180300945?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzAzNzk2ODk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 实现步骤

1、设置透明的状态栏、NoActionBar（用ToolBar替代）

```
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    <!-- Customize your theme here. -->
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
    <item name="windowActionBar">false</item>
    <item name="windowNoTitle">true</item>
    <item name="android:windowTranslucentStatus">true</item>
</style>
```

2、设置侧滑菜单的布局

DrawerLayout会包裹两层，一层是我们主界面的内容，一层是我们的侧滑菜单内容，控件的属性值也很容易理解，翻译成中文基本就明白其表示的意思，fitsSystemWindows属性设置为true可以让状态栏贴近屏幕上方，最贴近状态栏的View包括其子View都要设置相同的属性才会生效

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">

    <android.support.v4.widget.DrawerLayout
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true">

        <!--主布局-->
        <include layout="@layout/layout_content" />

        <!--菜单栏目-->
        <android.support.design.widget.NavigationView
            android:id="@+id/navigation_view"
            android:layout_width="240dp"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            app:headerLayout="@layout/menu_header"
            app:itemIconTint="@color/colorAccent"
            app:menu="@menu/menu_navigation" />
    </android.support.v4.widget.DrawerLayout>

</android.support.design.widget.CoordinatorLayout>
```

3、导航栏的头布局和菜单布局

>menu_header.xml

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="170dp"
    android:background="@drawable/bg_menu_header">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_margin="8dp"
        android:text="作者Hensen_"
        android:textColor="#FFFFFF"
        android:textSize="18dp" />
</RelativeLayout>
```

>menu_navigation.xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group
        android:id="@+id/group1"
        android:checkableBehavior="single">
        <item
            android:id="@+id/single_1"
            android:title="我的消息" />
        <item
            android:id="@+id/single_2"
            android:title="积分商城" />
        <item
            android:id="@+id/single_3"
            android:title="会员中心" />
        <item
            android:id="@+id/single_4"
            android:title="在线听歌" />
    </group>
    <item android:title="子菜单">
        <menu>
            <item
                android:id="@+id/item_1"
                android:title="听歌识曲" />
            <item
                android:id="@+id/item_2"
                android:title="主题皮肤" />
            <item
                android:id="@+id/item_3"
                android:title="夜间模式" />
            <item
                android:id="@+id/item_4"
                android:title="定时停止播放" />
            <item
                android:id="@+id/item_5"
                android:title="音乐闹钟" />
            <item
                android:id="@+id/item_6"
                android:title="我的音乐云盘" />
            <item
                android:id="@+id/item_7"
                android:title="驾驶模式" />
        </menu>
    </item>
</menu>
```

4、主布局

主布局也很简单，其实搞懂了控件的嵌套就明白是什么意思，由于我们知道主布局的HeaderView和DrawerLayout的头部都会碰到状态栏，所以都需要设置fitsSystemWindows属性

>伪代码

```
<android.support.design.widget.CoordinatorLayout >
	<!--整个HeaderView-->
    <android.support.design.widget.AppBarLayout>
	    <!--协调ToolBar和其他View-->
        <android.support.design.widget.CollapsingToolbarLayout>
            <ImageView/>
            <android.support.v7.widget.Toolbar />
        </android.support.design.widget.CollapsingToolbarLayout>
    </android.support.design.widget.AppBarLayout>
	<!--主内容-->
    <android.support.v4.widget.NestedScrollView
    </android.support.v4.widget.NestedScrollView>
	<!--悬浮按钮-->
    <android.support.design.widget.FloatingActionButton />
</android.support.design.widget.CoordinatorLayout>
```

>layout_content.xml

```
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">

    <android.support.design.widget.AppBarLayout
        android:id="@+id/appbar"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        android:fitsSystemWindows="true"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

        <android.support.design.widget.CollapsingToolbarLayout
            android:id="@+id/collapsing_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fitsSystemWindows="true"
            app:contentScrim="?attr/colorPrimary"
            app:expandedTitleMarginEnd="10dp"
            app:expandedTitleMarginStart="10dp"
            app:layout_scrollFlags="scroll|exitUntilCollapsed">

            <ImageView
                android:id="@+id/iv_content"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:contentDescription="@null"
                android:fitsSystemWindows="true"
                android:scaleType="fitXY"
                android:src="@drawable/bg_content_header"
                app:layout_collapseMode="parallax"
                app:layout_collapseParallaxMultiplier="0.8" />

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:layout_collapseMode="pin"
                app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />

        </android.support.design.widget.CollapsingToolbarLayout>
    </android.support.design.widget.AppBarLayout>

    <android.support.v4.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <include layout="@layout/item_card" />

            <include layout="@layout/item_card" />

            <include layout="@layout/item_card" />

            <include layout="@layout/item_card" />

            <include layout="@layout/item_card" />

            <include layout="@layout/item_card" />
        </LinearLayout>
    </android.support.v4.widget.NestedScrollView>

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/float_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|right"
        android:layout_margin="16dp"
        android:src="@android:drawable/ic_dialog_email"
        app:backgroundTint="@color/colorAccent"
        app:elevation="10dp"
        app:fabSize="normal"
        app:rippleColor="#ffffff" />
</android.support.design.widget.CoordinatorLayout>
```

>item_card.xml

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:layout_margin="16dp"
    android:orientation="vertical"
    app:cardElevation="10dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:text="Hello Material Design" />
</android.support.v7.widget.CardView>
```

5、代码实现

代码阅读起来也很简单，因为其命名很人性化，翻译一下就知道什么意思了
```
public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    FloatingActionButton float_button;
    CollapsingToolbarLayout collapsing_layout;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer_layout;
    NavigationView navigation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        float_button = (FloatingActionButton) findViewById(R.id.float_button);
        collapsing_layout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_layout);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置回滚时、拓展时标题的颜色
        collapsing_layout.setTitle("Material Design");
        collapsing_layout.setCollapsedTitleTextColor(Color.WHITE);
        collapsing_layout.setExpandedTitleColor(Color.WHITE);

        float_button.setOnClickListener(this);

        //增加菜单开关按钮
        toggle = new ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        //去除滚动条
        navigation_view.getChildAt(0).setVerticalScrollBarEnabled(false);
        navigation_view.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "This is Snackbar", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }
}
```

6、源码下载

[赶紧下载源码体验一下吧](https://github.com/AndroidHensen/Material-Design)