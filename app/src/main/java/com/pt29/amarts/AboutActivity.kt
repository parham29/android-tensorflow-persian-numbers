package com.pt29.amarts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val versionElement = Element()
        versionElement.setTitle("کتابخانه های استفاده شده:")

        val versionElement1 = Element()
        versionElement1.setTitle("tensorflow-android v1.7.0")

        val versionElement2 = Element()
        versionElement2.setTitle("autofittextview v0.2.1")

        val versionElement3 = Element()
        versionElement3.setTitle("filechooser v1.1.10")

        val aboutPage = AboutPage(this)
                .isRTL(true)
                .setImage(R.drawable.ts)
                .setDescription("نرم افزار نگاره پرداز\n" +
                        "قابلیت تشخیص اعداد از روی عکس به کمک Tensorflow\n" +
                        "با زبان برنامه نویسی kotlin\n" +
                        "توسعه دهندگان:\n پرهام طالبیان - 9313231112\n" +
                        "احمد کمال آبادی - 9313231118")
                .addItem(versionElement)
                .addItem(versionElement1)
                .addItem(versionElement2)
                .addGroup("تماس با ما")
                .addEmail("pt2902@gmail.com")
                .create()
        setContentView(aboutPage)
    }
}
