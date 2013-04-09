package test.msspeechsdk51;

public class SpeechSdkTest {
	static{
		System.loadLibrary("TestTTS");
	}
	/**
	 * 朗读,默认语速0音量100
	 * @param words 话
	 * @return
	 */
	public native int speak(String words);
	/**
	 * 朗读
	 * @param words	话
	 * @param rate	语速,范围[-10,10]
	 * @param volume音量,范围[0,100]
	 * @return
	 */
	public native int speak(String words, int rate, int volume);
	
	public static void main(String[] args) {
		SpeechSdkTest test = new SpeechSdkTest();
		
		String words = "服务器爆炸啦!" +
		"tomcat奔溃啦！" +
		"服务器被修空调的拉走啦！" +
		"机房着火啦！";
		test.speak(words);
		test.speak(words, 5, 100);
		
		String poem_1 = "惨惨惨！" +
		"吃晚饭要拉，" +
		"拉完还要撒，" +
		"撒完还想吃，" +
		"人生就是吃拉撒！";
		test.speak(poem_1, -4, 100);
		
		String poem_2 = "苍天有井独自空，星落天川遥映瞳。" +
		"小溪流泉映花彩，松江孤岛一叶枫。" +
		"南海涟波潭边杏，樱花尽朱落无音。" +
		"神仙谷内美人姬，饭尽之岛爱成梦。" +
		"西塞山野雁自翔，小桥水泽浸芳园。" +
		"武园枯藤空留兰，李氏眉宇尽是春。";
		test.speak(poem_2, -5, 100);
		
		String aTongueTwister = "白石塔，白石搭，白石搭白塔，白塔白石搭， 搭好白石塔，白塔白又大 。" +
		"吃葡萄不出葡萄皮，不吃葡萄倒吐葡萄皮。" +
		"四和十，十和四，十四和四十，四十和十四。" +
		"八百标兵奔北坡，北坡炮兵并排跑，炮兵怕把标兵碰，标兵怕碰炮兵炮。 ";
		test.speak(aTongueTwister, 5, 100);
	}
}
