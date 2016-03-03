package somshubham.gdgloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Forgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);
        Firebase.setAndroidContext(this);
    }




    public void reset(View view) {
        EditText post = (EditText) findViewById(R.id.editText);
        String email = post.getText().toString();

        //firebase code to reset the password.....
        Firebase ref = new Firebase("https://debandroid.firebaseio.com/");
   //     Firebase ref = new Firebase("https://testforcutm.firebaseio.com/");
        ref.resetPassword(email, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                // password reset email sent
                Toast.makeText(Forgot.this, "Successfully Reset the Password", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Forgot.this, MainActivity.class);
                startActivity(intent);
                finish();


            }

            @Override
            public void onError(FirebaseError firebaseError) {
                // error encountered
                Toast.makeText(Forgot.this, "Wrong email !", Toast.LENGTH_SHORT).show();
            }
        });


        //ends firebase


    }

    }
