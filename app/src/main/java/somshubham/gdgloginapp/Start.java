package somshubham.gdgloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Firebase.setAndroidContext(this);

       final TextView name =(TextView)findViewById(R.id.textView7);
        final TextView address =(TextView)findViewById(R.id.textView8);
        final TextView phone =(TextView)findViewById(R.id.textView9);
        final TextView username=(TextView)findViewById(R.id.username);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView5);






        Firebase ref = new Firebase("https://debandroid.firebaseio.com/");


        //to get the user id from the firebase.........

        AuthData authData =ref.getAuth();
        String uid="";
        if(authData!=null)
        {
            uid=authData.getUid().toString();
        }

        Log.i("mylog",""+uid);


        ref=new Firebase("https://debandroid.firebaseio.com/user/"+uid+"/");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
               // System.out.println(snapshot.child("photo").getValue());

               /* String k = snapshot.child("photo").getValue().toString();
                String accountname = snapshot.child("name").getValue().toString();
                String a =snapshot.child("address").getValue().toString();

                String p=snapshot.child("phone").getValue().toString();
                name.setText(accountname);
                username.setText("Hi " + accountname + " !");
                address.setText(a);

                phone.setText(p);

                Picasso.with(Start.this)
                        .load(k)
                        .into(imageView);
                */

                Log.i("debasis","sabat");
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });












    }





    public void logout(View view)
    {
        Intent intent =new Intent(Start.this,MainActivity.class);
        startActivity(intent);
    }

}
