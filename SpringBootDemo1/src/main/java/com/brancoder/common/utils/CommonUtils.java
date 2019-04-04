package com.brancoder.common.utils;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	/**
	 * 除法
	 */
	public static BigDecimal divide(String arg1, String arg2) {
		if (StringUtils.isEmpty(arg1)) {
			arg1 = "0.0";
		}
		if (StringUtils.isEmpty(arg2)) {
			arg2 = "0.0";
		}
		BigDecimal big3 = new BigDecimal("0.00");
		if (Double.parseDouble(arg2) != 0) {
			BigDecimal big1 = new BigDecimal(arg1);
			BigDecimal big2 = new BigDecimal(arg2);
			big3 = big1.divide(big2, 2, BigDecimal.ROUND_HALF_EVEN);
		}
		return big3;
	}

	/**
	 * 乘法
	 */
	public static BigDecimal mul(String arg1, String arg2) {
		if (StringUtils.isEmpty(arg1)) {
			arg1 = "0.0";
		}
		if (StringUtils.isEmpty(arg2)) {
			arg2 = "0.0";
		}
		BigDecimal big1 = new BigDecimal(arg1);
		BigDecimal big2 = new BigDecimal(arg2);
		BigDecimal big3 = big1.multiply(big2);
		return big3;
	}

	/**
	 * 减法
	 */
	public static BigDecimal sub(String arg1, String arg2) {
		if (StringUtils.isEmpty(arg1)) {
			arg1 = "0.0";
		}
		if (StringUtils.isEmpty(arg2)) {
			arg2 = "0.0";
		}
		BigDecimal big1 = new BigDecimal(arg1);
		BigDecimal big2 = new BigDecimal(arg2);
		BigDecimal big3 = big1.subtract(big2);
		return big3;
	}

	/**
	 * 加法
	 */
	public static BigDecimal add(String arg1, String arg2) {
		if (StringUtils.isEmpty(arg1)) {
			arg1 = "0.0";
		}
		if (StringUtils.isEmpty(arg2)) {
			arg2 = "0.0";
		}
		BigDecimal big1 = new BigDecimal(arg1);
		BigDecimal big2 = new BigDecimal(arg2);
		BigDecimal big3 = big1.add(big2);
		return big3;
	}

	/**
	 * 加法
	 */
	public static String add2(String arg1, String arg2) {
		if (StringUtils.isEmpty(arg1)) {
			arg1 = "0.0";
		}
		if (StringUtils.isEmpty(arg2)) {
			arg2 = "0.0";
		}
		BigDecimal big1 = new BigDecimal(arg1);
		BigDecimal big2 = new BigDecimal(arg2);
		BigDecimal big3 = big1.add(big2);
		return big3.toString();
	}

	/**
	 * 四捨五入保留N位小數 先四捨五入在使用double值自動去零
	 * 
	 * @param arg
	 * @param scare
	 *            保留位數
	 * @return
	 */
	public static String setScare(BigDecimal arg, int scare) {
		BigDecimal bl = arg.setScale(scare, BigDecimal.ROUND_HALF_UP);
		return String.valueOf(bl.doubleValue());
	}

	public static double setDifScare(double arg) {
		BigDecimal bd = new BigDecimal(arg);
		BigDecimal bl = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return Double.parseDouble(bl.toString());
	}

	/**
	 * 四捨五入保留兩位小數 先四捨五入在使用double值自動去零
	 * 
	 * @param arg
	 * @return
	 */
	public static String setDifScare(String arg) {
		BigDecimal bd = new BigDecimal(arg);
		BigDecimal bl = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bl.toString();
	}

	/**
	 * 四捨五入保留N位小數 先四捨五入在使用double值自動去零（傳參String類型）
	 * 
	 * @param arg
	 * @return
	 */
	public static String setDifScare(String arg, int i) {
		BigDecimal bd = new BigDecimal(arg);
		BigDecimal bl = bd.setScale(i, BigDecimal.ROUND_HALF_UP);
		return bl.toString();
	}

	/**
	 * 轉化成百分數 先四捨五入在使用double值自動去零
	 * 
	 * @param arg
	 * @return
	 */
	public static String setFenScare(BigDecimal arg) {
		BigDecimal bl = arg.setScale(3, BigDecimal.ROUND_HALF_UP);
		String scare = String.valueOf(mul(bl.toString(), "100").doubleValue());
		String fenScare = scare + "%";
		return fenScare;
	}

	/**
	 * 使用java正則表達式去掉多餘的.與0
	 * 
	 * @param s
	 * @return
	 */
	public static String subZeroAndDot(String s) {
		if (s.indexOf(".") > 0) {
			s = s.replaceAll("0+?$", "");// 去掉多餘的0
			s = s.replaceAll("[.]$", "");// 如最後一位是.則去掉
		}
		return s;
	}
}
