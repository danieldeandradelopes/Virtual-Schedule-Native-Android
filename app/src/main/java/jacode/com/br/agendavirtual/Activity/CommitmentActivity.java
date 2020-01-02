package jacode.com.br.agendavirtual.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import jacode.com.br.agendavirtual.Entidades.Commitment;
import jacode.com.br.agendavirtual.Entidades.User;
import jacode.com.br.agendavirtual.Helper.MaskEditText;
import jacode.com.br.agendavirtual.R;

public class CommitmentActivity extends AppCompatActivity {

    private BootstrapEditText edtName;
    private BootstrapEditText edtDescription;
    private BootstrapEditText edtDate;

    private BootstrapButton btnInsert;
    private BootstrapButton btnCancel;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser userAuth;

    private Commitment commitment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compromissos);

        database = FirebaseDatabase.getInstance();

        edtName = (BootstrapEditText) findViewById(R.id.edtName);
        edtDescription = (BootstrapEditText) findViewById(R.id.edtDescription);
        edtDate = (BootstrapEditText) findViewById(R.id.edtDate);

        edtDate.addTextChangedListener(MaskEditText.mask(edtDate, MaskEditText.FORMAT_DATE));

        btnInsert = (BootstrapButton) findViewById(R.id.btnInsert);
        btnCancel = (BootstrapButton) findViewById(R.id.btnCancel);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userAuth = FirebaseAuth.getInstance().getCurrentUser();
                String uid = userAuth.getUid();

                commitment = new Commitment();
                commitment.setName(edtName.getText().toString());
                commitment.setDescription(edtDescription.getText().toString());
                commitment.setDate(edtDate.getText().toString());
                commitment.setStatus("Pendente");
                commitment.setUid(uid);

                inserirCompromissoDatabase(commitment);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void inserirCompromissoDatabase(Commitment commitment) {

        myRef = database.getReference("commitment");

        String key = myRef.child("commitment").push().getKey();

        commitment.setKeyCommitment(key);

        myRef.child(key).setValue(commitment);

        Toast.makeText(this, "Compromisso Agendado!", Toast.LENGTH_SHORT).show();

        finish();
    }
}
