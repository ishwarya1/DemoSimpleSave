package sg.edu.rp.soi.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("greetings","Hello!");
        prefEdit.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
       //String msg = "No greetings!";
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
       String msg = prefs.getString("greetings","Hello!");
        Toast toast = Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        toast.show();
    }
}
