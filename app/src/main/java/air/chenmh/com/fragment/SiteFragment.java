package air.chenmh.com.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import air.chenmh.com.R;

/**
 * 监测数据
 * Created by 陈苗辉 on 2017/5/11.
 */
public class SiteFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_site, container, false);
        return view;
    }
}
