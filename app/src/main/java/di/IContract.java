package di;

public interface IContract {
    /**
     * iview
     */
    public interface iview{
        void Show(String message);
    }
    /**
     * ipresent
     */
    public interface ipresent<iview>{
        //关联试图
        void attachView(iview iview);
        //取消关联
        void detachView(iview iview);
        //逻辑  注册
        void requestInfo(String name, String pwd);

        void requestInfo1(String username, String password);
    }
    /**
     * imodule
     */
    public interface imodule{
        void requestData1(String username, String password, calllisten calllisten);

        //接口回调
        public interface calllisten{
            void responmsg(String message);
        }
        void requestData(String name, String pwd, calllisten calllisten);
    }
}
