package debug;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.arouter.RouterPath;

public class ViewModuleActivity extends BaseDebugActivity {

    @Override
    public Fragment createFragment() {
        return (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VIEW_FG).navigation();
    }
}