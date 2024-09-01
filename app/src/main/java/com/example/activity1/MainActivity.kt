package com.example.activity1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText



class MainActivity : AppCompatActivity() {

    val egyptpound = "EGP"
    val americandollar = "USD"
    val euro = "EURO"
    val SR = "SAUDI RIAL"
    val UAE = "U.A.E"

    var values = mapOf(
        egyptpound to 48.80 ,
        americandollar to 1 ,
        euro to 1.08 ,
        SR to 3.8460 ,
        UAE to 3.7644
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var convertbtn: Button = findViewById(R.id.convert_button)
        val entramount :TextInputEditText = findViewById(R.id.Enter_Amount)
        val resultno : TextInputEditText = findViewById(R.id.result_Amount)

        val tomenu : AutoCompleteTextView = findViewById(R.id.egypt_pound)
        val frommenu : AutoCompleteTextView = findViewById(R.id.dollar_1)

        val currencylist = listOf(egyptpound,americandollar,euro,SR,UAE)
        val adapter = ArrayAdapter(this,R.layout.to_currency_list,currencylist)
        frommenu.setAdapter(adapter)
        tomenu.setAdapter(adapter)




        convertbtn.setOnClickListener {
            Toast.makeText(this,"converting",Toast.LENGTH_LONG).show()

            var amount = entramount.text.toString().toDouble()
            var tocurrmenu = values [tomenu.text.toString()] as? Number
            var fromcurrmenu = values [frommenu.text.toString()] as? Number



            if (tocurrmenu != null && fromcurrmenu != null) {
                val result = tocurrmenu.toDouble() / fromcurrmenu.toDouble()
                resultno.setText(result.toString())
                println("Result of division: $result")
            } else {
                println("One of the values is null or not a number.")
                }

        }
    }
}