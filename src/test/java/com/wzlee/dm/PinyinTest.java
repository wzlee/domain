package com.wzlee.dm;

import static org.junit.Assert.*;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class PinyinTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void SingerTest(){
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		String[] pinyin;
		try {
			pinyin = PinyinHelper.toHanyuPinyinStringArray('愁',format);
			System.out.println(StringUtils.join(pinyin, ' '));
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String hanyuToPinyin(String hanyu){
		String pinyin = "";
        char[] nameChar = hanyu.toCharArray();
        HanyuPinyinOutputFormat defaultFormat =
                                           new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                	pinyin += PinyinHelper.toHanyuPinyinStringArray
                                           (nameChar[i], defaultFormat)[0];
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }
        }
        return pinyin;
    }
	
	public static void main(String[] args){
		System.out.println(hanyuToPinyin("宠物"));
	}
}
