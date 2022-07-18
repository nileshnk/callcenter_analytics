package Kapture_crm;
import java.sql.*;

public class Kapture_crm {

    public static void main(String[] args) {
 
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kapture_crm","root","");
            System.out.println("Connection created");
            String query = "WITH caller as (\n" +
                            "select id, from_number, \n" +
                            "date_format(str_to_date(start_time,'%d/%m/%Y %H:%i:%s'), '%Y-%m-%d %H:%i:%s') AS start_time,\n" +
                            "date_format(str_to_date(start_time,'%d/%m/%Y %H:%i:%s'), '%W') AS day_of_week,\n" +
                            "date_format(str_to_date(end_time,'%d/%m/%Y %H:%i:%s'), '%Y-%m-%d %H:%i:%s') AS end_time, duration\n" +
                            "from call_center\n" +
                            "),\n" +
                            "\n" +
                            "call_volume as (\n" +
                            "SELECT extract(hour from start_time) as start_hour,day_of_week, count(*) as volume from caller group by start_hour, day_of_week order by volume desc limit 1 ),\n" +
                            "\n" +
                            "duration_call as (\n" +
                            "SELECT extract(hour from start_time) as start_hour,day_of_week, sum(duration) as call_duration from caller group by start_hour, day_of_week order by duration desc limit 1 )\n" +
                            "\n" +
                            "\n" +
                            "select *,\n" +
                            "case when start_hour < 12 then concat(start_hour, \"-\", (start_hour + 1), \" AM\")\n" +
                            "else concat(start_hour, \"-\", (start_hour + 1), \" PM\")\n" +
                            "end as hour_of_day from call_volume;";
            Statement st = con.createStatement();
            
            st.execute(query);
            ResultSet resultSet = st.executeQuery(query);
            
            String day_of_week="";
            String hour_of_day="";
            
            while(resultSet.next()) {
                hour_of_day = resultSet.getString("hour_of_day");
                day_of_week = resultSet.getString("day_of_week");
            }
            
            System.out.println("Hour of the day when call volume is highest is "+hour_of_day);
            System.out.println("Day of the week when the call volume is highest is "+day_of_week);
            
            String query2 = "WITH caller as (\n" +
                            "select id, from_number, \n" +
                            "date_format(str_to_date(start_time,'%d/%m/%Y %H:%i:%s'), '%Y-%m-%d %H:%i:%s') AS start_time,\n" +
                            "date_format(str_to_date(start_time,'%d/%m/%Y %H:%i:%s'), '%W') AS day_of_week,\n" +
                            "date_format(str_to_date(end_time,'%d/%m/%Y %H:%i:%s'), '%Y-%m-%d %H:%i:%s') AS end_time, duration\n" +
                            "from call_center\n" +
                            "),\n" +
                            "\n" +
                            "call_volume as (\n" +
                            "SELECT extract(hour from start_time) as start_hour,day_of_week, count(*) as volume from caller group by start_hour, day_of_week order by volume desc limit 1 ),\n" +
                            "\n" +
                            "duration_call as (\n" +
                            "SELECT extract(hour from start_time) as start_hour,day_of_week, sum(duration) as call_duration from caller group by start_hour, day_of_week order by duration desc limit 1 )\n" +
                            "\n" +
                            "select *,\n" +
                            "case when start_hour < 12 then concat(start_hour, \"-\", (start_hour + 1), \" AM\")\n" +
                            "else concat(start_hour, \"-\", (start_hour + 1), \" PM\")\n" +
                            "end as hour_of_day from duration_call;";
            st.execute(query2);
            
            ResultSet resultset2 = st.executeQuery(query2);
            
            String hour = "";
            String day = "";
            
            while(resultset2.next())
            {
                hour = resultset2.getString("hour_of_day");
                day = resultset2.getString("day_of_week");
            }
            
            System.out.println("Hour of the day when calls are longest is "+hour);
            System.out.println("Day of the week when the calls are longest is "+day);

                    }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }
    
}