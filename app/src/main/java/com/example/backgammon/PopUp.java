package com.example.backgammon;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PopUp extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Möchten Sie Wirklich Aufgeben?")
                .setMessage("Falls Sie Aufgeben, bekommt Ihr Gegner einen Punkt zugeschrieben")
                .setCancelable(false)
                .setPositiveButton("Aufgeben", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
                .setNegativeButton("Nicht Aufgeben", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        return builder.create();

    }
}
