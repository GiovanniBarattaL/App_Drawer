package br.sp.etec.sebrae.appdrawer

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val menu = findViewById<NavigationView>(R.id.navigationview)
        val texto = findViewById<TextView>(R.id.txtconteudo)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        toolbar.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        menu.setNavigationItemSelectedListener {
            item -> when (item.itemId) {
                R.id.menu_inicio -> {
                    texto.text = "Tela Inicial"
                }
                R.id.menu_perfil -> {
                    texto.text = "Meu Perfil"
                }
                R.id.menuconfiguracao -> {
                    texto.text = "Configurações"
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }
}
