package kr.or.bit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.bit.dto.Emp;
import kr.or.bit.dto.chart.AvgMaxMinSalaryByDept;
import kr.or.bit.dto.chart.DataByYear;
import kr.or.bit.dto.chart.LocDept;
import kr.or.bit.dto.chart.StatisticsByMgr;
import kr.or.bit.dto.chart.TotalSaleryChart;

public interface EmpDao {
	
	public int insertEmp(Emp emp);
	
	public Emp getEmpByEmpno(int no);
	
	public List<String> getJobRegister();
	
	public int checkAdminLogin(Map<String, String> map);
	
	public List<Emp> getEmps();
	
	public int deleteEmpByEmpno(int empno);
	
	public int updateEmp(Emp emp);
	
	public List<TotalSaleryChart> ChartDataByTotalSalery(int count);
	
	public List<DataByYear> dataByYear();
	
	public List<Integer> getDethNos();
	
	public List<AvgMaxMinSalaryByDept> ChartSalByDept();
	
	public List<LocDept> LocChart();
	
	public List<StatisticsByMgr> statisticsByMgr();
	
}
