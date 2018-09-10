package di;

import java.lang.ref.WeakReference;

public class PresenterImp implements IContract.ipresent<IContract.iview>{
    private IContract.iview iview;
    private ModuleImp moduleImp;
    private WeakReference<IContract.iview> iviewWeakReference;
    private WeakReference<IContract.imodule> imoduleWeakReference;

    @Override
    public void attachView(IContract.iview iview) {
        this.iview=iview;
        moduleImp = new ModuleImp();
        //使用弱引用
        iviewWeakReference = new WeakReference<>(iview);
        imoduleWeakReference = new WeakReference<IContract.imodule>(moduleImp);
    }

    @Override
    public void detachView(IContract.iview iview) {
        iviewWeakReference.clear();
        imoduleWeakReference.clear();
    }

    @Override
    public void requestInfo(String name, String pwd) {
        moduleImp.requestData(name,pwd,new IContract.imodule.calllisten() {
            @Override
            public void responmsg(String message) {
                iview.Show(message);
            }
        });
    }

    @Override
    public void requestInfo1(String username, String password) {
        moduleImp.requestData1(username,password,new IContract.imodule.calllisten() {
            @Override
            public void responmsg(String message) {
                iview.Show(message);
            }
        });
    }
}
