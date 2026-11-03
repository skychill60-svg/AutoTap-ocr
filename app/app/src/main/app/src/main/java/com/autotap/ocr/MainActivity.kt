package com.autotap.ocr

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.provider.Settings
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private fun addText(
        layout: LinearLayout,
        text: String,
        size: Float
    ) {
        val view = TextView(this)
        view.text = text
        view.textSize = size
        view.gravity = Gravity.CENTER
        view.setPadding(12, 16, 12, 16)
        layout.addView(view)
    }

    private fun addButton(
        layout: LinearLayout,
        text: String,
        action: () -> Unit
    ) {
        val button = Button(this)
        button.text = text
        button.setOnClickListener { action() }
        layout.addView(
            button,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 24, 24, 24)

        addText(layout, "AutoTap OCR", 28f)
        addText(
            layout,
            "Pembaca huruf otomatis berdasarkan kotak target.",
            16f
        )

        addButton(layout, "Izin Tampilan Mengambang") {
            startActivity(
                Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION
                )
            )
        }

        addButton(layout, "Pengaturan Accessibility") {
            startActivity(
                Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            )
        }

        addText(
            layout,
            "Status: Persiapan aplikasi",
            14f
        )

        setContentView(layout)
    }
}
