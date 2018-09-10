package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    private Spinner spnnerPhoneNumber;
    private EditText editName;
    private EditText editId;
    private EditText editPin;
    private EditText editConfirmPin;
    private EditText editPhoneNumber;
    private EditText editEmail;
    private EditText editAdress;
    private Button btnRegister;
    private Button btnClear;
    public static final String PREFE_REGISTER = "abcxz";
    public SharedPreferences sharedPreference;
    private static ArrayList<Country> arrayList;
    String NumberCode = "";
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Init();
        editName = (EditText) findViewById(R.id.editName);
        editId = (EditText) findViewById(R.id.editId);
        editPin = (EditText) findViewById(R.id.editPin);
        editConfirmPin = (EditText) findViewById(R.id.editConfrimPin);
        editPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editAdress = (EditText) findViewById(R.id.editAdress);
        btnRegister = (Button) findViewById(R.id.btnRegisterSignup);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NumberCode.equals(""))
                    return;
                sharedPreference = getSharedPreferences(PREFE_REGISTER, Context.MODE_PRIVATE);

                String newName = editName.getText().toString();
                String newId = editId.getText().toString();
                String newPin = editId.getText().toString();
                String newPhoneNumber = editPhoneNumber.getText().toString();
                String newEmail = editEmail.getText().toString();
                String newAdress = editAdress.getText().toString();
                SharedPreferences.Editor editor = sharedPreference.edit();

                editor.putString("Name", newName);
                editor.putString("ID", newId);
                editor.putString("Pin", newPin);
                editor.putString("Phone", NumberCode + newPhoneNumber);
                editor.putString("Email", newEmail);
                editor.putString("Adress", newAdress);
                editor.putString("Current", "00.00");
                editor.apply();

                Toast.makeText(SignUpActivity.this, " Register sucess", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editId.setText("");
                editPhoneNumber.setText("");
                editEmail.setText("");
                editEmail.setText("");
                editConfirmPin.setText("");
            }
        });

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void Init() {

        spnnerPhoneNumber = (Spinner) findViewById(R.id.spinnerPhoneNumber);
        final ArrayList<Country> arrayList = new ArrayList<Country>();
        arrayList.add(new Country(R.drawable.ic_malaysia, "+60"));
        arrayList.add(new Country(R.drawable.ic_thailand, "+61"));
        arrayList.add(new Country(R.drawable.ic_singapore, "+62"));
        CountryAdapter adapter = new CountryAdapter(SignUpActivity.this, R.layout.item_country_current, arrayList);
        spnnerPhoneNumber.setAdapter(adapter);

        spnnerPhoneNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Country country;
                country = (Country) arrayList.get(position);
                NumberCode = country.getCode();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
