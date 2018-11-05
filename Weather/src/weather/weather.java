package weather;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JLabel;

public class weather {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					weather window = new weather();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public weather() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(78, 62, 77, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(38, 119, 46, 14);
		frame.getContentPane().add(lblResult);
		
		
		JLabel lblUserid = new JLabel("City:");
		lblUserid.setBounds(38, 65, 46, 14);
		frame.getContentPane().add(lblUserid);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(296, 61, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(20, 144, 394, 131);
		frame.getContentPane().add(textArea);
		
		
		JLabel lblWeather = new JLabel("Current Weather");
		lblWeather.setBounds(167, 28, 111, 14);
		frame.getContentPane().add(lblWeather);
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Thread thread = new Thread (new Runnable()
				{
					public void run()
					{
						String city = textField.getText();
						String params = null;
						String strUrl = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=fd02b4753f9e1795a66939c57840be45";
						JSONObject jsonObj;
						
						try {
							jsonObj = new JSONObject(makeHttpRequest(strUrl,"GET", params)) ;
							 
							String strFromPHP = null;
							strFromPHP = jsonObj.toString();
							textArea.setText(strFromPHP);
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
							
					}
				});
				thread.start();
	           
			}
		});
	}
	
	public String makeHttpRequest(String strUrl, String method, String params) throws JSONException {
		InputStream is = null;
		String json = "";
		
		try {
			strUrl = strUrl+"?"+params;
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(strUrl);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine())!=null) 
				sb.append(line+"\n");
			is.close();
			json = sb.toString();
			
		}	catch (Exception ee) {
			ee.printStackTrace();
		}
		return json;
	}
}
