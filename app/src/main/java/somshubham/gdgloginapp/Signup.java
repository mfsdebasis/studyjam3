package somshubham.gdgloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Firebase.setAndroidContext(this);










    }





    public void signup(View view)
    {
        EditText name_value=(EditText)findViewById(R.id.editText);
        EditText email_value=(EditText)findViewById(R.id.editText1);
        EditText phone_value=(EditText)findViewById(R.id.editText3);
        EditText address_value=(EditText)findViewById(R.id.editText4);
        EditText password_value=(EditText)findViewById(R.id.editText2);


       final String name=name_value.getText().toString();
      final  String email=email_value.getText().toString();
        final String  phone=phone_value.getText().toString();
        final String address=address_value.getText().toString();
        final String password=password_value.getText().toString();


        Firebase ref = new Firebase("https://debandroid.firebaseio.com/");

        ref.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));



                String myuniqid=result.get("uid").toString();


//my test code.........
                Firebase ref = new Firebase("https://debandroid.firebaseio.com/");
                Firebase postRef = ref.child("user");
                Firebase my = postRef.child(myuniqid);

                my.child("name").setValue(name);
                my.child("phone").setValue(phone);
                my.child("address").setValue(address);
                my.child("photo").setValue("http://gdgkarachi.com/devfest/img/favicons/apple-touch-icon-152x152.png");

                Toast.makeText(Signup.this, "Account created...", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Signup.this,MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error


                Toast.makeText(Signup.this, "failed...", Toast.LENGTH_SHORT).show();

            }
        });









        //my firebase ends here ................


    }











}
