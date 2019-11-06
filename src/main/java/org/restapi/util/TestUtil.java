package org.restapi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil 
{
	public static String getValueByJpath(JSONObject responseJson,String jpath)
	{
		Object obj=responseJson;
		for(String s:jpath.split("/"))
		{
			if(!s.isEmpty())
			{
				if(!(s.contains("[") || s.contains("]")))
				{
					obj=((JSONObject) obj).get(s);
				}
				else if((s.contains("[") || s.contains("]"))) 
				{
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
				}
			}
		
		}
		return obj.toString();
	}
	
	public static String getCurrentDateTimeStamp() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
		return df.format(dateobj);
	}
}
