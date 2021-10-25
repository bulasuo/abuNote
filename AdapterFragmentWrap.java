package com.artcm.artcmandroidapp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.artcm.artcmandroidapp.base.Constant;
import com.artcm.artcmandroidapp.pv.PagerOrderDetailPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserAboutUsPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserAccountSecurityPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserAddressManagerPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserChangeNickNamePresenter;
import com.artcm.artcmandroidapp.pv.PagerUserChangePhonePresenter;
import com.artcm.artcmandroidapp.pv.PagerUserConnectCustomerServicePresenter;
import com.artcm.artcmandroidapp.pv.PagerUserEditAddressPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserFeedbackPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserIdentityPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserIdentityUserNamePresenter;
import com.artcm.artcmandroidapp.pv.PagerUserInputOldPaymentPasswordPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserInputPasswordPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserPersonalEmailPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserPersonalInfoPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserPersonalOrderPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserRecommendCodePresenter;
import com.artcm.artcmandroidapp.pv.PagerUserSetPasswordPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserSetPaymentPasswordPresenter;
import com.artcm.artcmandroidapp.pv.PagerUserSettingPresenter;
import com.artcm.artcmandroidapp.ui.FragmentApplyRefund;
import com.artcm.artcmandroidapp.ui.FragmentIntroduce;
import com.artcm.artcmandroidapp.ui.FragmentOrderConfirm;
import com.artcm.artcmandroidapp.ui.FragmentOrderDetail;
import com.artcm.artcmandroidapp.ui.FragmentOrderShippingInfo;
import com.artcm.artcmandroidapp.ui.FragmentPersonalOrder;
import com.artcm.artcmandroidapp.ui.FragmentUser;
import com.artcm.artcmandroidapp.ui.FragmentUserAboutUs;
import com.artcm.artcmandroidapp.ui.FragmentUserAccountSecurity;
import com.artcm.artcmandroidapp.ui.FragmentUserAddressManager;
import com.artcm.artcmandroidapp.ui.FragmentUserChangeNickName;
import com.artcm.artcmandroidapp.ui.FragmentUserChangePhone;
import com.artcm.artcmandroidapp.ui.FragmentUserConnectCustomerService;
import com.artcm.artcmandroidapp.ui.FragmentUserEditAddress;
import com.artcm.artcmandroidapp.ui.FragmentUserFeedback;
import com.artcm.artcmandroidapp.ui.FragmentUserIdentity;
import com.artcm.artcmandroidapp.ui.FragmentUserIdentityUserName;
import com.artcm.artcmandroidapp.ui.FragmentUserInputOldPaymentPassword;
import com.artcm.artcmandroidapp.ui.FragmentUserInputPassword;
import com.artcm.artcmandroidapp.ui.FragmentUserPersonalEmail;
import com.artcm.artcmandroidapp.ui.FragmentUserPersonalInfo;
import com.artcm.artcmandroidapp.ui.FragmentUserRecommendCode;
import com.artcm.artcmandroidapp.ui.FragmentUserSetPassword;
import com.artcm.artcmandroidapp.ui.FragmentUserSetPaymentPassword;
import com.artcm.artcmandroidapp.ui.FragmentUserSetting;
import com.artcm.artcmandroidapp.ui.FragmentWelcomePage;
import com.artcm.artcmandroidapp.utils.BaseUtils;
import com.lin.base.BaseFragment;
import com.lin.base.mvp.BaseContract;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abu on 2016/5/30 16:43.
 */
public class AdapterFragmentWrap {
    //FragmentName-PresenterName的映射表<配置文件,暂时放这边>,当生成view时生成presenter
    private static HashMap<String, String> mFragment2PresenterMap = new HashMap();
    public static final int FRAGMENT_ANIAML_TYPE_NONE = -1;
    public static final int FRAGMENT_ANIAML_TYPE = 0;

    static {
        mFragment2PresenterMap.put(FragmentOrderDetail.class.getName(), PagerOrderDetailPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUser.class.getName(), PagerUserPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserAboutUs.class.getName(), PagerUserAboutUsPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserAccountSecurity.class.getName(), PagerUserAccountSecurityPresenter
                .class.getName());
        mFragment2PresenterMap.put(FragmentUserAddressManager.class.getName(), PagerUserAddressManagerPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserChangeNickName.class.getName(), PagerUserChangeNickNamePresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserChangePhone.class.getName(), PagerUserChangePhonePresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserConnectCustomerService.class.getName(),
                PagerUserConnectCustomerServicePresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserEditAddress.class.getName(), PagerUserEditAddressPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserFeedback.class.getName(), PagerUserFeedbackPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserIdentity.class.getName(), PagerUserIdentityPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserIdentityUserName.class.getName(), PagerUserIdentityUserNamePresenter
                .class.getName());
        mFragment2PresenterMap.put(FragmentUserInputOldPaymentPassword.class.getName(),
                PagerUserInputOldPaymentPasswordPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserInputPassword.class.getName(), PagerUserInputPasswordPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserPersonalEmail.class.getName(), PagerUserPersonalEmailPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserPersonalInfo.class.getName(), PagerUserPersonalInfoPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentPersonalOrder.class.getName(), PagerUserPersonalOrderPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserRecommendCode.class.getName(), PagerUserRecommendCodePresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserSetPassword.class.getName(), PagerUserSetPasswordPresenter.class
                .getName());
        mFragment2PresenterMap.put(FragmentUserSetPaymentPassword.class.getName(),
                PagerUserSetPaymentPasswordPresenter.class.getName());
        mFragment2PresenterMap.put(FragmentUserSetting.class.getName(), PagerUserSettingPresenter.class.getName());

        mFragment2PresenterMap.put(FragmentOrderShippingInfo.class.getName(), "0");
        mFragment2PresenterMap.put(FragmentApplyRefund.class.getName(), "0");
        mFragment2PresenterMap.put(FragmentWelcomePage.class.getName(), "0");
        mFragment2PresenterMap.put(FragmentIntroduce.class.getName(), "0");
        mFragment2PresenterMap.put(FragmentOrderConfirm.class.getName(), "0");
    }

    private ArrayList<String> mFragmentTagList = new ArrayList();//Fragment回退栈
    private FragmentManager mFmg;
    private int mFragmentContentId;
    private Fragment mCurrentFragment;

    private OnPageChagedListenner mOnPageChagedListenner;

    public AdapterFragmentWrap(FragmentManager mFmg, int mFragmentContentId, ArrayList<String> mFragmentTagList) {

        if (mFragmentTagList != null && mFragmentTagList.size() >= 1) {
            this.mFragmentTagList = mFragmentTagList;
        }
        this.mFragmentContentId = mFragmentContentId;
        this.mFmg = mFmg;
    }

    /**
     * tag: class().getName();
     */
    public void showFragment(String fragmentTag, Bundle data, boolean goBack, int animalType) {
        if (mCurrentFragment != null && mCurrentFragment.getClass().getName().equals(fragmentTag))
            return;

        hideAllFragment(false);
        BaseFragment toShowFragment = (BaseFragment) mFmg.findFragmentByTag(fragmentTag);
        FragmentTransaction showFt = obtainFragmentTransaction(mFmg.beginTransaction(), goBack, animalType);

        if (toShowFragment == null) {
            BaseFragment fragment = null;
            try {
                final String presenterTag = mFragment2PresenterMap.get(fragmentTag);
                if (presenterTag == null)
                    throw new RuntimeException("tag must like-tag: class().getName(); " +
                            "or you didn't Configuration mapping table<mFragment2PresenterMap>::" + fragmentTag);
                fragment = (BaseFragment) Class.forName(fragmentTag).newInstance();
                if (!presenterTag.equals("0")) {
                    Class<?> c = Class.forName(presenterTag);
                    c.getConstructor(BaseContract.View.class).newInstance(fragment);//实例化Presenter 并把自己的引用给Fragment
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if (data != null)
                fragment.setDoFinish(data.getBoolean(Constant.Key.DO_FINISH, false));
            fragment.setArguments(data);
            showFt.add(mFragmentContentId, fragment, fragmentTag).commitAllowingStateLoss();
            mFmg.beginTransaction().commit();//executePendingTransactions();
            mCurrentFragment = fragment;
        } else {
//            if (data != null) {
//                toShowFragment.setDoFinish(data.getBoolean(Constant.Key.DO_FINISH));
//                toShowFragment.setArguments(data);
//            }
            toShowFragment.setArguments(data);
            showFt.show(toShowFragment).commitAllowingStateLoss();
            mFmg.beginTransaction().commit();//.executePendingTransactions();
            mCurrentFragment = toShowFragment;
        }
        mFragmentTagList.add(fragmentTag);//入栈
        if (null != mOnPageChagedListenner)
            mOnPageChagedListenner.onPageChaged(fragmentTag);
    }

    public void removeFragment(String fragmentTag) {
        Fragment toRemoveFragment = mFmg.findFragmentByTag(fragmentTag);
        if (toRemoveFragment != null) {
            BaseUtils.hideSoftKeyBoard(toRemoveFragment.getActivity(), toRemoveFragment.getView());
            mFmg.beginTransaction().remove(toRemoveFragment).commitAllowingStateLoss();
            mFmg.beginTransaction().commit();//executePendingTransactions();
        }
    }

    public void clearTopInStack(String fragmentTag) {
        if (mCurrentFragment != null && mCurrentFragment.getClass().getName().equals(fragmentTag))
            return;
        hideAllFragment(true);
        int index = mFragmentTagList.lastIndexOf(fragmentTag);
        if (index != -1) {
            for (int i = mFragmentTagList.size() - 1; i > index; i--) {
                mFragmentTagList.remove(i);
            }
            mFragmentTagList.remove(index);
        }
        showFragment(fragmentTag, null, true, FRAGMENT_ANIAML_TYPE);
    }

    /**
     * 最后一个 该fragmentTag的fragmentTag出栈
     *
     * @param fragmentTag
     */
    public void outInStack(String fragmentTag) {
        mFragmentTagList.remove(mFragmentTagList.lastIndexOf(fragmentTag));
    }

    /**
     * goback 回退标志
     *
     * @param goback
     */
    private void hideAllFragment(boolean goback) {
        FragmentTransaction ft = mFmg.beginTransaction();
        obtainFragmentTransaction(ft, goback, FRAGMENT_ANIAML_TYPE);
        BaseFragment toHideFragment;

        for (String tag : mFragment2PresenterMap.keySet()) {
            toHideFragment = (BaseFragment) mFmg.findFragmentByTag(tag);
            if (toHideFragment != null) {
                BaseUtils.hideSoftKeyBoard(toHideFragment.getActivity(), toHideFragment.getView());
                if (toHideFragment.isDoFinish()//回退事件 && isDoFinish && 位于栈顶 则remove
                        && goback
                        && mFragmentTagList.size() > 0
                        && tag.equals(mFragmentTagList.get(mFragmentTagList.size() - 1))) {
                    toHideFragment.setArguments(null);
                    ft.remove(toHideFragment);
                } else
                    ft.hide(toHideFragment);
            }
        }
        ft.commitAllowingStateLoss();
        mFmg.executePendingTransactions();

    }

    /**
     * @return true:wrap自己处理了back事件   false:自己不处理back事件 并且把back事件传递给调用者
     */
    public boolean showLastFragmnet(int animalType) {
        if (mFragmentTagList.size() <= 1)
            return false;
        hideAllFragment(true);
        mFragmentTagList.remove(mFragmentTagList.size() - 1);//出栈
        final String tag = mFragmentTagList.get(mFragmentTagList.size() - 1);
        if (tag == null)
            return false;
        final Fragment toShowFragment = mFmg.findFragmentByTag(tag);
//        if (toShowFragment == null)
//            return false;
//        ft.show(toShowFragment);

        FragmentTransaction showFt = obtainFragmentTransaction(mFmg.beginTransaction(), true, animalType);
        if (toShowFragment == null) {
            BaseFragment fragment = null;
            try {
                final String presenterTag = mFragment2PresenterMap.get(tag);
                if (presenterTag == null)
                    throw new RuntimeException("tag must like-tag: class().getName(); " +
                            "or you didn't Configuration mapping table<mFragment2PresenterMap>");
                fragment = (BaseFragment) Class.forName(tag).newInstance();
                if (!presenterTag.equals("0")) {
                    Class<?> c = Class.forName(presenterTag);
                    c.getConstructor(BaseContract.View.class).newInstance(fragment);//实例化Presenter 并把自己的引用给Fragment
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            showFt.add(mFragmentContentId, fragment, tag).commitAllowingStateLoss();
            mFmg.beginTransaction().commit();//executePendingTransactions();
            mCurrentFragment = fragment;
        } else {
            showFt.show(toShowFragment).commitAllowingStateLoss();
            mFmg.beginTransaction().commit();//executePendingTransactions();
            mCurrentFragment = toShowFragment;
        }
        return true;
    }

    public Fragment getFragment(String fragmentTag) {
        BaseFragment fragment = (BaseFragment) mFmg.findFragmentByTag(fragmentTag);
        if (fragment == null) {
            try {
                final String presenterTag = mFragment2PresenterMap.get(fragmentTag);
                if (presenterTag == null)
                    throw new RuntimeException("tag must like-tag: class().getName(); " +
                            "or you didn't Configuration mapping table<mFragment2PresenterMap>");
                fragment = (BaseFragment) Class.forName(fragmentTag).newInstance();
                if (!presenterTag.equals("0")) {
                    Class<?> c = Class.forName(presenterTag);
                    c.getConstructor(BaseContract.View.class).newInstance(fragment);//实例化Presenter 并把自己的引用给Fragment
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return fragment;
    }

    public ArrayList<String> getFragmentTagList() {
        return mFragmentTagList;
    }


    public interface OnPageChagedListenner {
        void onPageChaged(String tag);
    }

    public void setonPageChagedListenner(OnPageChagedListenner mOnPageChagedListenner) {
        this.mOnPageChagedListenner = mOnPageChagedListenner;
    }

    private FragmentTransaction obtainFragmentTransaction(FragmentTransaction ft, boolean goback, int animalType) {
        switch (animalType) {
            case 0:
                if (!goback) {
                    ft.setCustomAnimations(com.lin.base.R.anim.anim_right_in_3s,
                            com.lin.base.R.anim.anim_left_out_3s);
                } else {
                    ft.setCustomAnimations(com.lin.base.R.anim.anim_left_in_3s,
                            com.lin.base.R.anim.anim_right_out_3s);
                }
                break;
            case 1:
                if (!goback) {
                    ft.setCustomAnimations(com.lin.base.R.anim.anim_bottom_in_3s,
                            com.lin.base.R.anim.anim_zoomout_95p_3s);
                } else {
                    ft.setCustomAnimations(com.lin.base.R.anim.anim_top_in_3s,
                            com.lin.base.R.anim.anim_zoomout_95p_3s);
                }
                break;

            default:
                break;
        }

        return ft;
    }

    // TODO: 2016/7/9
    /*
    后退
    .showFragment(FragmentUserSetPaymentPassword.class.getName(), mBundle)
                                    .removeFragment(mFragmentUserIdentity.getClass().getName())
                                    .outInStack(mFragmentUserIdentity.getClass().getName());

     跳转
     .clearTopInStack();
     */
    public boolean isTopFragment(String tag) {
        if (null != mFragmentTagList)
            return tag.equals(mFragmentTagList.get(mFragmentTagList.size() - 1));
        return false;
    }

    public Fragment getTopFragment() {
        if (mFmg != null && mFragmentTagList != null && mFragmentTagList.size() >= 1) {
            return mFmg.findFragmentByTag(mFragmentTagList.get(mFragmentTagList.size() - 1));
        }
        return null;
    }
}
