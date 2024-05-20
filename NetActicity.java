package com.example.activity;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTask extends AsyncTask<String, Void, String> {

    private static final String TAG = "NetworkTask";

    @Override
    protected String doInBackground(String... urls) {
        if (urls.length == 0) {
            return null;
        }

        String urlString = urls[0];
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String response = null;

        try {
            // 创建URL对象
            URL url = new URL(urlString);

            // 打开连接
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // 获取输入流
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            if (inputStream == null) {
                return null;
            }

            // 读取输入流
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            if (builder.length() == 0) {
                return null;
            }
            response = builder.toString();
        } catch (IOException e) {
            Log.e(TAG, "Error ", e);
            return null;
        } finally {
            // 关闭连接和流
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            // 在此处处理返回的数据
            Log.d(TAG, "Response: " + result);
        }
    }
}