package kr.ac.kopo.contextmenu2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var linear :
            LinearLayout
    lateinit var btnLinear :
            Button
    lateinit var btnRotation :
            Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linear = findViewById<LinearLayout>(R.id.linear)
        btnLinear = findViewById<Button>(R.id.btnLinearBg)
        btnRotation = findViewById<Button(R.id.btnRotation)

        registerForContextMenu(btnLinear)
        registerForContextMenu(btnRotation)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var menuInflater = this.menuInflater

        if(v == btnLinear) {
            menu!!.setHeaderTitle("배경색 변경") // 코틀린은 null값 허용 안한다. 허나 null값을 허용해야 하는 순간에는 !!를 사용한다.
            menuInflater.inflate(R.menu.menu_context, menu) //menu_context를 menu context에 등록해준다는 의미
        }

        if(v == btnLinear) {
            menu!!.setHeaderTitle("버튼 회전 및 확대") // 코틀린은 null값 허용 안한다. 허나 null값을 허용해야 하는 순간에는 !!를 사용한다.
            menuInflater.inflate(R.menu.menu2_context, menu) //menu2_context를 menu context에 등록해준다는 의미
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itemRed -> {
                // R.id.itemRed와 같을경우 중괄호 안에 작성
                linear.setBackgroundColor(color.RED)
                return true
            }

            R.id.itemYellow -> {
                // R.id.itemRed와 같을경우 중괄호 안에 작성
                linear.setBackgroundColor(color.YELLOW)
                return true
            }

            R.id.itemMagenta -> {
                // R.id.itemRed와 같을경우 중괄호 안에 작성
                linear.setBackgroundColor(color.MAGENTA)
                return true
            }

            R.id.itemRotation -> {
                // R.id.itemRed와 같을경우 중괄호 안에 작성
                btnRotation.rotation = 90f
                return true
            }

            R.id.itemRedZoomin -> {
                // R.id.itemRed와 같을경우 중괄호 안에 작성
                btnRotation.scoleX = 2f
                btnRotation.scloeY = 2f
                return true
            }

            R.id.itemRedZoomOriginal -> {
                // R.id.itemRed와 같을경우 중괄호 안에 작성
                btnRotation.scoleX = 1f
                btnRotation.scloeY = 1f
                return true
            }
        }



        return false
    }
}