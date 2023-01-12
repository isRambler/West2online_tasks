import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.zip.GZIPInputStream;

public class Get3d {
    //    https://devapi.qweather.com/v7/weather/3d?key=a5fc325000ca414b95008836a833259d&location=101230101
    public static void doGetWeather(String qUrl,String city){
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        String no=null;
        String date_1=null;
        String tempMax_1=null;
        String tempMin_1=null;
        String textDay_1=null;
        String date_2=null;
        String tempMax_2=null;
        String tempMin_2=null;
        String textDay_2=null;
        String date_3=null;
        String tempMax_3=null;
        String tempMin_3=null;
        String textDay_3=null;
        Connection connection=null;
        PreparedStatement st=null;

        try {

            URL url = new URL(qUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(1000);
            conn.setConnectTimeout(1000);
            conn.setRequestProperty("accept" , "*/*");
            conn.setRequestProperty("contentType", "application/json;charset=utf-8");


            is = new GZIPInputStream(conn.getInputStream());
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JSONObject jsonObject=JSONObject.fromObject(sb.toString());
        JSONArray jsonArray=jsonObject.getJSONArray("daily");
        JSONObject day_1=jsonArray.getJSONObject(0);
        JSONObject day_2=jsonArray.getJSONObject(1);
        JSONObject day_3=jsonArray.getJSONObject(2);
        date_1=day_1.getString("fxDate");
        tempMax_1=day_1.getString("tempMax");
        tempMin_1=day_1.getString("tempMin");
        textDay_1=day_1.getString("textDay");
        date_2=day_2.getString("fxDate");
        tempMax_2=day_2.getString("tempMax");
        tempMin_2=day_2.getString("tempMin");
        textDay_2=day_2.getString("textDay");
        date_3=day_3.getString("fxDate");
        tempMax_3=day_3.getString("tempMax");
        tempMin_3=day_3.getString("tempMin");
        textDay_3=day_3.getString("textDay");

        try {
            connection=JdbcUtils.getConnection();
            String sql="update weather_3d set date_1=?,tempmax_1=?,tempmin_1=?,textday_1=?,date_2=?,tempmax_2=?,tempmin_2=?,textday_2=?,date_3=?,tempmax_3=?,tempmin_3=?,textday_3=? where no=?";
            st=connection.prepareStatement(sql);
            if (city.equals("fuzhou")){
                no="1";
            } else if (city.equals("beijing")) {
                no="2";
            } else if (city.equals("shanghai")) {
                no="3";
            }
            st.setString(1,date_1);
            st.setString(2,tempMax_1);
            st.setString(3,tempMin_1);
            st.setString(4,textDay_1);
            st.setString(5,date_2);
            st.setString(6,tempMax_2);
            st.setString(7,tempMin_2);
            st.setString(8,textDay_2);
            st.setString(9,date_3);
            st.setString(10,tempMax_3);
            st.setString(11,tempMin_3);
            st.setString(12,textDay_3);
            st.setString(13,no);
            int i=st.executeUpdate();
            if (i>0){
                System.out.println("正在为你查询。。。");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(connection,st,null);
        }
    }
}
