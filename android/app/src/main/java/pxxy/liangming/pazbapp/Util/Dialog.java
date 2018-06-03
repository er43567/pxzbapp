package pxxy.liangming.pazbapp.Util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by asus on 2017/7/19.
 */

public class Dialog {

    public static void showDoubleEditDialog(final Context context, String title, String hint1, String hint2) {
        final EditText editText1 = new EditText(context);
        final EditText editText2 = new EditText(context);
        editText1.setHint(hint1);
        editText2.setHint(hint2);
        final LinearLayout ll = new LinearLayout(context);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llp.setMargins(8,8,8,8);
        editText1.setLayoutParams(llp);
        editText2.setLayoutParams(llp);
        ll.setLayoutParams(llp);
        ll.addView(editText1);
        ll.addView(editText2);

        AlertDialog.Builder inputDialog =  new AlertDialog.Builder(context);
        inputDialog.setTitle(title).setView(ll);
        inputDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        inputDialog.setNegativeButton("取消",null);
        inputDialog.show();
    }

    public static void showEditDialog(Context context, String title, ClickCallback clickCallback) {
        showEditDialog(context,title,null,clickCallback);
    }

    public static void showEditDialog(final Context context, String title, @Nullable String hint, final ClickCallback clickCallback) {
        final EditText editText = new EditText(context);
        if(hint!=null)
            editText.setText(hint);

        AlertDialog.Builder inputDialog =  new AlertDialog.Builder(context);
        inputDialog.setTitle(title).setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clickCallback.onEditSubmit(dialog,editText.getText().toString());
                    }
                });
        inputDialog.setNegativeButton("取消",null);
        inputDialog.show();
    }

    public static void showDialog(final Context context, String content) {
        AlertDialog.Builder inputDialog =  new AlertDialog.Builder(context);
        inputDialog.setMessage(content);
        inputDialog.show();
    }

    public static void showOKCancelDialog(final Context context, String title, String content, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(context);
        inputDialog.setTitle(title);
        if(content != null)
            inputDialog.setMessage(content);
        inputDialog.setPositiveButton("确定", okListener);
        inputDialog.setNegativeButton("取消", null);
        inputDialog.show();
    }

    public static void showOKCancelDialog(final Context context, String title, DialogInterface.OnClickListener okListener) {
        showOKCancelDialog(context,title,null,okListener);
    }

    public static ProgressDialog showProgressDialog(final Context context, String content, boolean cancelable) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(content);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(cancelable);
        progressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.cancel();
            }
        }, 5000);
        return progressDialog;
    }

    public static void showSingleChoiceDialog(final Context context, String items[], int default_pos, DialogInterface.OnClickListener listener){
        //final String[] items = { "我是1","我是2","我是3","我是4" };
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(context);
        singleChoiceDialog.setSingleChoiceItems(items, default_pos, listener);
        singleChoiceDialog.show();
    }

    public static void showListDialog(final Context context, String items[], DialogInterface.OnClickListener listener) {
        AlertDialog.Builder listDialog = new AlertDialog.Builder(context);
        listDialog.setItems(items, listener);
        listDialog.show();
    }


    public static void showMultiChoiceDialog(final Context context, String title, final String items[], final IMultiDialogCallback callback) {
        final ArrayList<Integer> choice = new ArrayList<>();
        final boolean initChoiceSets[]= new boolean[items.length];
        choice.clear();
        AlertDialog.Builder multiChoiceDialog =
                new AlertDialog.Builder(context);
        multiChoiceDialog.setTitle(title);
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            choice.add(which);
                        } else {
                            choice.remove(which);
                        }
                    }
                });
        multiChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onChoice(choice);
                    }
                });
        multiChoiceDialog.show();
    }

    //==================


    public interface IMultiDialogCallback {
        void onChoice(ArrayList<Integer> list);
    }

    public interface ClickCallback {
        void onEditSubmit(DialogInterface dialog, String inputs);
    }

    public interface DialogCallBack {
        void onEditSubmit(DialogInterface dialog, String input1, String input2);
    }


}
