package com.yanggeapp.yangge.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.yanggeapp.yangge.Article.Article;
import com.yanggeapp.yangge.Article.ArticleAdapter;
import com.yanggeapp.yangge.BannerAdapter;
import com.yanggeapp.yangge.Me.MeActivity;
import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mEtSearch;
    private LinearLayout mLayoutDefaultText;
    private List<Article> articleList = new ArrayList<>();
    public static final int CAROUSEL_TIME = 5000;//banner 滚动间隔
    private ViewPager vpBanner;
    private ViewGroup viewGroup;//显示点点点图片，可以看到ViewPager当前选中状态
    private BannerAdapter bannerAdapter;//ViewPager适配器
    private Handler handler=new Handler();
    private int currentItem = 0;//ViewPager当前位置
    private final Runnable mTicker = new Runnable(){
        public void run() {
            long now = SystemClock.uptimeMillis();
            long next = now + (CAROUSEL_TIME - now % CAROUSEL_TIME);
            handler.postAtTime(mTicker,next);//延迟5秒再次执行runnable,就跟计时器一样效果
            currentItem++;
            vpBanner.setCurrentItem(currentItem);
        }
    };
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null){
            actionbar.hide();
        }
        //搜索框
        mEtSearch = (EditText) findViewById(R.id.search);
        mLayoutDefaultText = (LinearLayout) findViewById(R.id.layout_default);
        // editText 离开监听
        mEtSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // hasFocus 为false时表示点击了别的控件，离开当前editText控件
                if (!hasFocus){
                    if ("".equals(mEtSearch.getText().toString())) {
                        mLayoutDefaultText.setVisibility(View.VISIBLE);
                    }
                }else{
                    mLayoutDefaultText.setVisibility(View.GONE);
                }
            }
        });
        //Banner图
        vpBanner= (ViewPager) findViewById(R.id.vp_banner);
        bannerAdapter = new BannerAdapter(this);
        bannerAdapter.setOnBannerClickListener(onBannerClickListener);
        vpBanner.setOffscreenPageLimit(2);//缓存页数
        vpBanner.setAdapter(bannerAdapter);
        vpBanner.addOnPageChangeListener(onPageChangeListener);
        viewGroup = (ViewGroup) findViewById(R.id.viewGroup);//显示点点点控件
        //将点点加入到ViewGroup中
        for (int i = 0; i < bannerAdapter.getBanners().length; i++) {
            ImageView imageView = new ImageView(this);
            //设置图片宽高
            imageView.setLayoutParams(new ViewGroup.LayoutParams(10, 10));
            if (i == 0) {
                imageView.setBackgroundResource(R.mipmap.icon_page_select);
            } else {
                imageView.setBackgroundResource(R.mipmap.icon_page_normal);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 10;//左边距
            layoutParams.rightMargin = 10;//右边距
            viewGroup.addView(imageView,layoutParams);
        }
        //给ViewPager设置当前页，这样刚打开软件也能向左滑动
        currentItem = bannerAdapter.getBanners().length * 50;
        vpBanner.setCurrentItem(currentItem);
        handler.postDelayed(mTicker,CAROUSEL_TIME);//开启计时器

        //我的按钮点击事件
        ImageButton mebutton = (ImageButton) findViewById(R.id.me_button);
        mebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this,MeActivity.class);
                startActivityForResult(intent,1);
            }
        });
        //羽毛笔按钮点击事件
        ImageButton writebutton = (ImageButton) findViewById(R.id.write_button);
        writebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChooseActivity.class);
                startActivityForResult(intent,1);
            }
        });
        //载入文章
        initArticle();//初始化文章数据
        ArticleAdapter adapter = new ArticleAdapter(MainActivity.this,R.layout.article_item,articleList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article article = articleList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(String.valueOf(articleList.get(position))));
                startActivity(intent);
            }
        });
    }
    //Banner图实现
    private ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
        @Override
        public void onPageSelected(int position) {
            currentItem = position;
            //改变点点点图片的选中状态
            setImageBackground(position %= bannerAdapter.getBanners().length);
        }
        @Override
        public void onPageScrollStateChanged(int state) {}
    };
    /**
     * 改变点点点的切换效果
     * @param selectItems 当前选中位置
     */
    private void setImageBackground(int selectItems){
        for (int i = 0; i < bannerAdapter.getBanners().length; i++) {
            ImageView imageView = (ImageView) viewGroup.getChildAt(i);
            imageView.setBackgroundDrawable(null);//先把背景设置成无
            if (i == selectItems){
                imageView.setImageResource(R.mipmap.icon_page_select);
            } else {
                imageView.setImageResource(R.mipmap.icon_page_normal);
            }
        }
    }
    private View.OnClickListener onBannerClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position=(Integer) view.getTag();//从tag中取出当前点击的ImageView的位置
            //Toast.makeText(MainActivity.this,"当前点击位置:"+position,Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(mTicker);//删除计时器
    }
    //载入文章内容
    private void initArticle(){
        for (int i = 0;i < 50; i++) {
            Article article = new Article("拿木头玩具学编程，这是麻省理工设计的早教方法！","拿木头玩具学编程，这是麻省理工设计的早教方法！",R.drawable.img1);
            articleList.add(article);
            Article article1 = new Article("拿木头玩具学编程，这是麻省理工设计的早教方法！","拿木头玩具学编程，这是麻省理工设计的早教方法！",R.drawable.img2);
            articleList.add(article1);
            Article article2 = new Article("拿木头玩具学编程，这是麻省理工设计的早教方法！","拿木头玩具学编程，这是麻省理工设计的早教方法！",R.drawable.img3);
            articleList.add(article2);
            Article article3 = new Article("拿木头玩具学编程，这是麻省理工设计的早教方法！","拿木头玩具学编程，这是麻省理工设计的早教方法！",R.drawable.img4);
            articleList.add(article3);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis(); // 更新mExitTime
            } else {
                //启动一个意图,回到桌面
                Intent backHome = new Intent(Intent.ACTION_MAIN);
                backHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                backHome.addCategory(Intent.CATEGORY_HOME);
                startActivity(backHome);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}








