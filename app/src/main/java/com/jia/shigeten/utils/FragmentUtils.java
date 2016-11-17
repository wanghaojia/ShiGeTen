package com.jia.shigeten.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jia.shigeten.fragments.ContentFragment;
import com.jia.shigeten.fragments.SettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment工具类
 * Created by JIA on 2016/11/15.
 */

public class FragmentUtils {

    private static List<Fragment> fragments_main = new ArrayList<>();                  //主页面的碎片集合

    //静态代码块，初始化数据
    static{
        //初始化主页面的Fragment集合

        ContentFragment critic = new ContentFragment();
        Bundle bundle_critic = new Bundle();
        bundle_critic.putInt("fragment_type",Utils.CRITIC_TYPE);
        critic.setArguments(bundle_critic);
        ContentFragment novel = new ContentFragment();
        Bundle bundle_novel = new Bundle();
        bundle_novel.putInt("fragment_type",Utils.NOVEL_TYPE);
        novel.setArguments(bundle_novel);
        ContentFragment dragram = new ContentFragment();
        Bundle bundle_dragram = new Bundle();
        bundle_dragram.putInt("fragment_type",Utils.DIAGRAM_TYPE);
        dragram.setArguments(bundle_dragram);
        SettingFragment setting = new SettingFragment();
        fragments_main.add(critic);
        fragments_main.add(novel);
        fragments_main.add(dragram);
        fragments_main.add(setting);
    }

    public static List<Fragment> getFragments_main() {
        return fragments_main;
    }
}
