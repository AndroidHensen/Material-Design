# Android�����ؼ�����MaterialDesign�������ǰ���������5.0��Ŀ��ʼ�ĵ�һ��

## ǰ��

�ۿ�Android8.0Ҫ������Android5.0��֪ʶ��ʱ����һ���ʱ���ս�һ���ˣ��������֧��Android5.0�İ汾���ϰ汾�������������λʵ�ְɡ�����ֻ�Ǵ��Ŵ������һ����Ҫ��һЩ�ؼ���ֻ���ô�Ҹ������������Ŀ���Ѹ����ʱ�仨�����߼���

## Ч����ʾ

���������״̬����Ư��Ŷ

![����дͼƬ����](http://img.blog.csdn.net/20171114175801299?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzAzNzk2ODk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## �������

* CoordinatorLayout
* DrawerLayout
* NavigationView
* AppBarLayout
* CollapsingToolbarLayout
* Toolbar
* NestedScrollView
* FloatingActionButton
* CardView

## ��Ŀ�ṹ

��Ŀ��ʵ�ܼ򵥣�ֻ�ǲ��ֵ�Ƕ��Ҫ׼ȷ�Ϳ���ʵ��������Ч������һ����������

![����дͼƬ����](http://img.blog.csdn.net/20171114180300945?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzAzNzk2ODk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## ʵ�ֲ���

1������͸����״̬����NoActionBar����ToolBar�����

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

2�����ò໬�˵��Ĳ���

DrawerLayout��������㣬һ������������������ݣ�һ�������ǵĲ໬�˵����ݣ��ؼ�������ֵҲ��������⣬��������Ļ������������ʾ����˼��fitsSystemWindows��������Ϊtrue������״̬��������Ļ�Ϸ���������״̬����View��������View��Ҫ������ͬ�����ԲŻ���Ч

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

        <!--������-->
        <include layout="@layout/layout_content" />

        <!--�˵���Ŀ-->
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

3����������ͷ���ֺͲ˵�����

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
        android:text="����Hensen_"
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
            android:title="�ҵ���Ϣ" />
        <item
            android:id="@+id/single_2"
            android:title="�����̳�" />
        <item
            android:id="@+id/single_3"
            android:title="��Ա����" />
        <item
            android:id="@+id/single_4"
            android:title="��������" />
    </group>
    <item android:title="�Ӳ˵�">
        <menu>
            <item
                android:id="@+id/item_1"
                android:title="����ʶ��" />
            <item
                android:id="@+id/item_2"
                android:title="����Ƥ��" />
            <item
                android:id="@+id/item_3"
                android:title="ҹ��ģʽ" />
            <item
                android:id="@+id/item_4"
                android:title="��ʱֹͣ����" />
            <item
                android:id="@+id/item_5"
                android:title="��������" />
            <item
                android:id="@+id/item_6"
                android:title="�ҵ���������" />
            <item
                android:id="@+id/item_7"
                android:title="��ʻģʽ" />
        </menu>
    </item>
</menu>
```

4��������

������Ҳ�ܼ򵥣���ʵ�㶮�˿ؼ���Ƕ�׾�������ʲô��˼����������֪�������ֵ�HeaderView��DrawerLayout��ͷ����������״̬�������Զ���Ҫ����fitsSystemWindows����

>α����

```
<android.support.design.widget.CoordinatorLayout >
	<!--����HeaderView-->
    <android.support.design.widget.AppBarLayout>
	    <!--Э��ToolBar������View-->
        <android.support.design.widget.CollapsingToolbarLayout>
            <ImageView/>
            <android.support.v7.widget.Toolbar />
        </android.support.design.widget.CollapsingToolbarLayout>
    </android.support.design.widget.AppBarLayout>
	<!--������-->
    <android.support.v4.widget.NestedScrollView
    </android.support.v4.widget.NestedScrollView>
	<!--������ť-->
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

5������ʵ��

�����Ķ�����Ҳ�ܼ򵥣���Ϊ�����������Ի�������һ�¾�֪��ʲô��˼��
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

        //���ûع�ʱ����չʱ�������ɫ
        collapsing_layout.setTitle("Material Design");
        collapsing_layout.setCollapsedTitleTextColor(Color.WHITE);
        collapsing_layout.setExpandedTitleColor(Color.WHITE);

        float_button.setOnClickListener(this);

        //���Ӳ˵����ذ�ť
        toggle = new ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        //ȥ��������
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

6��Դ������

[�Ͻ�����Դ������һ�°�](https://github.com/AndroidHensen/Material-Design)