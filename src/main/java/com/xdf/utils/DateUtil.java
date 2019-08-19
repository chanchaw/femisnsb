package com.xdf.utils; 
  
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List; 
  
/** 
 * ���ڳ��÷��� 
 * 
 * @author 
 * 
 */
public class DateUtil { 
  
  /** 
   * ���ñ��� 
   */
  public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss"; 
  public static final String DATE_FORMAT_YMD = "yyyy-MM-dd"; 
  public static final String DATE_FORMAT_HMS = "HH:mm:ss"; 
  public static final String DATE_FORMAT_HM = "HH:mm"; 
  public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm"; 
  public static final String DATE_FORMAT_YMDHMS = "yyyyMMddHHmmss"; 
  public static final long ONE_DAY_MILLS = 3600000 * 24; 
  public static final int WEEK_DAYS = 7; 
  private static final int dateLength = DATE_FORMAT_YMDHM.length(); 
    
    
  /** 
   * ����ת��Ϊָ����ʽ�ַ��� 
   * 
   * @param time 
   * @param format 
   * @return 
   */
  public static String formatDateToString(Date time, String format) { 
    SimpleDateFormat sdf = new SimpleDateFormat(format); 
    return sdf.format(time); 
  } 
  
  /** 
   * �ַ���ת��Ϊ�ƶ���ʽ���� 
   * (ע�⣺���������������2014-12-21 12:12��format��Ӧ��ӦΪyyyy-MM-dd HH:mm 
   * �����쳣�׳�) 
   * @param date 
   * @param format 
   * @return 
   * @throws ParseException 
   *       @ 
   */
  public static Date formatStringToDate(String date, String format) { 
    SimpleDateFormat sdf = new SimpleDateFormat(format); 
    try { 
      return sdf.parse(date); 
    } catch (ParseException ex) { 
      ex.printStackTrace(); 
      throw new RuntimeException(ex.toString()); 
    } 
  } 
  
  /** 
   * �ж�һ�������Ƿ���������ʱ���� 
   * @param time 
   * @param timeRange 
   * @return 
   */
  public static boolean isTimeInRange(Date time, Date[] timeRange) { 
    return (!time.before(timeRange[0]) && !time.after(timeRange[1])); 
  } 
  
  /** 
   * ��������ʱ���ȡ��ȷ���ֵ�ʱ�� 
   * 
   * @param fullDateStr 
   * @return 
   */
  public static String getDateToMinute(String fullDateStr) { 
    return fullDateStr == null ? null
        : (fullDateStr.length() >= dateLength ? fullDateStr.substring( 
            0, dateLength) : fullDateStr); 
  } 
  
  /** 
   * ����ָ����ȵ������ܡ�List�а�������String[2]���� string[0]���ܵĿ�ʼ����,string[1]�Ǳ��ܵĽ������ڡ� 
   * ���ڵĸ�ʽΪYYYY-MM-DD ÿ��ĵ�һ���ܣ������������һ�������������졣 
   * ���磺2009��ĵ�һ���ܿ�ʼ����Ϊ2009-01-05����������Ϊ2009-01-11�� ����һ����һ�꣬��ô����������ڵ��ܾ�����һ����ܡ� 
   * ���磺2008-12-29������һ��2009-01-04�������գ���ô����ܾ���2008��ȵ����һ���ܡ� 
   * 
   * @param year 
   *      ��ʽ YYYY ���������1900��� С��9999�� 
   * @return @ 
   */
  public static List<String[]> getWeeksByYear(final int year) { 
    int weeks = getWeekNumOfYear(year); 
    List<String[]> result = new ArrayList<String[]>(weeks); 
    int start = 1; 
    int end = 7; 
    for (int i = 1; i <= weeks; i++) { 
      String[] tempWeek = new String[2]; 
      tempWeek[0] = getDateForDayOfWeek(year, i, start); 
      tempWeek[1] = getDateForDayOfWeek(year, i, end); 
      result.add(tempWeek); 
    } 
    return result; 
  } 
  
  /** 
   * ����ָ���ꡢ�ܵ���һ�ꡢ�� 
   * 
   * @param year 
   * @param week 
   * @return @ 
   */
  public static int[] getLastYearWeek(int year, int week) { 
    if (week <= 0) { 
      throw new IllegalArgumentException("����Ų���С��1����"); 
    } 
    int[] result = { week, year }; 
    if (week == 1) { 
      // ��һ�� 
      result[1] -= 1; 
      // ���һ�� 
      result[0] = getWeekNumOfYear(result[1]); 
    } else { 
      result[0] -= 1; 
    } 
    return result; 
  } 
  
  /** 
   * ��һ��[�ܣ���] 
   * 
   * @param year 
   * @param week 
   * @return @ 
   */
  public static int[] getNextYearWeek(int year, int week) { 
    if (week <= 0) { 
      throw new IllegalArgumentException("����Ų���С��1����"); 
    } 
    int[] result = { week, year }; 
    int weeks = getWeekNumOfYear(year); 
    if (week == weeks) { 
      // ��һ�� 
      result[1] += 1; 
      // ��һ�� 
      result[0] = 1; 
    } else { 
      result[0] += 1; 
    } 
    return result; 
  } 
  
  /** 
   * ����ָ����ȹ��ж��ٸ��ܡ�(����һ��ʼ) 
   * 
   * @param year 
   * @return @ 
   */
  public static int getWeekNumOfYear(final int year) { 
    return getWeekNumOfYear(year, Calendar.MONDAY); 
  } 
  
  /** 
   * ����ָ����ȹ��ж��ٸ��ܡ� 
   * 
   * @param year 
   *      yyyy 
   * @return @ 
   */
  public static int getWeekNumOfYear(final int year, int firstDayOfWeek) { 
    // ÿ��������52���� �������53���ܡ� 
    int minWeeks = 52; 
    int maxWeeks = 53; 
    int result = minWeeks; 
    int sIndex = 4; 
    String date = getDateForDayOfWeek(year, maxWeeks, firstDayOfWeek); 
    // �ж�����Ƿ������������˵����53���ܡ� 
    if (date.substring(0, sIndex).equals(year)) { 
      result = maxWeeks; 
    } 
    return result; 
  } 
  
  public static int getWeeksOfWeekYear(final int year) { 
    Calendar cal = Calendar.getInstance(); 
    cal.setFirstDayOfWeek(Calendar.MONDAY); 
    cal.setMinimalDaysInFirstWeek(WEEK_DAYS); 
    cal.set(Calendar.YEAR, year); 
    return cal.getWeeksInWeekYear(); 
  } 
  
  /** 
   * ��ȡָ����ݵĵڼ��ܵĵڼ����Ӧ������yyyy-MM-dd(����һ��ʼ) 
   * 
   * @param year 
   * @param weekOfYear 
   * @param dayOfWeek 
   * @return yyyy-MM-dd ��ʽ������ @ 
   */
  public static String getDateForDayOfWeek(int year, int weekOfYear, 
      int dayOfWeek) { 
    return getDateForDayOfWeek(year, weekOfYear, dayOfWeek, Calendar.MONDAY); 
  } 
  
  /** 
   * ��ȡָ����ݵĵڼ��ܵĵڼ����Ӧ������yyyy-MM-dd��ָ���ܼ���һ�ܵĵ�һ�죨firstDayOfWeek�� 
   * 
   * @param year 
   * @param weekOfYear 
   * @param dayOfWeek 
   * @param firstDayOfWeek 
   *      ָ���ܼ���һ�ܵĵ�һ�� 
   * @return yyyy-MM-dd ��ʽ������ 
   */
  public static String getDateForDayOfWeek(int year, int weekOfYear, 
      int dayOfWeek, int firstDayOfWeek) { 
    Calendar cal = Calendar.getInstance(); 
    cal.setFirstDayOfWeek(firstDayOfWeek); 
    cal.set(Calendar.DAY_OF_WEEK, dayOfWeek); 
    cal.setMinimalDaysInFirstWeek(WEEK_DAYS); 
    cal.set(Calendar.YEAR, year); 
    cal.set(Calendar.WEEK_OF_YEAR, weekOfYear); 
    return formatDateToString(cal.getTime(), DATE_FORMAT_YMD); 
  } 
  
  /** 
   * ��ȡָ���������ڼ� 
   * 
   * @param datetime 
   * @throws ParseException 
   *       @ 
   */
  public static int getWeekOfDate(String datetime) throws ParseException { 
    Calendar cal = Calendar.getInstance(); 
    cal.setFirstDayOfWeek(Calendar.MONDAY); 
    cal.setMinimalDaysInFirstWeek(WEEK_DAYS); 
    Date date = formatStringToDate(datetime, DATE_FORMAT_YMD); 
    cal.setTime(date); 
    return cal.get(Calendar.DAY_OF_WEEK); 
  
  } 
  
  /** 
   * ����ĳ��ĳ���ڵ���������(����һ��ʼ Ϊÿ�ܵĵ�һ��) 
   * 
   * @param yearNum 
   * @param weekNum 
   * @return @ 
   */
  public static List<String> getWeekDays(int yearNum, int weekNum) { 
    return getWeekDays(yearNum, weekNum, Calendar.MONDAY); 
  } 
  
  /** 
   * ����ĳ��ĳ���ڵ���������(����) 
   * 
   * @param yearNum 
   * @param weekNum 
   * @return yyyy-MM-dd ��ʽ�������б� 
   */
  public static List<String> getWeekDays(int year, int weekOfYear, 
      int firstDayOfWeek) { 
    List<String> dates = new ArrayList<String>(); 
    int dayOfWeek = firstDayOfWeek; 
    for (int i = 0; i < WEEK_DAYS; i++) { 
      dates.add(getDateForDayOfWeek(year, weekOfYear, dayOfWeek++, 
          firstDayOfWeek)); 
    } 
    return dates; 
  } 
  
  /** 
   * ��ȡĿ�����ڵ����ܡ����ܡ������ܵ��ꡢ����Ϣ 
   * 
   * @param queryDate 
   *      �����ʱ�� 
   * @param weekOffset 
   *      -1:���� 0:���� 1:���� 
   * @param firstDayOfWeek 
   *      ÿ���Եڼ���Ϊ���� 
   * @return 
   * @throws ParseException 
   */
  public static int[] getWeekAndYear(String queryDate, int weekOffset, 
      int firstDayOfWeek) throws ParseException { 
  
    Date date = formatStringToDate(queryDate, DATE_FORMAT_YMD); 
    Calendar calendar = Calendar.getInstance(); 
    calendar.setTime(date); 
    calendar.setFirstDayOfWeek(firstDayOfWeek); 
    calendar.setMinimalDaysInFirstWeek(WEEK_DAYS); 
    int year = calendar.getWeekYear(); 
    int week = calendar.get(Calendar.WEEK_OF_YEAR); 
    int[] result = { week, year }; 
    switch (weekOffset) { 
    case 1: 
      result = getNextYearWeek(year, week); 
      break; 
    case -1: 
      result = getLastYearWeek(year, week); 
      break; 
    default: 
      break; 
    } 
    return result; 
  } 
  
  /** 
   * ����������ڵ����� 
   * 
   * @param startDate 
   *      ��ʼ�����ִ� 
   * @param endDate 
   *      ���������ִ� 
   * @return 
   * @throws ParseException 
   */
  public static int getDaysBetween(String startDate, String endDate) 
      throws ParseException { 
    int dayGap = 0; 
    if (startDate != null && startDate.length() > 0 && endDate != null
        && endDate.length() > 0) { 
      Date end = formatStringToDate(endDate, DATE_FORMAT_YMD); 
      Date start = formatStringToDate(startDate, DATE_FORMAT_YMD); 
      dayGap = getDaysBetween(start, end); 
    } 
    return dayGap; 
  } 
  
  private static int getDaysBetween(Date startDate, Date endDate) { 
    return (int) ((endDate.getTime() - startDate.getTime()) / ONE_DAY_MILLS); 
  } 
  
  /** 
   * ������������֮��������� 
   * @param startDate 
   * @param endDate 
   * @return 
   */
  public static int getDaysGapOfDates(Date startDate, Date endDate) { 
    int date = 0; 
    if (startDate != null && endDate != null) { 
      date = getDaysBetween(startDate, endDate); 
    } 
    return date; 
  } 
  
  /** 
   * ������������֮�����ݲ�� 
   * 
   * @param firstDate 
   * @param secondDate 
   * @return 
   */
  
  public static int getYearGapOfDates(Date firstDate, Date secondDate) { 
    if (firstDate == null || secondDate == null) { 
      return 0; 
    } 
    Calendar helpCalendar = Calendar.getInstance(); 
    helpCalendar.setTime(firstDate); 
    int firstYear = helpCalendar.get(Calendar.YEAR); 
    helpCalendar.setTime(secondDate); 
    int secondYear = helpCalendar.get(Calendar.YEAR); 
    return secondYear - firstYear; 
  } 
  
  /** 
   * ������������֮����·ݲ�� 
   * 
   * @param firstDate 
   * @param secondDate 
   * @return 
   */
  public static int getMonthGapOfDates(Date firstDate, Date secondDate) { 
    if (firstDate == null || secondDate == null) { 
      return 0; 
    } 
  
    return (int) ((secondDate.getTime() - firstDate.getTime()) 
        / ONE_DAY_MILLS / 30); 
  
  } 
  
  /** 
   * �����Ƿ������ǰ���� 
   * 
   * @param datys 
   * @return 
   */
  public static boolean isContainCurrent(List<String> dates) { 
    boolean flag = false; 
    SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_YMD); 
    Date date = new Date(); 
    String dateStr = fmt.format(date); 
    for (int i = 0; i < dates.size(); i++) { 
      if (dateStr.equals(dates.get(i))) { 
        flag = true; 
      } 
    } 
    return flag; 
  } 
  
  /** 
   * ��date��ʼ����time�������� 
   * 
   * @param date 
   * @param time 
   * @return 
   * @throws ParseException 
   */
  public static String getCalculateDateToString(String startDate, int time) 
      throws ParseException { 
    String resultDate = null; 
    if (startDate != null && startDate.length() > 0) { 
      Date date = formatStringToDate(startDate, DATE_FORMAT_YMD); 
      Calendar c = Calendar.getInstance(); 
      c.setTime(date); 
      c.set(Calendar.DAY_OF_YEAR, time); 
      date = c.getTime(); 
      resultDate = formatDateToString(date, DATE_FORMAT_YMD); 
    } 
    return resultDate; 
  } 
  
  /** 
   * ��ȡ��ĳ���ڿ�ʼ���㣬ָ�����������ڸ���ĵڼ��� 
   * 
   * @param date 
   * @param admitDate 
   * @return 
   * @throws ParseException 
   *       @ 
   */
  public static int[] getYearAndWeeks(String date, String admitDate) 
      throws ParseException { 
    Calendar c = Calendar.getInstance(); 
    c.setTime(formatStringToDate(admitDate, DATE_FORMAT_YMD)); 
    int time = c.get(Calendar.DAY_OF_WEEK); 
    return getWeekAndYear(date, 0, time); 
  } 
  
  /** 
   * ��ȡָ������refDate��ǰ���һ�ܵ��������� 
   * 
   * @param refDate 
   *      �ο����� 
   * @param weekOffset 
   *      -1:���� 0:���� 1:���� 
   * @param startDate 
   *      ������һ�ܵĵ�һ�� 
   * @return yyyy-MM-dd ��ʽ������ 
   * @throws ParseException 
   *       @ 
   */
  public static List<String> getWeekDaysAroundDate(String refDate, 
      int weekOffset, String startDate) throws ParseException { 
    // ��startDateΪһ�ܵĵ�һ�� 
    Calendar c = Calendar.getInstance(); 
    c.setTime(formatStringToDate(startDate, DATE_FORMAT_YMD)); 
    int firstDayOfWeek = c.get(Calendar.DAY_OF_WEEK); 
    // ��ȡ��Ӧ�� 
    int[] weekAndYear = getWeekAndYear(refDate, weekOffset, firstDayOfWeek); 
    // ��ȡ��Ӧ�ܵ��������� 
    return getWeekDays(weekAndYear[1], weekAndYear[0], firstDayOfWeek); 
  } 
  
  /** 
   * ����ʱ����ȡʱ������ 
   * 
   * @param hours 
   * @return 
   */
  public static List<String[]> getTimePointsByHour(int[] hours) { 
    List<String[]> hourPoints = new ArrayList<String[]>(); 
    String sbStart = ":00:00"; 
    String sbEnd = ":59:59"; 
    for (int i = 0; i < hours.length; i++) { 
      String[] times = new String[2]; 
      times[0] = hours[i] + sbStart; 
      times[1] = (hours[(i + 1 + hours.length) % hours.length] - 1) 
          + sbEnd; 
      hourPoints.add(times); 
    } 
    return hourPoints; 
  } 
  
  /** 
   * 
   * ����ָ�������ڣ����ӻ��߼������� 
   * 
   * @param date 
   * @param amount 
   * @return 
   */
  public static Date addDays(Date date, int amount) { 
    return add(date, Calendar.DAY_OF_MONTH, amount); 
  } 
  
  /** 
   * ����ָ�������ڣ����ͣ����ӻ�������� 
   * 
   * @param date 
   * @param calendarField 
   * @param amount 
   * @return 
   */
  public static Date add(Date date, int calendarField, int amount) { 
    if (date == null) { 
      throw new IllegalArgumentException("The date must not be null"); 
    } 
    Calendar c = Calendar.getInstance(); 
    c.setTime(date); 
    c.add(calendarField, amount); 
    return c.getTime(); 
  } 
  
  /** 
   * ��ȡ��ǰ���ڵ�������� ʱ��2014-12-21 23:59:59 
   * @return 
   */
  public static Date getCurDateWithMaxTime() { 
    Calendar c = Calendar.getInstance(); 
    c.set(Calendar.HOUR_OF_DAY, 23); 
    c.set(Calendar.MINUTE, 59); 
    c.set(Calendar.SECOND, 59); 
    return c.getTime(); 
  } 
  
  /** 
   * ��ȡ��ǰ���ڵ���С����ʱ�� 2014-12-21 00:00:00 
   * @return 
   */
  public static Date getCurDateWithMinTime() { 
    Calendar c = Calendar.getInstance(); 
    c.set(Calendar.HOUR_OF_DAY, 0); 
    c.set(Calendar.MINUTE, 0); 
    c.set(Calendar.SECOND, 0); 
    c.set(Calendar.MILLISECOND, 0); 
    return c.getTime(); 
  } 
  
  /**
 * �ӵ�ǰ���ڵ�����л�ȡָ������
 * length<0��2018=""
 * length=0��2018=""
 * length=1��2018="8"
 * length=2��2018="18"
 * length=3��2018="018"
 * length=4��2018="2018"
 * length>4��2018="2018"  
   */
  public static String getYear8Length(Integer length) {
	  Calendar date = Calendar.getInstance();
	  String year = String.valueOf(date.get(Calendar.YEAR));
	  
	  Integer start = 4-length;
	  if(start<0) {
		  start=0;
	  }else if(start>=4) {
		  start=4;
	  }
	  return year.substring(start);
  }
  
  
  public static String getMonth8Length(Integer length) {
	  if(length<=0) return "";// 0��ʾ��Ҫ�·ݣ���ô���ؿ��ַ���
	  if(length>=2) length=2;// �·������λ����
	  
	  Calendar date = Calendar.getInstance();
	  String month = String.valueOf(date.get(Calendar.MONTH)+1);
	  
	  Integer start = 2-length;//��ȡ�·��ַ�������ʼλ��
	  
	  if(month.length()<length) {
		  month = StringUtil.leftPad(month, length, "0");
	  }
	  return month.substring(start);
  }
  
  /**
   * ��ȡ��ǰ�����е��·ݣ���λ�����ַ���
   */
  public static String getCurMonth() {
	  Calendar date = Calendar.getInstance();
	  return String.valueOf(date.get(Calendar.MONTH)+1);
  }
  

  
  /**
   * ��ȡ��ǰ�����е��գ���λ�����ַ���
   */
  public static String getCurDay() {
	  Calendar date = Calendar.getInstance();
	  
	  String theDay = String.valueOf(date.get(Calendar.DATE));
	  theDay =StringUtil.leftPad(theDay, 2, "0");
	  return theDay;
  }
  
  
  public static String getDay8Length(Integer length) {
	  String theDay=getCurDay();
	  
	  if(length>2) length=2;// ���������λ����
	  
	  if(length>0) {
		  if(theDay.length()<length) {
			  theDay = StringUtil.leftPad(theDay, length, "0");
		  }
		  return theDay;
	  }else {
		  return "";  
	  }
  }
  
}