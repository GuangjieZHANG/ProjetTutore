package com.example.ressources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private StudentGradeMessage sgm ;
	private Map<String, StudentGradeMessage> stuGradeMap ;
	private ArrayList<Pie> pie = new ArrayList<Pie>();
	private ArrayList<ClassMessage> cml = new ArrayList<ClassMessage>();
	private ClassMessage cm ;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private GraphicalView charView;
	private CalendarView cv;
	private LinearLayout layout;
	private FrameLayout fl;
	private Pie p;
	private Intent intent;
	private List<HashMap<String, StudentGradeMessage>> studentGradeList = new ArrayList<HashMap<String,StudentGradeMessage>>();
	private CategorySeries mSeries;
	private DefaultRenderer mRenderer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		btn5 = (Button) findViewById(R.id.button5);
		layout = (LinearLayout) findViewById(R.id.chart);
		fl = (FrameLayout) findViewById(R.id.fl);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		initData();
		

	}
	 @Override
	  protected void onRestoreInstanceState(Bundle savedState) {
	    super.onRestoreInstanceState(savedState);
	    mSeries = (CategorySeries) savedState.getSerializable("current_series");
	    mRenderer = (DefaultRenderer) savedState.getSerializable("current_renderer");
	  }

	  @Override
	  protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putSerializable("current_series", mSeries);
	    outState.putSerializable("current_renderer", mRenderer);
	  }
	private void initData() {
		// TODO Auto-generated method stub
		stuGradeMap = new HashMap<String, StudentGradeMessage>();
		sgm = new StudentGradeMessage();
		sgm.setName("1.1");
		sgm.setMath(80);
		sgm.setChinese(87);
		sgm.setEnglish(78);
		sgm.setTotal(248);
		sgm.setNumChinese(10);
		sgm.setNumEnglish(25);
		sgm.setNumMath(9);
		sgm.setNumTotal(12);
		stuGradeMap.put("name",sgm );
		studentGradeList.add((HashMap<String, StudentGradeMessage>) stuGradeMap);
		stuGradeMap = new HashMap<String, StudentGradeMessage>();
		sgm = new StudentGradeMessage();
		sgm.setName("1.2");
		sgm.setMath(67);
		sgm.setChinese(89);
		sgm.setEnglish(80);
		sgm.setTotal(236);
		sgm.setNumChinese(5);
		sgm.setNumEnglish(21);
		sgm.setNumMath(23);
		sgm.setNumTotal(16);
		stuGradeMap.put("name",sgm );
		studentGradeList.add((HashMap<String, StudentGradeMessage>) stuGradeMap);
		stuGradeMap = new HashMap<String, StudentGradeMessage>();
		sgm = new StudentGradeMessage();
		sgm.setName("1.3");
		sgm.setMath(50);
		sgm.setChinese(80);
		sgm.setEnglish(70);
		sgm.setTotal(200);
		sgm.setNumChinese(10);
		sgm.setNumEnglish(35);
		sgm.setNumMath(39);
		sgm.setNumTotal(29);
		stuGradeMap.put("name",sgm );
		studentGradeList.add((HashMap<String, StudentGradeMessage>) stuGradeMap);
		stuGradeMap = new HashMap<String, StudentGradeMessage>();
		sgm = new StudentGradeMessage();
		sgm.setName("1.4");
		sgm.setMath(60);
		sgm.setChinese(67);
		sgm.setEnglish(60);
		sgm.setTotal(187);
		sgm.setNumChinese(40);
		sgm.setNumEnglish(30);
		sgm.setNumMath(30);
		sgm.setNumTotal(40);
		stuGradeMap.put("name",sgm );
		studentGradeList.add((HashMap<String, StudentGradeMessage>) stuGradeMap);
		stuGradeMap = new HashMap<String, StudentGradeMessage>();
		sgm = new StudentGradeMessage();
		sgm.setName("1.5");
		sgm.setMath(80);
		sgm.setChinese(87);
		sgm.setEnglish(88);
		sgm.setTotal(258);
		sgm.setNumChinese(9);
		sgm.setNumEnglish(7);
		sgm.setNumMath(13);
		sgm.setNumTotal(14);
		stuGradeMap.put("name",sgm );
		studentGradeList.add((HashMap<String, StudentGradeMessage>) stuGradeMap);
		stuGradeMap = new HashMap<String, StudentGradeMessage>();
		sgm = new StudentGradeMessage();
		sgm.setName("1.6");
		sgm.setMath(90);
		sgm.setChinese(80);
		sgm.setEnglish(50);
		sgm.setTotal(220);
		sgm.setNumChinese(10);
		sgm.setNumEnglish(35);
		sgm.setNumMath(2);
		sgm.setNumTotal(21);
		stuGradeMap.put("name",sgm );
		studentGradeList.add((HashMap<String, StudentGradeMessage>) stuGradeMap);
		
		p = new Pie();
		p.setName("1");
		p.setValue(15);
		pie.add(p);
		p = new Pie();
		p.setName("2");
		p.setValue(20);
		pie.add(p);
		p = new Pie();
		p.setName("3");
		p.setValue(3);
		pie.add(p);
		p = new Pie();
		p.setName("4");
		p.setValue(5);
		pie.add(p);
		cm = new ClassMessage();
		cm.setClassName("CLASS ONE");
		cm.setExcellent(8.695);
		cm.setPass(84.78);
		cm.setUnpass(15.22);
		cml.add(cm);
		cm = new ClassMessage();
		cm.setClassName("CLASS TWO");
		cm.setExcellent(18.18);
		cm.setPass(97.72);
		cm.setUnpass(2.28);
		cml.add(cm);
		cm = new ClassMessage();
		cm.setClassName("CLASS THREE");
		cm.setExcellent(27.9);
		cm.setPass(88.37);
		cm.setUnpass(11.63);
		cml.add(cm);
		cm = new ClassMessage();
		cm.setClassName("CLASS FOUR");
		cm.setExcellent(17.08);
		cm.setPass(97.82);
		cm.setUnpass(2.18);
		cml.add(cm);
		cm = new ClassMessage();
		cm.setClassName("CLASS FIVE");
		cm.setExcellent(11.11);
		cm.setPass(88.88);
		cm.setUnpass(12.12);
		cml.add(cm);
		
	}
	
	

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.button1:
			charView = (GraphicalView) GraphUtils.getInstance().getLineChartView(MainActivity.this, studentGradeList , "B");
			layout.removeAllViews();
			layout.addView(charView);
			break;
		case R.id.button2:
			String[] sub = new String[] { "GRADE" };
			Integer[] color = new Integer[] { Color.BLUE, Color.GREEN,
					Color.MAGENTA, Color.RED };
			charView = (GraphicalView) GraphUtils.getInstance()
					.getLineChartViewOfNum(MainActivity.this, studentGradeList,
							sub, color);
			layout.removeAllViews();
			layout.addView(charView);
			break;
		case R.id.button3:
			charView = (GraphicalView) GraphUtils.getInstance()
					.getPieChartView(getBaseContext(), pie);
			fl.removeAllViews();
			fl.addView(charView);
			FrameLayout.LayoutParams param3 = new FrameLayout.LayoutParams(100,
					100);
			param3.setMargins(165, 52, 0, 0);
			TextView tvi = new TextView(MainActivity.this);
			tvi.setText("50");
			tvi.setTextSize(30f);
			tvi.setGravity(Gravity.CENTER);
			tvi.setBackgroundResource(R.drawable.bg_renshu);
			// tvi.setBackgroundColor(Color.BLACK);
			tvi.setLayoutParams(param3);
			fl.addView(tvi);
			break;
		case R.id.button4:
			charView = (GraphicalView) GraphUtils.getInstance().getBarHorView(
					getBaseContext());
			fl.removeAllViews();
			fl.addView(charView);
			break;
		case R.id.button5:
			 String[] titles = new String[] { "ALLSCORE", "MYSCORE" };
			 List<double[]> values = new ArrayList<double[]>();
			    values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13, 10 });
			    values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9, 6 });
			charView = (GraphicalView)GraphUtils.getInstance().getAChartDoubleLine(MainActivity.this,titles,values);
			layout.removeAllViews();
			layout.addView(charView);
			break;
			default:
				break;
		}
	}
	
}