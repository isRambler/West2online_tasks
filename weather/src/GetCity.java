import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.zip.GZIPInputStream;

public class GetCity {
////    https://geoapi.qweather.com/v2/city/lookup?key=a5fc325000ca414b95008836a833259d&location=福州
//    URL url;
//
//    public void getFz(){
//        try {
//            url = new URL("https://geoapi.qweather.com/v2/city/lookup?key=a5fc325000ca414b95008836a833259d&location=fuzhou");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
////            获取输入流并转化为String类
//            try{
//                InputStream in=connection.getInputStream();
//                BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
//                StringBuilder response=new StringBuilder();
//                String line;
//                while((line= reader.readLine())!=null){
//                    response.append(line).append("\r\n");
//                }
//                System.out.println(response);
//                reader.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                if (connection!=null){
//                    connection.disconnect();
//                }
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }


    public static void doGet(String qUrl,String city){

        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        String no=null;
        String id=null;
        String name=null;
        String lat=null;
        String lon=null;
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
        JSONArray jsonArray=jsonObject.getJSONArray("location");
        JSONObject allJsonObject=jsonArray.getJSONObject(0);
        name=allJsonObject.getString("name");
        id=allJsonObject.getString("id");
        lat=allJsonObject.getString("lat");
        lon=allJsonObject.getString("lon");

//        将获取的数据读入数据库
        try {
            connection=JdbcUtils.getConnection();
            String sql="update city set id=?,name=?,lat=?,lon=? where no=?";
            st=connection.prepareStatement(sql);
            if(city.equals("fuzhou")){
                no="1";
            } else if (city.equals("beijing")) {
                no="2";
            } else if (city.equals("shanghai")) {
                no="3";
            }
            st.setString(1,id);
            st.setString(2,name);
            st.setString(3,lat);
            st.setString(4,lon);
            st.setString(5,no);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("正在为你查询。。。");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(connection,st,null);
        }

    }


}
