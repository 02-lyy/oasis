package com.example.basemvvm.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.view.inputmethod.InputMethodManager
import androidx.core.content.FileProvider
import com.example.kotlinbase.BuildConfig
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

object SystemUtils {
    /**
     * 关闭键盘
     * @param context
     */
    fun closeSoftKeyBoard(context: Activity) {
        val view = context.window.peekDecorView()
        if (view != null) {
            val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * 打开键盘
     * @param context
     */
    fun openSoftKeyBoard(context: Activity) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    /**
     * 获取pg对应的版本号
     * @param pg
     * @return
     */
    @JvmStatic
    fun getApkVersionCodeByPg(context: Context, pg: String?): Long {
        var versionCode: Long = -1
        try {
            val packageInfo = context.packageManager.getPackageInfo(pg!!, 0)
            versionCode = packageInfo.longVersionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionCode
    }

    /**
     * 安装apk
     */
    fun installApk(context: Context, file: File?) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        if (Build.VERSION.SDK_INT >= 24) { // Android7.0及以上版本 Log.d("-->最新apk下载完毕","Android N及以上版本");
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            val contentUri = FileProvider.getUriForFile(context, BuildConfig.LIBRARY_PACKAGE_NAME + ".fileProvider", file!!)
            //参数二:应用包名+".fileProvider"(和步骤二中的Manifest文件中的provider节点下的authorities对应)
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive")
        } else {
            // Android7.0以下版本 Log.d("-->最新apk下载完毕","Android N以下版本");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }

    /**
     * 静默安装
     */
    @JvmStatic
    fun installNewApk(apkPath: String?): Boolean {
        var process: Process? = null
        var successResult: BufferedReader? = null
        var errorResult: BufferedReader? = null
        val successMsg = StringBuilder()
        val errorMsg = StringBuilder()
        try {
//            //7.0以前版本使用
//            process = new ProcessBuilder("pm", "install", "-r", apkPath).start();
            //7.0以后版本使用
            process = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                ProcessBuilder("pm", "install", "-r", apkPath).start()
            } else {
                ProcessBuilder("pm", "install", "-i", BuildConfig.LIBRARY_PACKAGE_NAME, "-r", apkPath).start()
            }
            successResult = BufferedReader(InputStreamReader(process.inputStream))
            errorResult = BufferedReader(InputStreamReader(process.errorStream))
            var s: String?
            while (successResult.readLine().also { s = it } != null) {
                successMsg.append(s)
            }
            while (errorResult.readLine().also { s = it } != null) {
                errorMsg.append(s)
            }
        } catch (e: Exception) {
        } finally {
            try {
                successResult?.close()
                errorResult?.close()
            } catch (e: Exception) {
            }
            process?.destroy()
        }

        //如果含有“success”单词则认为安装成功
        return successMsg.toString().equals("success", ignoreCase = true)
    }
}