import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class desk {
    public static void show(){
//        101010100,北京,北京,北京
//        101020100,上海,上海,上海
//        101230101,福州,福州,福建
        String cityName=null;
        String cityId=null;
        String url_getCity_1="https://geoapi.qweather.com/v2/city/lookup?key=a5fc325000ca414b95008836a833259d&location=";
        String url_getCity_2;
        String url_get3d_1="https://devapi.qweather.com/v7/weather/3d?key=a5fc325000ca414b95008836a833259d&location=";
        String url_get3d_2;
        Scanner scanner = new Scanner(System.in);
        GetCity getCity = new GetCity();
        Get3d get3d = new Get3d();
        Connection connection=null;
        PreparedStatement st=null;
        ResultSet rs_city=null;
        ResultSet rs_weather=null;
        String no=null;
        String judge=null;

        while (true){
            System.out.println("=============天气查询系统=============");
            System.out.println("请输入你想查询的城市的拼音（例 福州：fuzhou）");
            System.out.println("（本系统暂时只支持查询北京、上海和福州的信息）");
            cityName=scanner.next();
            url_getCity_2=url_getCity_1+cityName;
            if(cityName.equals("fuzhou")){
                cityId="101230101";
                no="1";
            } else if (cityName.equals("beijing")) {
                cityId="101010100";
                no="2";
            } else if (cityName.equals("shanghai")) {
                cityId="101020100";
                no="3";
            }
            url_get3d_2=url_get3d_1+cityId;
            getCity.doGet(url_getCity_2,cityName);
            get3d.doGetWeather(url_get3d_2,cityName);

            try {
                connection=JdbcUtils.getConnection();
                String sql_city="select * from city where no=?";
                st=connection.prepareStatement(sql_city);
                st.setString(1,no);
                rs_city=st.executeQuery();
                if(rs_city.next()){
                    System.out.println("所查城市：" +rs_city.getObject("name")+" "+
                                        "id:"+rs_city.getObject("id")+" "+
                                        "纬度为："+rs_city.getObject("lat")+" "+
                                        "经度为："+rs_city.getObject("lon")
                                        );
                }
                String sql_weather="select * from weather_3d where no=?";
                st=connection.prepareStatement(sql_weather);
                st.setString(1,no);
                rs_weather= st.executeQuery();
                if (rs_weather.next())
                {
                    System.out.println("今日为："+rs_weather.getObject("date_1")+" "+
                                        "今日最高气温为："+rs_weather.getObject("tempmax_1")+" "+
                                        "今日最低气温为："+rs_weather.getObject("tempmin_1")+" "+
                                        "今天"+rs_weather.getObject("textday_1")+"哦！"+"\n"+
                                        "明日最高气温为："+rs_weather.getObject("tempmax_2")+" "+
                                        "明日最低气温为："+rs_weather.getObject("tempmin_2")+" "+
                                        "明天"+rs_weather.getObject("textday_2")+"哦！"+"\n"+
                                        "后天最高气温为："+rs_weather.getObject("tempmax_3")+" "+
                                        "后天最低气温为："+rs_weather.getObject("tempmin_3")+" "+
                                        "后天"+ rs_weather.getObject("textday_3")+"哦！"+"\n"+
                                        "无论天气如何，希望你依然拥有好心情！"
                                        );
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                JdbcUtils.release(connection,st,rs_city);
                JdbcUtils.release(connection,st,rs_weather);
            }

            System.out.println("是否想要继续使用本系统？（y/n）");
            judge=scanner.next();
            if (judge.equals("y")){
                continue;
            }else {
                System.out.println("感谢使用，再见！");
                break;
            }

        }

        scanner.close();
    }
}
