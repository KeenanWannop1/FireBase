package com.example.admin.firebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserAuthenticator {
    public static final String TAG = UserAuthenticator.class.getSimpleName() + "_TAG";
    FirebaseAuth auth;

    public UserAuthenticator() {
        auth = FirebaseAuth.getInstance();
    }

    public void signIn(String userEmail, String password, Activity activity ){
        auth.signInWithEmailAndPassword(userEmail, password)
        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = auth.getCurrentUser();
                //    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                //    updateUI(null);
                }

                // ...
            }
        });
    }
    public void signUp(String userEmail, String password, Activity activity){
        auth.createUserWithEmailAndPassword(userEmail, password)
        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    FirebaseUser user = auth.getCurrentUser();
                   // updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    //updateUI(null);
                }

                // ...
            }
        });

    }
    public void checkSession(){

    }
    public void signOut(){

    }
}
