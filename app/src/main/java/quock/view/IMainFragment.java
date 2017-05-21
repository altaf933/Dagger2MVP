package quock.view;

/**
 * Created by altaf.h.shaikh on 5/18/2017.
 */

public interface IMainFragment {

    interface View {
        public boolean isShow();
        public boolean isHide();
    }

    interface  Presenter{
        void loadData();
    }
}
