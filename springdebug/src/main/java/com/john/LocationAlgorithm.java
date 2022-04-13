package com.john;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 故障定位算法类，距离长度统一为米，
 * 该算法定义机头为原点。
 * @Author: johnwonder
 * @Date: 2021/12/7
 */
public class LocationAlgorithm {

	public static void main(String[] args) throws IOException {


		String fileName = "/Users/zhangjiong/Desktop/prepare.csv";
		List<Point> datas =  readCsvData(fileName);


		List<Point> initPoints = new ArrayList<>(datas);
		LocationAlgorithm locationAlgorithm  = new LocationAlgorithm();
		locationAlgorithm.init(363,410,330,320,SIDE.DOWN,SIDE.UP,initPoints);

		locationAlgorithm.getFaultPoint(1640824120000L,"2020061901080002222f51ff",118.02);

		Location location =locationAlgorithm.distanceFromHead("2020061901080002222f51ff",118.02);

		System.out.println(location.distance);
	}

	private static List<Point> readCsvData(String fileName) throws IOException {


		CsvReader reader = CsvUtil.getReader();
		CsvData csvRows = reader.read(FileUtil.file(fileName));

		List<CsvRow> rows = csvRows.getRows();

		Point[]  points =  new Point[rows.size()];

		for (int i = 0; i < rows.size(); i++) {

				if(points[i] == null)
					points[i] = new Point();
				int next = i >= rows.size() -1 ? 0 : i+1;
				points[i].next = points[next] == null ?  (points[next]  = new Point()) : points[next];

				int prev = i == 0 ? rows.size() -1 : i-1;
				points[i].prev = points[prev] == null ? (points[prev] = new Point()) : points[prev];
			points[i].pointNum =  rows.get(i).get(0);
			points[i].nextSpace =  Double.parseDouble(rows.get(i).get(2));
			points[i].prevSpace = Double.parseDouble(rows.get(i).get(4));

		}

		return Arrays.asList(points);
	}

	private static  class  Location {

		private final double distance;

		private final boolean isReverse;

		private final SIDE faultSide;

		public Location(double distance, boolean isReverse,SIDE faultSide) {
			this.distance = distance;
			this.isReverse = isReverse;
			this.faultSide = faultSide;
		}

		public double getDistance() {
			return distance;
		}

		public boolean isReverse() {
			return isReverse;
		}

		public SIDE getFaultSide() {
			return faultSide;
		}
	}
	/**
	 * 皮带上的标识(包括 RFID 或者故障点)
	 */
	private static class Point {

		/**
		 * 标识符
		 */
		private  String pointNum;


		/**
		 * 后面一个标识点，next代表皮带正转的方向
		 */
		private  Point next;

		/**
		 * 和后面一个标识点的距离
		 */
		private  double  nextSpace;


		/**
		 * 前面一个标识点，prev代表皮带反转的方向
		 */
		private Point prev;

		/**
		 * 和前面一个标识点的距离
		 */
		private double prevSpace;

		public String getPointNum() {
			return pointNum;
		}

		public Point getNext() {
			return next;
		}

		public double getNextSpace() {
			return nextSpace;
		}

		public Point getPrev() {
			return prev;
		}

		public double getPrevSpace() {
			return prevSpace;
		}
	}

	/**
	 * 故障监测点和 读卡器安装 相对位置
	 * 		//监测点 和 读卡器 在一侧
	 * 		//1。如果是逆时针 旋转，那么 cardLocation 和monitorLocation 以 右侧为原点
	 * 		//2。如果是顺时针 旋转，那么 cardLocation 和monitorLocation 以 左侧为原点
	 *
	 * 		//监测点和 读卡器在两侧
	 * 		//1。如果是逆时针 旋转，那么 cardLocation 和monitorLocation 以 左侧侧为原点
	 * 		//2。如果是顺时针 旋转，那么 cardLocation 和monitorLocation 以 右侧为原点
	 */
	private enum SIDE {

		UP, //皮带上侧
		DOWN, //皮带下侧
	}

	/*
		某一个时刻距离读卡器最近的RFID 信息
	 */
	private static class NearestPoint{

		/**
		 * 最近的一个rfid标识
		 */
		private String rfidNo;
		/**
		 * 最近一次离读卡器的位置距离
		 */
		private double distance;

		private Point nearestPoint;


		public String getRfidNo() {
			return rfidNo;
		}

		public double getDistance() {
			return distance;
		}

		public Point getNearestPoint() {
			return nearestPoint;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		public void setRfidNo(String rfidNo) {
			this.rfidNo = rfidNo;
		}

		public void setNearestPoint(Point nearestPoint) {
			this.nearestPoint = nearestPoint;
		}
	}

	/**
	 * 读卡器距离原点的位置，
	 * 正转就得传原点开始离读卡器的位置
	 * 反转就得传终点开始离读卡器的位置 单位为 m
	 */
	private double cardLocation;

	/**
	 * 故障监测点距离原点的位置，单位为 m
	 * 正转就 是 monitorToHead
	 * 反转就 是 皮带长度 - monitorToHead
	 */
	private double monitorLocation;

	private double cardToHead; //初始化为读卡器距离原点的位置

	private double monitorToHead; //初始化为读卡器距离原点的位置


	private final String faultPrefix = "fault_";
	/**
	 * 输送带上侧长度
	 */
	private double beltUpLen;

	/**
	 * 输送带下侧长度
	 */
	private double beltDownLen;

	/**
	 * 是否是反转,默认正转
	 */
	private boolean isReverse =false;

	private SIDE cardSide;
	private SIDE monitorSide;
	/*
	   该输送机上的所有 标识集合
	   从上位机获取到
	 */
	private List<Point> points;


	/**
	 *  反转
	 */
	public  void reverseRotation(){

		this.isReverse = !isReverse;
		setLocationParam();
	}

	private void setLocationParam(){

		if(beltUpLen < 0 || beltDownLen < 0)
			return;

		cardLocation =  isReverse ? cardSide == SIDE.UP ? cardToHead : beltDownLen -cardToHead
				: cardSide == SIDE.UP ? beltUpLen - cardToHead : cardToHead;

		//监测点位置 参照读卡器位置方向
		if(cardSide == SIDE.DOWN && monitorSide == SIDE.UP){
			monitorLocation = isReverse? beltUpLen - monitorToHead :monitorToHead;
		}else if(cardSide == SIDE.UP && monitorSide == SIDE.DOWN){
			monitorLocation = isReverse? monitorToHead : beltDownLen - monitorToHead ;
		}else if(cardSide == SIDE.UP && monitorSide == SIDE.UP){
			monitorLocation = isReverse? monitorToHead : beltUpLen - monitorToHead ;
		}else {
			monitorLocation = isReverse?  beltDownLen - monitorToHead :monitorToHead ;
		}
	}

	/**
	 * 初始化值
	 * @param upBeltLen 上侧皮带长
	 * @param downBeltLen 下侧皮带长
	 * @param cardToHead 读卡器距离原点位置
	 * @param monitorToHead 监测点距离原点位置
	 * @param cardSide 读卡器安装在哪侧
	 * @param monitorSide 监测点安装在哪侧
	 * @param points 初始化rfid 集合
	 */
	public void init(double upBeltLen,double downBeltLen,double cardToHead,double monitorToHead,SIDE cardSide,SIDE monitorSide, List<Point> points){

		this.beltUpLen = upBeltLen;
		this.beltDownLen = downBeltLen;
		this.cardToHead = cardToHead;
		this.monitorToHead = monitorToHead;
		this.cardSide = cardSide;
		this.monitorSide = monitorSide;
		this.points = points;
		setLocationParam();
	}
	/**
	 * 获取监测到故障时刻的故障点,并加入标识点集合
	 * 故障监测点位于上侧皮带
	 * 读卡器位于下侧皮带
	 * @param monitorTime 故障时刻
	 */
	public void getFaultPoint(long monitorTime,String nearstRfidNo,double nearstDistance){

		//获取该时刻离读卡器最近的一个rfid标识点
		NearestPoint nearestPoint = getRFIDFromCard(nearstRfidNo,nearstDistance);

		Point  faultPoint = getFaultPoint(monitorTime,nearestPoint.getDistance(),nearestPoint.getNearestPoint());

		//筛选是否已经存在相同位置的故障点 2022-01-12
		boolean isExist = points.stream().anyMatch(p -> p.getPointNum().startsWith(faultPrefix) &&
										p.nextSpace == faultPoint.nextSpace && p.next == faultPoint.next);
		if(!isExist)
		points.add(faultPoint);//把故障点加入皮带标识点集合
	}

	/**
	 * 获取任意时刻的离监测点最近的RIFD
	 * 2022-01-12
	 * @param monitorTime 时刻
	 */
	public Point getNearRFIDPoint(long monitorTime,String nearstRfidNo,double nearstDistance){

		//获取该时刻离读卡器最近的一个rfid标识点
		NearestPoint nearestPoint = getRFIDFromCard(nearstRfidNo,nearstDistance);

		Point  faultPoint =  getFaultPoint(monitorTime,nearestPoint.getDistance(),nearestPoint.getNearestPoint());

		return  isReverse ? faultPoint.prev : faultPoint.next;
	}



	private double caculateMonitorToCardPoint(double cardPointDistance){

		double monitorToCardPoint  =0 ; //最近的一个RFID 和 监测点之间的距离

		// 监测点 和 读卡器 在一侧
		//1。如果是逆时针 旋转，那么 cardLocation 和monitorLocation 以 右侧为原点
		//2。如果是顺时针 旋转，那么 cardLocation 和monitorLocation 以 左侧为原点

		//监测点和 读卡器在两侧
		//1。如果是逆时针 旋转，那么 cardLocation 和monitorLocation 以 左侧侧为原点
		//2。如果是顺时针 旋转，那么 cardLocation 和monitorLocation 以 右侧为原点
		double cardToTail =  cardSide == SIDE.UP ? beltUpLen -cardLocation : beltDownLen - cardLocation;  //计算读卡器和机尾之间的距离

		double otherSideBeltLen  = cardSide == SIDE.DOWN ? beltUpLen : beltDownLen;
		double sameSideBeltLen  = cardSide == SIDE.DOWN ? beltDownLen : beltUpLen;

		//最近的一个RFID在机尾之前
		boolean isSameSide = cardSide.equals(monitorSide);
		if(cardPointDistance < cardToTail){

			if(isSameSide){
				if(cardLocation + cardPointDistance < monitorLocation){

					monitorToCardPoint =  monitorLocation - (cardLocation +  cardPointDistance);
				}
				else {
					monitorToCardPoint = cardToTail - cardPointDistance + otherSideBeltLen + monitorLocation;
				}
			}else {
				//2021-12-31 otherSideBeltLen 改为 sameSideBeltLen
				monitorToCardPoint = sameSideBeltLen - cardLocation - cardPointDistance + otherSideBeltLen - monitorLocation;

			}
		}
		else if(cardPointDistance < beltDownLen + beltUpLen) { //正常读到芯片

			double remainLength =  cardPointDistance - cardToTail;

			if(isSameSide){
				//最近的rfid在皮带另一侧
				if(remainLength < otherSideBeltLen){
					monitorToCardPoint = otherSideBeltLen -remainLength  +  monitorLocation;

				}else
				{
					//最近的rfid在 读卡器一侧
					monitorToCardPoint =  monitorLocation - (remainLength - otherSideBeltLen);
				}
			}else{
				double pointRemainToUpHead = otherSideBeltLen - remainLength;
				//故障监测点也在上方皮带，且在最近的rfid左侧
				if(pointRemainToUpHead > monitorLocation){
					monitorToCardPoint = pointRemainToUpHead-monitorLocation;
				}else
				{
					//最近的标识点在 监测点左边
					monitorToCardPoint = pointRemainToUpHead +sameSideBeltLen + otherSideBeltLen -  monitorLocation;
				}
			}

		}else {
			monitorToCardPoint =  caculateMonitorToCardPoint(cardPointDistance);
		}

		return monitorToCardPoint;
	}

	private Point getFaultPoint(long monitorTime,double distance,Point nearestPoint){

		//计算读卡器读到的最近的rfid到监测点的距离
		double monitorToCardPoint = caculateMonitorToCardPoint(distance);

		return caculateFaultPoint(monitorTime,monitorToCardPoint,0,nearestPoint);

		//把故障点加入皮带标识点集合
		//points.add(faultPoint);

	}

	/**
	 * 获取任意时刻皮带上的故障点距离左侧机头位置
	 * 故障监测点位于上侧皮带
	 * 读卡器位于下侧皮带
	 * @param nearstRfidNo  最近的rfid编号
	 * @param nearstDistance  最近的rfid编号 离读卡器距离
	 * @return
	 */
	public  Location distanceFromHead(String nearstRfidNo,double nearstDistance){


		boolean hasFaultPoint =  points.stream().anyMatch(p -> p.getPointNum().startsWith(faultPrefix));
		if(!hasFaultPoint)
			return  null;
		//获取该时刻离读卡器最近的一个rfid标识点
		NearestPoint nearestPoint = getRFIDFromCard(nearstRfidNo,nearstDistance);

		//计算出该rfid 和 最近故障点之间的距离
		double distanceWithFaultPoint = distanceWithFaultPoint(0,nearestPoint.getNearestPoint());

		return fromHeadLocation(nearestPoint.getDistance(),distanceWithFaultPoint);
	}

	/**
	 * 获取任意时刻皮带上的所有故障点距离左侧机头位置
	 * 故障监测点位于上侧皮带
	 * 读卡器位于下侧皮带
	 * @param nearstRfidNo  最近的rfid编号
	 * @param nearstDistance  最近的rfid编号 离读卡器距离
	 * @return
	 */
	public  List<Location> anyDistanceFromHead(String nearstRfidNo,double nearstDistance){

		Set<Point> faultPoints = points.stream().filter(p -> p.getPointNum().startsWith(faultPrefix)).collect(Collectors.toSet());
		//获取该时刻离读卡器最近的一个rfid标识点
		NearestPoint nearestPoint = getRFIDFromCard(nearstRfidNo,nearstDistance);

		//计算出该rfid 和 最近故障点之间的距离
		Set<String> alreadyPoints = new HashSet<>();
		Map<String, Double> faultPointToDistance = new HashMap<>();

	  	distanceWithAnyFaultPoint(alreadyPoints, faultPoints.size(),0,nearestPoint.getNearestPoint(),faultPointToDistance);

		List<Location> pointLocations = new ArrayList<>();
		for (Map.Entry<String, Double> entry : faultPointToDistance.entrySet()) {

		  pointLocations.add(fromHeadLocation(nearestPoint.getDistance(),entry.getValue()));
		}
		return pointLocations;
	}




	private Location fromHeadLocation(double cardPointDistance,double distanceWithFaultPoint){

		double cardToTail = cardSide ==  SIDE.UP  ? beltUpLen -cardLocation : beltDownLen-cardLocation;
		double otherSideBeltLen = cardSide ==  SIDE.UP ? beltDownLen : beltUpLen;

		double sameSideBeltLen = cardSide ==  SIDE.UP ? beltUpLen : beltDownLen;
		//最近的一个RFID在机尾之前
		if(cardPointDistance < cardToTail){
			//最近的rfid离机尾还剩多少距离
			double pointRemainToTail = cardToTail - cardPointDistance;

			//故障点在尾部之前
			if(distanceWithFaultPoint < pointRemainToTail)
				return new Location(cardLocation + cardPointDistance + distanceWithFaultPoint,isReverse,cardSide);
			else {
				//故障点在尾部之后
				double pointToHead =pointRemainToTail + otherSideBeltLen;

				//也可以取绝对值
				//故障点在皮带上方
				if(pointToHead > distanceWithFaultPoint){
					return new Location(pointToHead - distanceWithFaultPoint,isReverse,cardSide ==  SIDE.UP ? SIDE.DOWN : SIDE.UP);
				}else {
					//故障点在皮带下方
					return new Location(distanceWithFaultPoint -pointToHead,isReverse,cardSide);
				}
			}
		}
		else if(cardPointDistance < beltDownLen + beltUpLen){ //正常读到芯片


			double remainLength =  cardPointDistance - cardToTail;

			//最近的rfid在上方皮带
			if(otherSideBeltLen > remainLength){

				double pointRemainToHead = otherSideBeltLen - remainLength;
				//故障点也在上方皮带，且在最近的rfid左侧
				if(distanceWithFaultPoint < pointRemainToHead){
					return  new Location(pointRemainToHead - distanceWithFaultPoint,isReverse,cardSide ==  SIDE.UP ? SIDE.DOWN : SIDE.UP);
				}else {

					double faultPointToHead = distanceWithFaultPoint - pointRemainToHead;
					//故障点在下方皮带
					if(faultPointToHead < sameSideBeltLen){
						return new Location(faultPointToHead,isReverse,cardSide);
					}else
					{
						//故障点在上方皮带，且在最近的rfid右侧
						//(distanceWithFaultPoint - sameSideBeltLen) 改为faultPointToHead - sameSideBeltLen 2022-01-24
						return  new Location(otherSideBeltLen - (faultPointToHead - sameSideBeltLen),isReverse,cardSide ==  SIDE.UP ? SIDE.DOWN : SIDE.UP);
					}
				}
			}else
			{
				//最近的rfid在下方皮带 且在读卡器左侧
				double remainToHead = remainLength - otherSideBeltLen;


				//故障点在下方皮带
				if(remainToHead + distanceWithFaultPoint < sameSideBeltLen){

					return  new Location(remainToHead+distanceWithFaultPoint,isReverse,cardSide);
				}else{

					double faultPointToHead = remainToHead + distanceWithFaultPoint - sameSideBeltLen;
					//故障点在皮带上方
					if(faultPointToHead < otherSideBeltLen){
						return  new Location(otherSideBeltLen - faultPointToHead,isReverse,cardSide ==  SIDE.UP ? SIDE.DOWN : SIDE.UP);
					}else
					{
						return  new Location(faultPointToHead -otherSideBeltLen,isReverse,cardSide);
					}
				}

			}


		}else{

			//超过输送带长度 ，递归 获取
			return  fromHeadLocation(cardToTail,cardPointDistance - (beltUpLen+beltDownLen));
		}
	}

	/**
	 * 获取某一个时刻离读卡器最近的一个RFID
	 * todo 初始化的rfid集合里没有 读到的rfid
	 * @return
	 */
	private NearestPoint getRFIDFromCard(String nearstRridNo,double nearestDistance){

		//todo 根据上位机 这一时刻 发送的rfid信息获取
		NearestPoint nearestPoint =  new NearestPoint();
		nearestPoint.setDistance(nearestDistance); // 获取读取到的距离
		nearestPoint.setRfidNo(nearstRridNo); //获取读取到的rfid标识
		for (Point point : points) {
			if(point.getPointNum().equals(nearestPoint.getRfidNo())) {
				nearestPoint.setNearestPoint(point);
				break;
			}
		}
		return nearestPoint;
	}

	/**
	 * 计算监测故障点和 离监测故障点最近的一个rfid 之间的距离
	 * 并且返回一个模拟的RFID标识
	 * @param monitorToCardPoint
	 * @param totalDistance
	 * @param currentPoint
	 * @return
	 */
	private Point caculateFaultPoint(long timeStamp,double monitorToCardPoint,double totalDistance,Point currentPoint){

		double nextSpace = isReverse ? currentPoint.prevSpace : currentPoint.nextSpace;
		Point nextPoint = isReverse ? currentPoint.prev : currentPoint.next;
		if(totalDistance + nextSpace >= monitorToCardPoint) {

			//生成一个故障点
			Point faultPoint = new Point();
			faultPoint.pointNum = faultPrefix+ timeStamp; //故障点标识符

		    faultPoint.next = isReverse ? currentPoint : currentPoint.next ;
		    faultPoint.nextSpace = isReverse ?  monitorToCardPoint - totalDistance : nextSpace - (monitorToCardPoint - totalDistance) ;
		    faultPoint.prev = isReverse ? currentPoint.prev : currentPoint;
		    faultPoint.prevSpace = isReverse ? nextSpace - (monitorToCardPoint - totalDistance) : monitorToCardPoint - totalDistance;


			//重置当前标识点的下个标识点
			if(isReverse){
				currentPoint.prev.nextSpace = nextSpace - (monitorToCardPoint - totalDistance);
				currentPoint.prev.next = faultPoint;

				currentPoint.prev = faultPoint;
				//故障监测点 和 离监测故障点最近的一个rfid 之间的距离
				currentPoint.prevSpace = monitorToCardPoint - totalDistance;

			}else{
				currentPoint.next.prevSpace = nextSpace - (monitorToCardPoint - totalDistance);
				currentPoint.next.prev = faultPoint;

				currentPoint.next = faultPoint;
				//故障监测点 和 离监测故障点最近的一个rfid 之间的距离
				currentPoint.nextSpace = monitorToCardPoint - totalDistance;

			}

			return faultPoint;
		}
		totalDistance += nextSpace;
		return  caculateFaultPoint(timeStamp,monitorToCardPoint,totalDistance,nextPoint);
	}

	/**
	 * 必须要有faultPoint 不然会无限递归
	 * @param totalDistance
	 * @param point
	 * @return
	 */
	private double distanceWithFaultPoint(double totalDistance,Point point){

		double nextSpace = isReverse ? point.prevSpace : point.nextSpace;
		Point nextPoint = isReverse ? point.prev :point.next;
		totalDistance += nextSpace;

		if(nextPoint.getPointNum().startsWith(faultPrefix)){
			return totalDistance;
		}

		return  distanceWithFaultPoint(totalDistance,nextPoint);

	}

	private Map<String,Double> distanceWithAnyFaultPoint(Set<String> alreadyPoints,int totalFaultCount,double totalDistance, Point point, Map<String, Double> faultPoints){

		double nextSpace = isReverse ? point.prevSpace : point.nextSpace;
		Point nextPoint = isReverse ? point.prev :point.next;
		totalDistance += nextSpace;

		if(nextPoint.getPointNum().startsWith(faultPrefix)){
			alreadyPoints.add(nextPoint.getPointNum());
			faultPoints.put(nextPoint.getPointNum(),totalDistance);
			if(alreadyPoints.size() >= totalFaultCount){
				return  faultPoints;
			}
		}

		return  distanceWithAnyFaultPoint(alreadyPoints,totalFaultCount,totalDistance,nextPoint,faultPoints);

	}
}
