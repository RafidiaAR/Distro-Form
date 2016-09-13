package id.sch.smktelkom_mlg.tugas01.xirpl1028.orderyourchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etname, etadrs, etnmbr,etamnt;
    Button bOK, bOR;
    TextView tvhasil1,tvhasil2,tvhasil3,tvhasil4;
    CheckBox cb1,cb2,cb3,cb4;
    RadioButton rbG,rbR,rbB,rbDB;
    RadioGroup rgstatus;
    Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.name);
        etadrs = (EditText) findViewById(R.id.address);
        etnmbr = (EditText) findViewById(R.id.number);
        etamnt = (EditText) findViewById(R.id.jmlh);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvhasil1 = (TextView) findViewById(R.id.hasil1);
        tvhasil2 = (TextView) findViewById(R.id.hasil2);
        tvhasil3 = (TextView) findViewById(R.id.hasil3);
        tvhasil4 = (TextView) findViewById(R.id.hasil4);
        cb1 = (CheckBox) findViewById(R.id.shs);
        cb2 = (CheckBox) findViewById(R.id.jck);
        cb3 = (CheckBox) findViewById(R.id.hd);
        cb4 = (CheckBox) findViewById(R.id.sws);
        rbG = (RadioButton) findViewById(R.id.gre);
        rbB = (RadioButton) findViewById(R.id.blk);
        rbR = (RadioButton) findViewById(R.id.rd);
        rbDB = (RadioButton) findViewById(R.id.db);
        rgstatus = (RadioGroup) findViewById(R.id.radiogro);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        bOR = (Button) findViewById(R.id.buttonorder);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                doProcess();

            }
        });

        findViewById(R.id.buttonorder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doProcess() {

        if (isvalid())
        {
        String name = etname.getText().toString();
        String adrs = etadrs.getText().toString();
        String nmbr = etnmbr.getText().toString();
        tvhasil1.setText("Name : "+name + "\n"+ "Addresss :"+ adrs + "\n" + "ID Card Number" + nmbr);
        }
}
    private boolean isvalid() {
        String name = etname.getText().toString();
        String adrs = etadrs.getText().toString();
        String nmbr = etnmbr.getText().toString();

        boolean valid=true;

        if(name.isEmpty()){
            etname.setError("Fill Your Name First");
            valid = false;
        }
        else if(name.length()<5){
            etname.setError("Minimum Consist of 5 Character");
            valid = false;
        }
        else
        {
            etname.setError(null);
        }
        if(adrs.isEmpty()){
            etadrs.setError("Fill Your Address First");
        }
        else{
            etadrs.setError(null);
        }
        if(nmbr.isEmpty()){
            etnmbr.setError("Fill Your Number ID Card First");
        }
        else if(nmbr.length() != 5 ){
            etnmbr.setError("Number Consist of 5 Character");
            valid = false;
        }
        else{
            etnmbr.setError(null);
        }
        return valid;
    }
    private void doClick() {
        String hasil = "Produk yang Anda Pilih :\n";
        int starlen = hasil.length();
        if(cb1.isChecked()) hasil+=cb1.getText()+"\n";
        if(cb2.isChecked()) hasil+=cb2.getText()+"\n";
        if(cb3.isChecked()) hasil+=cb3.getText()+"\n";
        if(cb4.isChecked()) hasil+=cb4.getText()+"\n";

        if(hasil.length()==starlen) hasil+="Tidak ada pada pilihan";
        tvhasil2.setText(hasil);

        String hasil3= null;
        if(rgstatus.getCheckedRadioButtonId() !=-1)
        {
            RadioButton rb=(RadioButton)
                    findViewById(rgstatus.getCheckedRadioButtonId());
            hasil3 = rb.getText().toString();
        }

        if(hasil3 == null){
            tvhasil3.setText("Anda Belum Memilih Warna");
        }
        else{
            tvhasil3.setText("Warna Yang Anda Pilih : "+ hasil3);
        }


        String jmlh = etamnt.getText().toString();
        tvhasil4.setText("Ukuran Anda : "+sp1.getSelectedItem().toString() + "\n" + "Jumlah Produk dipesan : "+ jmlh +"Pcs");
    }

}
