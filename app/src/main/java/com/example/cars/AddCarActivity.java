package com.example.cars;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AddCarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

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
        String[] handNumbers = {"יד ראשונה", "יד שנייה", "יד שלישית", "יד רביעית", "יד חמישית",
                "יד שישית", "יד שביעית", "יד שמינית", "יד תשיעית", "יד עשירית"};
        AutoCompleteTextView etHandNumber = findViewById(R.id.etHandNumber);
        ArrayAdapter<String> handAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, handNumbers);
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
    }
}

