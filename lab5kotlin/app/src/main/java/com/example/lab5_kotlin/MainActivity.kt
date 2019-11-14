package com.example.lab5_kotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener(View.OnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

            dialog.setNeutralButton(
                "取消"
            ) { dialog, which ->
                Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show()
            }

            dialog.setNegativeButton(
                "自定義Toast"
            ) { dialog, i -> showToast() }

            dialog.setPositiveButton(
                "顯示List"
            ) { dialog, i -> showListDialog() }
            dialog.show()
        })
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater = layoutInflater
        val layout =
           inflater.inflate(R.layout.custom_toast,custom_toast_root)
        toast.view = layout

        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")

        dialog_list.setItems(
            list
        ) { dialog, i ->
            Toast.makeText(this@MainActivity, "你選擇是" + list[i], Toast.LENGTH_SHORT).show()
        }
        dialog_list.show()
    }

}
