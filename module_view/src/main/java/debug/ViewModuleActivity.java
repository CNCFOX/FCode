package debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.arouter.RouterPath;
import com.cfox.lib_common.base.BaseActivity;


public class ViewModuleActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VIEW_FG).navigation();
        setContentView(fragment.onCreateView(LayoutInflater.from(this), null,null));
    }
}
