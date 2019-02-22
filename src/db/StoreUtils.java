package db;

import model.Student;
import model.TableResult;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import java.util.Map;

/**
 * Created by rockywoo on 2019/2/15.
 */
public class StoreUtils {
	
	public static Integer index = 0;
	public static Integer keyMinPlan1 = new Integer(-1);
	public static Integer keyMinPlan2 = new Integer(-1);
	public static Integer keyMinPlan3 = new Integer(-1);
	public static Map<Integer, Integer[][]> plans = new HashMap<Integer, Integer[][]>();
    public static Map<Integer, Student> students = new HashMap<Integer, Student>();
    public static boolean stop = false;

    public static List<TableResult> tableResult1=new ArrayList<>();
	public static List<TableResult> tableResult2=new ArrayList<>();
	public static List<TableResult> tableResult3=new ArrayList<>();
}
