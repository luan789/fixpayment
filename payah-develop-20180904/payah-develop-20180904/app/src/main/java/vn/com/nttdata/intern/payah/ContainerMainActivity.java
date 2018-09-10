package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContainerMainActivity extends AppCompatActivity implements View.OnClickListener, FragmentTopupClass.InterfaceTopupListener, FragmentTopupSubmit.InterfaceBtnBackTopupSubmit, FragmentScan.InterfaceClickImageScan, FragmentPaymentCode.InterfaceClickScanQrCodeListener {
    private Button btnScan, btnTopup, btnPay, btnTransfer, btnHome, btnHistory, btnMe;
    LayoutInflater inflater;
    private LinearLayout layoutTopMenu;
    //fragment container
    private FragmentTopupClass fragmentTopupClass;
    private FragmentTopupSubmit fragmentTopupSubmit;
    private FragmentMainHome fragmentMainHome;
    private FragmentHistory fragmentHistory;
    private FragmentMe fragmentMe;
    private FragmentScan fragmentScan;
    private FragmentPaymentCode fragmentPaymentCode;
    //////////////////
    private FragmentManager fragmentManager;
    //private FragmentTransaction fragmentTransaction;
    //event exit
    boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_container_main);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        findById();//find id view in activity_container_main

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //find id
        btnScan.setOnClickListener(this);
        btnPay.setOnClickListener(this);
        btnTopup.setOnClickListener(this);
        btnTransfer.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnMe.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        layoutTopMenu = findViewById(R.id.layout_menu_top);
        //define fragment manager
        fragmentManager = getSupportFragmentManager();
        //define fragment transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //define fragment
        fragmentTopupClass = new FragmentTopupClass();
        fragmentTopupSubmit = new FragmentTopupSubmit();
        fragmentMainHome = new FragmentMainHome();
        fragmentHistory = new FragmentHistory();
        fragmentMe = new FragmentMe();
        fragmentScan = new FragmentScan();
        fragmentPaymentCode = new FragmentPaymentCode();
        //default screen start
        fragmentTransaction.replace(R.id.layout_container_main, fragmentMainHome);
        fragmentTransaction.commit();
        //set onclick back on topup submit class
        fragmentTopupSubmit.setOnclickBtnBackListenerS(this);
        fragmentScan.setOnClickImageScanListener(this);
        fragmentTopupClass.setOnclickListener(this);
        fragmentPaymentCode.setOnClickScanQr(this);
        //exit app
        doubleBackToExitPressedOnce = false;

    }

    private void findById() {
        btnScan = findViewById(R.id.button_top_scan);
        btnHistory = findViewById(R.id.button_bot_history);
        btnHome = findViewById(R.id.button_bot_home);
        btnMe = findViewById(R.id.button_bot_me);
        btnTransfer = findViewById(R.id.button_top_transfer);
        btnTopup = findViewById(R.id.button_top_topup);
        btnPay = findViewById(R.id.button_top_pay);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_top_scan:
                clickBtnScan();
                break;
            case R.id.button_top_topup:
                clickBtnTopup();
                break;
            case R.id.button_top_pay:
                clickBtnPay();
                break;
            case R.id.button_top_transfer:
                clickBtnTransfer();
                break;
            case R.id.button_bot_home:
                clickBtnHome();
                break;
            case R.id.button_bot_me:
                clickBtnMe();
                break;
            case R.id.button_bot_history:
                clickBtnHistory();
                break;
        }
    }

    private void clickBtnScan() {
        setHiglight(btnScan);
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentScan);
        ft_rep.commit();

    }

    private void clickBtnTopup() {
        setHiglight(btnTopup);
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentTopupClass);
        ft_rep.commit();

    }

    private void clickBtnTransfer() {

    }

    private void clickBtnPay() {

    }

    private void clickBtnHome() {
        clearBackStack();
        setHiglight(btnHome);
        if (layoutTopMenu.getVisibility() == View.GONE) {
            layoutTopMenu.setVisibility(View.VISIBLE);
        }
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentMainHome);
        ft_rep.commit();
    }

    private void clickBtnMe() {
        setHiglight(btnMe);
        clearBackStack();
        if (layoutTopMenu.getVisibility() == View.GONE) {
            layoutTopMenu.setVisibility(View.VISIBLE);
        }
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentMe);
        ft_rep.commit();
    }

    private void clickBtnHistory() {
        setHiglight(btnHistory);
        clearBackStack();
        if (layoutTopMenu.getVisibility() == View.GONE) {
            layoutTopMenu.setVisibility(View.VISIBLE);
        }
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentHistory);
        ft_rep.commit();
    }

    @Override
    public void clickBtnTopupListener() {

        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            ft_rep.addToBackStack(fragmentTopupSubmit.getClass().getSimpleName());
        }
        ft_rep.replace(R.id.layout_container_main, fragmentTopupSubmit);
        ft_rep.commit();
    }

    @Override
    public void onClickBtnBackTopsubmitListenr() {
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentTopupClass);
        ft_rep.commit();
    }

    @Override
    public void onClickBtnSubmitTopsubmitListener(Boolean bl) {
        if (bl) {
            FragmentTransaction ft_rep = fragmentManager.beginTransaction();
            ft_rep.replace(R.id.layout_container_main, fragmentTopupClass);
            ft_rep.commit();
        }
    }

    @Override
    public void onClickScanListener() {
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            ft_rep.addToBackStack(fragmentPaymentCode.getClass().getSimpleName());
        }
        ft_rep.replace(R.id.layout_container_main, fragmentPaymentCode);
        ft_rep.commit();
        layoutTopMenu.setVisibility(View.GONE);
    }

    @Override
    public void onClickScanQrListener() {
        layoutTopMenu.setVisibility(View.VISIBLE);
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentScan);
        ft_rep.commit();
    }

    @Override
    public void onClickBackQrListener() {
        layoutTopMenu.setVisibility(View.VISIBLE);
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentScan);
        ft_rep.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //getFragmentManager().popBackStack();
        if (layoutTopMenu.getVisibility() == View.GONE) {
            layoutTopMenu.setVisibility(View.VISIBLE);
        }
    }
    private void clearBackStack(){
        FragmentManager manager = ContainerMainActivity.this.getSupportFragmentManager();
        manager.popBackStack();
    }

    private void setHiglight(Button a){
        ArrayList<Button> listBtn=new ArrayList<>();
        listBtn.add(btnHistory);
        listBtn.add(btnHome);
        listBtn.add(btnMe);
        listBtn.add(btnScan);
        //listBtn.add(btnTransfer);
        listBtn.add(btnTopup);
        for(int i=0;i<listBtn.size();i++){
            if(listBtn.get(i)==a){
                Log.d("TAG","click");
                listBtn.get(i).setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.button_teal));
            }else {
                listBtn.get(i).setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.background_currency));
            }
        }
    }
}