
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Iterator;
	import java.util.Locale.Category;
	import java.util.concurrent.Executors;

	import javax.swing.JOptionPane;

	import org.json.simple.JSONObject;
	import org.json.simple.JSONArray;
	import org.json.simple.parser.ParseException;
	import org.json.simple.parser.JSONParser;

	import okhttp3.*;


	public class PaymentBack {
		
		private final static OkHttpClient httpClient = new OkHttpClient(); 

		public static final MediaType MEDIA_TYPE_MARKDOWN
	    = MediaType.parse("application/json; charset=utf-8"); 

		public boolean keyTest(String key) throws Exception{ 

			String json = "{'url' : 'https://raw.githubusercontent.com/MicrosoftDocs/mslearn-process-images-with-the-computer-vision-service/master/images/mountains.jpg'}"; 

		
			
			Request request = new Request.Builder() 
					.url("https://westus2.api.cognitive.microsoft.com/vision/v2.0/analyze?visualFeatures=Brands") 
					.addHeader("Ocp-Apim-Subscription-Key", key) 
					.addHeader("Content-Type", "application/json") 
					.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, json)) 
					.build(); 
			try (Response response = httpClient.newCall(request).execute()){ 
				
				System.out.println(response.toString());
				
				
				boolean isBadKey = response.toString().indexOf("PermissionDenied") !=-1? true: false;
				if (isBadKey) {
					return false;
					
				}else { 
					return true;
				}
			}

		}
		

		public void POST(String path, String mode){ 
			String command;
			main m = new main(); 
			String key = null;
			
			command = "curl.exe \"https://westus2.api.cognitive.microsoft.com/vision/v2.0/analyze?visualFeatures=" + mode  + "\" -H \"Ocp-Apim-Subscription-Key:"
					+ key + "\" -H \"Content-Type:application/octet-stream\" --data-binary \"@" + path + "\""; 
			String cmds[] = {"powershell.exe",command}; 
			
			
			Runtime run = Runtime.getRuntime();
			Process pr;
			String output = null;
			try {
				pr = run.exec(cmds); 
				pr.waitFor(); 
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream())); 
				String line = ""; 
				while ((line=buf.readLine())!=null) { 
					output = line;
				}
				while ((line=buf.readLine())!=null) {
					output = line;
					}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			
			

			JSONParser parser = new JSONParser();
		    String s = output;
		    System.out.println(output);
		    JSONObject jsonObject = null;

		    Object text = null;
		    int cont = 0;
		    String[] tags = null;

		    String brand = null;
		    
		    int confidence = 0;
		      try{
		    	 jsonObject = (JSONObject) parser.parse(s); 
		         
		         if(mode == "Description") { 
		        	String jsonst1 = jsonObject.get("description").toString(); 
		        	JSONObject jsonObject2  = (JSONObject) parser.parse(jsonst1);
		        	JSONArray tagsJSON = (JSONArray) jsonObject2.get("tags"); 
		        	Iterator<String> iterator = tagsJSON.iterator();
		        	tags = new String[100]; 
		        	while (iterator.hasNext()) {
		        		tags[cont] = iterator.next();
		        		cont++;
					}
		        	
		        	
		        	
		        	
		        	JSONArray JSONcaptions = (JSONArray) jsonObject2.get("captions");
		        	Iterator<JSONObject> iterator2 = JSONcaptions.iterator();
		        	int cont1 = 0;
		        	JSONObject t = iterator2.next();
		        	String out = null;
		        	for(int i =0;i<2;i++) {
		        		
		        		
		        		if(cont1 == 0) {
		        			text = t.get("text");
		        		}else {
		        			confidence = (int) Math.round((double) t.get("confidence") * 100);
		        		}
		        		cont1++;
		        		System.out.println("Se detecto: " + text);
		        		out = "Se detecto: " + text + "\n";
		        		System.out.println("Con una seguridad del: " + confidence + "%");
		        		out = out + "Con una seguridad del: " + confidence + "%" + "\n" + "Con estos tags:" + "\n";
		        		System.out.println("Con estos tags:");
		        	    for(int j = 0; j <= cont-1;j++) {
		              		System.out.println(tags[j]);
		              		out = out + "    " + tags[j] + "\n";
		              	} 
		        	    
		        	}
		        	JOptionPane.showMessageDialog(null, out ,"Resultado", 1);
		        	
		         }else if(mode == "Brands") { 
		        	 confidence = 0;
		        	 System.out.println("Brands");
		        	 String jsonst1 = jsonObject.get("brands").toString();
		        	 JSONArray jsonBrands = (JSONArray) parser.parse(jsonst1);
					 Iterator<JSONObject> iterator = jsonBrands.iterator(); 
					 JSONObject b = iterator.next();
					 brand = b.get("name").toString();
					 confidence = (int) Math.round((double) b.get("confidence") * 100);
		        	 
					 String out = null;
		        	 System.out.println("La marca es: " + brand);
		        	 out = "La marca detectada es: " + brand + "\n";
		        	 System.out.println("Con una seguridad del: " + confidence + "%");
		        	 out = out + "Con una seguridad del: " + confidence + "%" + "\n";
		        	 
		        	 JOptionPane.showMessageDialog(null, out ,"Resultado", 1);
		        	 
		         }else if(mode == "Objects") { 
		        	 System.out.println("Objects");
		        	 String jsonObj = jsonObject.get("objects").toString();
		        	 JSONArray jsonArr = (JSONArray) parser.parse(jsonObj);
		        	 Iterator<JSONObject> iterator = jsonArr.iterator();
		        	 JSONObject o = iterator.next();
		        	 
		        	 confidence = (int) Math.round((double) o.get("confidence") * 100);
		        	 String out = null;
		        	 System.out.println("Se detecto este objeto: " + o.get("object"));
		        	 out = "Se detecto este objeto: " + o.get("object") + "\n";
		        	 System.out.println("Con una seguridad del: " + confidence + "%");
		        	 out = out + "Con una seguridad del: " + confidence + "%";
		        	 
		        	 JOptionPane.showMessageDialog(null, out ,"Resultado", 1);
		        	 
		         }

		      }catch (Exception e) {
		    	  if(e.toString() != "java.util.NoSuchElementException") {
		    		  System.out.println(e);
		    		  try {
		    			  JOptionPane.showMessageDialog(null, jsonObject.get("code") + "\n" + jsonObject.get("message") + "\n" + "Es posible tu key no tenga suficientes privilegios para realizar el pago.", "Error del servidor", 0);
		    		  }catch (Exception error){ 
		    			  JOptionPane.showMessageDialog(null, "Ha ocurrido un error interno en el programa\n" + "Debug info:\n    " + error, "Error del programa", 0);
		    		  }
		    	  }else { 
		    		  System.out.println("No se detectaron " + mode);
		    		  JOptionPane.showMessageDialog(null, "No se detectaron " + mode ,"Resultado", 2);
		    	  }
			}
		      
		      
			
		    
		    
		}
	}
		



