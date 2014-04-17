package com.university.Servlet;
import com.university.Service.*;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service s1 = new Service();
//			boolean a1 = s1.forScriptGetBranchName();
//			boolean b1 = s1.forScriptGetUniversityName();
//			boolean b1 = s1.forScriptGetStateName();
//			boolean b1 = s1.getUniversityNamesListFromBranch("Engineering");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
//
//public String[] getUniversityInfo(String univ_name) throws IOException, JSONException{
//	
//	System.out.println("In String[] getUniversityInfo(String univ_name)");
//	String[] universityDetail = new String[36];
//
//	// build a URL
//	String name = univ_name;
//
//	name = name.replaceAll(" ", "%20");
//	String s = "http://universityapi.vaibhav28.cloudbees.net/getUniversityInfoByName?univName=" + name;
//	URL url = new URL(s);
//
//	// read from the URL
//	Scanner scan = new Scanner(url.openStream());
//	String str = new String();
//
//	while (scan.hasNext())
//		str += scan.nextLine();
//	scan.close();
//
//	str = str.replaceAll(": \" \" ", "No Info");
//	JSONObject obj = new JSONObject(str);
//	JSONObject res = obj.getJSONArray("univInfoList").getJSONObject(0);		
//
//	System.out.println("This is RES "+res.toString());
//	universityDetail[0] = res.getString("instnm");
//	universityDetail[1] = res.getString("addr");
//	universityDetail[2] = res.getString("city");
//	universityDetail[3] = res.getString("stabbr");
//	universityDetail[4] = res.getString("zip");
//	universityDetail[5] = res.getString("fips");
//	universityDetail[6] = res.getString("obereg");
//	universityDetail[7] = res.getString("chfnm");
//	universityDetail[8] = res.getString("chftitle");
//	universityDetail[9] = res.getString("gentele");
//	universityDetail[10] = res.getString("ein");
//	universityDetail[11] = res.getString("webaddr");
//	universityDetail[12] = res.getString("adminurl");
//	universityDetail[13] = res.getString("faidurl");
//	universityDetail[14] = res.getString("applurl");
//	universityDetail[15] = res.getString("npricurl");
//	universityDetail[16] = res.getString("iclevel");
//	universityDetail[17] = res.getString("control");
//	universityDetail[18] = res.getString("hloffer");
//	universityDetail[19] = res.getString("ugoffer");
//	universityDetail[20] = res.getString("groffer");
//	universityDetail[21] = res.getString("hdegofr1");
//	universityDetail[22] = res.getString("deggrant");
//	universityDetail[23] = res.getString("hospital");
//	universityDetail[24] = res.getString("medical");
//	universityDetail[25] = res.getString("openpubl");
//	universityDetail[26] = res.getString("act");
//	universityDetail[27] = res.getString("ialias");
//	universityDetail[28] = res.getString("instcat");
//	universityDetail[29] = res.getString("instsize");
//	universityDetail[30] = res.getString("f1sysnam");
//	universityDetail[31] = res.getString("faxtele");
//	universityDetail[31] = res.getString("countycd");
//	universityDetail[32] = res.getString("countynm");
//	universityDetail[33] = res.getString("longitude");
//	universityDetail[34] = res.getString("latitude");	
//	System.out.println("Returning String[] getUniversityInfo(String univ_name)");
//	return universityDetail;
//}
//
//
//package com.university.Servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.university.Service.*;
//import com.university.bean.UniversityInfoBean;
//
///**

//
//public boolean forScriptGetBranchName() throws IOException, JSONException{
//
//	// build a URL
//	String s = "http://localhost:8080/university/getAllUnivDepartment";
//	URL url = new URL(s);
//
//	// read from the URL
//	Scanner scan = new Scanner(url.openStream());
//	String str = new String();
//
//	while (scan.hasNext())
//		str += scan.nextLine();
//	scan.close();
//
//	System.out.println("This is the json "+str);
//	str = str.replaceAll(": \" \" ", "No Info");
//	JSONObject obj = new JSONObject(str);
//	System.out.println(obj.toString());
//	JSONArray res = obj.getJSONArray("univEnrollList");		
//
//	System.out.println("RES Object to String : "+res.toString());
//	System.out.println("RES Object Length to String : "+res.length());
//	int size = res.length();
//	String n1;
//	int endIndex = 0;
//
//	String[] univBranchList = new String[size];
//	
//	for(int i=0;i<=size-1;i++){
//		n1 = res.get(i).toString();
//		System.out.println("N "+i+" : "+n1);
//		endIndex = (n1.length()) - 2;
//		n1 = n1.substring(2, endIndex);
//		System.out.println("New N1 "+i+" : "+n1);
//
//		String[] temp = n1.split("\",\"");
//
//		System.out.println("Element 1: "+temp[0]);
//		System.out.println("Element 2: "+temp[1]);
//
//		univBranchList[i] = temp[0];
//		
//		System.out.println("Univ List "+i+": "+univBranchList[i]);
//
//	}
//
//	for(int i=0;i<=size-1;i++){
//		System.out.println("University "+i+" : "+univBranchList[i]);
//
//	}
//	
//	return true;
//}

// * Servlet implementation class UniversityInfo
// */
//
//@WebServlet("/getDetailFromType")
//public class UniversityInfoServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	Service service = new Service();
//	String[] univInfoNameList, univStateList, univBranchList;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//		System.out.println("In University Info Servlet ");
//		String[] universityNames, universityDetail;
//		
//		try{
//			univInfoNameList = new String[service.forScriptGetUniversityName().length];
//			univInfoNameList = service.forScriptGetUniversityName();
//
//			univStateList = new String[service.forScriptGetStateName().length];
//			univStateList = service.forScriptGetStateName();
//
//			univBranchList = new String[service.forScriptGetBranchName().length];
//			univBranchList = service.forScriptGetBranchName();
//
//			String univ_Name = request.getParameter("univ_name");
//			System.out.println("Univ Name is : "+univ_Name);
//
//			String branch_Name = request.getParameter("branch_name");
//			System.out.println("Branch Name is : "+branch_Name);
//
//			String state_Name = request.getParameter("state_name");
//			System.out.println("State Name is : "+state_Name);
//
//			request.setAttribute("univInfoNameList", univInfoNameList);
//			request.setAttribute("univStateList", univStateList);
//			request.setAttribute("univBranchList", univBranchList);
//
//			if(! (univ_Name == null))
//			{
//				System.out.println("In University Detail Module");
//				universityNames = new String[36];
//				universityDetail = service.getUniversityInfo(univ_Name);
//				System.out.println("Checking university Detail Array : "+universityDetail[1]);
//				System.out.println("This is university detail Array : "+universityDetail);
//				request.setAttribute("universityDetail", universityDetail);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("universitydetail.jsp");
//				dispatcher.forward( request, response); 
//				return;
//			}
//			
//			else if(! (state_Name == null))
//			{
//				System.out.println("In State University Name Model");
//				universityNames = new String[service.getUniversityNamesList(state_Name).length];
//				universityNames = service.getUniversityNamesList(state_Name);
//				request.setAttribute("universityNames", universityNames);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("statelist.jsp");
//				dispatcher.forward( request, response); 
//				return;
//			}
//			
//			else
//			{
//				System.out.println("In Branch Based University Name Model");
//				universityNames = new String[36];
//				universityDetail = service.getUniversityInfo(univ_Name);
//				System.out.println("Checking university Detail Array : "+universityDetail[1]);
//				request.setAttribute("universityDetail", universityDetail);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("universitydetail.jsp");
//				dispatcher.forward( request, response); 
//				return;
//			}
//	
//		}
//		catch(Exception e){
//			e.getStackTrace();
//		}
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
//
//}

