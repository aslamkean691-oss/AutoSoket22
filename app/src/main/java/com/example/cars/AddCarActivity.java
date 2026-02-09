package com.example.cars;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cars.Hellper.DALAppWriteConnection;
import com.example.cars.model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AddCarActivity extends AppCompatActivity {

    private static final String[] HAND_NUMBERS = {"יד ראשונה", "יד שנייה", "יד שלישית", "יד רביעית", "יד חמישית",
            "יד שישית", "יד שביעית", "יד שמינית", "יד תשיעית", "יד עשירית"};

    private DALAppWriteConnection dal;
    private final Executor background = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        dal = new DALAppWriteConnection(this);

        // סוג רכב
        String[] carTypes = {"ב.מ.וו", "אאודי", "מרצדס", "טויוטה", "ניסאן", "יונדאי", "קיה", "פולקסווגן", "שברולט",
                "פורד", "סובארו", "מאזדה", "סיאט", "סקודה", "רנו", "פיג׳ו", "סיטרואן", "סוזוקי", "מיצובישי",
                "מיני", "סמארט", "לנד רובר", "ג׳יפ", "פיאט", "אלפא רומיאו", "אופל", "דייהטסו"};
        AutoCompleteTextView etType = findViewById(R.id.etType);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, carTypes);
        etType.setAdapter(typeAdapter);
        etType.setThreshold(1);

        // צבע
        String[] colors = {"לבן", "שחור", "אפור", "כסוף", "אדום", "כחול", "ירוק", "צהוב", "כתום", "חום", "בז'", "סגול", "זהב", "בורדו", "טורקיז"};
        AutoCompleteTextView etColor = findViewById(R.id.etColor);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, colors);
        etColor.setAdapter(colorAdapter);
        etColor.setThreshold(1);

        // סוג יד
        String[] ownerships = {"פרטי", "ליסינג", "השכרה", "מונית", "מדינה"};
        AutoCompleteTextView etOwnership = findViewById(R.id.etOwnership);
        ArrayAdapter<String> ownerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, ownerships);
        etOwnership.setAdapter(ownerAdapter);
        etOwnership.setThreshold(1);

        // איזה יד עד 10
        AutoCompleteTextView etHandNumber = findViewById(R.id.etHandNumber);
        ArrayAdapter<String> handAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, HAND_NUMBERS);
        etHandNumber.setAdapter(handAdapter);
        etHandNumber.setThreshold(1);

        // איזה שנה (الأحدث أولاً)
        List<String> yearsList = new ArrayList<>();
        for (int i = 2035; i >= 1990; i--) yearsList.add(String.valueOf(i));
        AutoCompleteTextView etYear = findViewById(R.id.etYear);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, yearsList);
        etYear.setAdapter(yearAdapter);
        etYear.setThreshold(1);

        // أشهر
        String[] months = {"ינואר", "פברואר", "מרץ", "אפריל", "מאי", "יוני", "יולי", "אוגוסט", "ספטמבר", "אוקטובר", "נובמבר", "דצמבר"};

        // תאריך עלייה לגביש
        AutoCompleteTextView etMonth = findViewById(R.id.etMonth);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, months);
        etMonth.setAdapter(monthAdapter);
        etMonth.setThreshold(1);

        AutoCompleteTextView etMonthYear = findViewById(R.id.etMonthYear);
        ArrayAdapter<String> monthYearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, yearsList);
        etMonthYear.setAdapter(monthYearAdapter);
        etMonthYear.setThreshold(1);

        // טסט עד
        AutoCompleteTextView etTestMonth = findViewById(R.id.etTestMonth);
        etTestMonth.setAdapter(monthAdapter);
        etTestMonth.setThreshold(1);

        AutoCompleteTextView etTestYear = findViewById(R.id.etTestYear);
        etTestYear.setAdapter(monthYearAdapter);
        etTestYear.setThreshold(1);

        Button btnAddCar = findViewById(R.id.btnAddCar);
        btnAddCar.setOnClickListener(v -> saveCarToAppwrite(btnAddCar,
                (AutoCompleteTextView) findViewById(R.id.etType),
                (AutoCompleteTextView) findViewById(R.id.etColor),
                (AutoCompleteTextView) findViewById(R.id.etOwnership),
                (AutoCompleteTextView) findViewById(R.id.etHandNumber),
                (AutoCompleteTextView) findViewById(R.id.etYear),
                (AutoCompleteTextView) findViewById(R.id.etMonth),
                (AutoCompleteTextView) findViewById(R.id.etMonthYear),
                (AutoCompleteTextView) findViewById(R.id.etTestMonth),
                (AutoCompleteTextView) findViewById(R.id.etTestYear),
                (EditText) findViewById(R.id.etKm),
                (EditText) findViewById(R.id.etMekhiron),
                (EditText) findViewById(R.id.etPrice)
        ));
    }

    private void saveCarToAppwrite(
            Button btnAddCar,
            AutoCompleteTextView etType,
            AutoCompleteTextView etColor,
            AutoCompleteTextView etOwnership,
            AutoCompleteTextView etHandNumber,
            AutoCompleteTextView etYear,
            AutoCompleteTextView etMonth,
            AutoCompleteTextView etMonthYear,
            AutoCompleteTextView etTestMonth,
            AutoCompleteTextView etTestYear,
            EditText etKm,
            EditText etMekhiron,
            EditText etPrice
    ) {

        String type = etType.getText() != null ? etType.getText().toString().trim() : "";
        String color = etColor.getText() != null ? etColor.getText().toString().trim() : "";
        if (TextUtils.isEmpty(type) || TextUtils.isEmpty(color)) {
            Toast.makeText(this, "נא למלא סוג רכב וצבע", Toast.LENGTH_SHORT).show();
            return;
        }

        String ownership = etOwnership.getText() != null ? etOwnership.getText().toString().trim() : "";
        String handText = etHandNumber.getText() != null ? etHandNumber.getText().toString().trim() : "";
        int hands = 1;
        for (int i = 0; i < HAND_NUMBERS.length; i++) {
            if (HAND_NUMBERS[i].equals(handText)) {
                hands = i + 1;
                break;
            }
        }

        String year = etYear.getText() != null ? etYear.getText().toString().trim() : "";
        String month = etMonth.getText() != null ? etMonth.getText().toString().trim() : "";
        String monthYear = etMonthYear.getText() != null ? etMonthYear.getText().toString().trim() : "";
        String registrationDate = (month.isEmpty() || monthYear.isEmpty()) ? "" : month + "/" + monthYear;

        String testMonth = etTestMonth.getText() != null ? etTestMonth.getText().toString().trim() : "";
        String testYear = etTestYear.getText() != null ? etTestYear.getText().toString().trim() : "";
        String testDate = (testMonth.isEmpty() || testYear.isEmpty()) ? "" : testMonth + "/" + testYear;

        int kms = 0;
        try {
            String kmStr = etKm.getText() != null ? etKm.getText().toString().trim() : "";
            if (!kmStr.isEmpty()) kms = Integer.parseInt(kmStr);
        } catch (NumberFormatException ignored) {}

        double priceList = 0;
        double price = 0;
        try {
            String mekhironStr = etMekhiron.getText() != null ? etMekhiron.getText().toString().trim() : "";
            if (!mekhironStr.isEmpty()) priceList = Double.parseDouble(mekhironStr);
        } catch (NumberFormatException ignored) {}
        try {
            String priceStr = etPrice.getText() != null ? etPrice.getText().toString().trim() : "";
            if (!priceStr.isEmpty()) price = Double.parseDouble(priceStr);
        } catch (NumberFormatException ignored) {}

        car carItem = new car(type, year, registrationDate, testDate, color, kms, hands, ownership, priceList, price);

        btnAddCar.setEnabled(false);
        background.execute(() -> {
            DALAppWriteConnection.OperationResult<ArrayList<car>> result = dal.saveData(carItem, "cars", null);
            runOnUiThread(() -> {
                btnAddCar.setEnabled(true);
                if (result != null && result.success) {
                    Toast.makeText(AddCarActivity.this, "הרכב נוסף בהצלחה", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    String msg = (result != null && result.message != null) ? result.message : "שגיאה בשמירה";
                    Toast.makeText(AddCarActivity.this, msg, Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}

