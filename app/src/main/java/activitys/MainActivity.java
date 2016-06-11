package activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asus.newmodeofhealthbulter.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import activitys.HealthRecordActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btn_health_recode,btn_self_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_health_recode=(Button)findViewById(R.id.btn_health_record);
        btn_self_center=(Button)findViewById(R.id.btn_self_center);
        btn_health_recode.setOnClickListener(this);
        btn_self_center.setOnClickListener(this);

        copyDataBase("health_bulter.db");
    }

    @Override
    public void onClick(View v) {
        if(btn_self_center.getId()==v.getId()){
            //个人中心
        }
        else if(btn_health_recode.getId()==v.getId()){
            //健康档案
            startActivity(new Intent(this, HealthRecordActivity.class));
        }
    }


    /**
     * 将assets文件夹下的数据库拷贝到相应路径中并加载
     * @param dbName
     */
    private void copyDataBase(String dbName){
        File file=new File(getFilesDir(),dbName);
        if(file.exists()){
            return;
        }

        InputStream in=getClass().getClassLoader().getResourceAsStream("assets/" + dbName);
        FileOutputStream fout=null;
        try {
            fout=new FileOutputStream(file);
            int len=0;
            byte[] b=new byte[1024];
            while((len=in.read(b))!=-1){
                fout.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
