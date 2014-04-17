package com.university.Service;

import com.university.dao.*;
import com.university.bean.*;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Service {
	
	//New Function Starts Here
	//Function Definition :  To Verify The User from Database
	public RegistrationBean verifyUser(String email, String password){
		DatabaseConnection db = new DatabaseConnection();
		return db.signIn(email, password);	
	}
	//Function Ends Here
	
	//New Function Starts Here
	//Function Definition : To get all details of university for university detail page
	public UniversityInfoBean getUniversityInfo(String univ_name) throws IOException, JSONException{

		UniversityInfoBean universityDetail = new UniversityInfoBean();

		// build a URL
		String name = univ_name;

		name = name.replaceAll(" ", "%20");
		String s = "http://localhost:8080/university/getUniversityInfoByName?univName=" + name;
		URL url = new URL(s);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();

		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		str = str.replaceAll(": \" \" ", "No Info");
		JSONObject obj = new JSONObject(str);
		JSONObject res = obj.getJSONArray("univInfoList").getJSONObject(0);		

		universityDetail.setInstnm(res.getString("instnm"));
		universityDetail.setAddr(res.getString("addr"));
		universityDetail.setCity(res.getString("city"));
		universityDetail.setStabbr(res.getString("stabbr"));
		universityDetail.setZip(res.getString("zip"));
		universityDetail.setFips(res.getString("fips"));
		universityDetail.setObereg(res.getString("obereg"));
		universityDetail.setChfnm(res.getString("chfnm"));
		universityDetail.setChftitle(res.getString("chftitle"));
		universityDetail.setGentele(res.getString("gentele"));
		universityDetail.setEin(res.getString("ein"));
		universityDetail.setWebaddr(res.getString("webaddr"));
		universityDetail.setAdminurl(res.getString("adminurl"));
		universityDetail.setFaidurl(res.getString("faidurl"));
		universityDetail.setApplurl(res.getString("applurl"));
		universityDetail.setNpricurl(res.getString("npricurl"));
		universityDetail.setIclevel(res.getString("iclevel"));
		universityDetail.setControl(res.getString("control"));
		universityDetail.setHloffer(res.getString("hloffer"));
		universityDetail.setUgoffer(res.getString("ugoffer"));
		universityDetail.setGroffer(res.getString("groffer"));
		universityDetail.setHdegofr1(res.getString("hdegofr1"));
		universityDetail.setDeggrant(res.getString("deggrant"));
		universityDetail.setHospital(res.getString("hospital"));
		universityDetail.setMedical(res.getString("medical"));
		universityDetail.setOpenpubl(res.getString("openpubl"));
		universityDetail.setAct(res.getString("act"));
		universityDetail.setIalias(res.getString("ialias"));
		universityDetail.setInstcat(res.getString("instcat"));
		universityDetail.setInstsize(res.getString("instsize"));
		//	Problematic parameter
		//	universityDetail.setF1SYSNAM(res.getString("f1sysnam"));
		//	universityDetail.setFaxtele(res.getString("faxtele"));
		//	universityDetail.setCountycd(res.getString("countycd"));
		//	universityDetail.setCountynm(res.getString("countynm"));
		universityDetail.setLongitude(res.getString("longitude"));
		universityDetail.setLatitude(res.getString("latitude"));	

		return universityDetail;
	}
	//Function Ends Here
	
	//New Function Starts Here
	//Function Definition : to get all university from state name
	public String[] getUniversityNamesList(String state_name) throws IOException, JSONException{

		String[] s1;

		// build a URL
		String state = state_name;
		System.out.println("State named entered is :"+state);
		state = state.replaceAll(" ", "%20");
		String s = "http://localhost:8080/university/getUniversityInfoByState?state=" + state;
		URL url = new URL(s);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();

		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		System.out.println("This is the json "+str);
		str = str.replaceAll(": \" \" ", "No Info");
		JSONObject obj = new JSONObject(str);
		System.out.println(obj.toString());
		JSONObject res;		

		//Array Size of array
		s1 = new String[obj.getJSONArray("univInfoList").length()];
		for(int i = 0; i < obj.getJSONArray("univInfoList").length(); i++)
		{			
			res = obj.getJSONArray("univInfoList").getJSONObject(i);
			s1[i] = res.getString("instnm");
		}
		return s1;
	}
	//Function Ends Here
	
	//New Function Starts Here
	//Function Definition : to get all university from branch name
	public String[] getUniversityNamesListFromBranch(String branch_name) throws IOException, JSONException{


		// build a URL
		String branch = branch_name;
		System.out.println("State named entered is :"+branch);
		branch = branch.replaceAll(" ", "%20");
		String s = "http://localhost:8080/university/getUnivNameByDepartment?department=" + branch;
		System.out.println("Passinf this URL : "+s);
		URL url = new URL(s);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();

		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		JSONObject obj = new JSONObject(str);
		JSONArray res = obj.getJSONArray("univEnrollList");		

		int size = res.length();
		String n1;
		int endIndex = 0;

		String[] univBranchList = new String[size];

		for(int i=0;i<=size-1;i++){
			n1 = res.get(i).toString();
			endIndex = (n1.length()) - 2;
			n1 = n1.substring(2, endIndex);
			String[] temp = n1.split("\",\"");
			univBranchList[i] = temp[0];			
		}

		return univBranchList;
	}	
	//Function Ends Here

/*------------------------------------------ALL FUNCTIONS BELOW ARE WRITTEN FOR AUTOCOMPLETE FEATURE--------------------------------------------------*/

	//New Function Starts Here
	//Function Definition : to get all university
	public String[] forScriptGetUniversityName() throws IOException, JSONException{

		// build a URL
		String s = "http://localhost:8080/university/getAllUniversityName";
		URL url = new URL(s);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();

		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		JSONObject obj = new JSONObject(str);
		JSONArray res = obj.getJSONArray("univInfoList");		

		int size = res.length();
		String n1;
		int endIndex = 0;

		String[] univList = new String[size];
		//		String[] univStateList = new String[size];

		for(int i=0;i<=size-1;i++){
			n1 = res.get(i).toString();
			endIndex = (n1.length()) - 2;
			n1 = n1.substring(2, endIndex);
			String[] temp = n1.split("\",\"");
			univList[i] = temp[0];
			//			univStateList[i] = temp[1];
		}
		return univList;
	}
	//Function Ends Here
	
	//New Function Starts Here
	//Function Definition : to get all branch	
	public String[] forScriptGetBranchName() throws IOException, JSONException{

		// build a URL
		String s = "http://localhost:8080/university/getAllUnivDepartment";
		URL url = new URL(s);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();

		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		JSONObject obj = new JSONObject(str);
		JSONArray res = obj.getJSONArray("univEnrollList");		

		int size = res.length();
		String n1;

		String[] univBranchList = new String[size];

		for(int i=0;i<=size-1;i++){
			n1 = res.get(i).toString();
			String[] temp = n1.split("\",\"");
			univBranchList[i] = temp[0];
		}
		return univBranchList;
	}
	//Function Ends Here
	
	//New Function Starts Here
	//Function Definition : to get all states
	public String[] forScriptGetStateName() throws IOException, JSONException{

		// build a URL
		String s = "http://localhost:8080/university/getAllUnivStates";
		URL url = new URL(s);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();

		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		JSONObject obj = new JSONObject(str);
		JSONArray res = obj.getJSONArray("univInfoList");		

		int size = res.length();
		String n1;

		String[] univStateList = new String[size];

		for(int i=0;i<=size-1;i++){
			n1 = res.get(i).toString();
			String[] temp = n1.split("\",\"");
			univStateList[i] = temp[0];
		}
		return univStateList;
	}
	//Function Ends Here
}
