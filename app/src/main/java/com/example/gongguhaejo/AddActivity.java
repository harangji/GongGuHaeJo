package com.example.gongguhaejo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    private ArrayAdapter<CharSequence> adapter;  // adapter 변수를 클래스 레벨로 이동
    private EditText et_rest_name;
    private Spinner spinner_foodcate;
    private EditText et_food_deliveryprice;
    private Button btn_save;

    private ImageView img_food;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("GongguList");

        // Firebase database reference
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                AddActivity.this,
                R.array.food_categories,
                android.R.layout.simple_spinner_dropdown_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_foodcate = findViewById(R.id.spinner_foodcate);
        spinner_foodcate.setAdapter(adapter);

        // Initialize views
        et_rest_name = findViewById(R.id.et_restname);
        spinner_foodcate = findViewById(R.id.spinner_foodcate);
        et_food_deliveryprice = findViewById(R.id.et_fooddeliveryprice);
        btn_save = findViewById(R.id.btn_save);
        // Save button click listener
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGongguList();
            }
        });
    }

    private void saveGongguList() {
        // 사용자가 입력한 데이터 가져오기
        String restName = et_rest_name.getText().toString().trim();
        String foodKate = spinner_foodcate.getSelectedItem().toString().trim();
        int deliveryPrice = Integer.parseInt(et_food_deliveryprice.getText().toString().trim());

        // 데이터베이스에 저장할 GongguList 객체 생성
        GongguList gongguList = new GongguList();
        gongguList.setRest_name(restName);
        gongguList.setFood_cate(foodKate);
        gongguList.setFood_deliveryprice(deliveryPrice);

        // Firebase 데이터베이스에 객체 저장
        String key = databaseReference.child("GongguList").push().getKey(); // 고유한 키 생성
        databaseReference.child("GongguList").child(key).setValue(gongguList);

        // 저장 후 현재 Activity 종료
        finish();
    }
}
