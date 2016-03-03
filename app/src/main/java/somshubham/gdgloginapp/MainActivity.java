package somshubham.gdgloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Firebase.setAndroidContext(this);


    }


    public void login(View view)
    {


        EditText box1=(EditText)findViewById(R.id.editText);
        EditText box2=(EditText)findViewById(R.id.editText2);


        //get the data.......

        String password=box2.getText().toString();
        final   String email=box1.getText().toString();


        //final Firebase ref = new Firebase("https://bbsrstudyjam.firebaseio.com/");
        final Firebase ref = new Firebase("https://debandroid.firebaseio.com/");

        ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: have logged in user: " + authData.getUid() + ", Provider: " + authData.getProvider());
                Log.i("mylogforuser","User ID: have logged in user: " + authData.getUid() + ", Provider: " + authData.getProvider());

                Intent intent = new Intent(MainActivity.this, Start.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error

                System.out.println("not done ");
                Toast.makeText(MainActivity.this, "Failed Login", Toast.LENGTH_SHORT).show();
            Log.i("mymsg","login failed due to internet....");
            }
        });






    }

    public void forgot(View view)
    {
        Intent intent =new Intent(MainActivity.this,Forgot.class);
        startActivity(intent);
    }
    public void signup(View view)
    {
        Intent intent =new Intent(MainActivity.this,Signup.class);
        startActivity(intent);
    }

}
