package javaClass;

import static androidx.core.app.PendingIntentCompat.getActivity;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.unionservice.R;

public class dialog extends DialogFragment {

    //private static DialogFragment showDialog = null;

    public void ShowDialogBox(){
            final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
            View mView = getLayoutInflater().inflate(R.layout.dialog_item, null);
            alert.setView(mView);

            final AlertDialog alertDialog = alert.create();
            alertDialog.setCancelable(false);

            mView.findViewById(R.id.chancelBTN).setOnClickListener(v -> {
                alertDialog.dismiss();
            });

            mView.findViewById(R.id.okBTN).setOnClickListener(v -> {
                Toast.makeText(getContext(),"Clicked OK BTN", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            });

            alertDialog.show();
        }


    }

